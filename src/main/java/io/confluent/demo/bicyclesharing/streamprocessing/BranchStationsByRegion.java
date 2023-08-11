package io.confluent.demo.bicyclesharing.streamprocessing;

import io.confluent.common.utils.TestUtils;
import io.confluent.demo.bicyclesharing.pojo.*;
import io.confluent.demo.bicyclesharing.utils.ClientsUtils;
import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import io.confluent.kafka.streams.serdes.json.KafkaJsonSchemaSerde;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.*;
import org.apache.kafka.streams.kstream.*;
import org.apache.log4j.Logger;

import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.function.Function;

public class BranchStationsByRegion {
    private static final Logger logger = Logger.getLogger(BranchStationsByRegion.class);
    private static Properties streamsConfiguration;
    private static String stationInformationTopicName, systemRegionsTopicName, stationStatusTopicName;

    BranchStationsByRegion(String propertiesFile) {
        try {
            streamsConfiguration = ClientsUtils.loadConfig(propertiesFile);
            streamsConfiguration.put("default.key.serde", Serdes.String().getClass().getName());
            streamsConfiguration.put(StreamsConfig.APPLICATION_ID_CONFIG, "branch-by-station-region");
            streamsConfiguration.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
            streamsConfiguration.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, KafkaJsonSchemaSerde.class);
            // streamsConfiguration.put("json.value.type", "io.confluent.demo.bicyclesharing.pojo.StationInformation");
            // streamsConfiguration.put("json.value.type", "com.fasterxml.jackson.databind.JsonNode");
            streamsConfiguration.put("json.value.type", "java.lang.Object");
            streamsConfiguration.put(AbstractKafkaSchemaSerDeConfig.AUTO_REGISTER_SCHEMAS, true);
            // consumer from the beginning of the topic or last offset
            streamsConfiguration.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
            // Use a temporary directory for storing state, which will be automatically removed after the test.
            streamsConfiguration.put(StreamsConfig.STATE_DIR_CONFIG, TestUtils.tempDirectory().getAbsolutePath());
            stationInformationTopicName = streamsConfiguration.getProperty("station.information.topic");
            systemRegionsTopicName = streamsConfiguration.getProperty("system.regions.topic");
            stationStatusTopicName = streamsConfiguration.getProperty("station.status.clean.topic");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error in constructor: " + e.getMessage());
        }
    }

    private static KafkaStreams buildTopology(String propertiesFile) {

        try {
            // JOIN station information + system region > station id + region name JOIN station status

            //
            // Step 1: Configure and start the processor topology.
            //
            final StreamsBuilder builder = new StreamsBuilder();

            // Build KTable for the station.information - KEY is station id
            Properties serdeConfig1 = ClientsUtils.loadConfig(propertiesFile);
            serdeConfig1.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, KafkaJsonSchemaSerde.class);
            serdeConfig1.put("json.value.type", "io.confluent.demo.bicyclesharing.pojo.StationInformationSingle");
            Serde s1 = new KafkaJsonSchemaSerde();
            s1.configure(serdeConfig1, false);
            final KTable<String, StationInformationSingle> stationInfo = builder.table(stationInformationTopicName, Consumed.with(Serdes.String(), s1));

            // Build KTable for the system.regions  - KEY is region id
            Properties serdeConfig2 = ClientsUtils.loadConfig(propertiesFile);
            serdeConfig2.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, KafkaJsonSchemaSerde.class);
            serdeConfig2.put("json.value.type", "io.confluent.demo.bicyclesharing.pojo.SystemRegionSingle");
            Serde s2 = new KafkaJsonSchemaSerde();
            s2.configure(serdeConfig2, false);
            final KTable<String, SystemRegionSingle> systemRegions = builder.table(systemRegionsTopicName, Consumed.with(Serdes.String(), s2));

            // Join the KTables on key region_id - WORKS
            // TODO Mystery why need this KTable for the entire thing to work
            KTable<String, String> joined = stationInfo.join(systemRegions,
                    (station, region) -> "station_id =" + station.getStation().getStationId() + ", region_name=" + region.getRegion().getName()
                    // (station, region) -> region
            );

            joined.toStream().to("region");
            // end of mystery

            //final KTable<ProductID, Product> products = builder.table("Product");

            // Function<String, String> foreignKeyExtractor = (RegionId) -> RegionId;
            //Function<Long, Long> foreignKeyExtractor = (StationInformation) -> StationInformation;

            Function<StationInformationSingle, String> foreignKeyExtractor =
                    (StationInformationSingle x) -> x.getStation().getRegionId();

            final KTable<String, String> stationWithRegion = stationInfo.join(
                    systemRegions,
                    foreignKeyExtractor,
                    (station, region) -> region.getRegion().getName()
            );

            // stationWithRegion.toStream().to("station.region");

            // Build KStream for the station.status - KEY is station_id
            Properties serdeStationStatusConfig = ClientsUtils.loadConfig(propertiesFile);
            serdeStationStatusConfig.put("json.value.type", "io.confluent.demo.bicyclesharing.pojo.StationStatusSingle");
            Serde serdeStationStatus = new KafkaJsonSchemaSerde();
            serdeStationStatus.configure(serdeStationStatusConfig, false);
            final KStream<String, StationStatusSingle> stationStatus = builder.stream(stationStatusTopicName, Consumed.with(Serdes.String(), serdeStationStatus));

            // Join the station status KStream with the joined KTable
            KStream<String, StationStatusSingle> joinStatusRegion = stationStatus.join(stationWithRegion,
                    (station, region) -> new MyStationStatus(station, region).getStationStatus());

            //joinStatusRegion.to("status.region");
            logger.info("Going to create topics for regions ... ");
            // Dynamically route events to topics with the region name
            joinStatusRegion.to((eventId, event, record) ->
            {
                logger.info("Region to create: " + event.getAdditionalProperties().get("region"));
                return ClientsUtils.createTopic(serdeConfig1, (String) event.getAdditionalProperties().get("region"));
            });
            return new KafkaStreams(builder.build(), streamsConfiguration);

        } catch (Exception e) {
            logger.error("Exception: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("This program takes one argument: the path to an environment configuration file.");
        }

        BranchStationsByRegion producer = new BranchStationsByRegion(args[0]);
        final KafkaStreams streams = producer.buildTopology(args[0]);

        final CountDownLatch latch = new CountDownLatch(1);

        // Attach shutdown handler to catch Control-C.
        Runtime.getRuntime().addShutdownHook(new Thread("streams-regions-shutdown-hook") {
            @Override
            public void run() {
                streams.close(Duration.ofSeconds(5));
                latch.countDown();
            }
        });

        try {
            streams.start();
            latch.await();
        } catch (Throwable e) {
            System.exit(1);
        }
        System.exit(0);
    }
}

            /*
            final String storeName = "joined-store";
            stationInfo.join(systemRegions,
                            (regionValue, lastLoginValue) -> regionValue + "/" + lastLoginValue,
                            Materialized.as(storeName))
                    .toStream()
                    .to("outputTopic", Produced.with(Serdes.String(), Serdes.String()));
            */

//station_information
//{"region_id":"5","rental_methods":["KEY","CREDITCARD"],"legacy_id":"309","name":"San Jose City Hall","capacity":23,"rental_uris":{"android":"https://sfo.lft.to/lastmile_qr_scan","ios":"https://sfo.lft.to/lastmile_qr_scan"},"eightd_has_key_dispenser":false,"station_id":"5c17e1c8-5d21-4309-afcb-e69da27acf31","short_name":"SJ-M10-1","lat":37.337391,"has_kiosk":true,"electric_bike_surcharge_waiver":false,"lon":-121.886995,"external_id":"5c17e1c8-5d21-4309-afcb-e69da27acf31","station_type":"classic","eightd_station_services":[]}
//
//system_regions
//{"region_id":"5","name":"San Jose"}
//
//station_status
//{"legacy_id":"309","is_returning":1,"num_bikes_disabled":0,"is_renting":1,"num_bikes_available":8,"is_installed":1,"station_status":"active","num_docks_disabled":0,"last_reported":1651445609,"station_id":"5c17e1c8-5d21-4309-afcb-e69da27acf31","eightd_has_available_keys":false,"num_docks_available":15,"num_ebikes_available":0}
//


        /*
            KTable<String, StationInformation> stationInfoTable = stationInfo
                    .mapValues(v -> {
                        try {
                            io.confluent.demo.citibike.api.StationInformation.StationInfo info = mapper.readValue(
                                    v, io.confluent.demo.citibike.api.StationInformation.StationInfo.class);
                            return info;
                        } catch (Exception e) {
                            log.error("Deserialize error 2: " + e.getMessage());
                            throw new RuntimeException("Deserialize error" + e);
                        }
                    });



            KStream<String, StationStatus> events = builder.stream(stationStatusTopicName);
            // then take action on the events in the stream

            final KStream<String, StationStatus>[] branches = events.branch(
                    (id, event) -> event.getData ().getStations().get(0).getStationId() = ,
                    (id, event) -> event.getTransactionValue() < FRAUD_LIMIT);
            branches[0].to();
            branches[1].to(validatedTransactionsTopicName);



            // Get the stream of station statuses (station id & number bikes available)
            ObjectMapper mapper = new ObjectMapper();
            KStream<String, String> statusStream = builder.stream(
                    STATUS_TOPIC,
                    Consumed.with(Serdes.String(), Serdes.String()))
                    .map((station_id, v) -> {
                        try {
                            io.confluent.demo.citibike.api.StationStatus.StationStatus status = mapper.readValue(
                                    v, io.confluent.demo.citibike.api.StationStatus.StationStatus.class);
                            return new KeyValue<>(station_id, Integer.toString(status.num_bikes_available));
                        } catch (Exception e) {
                            log.error("Deserialize error 1: " + e.getMessage());
                            throw new RuntimeException("Deserialize error" + e);
                        }
                    });



            // Build KTable for the system regions
            KTable<String, SystemInformation> stationInfo = builder.table(SYSTEM_REGIONS_TOPIC);
            KTable<String, io.confluent.demo.citibike.api.StationInformation.StationInfo> stationInfoTable = stationInfo
                    .mapValues(v -> {
                        try {
                            io.confluent.demo.citibike.api.StationInformation.StationInfo info = mapper.readValue(
                                    v, io.confluent.demo.citibike.api.StationInformation.StationInfo.class);
                            return info;
                        } catch (Exception e) {
                            log.error("Deserialize error 2: " + e.getMessage());
                            throw new RuntimeException("Deserialize error" + e);
                        }
                    });

            // stations with bike availability ratio (num_bikes_avail / capacity) < threshold 10%
            KStream<String, String> outputStream = statusStream
                    .leftJoin(stationInfoTable, (num_bikes, info) -> {
                        return new BikeStats(Integer.parseInt(num_bikes), info.capacity,
                                info.latitude, info.longitude);
                    })
                    .filter((k, stats) -> stats.availabilityRatio < 0.1)
                    .map((k, stats) -> new KeyValue<>(k, "station_id: " + k +
                            ", longitude " + stats.longitude +
                            ", latitude " + stats.latitude +
                            ", bikes: " + stats.numBikesAvailable +
                            ", capacity: " + stats.stationCapacity +
                            ", ratio: " + String.format("%.2f", stats.availabilityRatio * 100) + "%"));

            // output to kafka topic
            outputStream
                    .to(LOW_BIKE_TOPIC, Produced.with(Serdes.String(), Serdes.String()));

            // stations with bike availability ratio (num_bikes_avail / capacity) > threshold 10%
            KStream<String, String> outputStreamMedium = statusStream
                    .leftJoin(stationInfoTable, (num_bikes, info) -> {
                        return new BikeStats(Integer.parseInt(num_bikes), info.capacity,
                                info.latitude, info.longitude);
                    })
                    .filter((k, stats) -> stats.availabilityRatio >= 0.1 && stats.availabilityRatio < 0.5)
                            .map((k, stats) -> new KeyValue<>(k, "station_id: " + k +
                            ", longitude " + stats.longitude +
                            ", latitude " + stats.latitude +
                            ", bikes: " + stats.numBikesAvailable +
                            ", capacity: " + stats.stationCapacity +
                            ", ratio: " + String.format("%.2f", stats.availabilityRatio * 100) + "%"));


            // Enrich orders to include customer loyalty level
            orders.join(customers,
                            (orderId, order) -> order.getCustomerId(),
                            (order, customer) -> new OrderEnriched (order.getId(),
                                    order.getCustomerId(),
                                    customer.getLevel()))

                    // Dynamically route the enriched order to an output topic
                    // whose name is the customer loyalty level
                    .to((orderId, orderEnriched, record) ->
                            orderEnriched.getCustomerLevel());



            // output to kafka topic
            outputStreamMedium
                    .to(MEDIUM_BIKE_TOPIC, Produced.with(Serdes.String(), Serdes.String()));

            // stations with bike availability ratio (num_bikes_avail / capacity) >= 50%
            KStream<String, String> outputStreamHigh = statusStream
                    .leftJoin(stationInfoTable, (num_bikes, info) -> {
                        return new BikeStats(Integer.parseInt(num_bikes), info.capacity,
                                info.latitude, info.longitude);
                    })
                    .filter((k, stats) -> stats.availabilityRatio >= 0.5)
                    .map((k, stats) -> new KeyValue<>(k, "station_id: " + k +
                            ", longitude " + stats.longitude +
                            ", latitude " + stats.latitude +
                            ", bikes: " + stats.numBikesAvailable +
                            ", capacity: " + stats.stationCapacity +
                            ", ratio: " + String.format("%.2f", stats.availabilityRatio * 100) + "%"));

            // output to kafka topic
            outputStreamHigh
                    .to(HIGH_BIKE_TOPIC, Produced.with(Serdes.String(), Serdes.String()));

            return new KafkaStreams(builder.build(), streamsConfiguration);

         */

