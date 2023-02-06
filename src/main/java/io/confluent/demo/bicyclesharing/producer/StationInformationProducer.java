package io.confluent.demo.bicyclesharing.producer;

import io.confluent.demo.bicyclesharing.pojo.*;
import io.confluent.demo.bicyclesharing.utils.ClientsUtils;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.log4j.Logger;
import java.util.List;
import java.util.Properties;

public class StationInformationProducer {

    private static final Logger logger = Logger.getLogger(StationInformationProducer.class);
    private static Properties props;
    private String stationInformationTopic, stationInformationUrl;

    StationInformationProducer(String propertiesFile) {
        try {
            props = ClientsUtils.loadConfig(propertiesFile);
            props.put("key.serializer", StringSerializer.class);
            props.put("value.serializer", "io.confluent.kafka.serializers.json.KafkaJsonSchemaSerializer");
            props.setProperty("auto.register.schemas", "true");
            props.setProperty("use.latest.version", "true");
            stationInformationTopic = props.getProperty("station.information.topic");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error in constructor: " + e.getMessage());
        }
    }

    public void runProducer() {
        try {
            // Record example
            // {"region_id":"5","rental_methods":["KEY","CREDITCARD"],"legacy_id":"309","name":"San Jose City Hall",
            // "capacity":23,"rental_uris":{"android":"https://sfo.lft.to/lastmile_qr_scan","ios":"https://sfo.lft.to/lastmile_qr_scan"},
            // "eightd_has_key_dispenser":false,"station_id":"5c17e1c8-5d21-4309-afcb-e69da27acf31","short_name":"SJ-M10-1","lat":37.337391,
            // "has_kiosk":true,"electric_bike_surcharge_waiver":false,"lon":-121.886995,"external_id":"5c17e1c8-5d21-4309-afcb-e69da27acf31",
            // "station_type":"classic","eightd_station_services":[]}

            // Get stations information from the gtfs API
            Gtfs gtfs = new Gtfs(props);

            List<StationInformationSingle> stationsList = gtfs.getStationInformationList();
            int numStations =  stationsList.size();

            for (int i = 0; i < numStations; i++) {

                String stationId = stationsList.get(i).getStation().getStationId();

                // Set the Kafka client ID as the station
                props.put(ProducerConfig.CLIENT_ID_CONFIG, stationId);

                // Create a producer
                Producer producer = new KafkaProducer<>(props);

                // Create a producer record (key = stationId)
                ProducerRecord record = new ProducerRecord<>(stationInformationTopic, stationId, stationsList.get(i));

                // Send the record
                producer.send(record);
                // log.error("Loop count #" + loopCount + " - record#" + numRecords++ + " of total " + numStations + " for station name " + stationStatusPOJO.getStationName() + ".");

                // Close producer
                producer.close();

                logger.info("Station information " + stationId
                        + " sending record with KEY=" + record.key()
                        + " and VALUE=" + record.value());
            }
            logger.info("Finished loading station information.");
        } catch (Exception e) {
            logger.error("Error in StationInformationProducer.runProducer method: ", e);
            StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
            for (StackTraceElement stackTrace : stackTraceElements) {
                logger.error(stackTrace.getClassName() + "  " + stackTrace.getMethodName() + " " + stackTrace.getLineNumber());
            }
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void main(final String[] args) throws Exception {
        int numArgs = args.length;
        if (numArgs < 1) {
            logger.error("Provide the properties file as argument.");
            System.exit(1);
        } else {
            try {
                StationInformationProducer producer = new StationInformationProducer(args[0]);
                producer.runProducer();
            } catch (Exception e) {
                logger.error("Error in main method: " + e.getMessage());
            }
        }
    }
}