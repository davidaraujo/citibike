package io.confluent.demo.bicyclesharing.streamprocessing;

import io.confluent.common.utils.TestUtils;
import io.confluent.demo.bicyclesharing.pojo.StationStatusSingle;
import io.confluent.demo.bicyclesharing.utils.ClientsUtils;
import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import io.confluent.kafka.streams.serdes.json.KafkaJsonSchemaSerde;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.errors.StreamsUncaughtExceptionHandler;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.log4j.Logger;

import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class BranchStationsByStatus {
    private static final Logger logger = Logger.getLogger(BranchStationsByStatus.class);
    private static Properties streamsConfiguration;
    private static String stationStatusTopicName;

    BranchStationsByStatus(String propertiesFile) {
        try {
            streamsConfiguration = ClientsUtils.loadConfig(propertiesFile);
            streamsConfiguration.put("default.key.serde", Serdes.String().getClass().getName());
            streamsConfiguration.put(StreamsConfig.APPLICATION_ID_CONFIG, streamsConfiguration.getProperty("stations.branch.app"));
            streamsConfiguration.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
            streamsConfiguration.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, KafkaJsonSchemaSerde.class);
            streamsConfiguration.put("json.value.type", "io.confluent.demo.bicyclesharing.pojo.StationStatusSingle");
            stationStatusTopicName = streamsConfiguration.getProperty("stations.raw.topic");
            streamsConfiguration.put(AbstractKafkaSchemaSerDeConfig.AUTO_REGISTER_SCHEMAS, true);
            // consumer from the beginning of the topic or last offset
            streamsConfiguration.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
            // Use a temporary directory for storing state, which will be automatically removed after the test.
            streamsConfiguration.put(StreamsConfig.STATE_DIR_CONFIG, TestUtils.tempDirectory().getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error in constructor: " + e.getMessage());
        }
    }

    private static KafkaStreams branch() {
        try {
            final StreamsBuilder builder = new StreamsBuilder();

            // Build KStream for the bike.status
            final KStream<String, StationStatusSingle> stationStatus = builder.stream(stationStatusTopicName);

            // Dynamically route events to topics based on their status
           // AtomicReference<String> status;
            stationStatus.to((eventId, event, record) ->
                    {
                      /* OLD USING STATION STATUS PROPERTY THAT STOPPED BEING POPULATED ON THE FEED
                        // get the station status name is lower case
                        String status= ((String) event.getStation().getAdditionalProperties().get("station_status")).toLowerCase();

                        System.out.println("Status of station " + eventId + " is " + status);

                        // normalize status name of stations that are operating as normal to be always "active" - e.g. in Sao Paulo they use the name "IN_SERVICE"
                        if (status.equals("in_service"))
                            status = "active";
                        return ClientsUtils.createTopic(streamsConfiguration, status);
                    });
                       */

                        // New routing using the is_renting field
                        // get the station status name is lower case
                        boolean is_renting=  event.getStation().getIsRenting();

                        System.out.println("Station " + eventId + " is renting? " + is_renting);
                        return ClientsUtils.createTopic(streamsConfiguration, is_renting ? streamsConfiguration.getProperty("stations.online.topic"): streamsConfiguration.getProperty("stations.offline.topic"));
                    });
            return new KafkaStreams(builder.build(), streamsConfiguration);
            /*streams = new KafkaStreams(builder.build(), streamsConfiguration);

            streams.setUncaughtExceptionHandler(ex -> {
                System.out.println("Kafka-Streams uncaught exception occurred. Stream will be replaced with new thread:" + ex);
                return StreamsUncaughtExceptionHandler.StreamThreadExceptionResponse.REPLACE_THREAD;
            });

            streams.cleanUp();
            streams.start();
            Runtime.getRuntime().addShutdownHook(new Thread(streams::close)); */
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

        BranchStationsByStatus producer = new BranchStationsByStatus(args[0]);
        final KafkaStreams streams = producer.branch();

        final CountDownLatch latch = new CountDownLatch(1);

        // Attach shutdown handler to catch Control-C.
        Runtime.getRuntime().addShutdownHook(new Thread("streams-status-shutdown-hook") {
            @Override
            public void run() {
                streams.close(Duration.ofSeconds(5));
                latch.countDown();
            }
        });

        try {
            streams.setUncaughtExceptionHandler(ex -> {
                System.out.println("Kafka-Streams uncaught exception occurred. Stream will be replaced with new thread:" + ex);
                return StreamsUncaughtExceptionHandler.StreamThreadExceptionResponse.REPLACE_THREAD;
            });
            streams.start();
            latch.await();
        } catch (Throwable e) {
            System.out.println("streams-shutdown: " + e);
            System.exit(1);
        }
        System.exit(0);
    }
}