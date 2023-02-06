package io.confluent.demo.bicyclesharing.streamprocessing;

import io.confluent.demo.bicyclesharing.pojo.StationStatusSingle;
import io.confluent.demo.bicyclesharing.utils.ClientsUtils;
import io.confluent.kafka.streams.serdes.json.KafkaJsonSchemaSerde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.errors.StreamsUncaughtExceptionHandler;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.log4j.Logger;

import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class DataQualityRules {
    private static final Logger logger = Logger.getLogger(DataQualityRules.class);
    private static Properties streamsConfiguration;
    private static String stationTopicName, stationCleanTopicName;

    DataQualityRules(String propertiesFile) {
        try {
            streamsConfiguration = ClientsUtils.loadConfig(propertiesFile);
            streamsConfiguration.put("default.key.serde", Serdes.String().getClass().getName());
            streamsConfiguration.put(StreamsConfig.APPLICATION_ID_CONFIG, "data-quality-validations");
            streamsConfiguration.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
            streamsConfiguration.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, KafkaJsonSchemaSerde.class);
            streamsConfiguration.put("json.value.type", "io.confluent.demo.bicyclesharing.pojo.StationStatusSingle");
            stationTopicName = streamsConfiguration.getProperty("station.status.topic");
            stationCleanTopicName = streamsConfiguration.getProperty("station.status.clean.topic");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error in constructor: " + e.getMessage());
        }
    }

    private static KafkaStreams branch() {

        try {
            final StreamsBuilder builder = new StreamsBuilder();

            // Build KStream for the bike.status
            final KStream<String, StationStatusSingle> stationStatus = builder.stream(stationTopicName);

            final KStream<String, StationStatusSingle> normalizeFieldNames = stationStatus.
                    map((k, v) -> {

                        // *** Rule #1 - normalize status field name to station_status
                        String fieldNameStatus = (String) v.getStation().getAdditionalProperties().get("status");
                        String fieldNameStationStatus = (String) v.getStation().getAdditionalProperties().get("station_status");

                        // If field name is status, convert to field name station_status
                        if (fieldNameStatus != null) {
                            v.getStation().getAdditionalProperties().put("station_status", fieldNameStatus);
                            v.getStation().getAdditionalProperties().remove("status");
                        }
                        // Else if field name is status_status is empty, insert one with value Unknown
                        else if (fieldNameStationStatus == null) {
                            v.getStation().getAdditionalProperties().put("station_status", "Unknown");
                        }
                        // *** Rule #2 - ...

                        System.out.println(v.getStation().getAdditionalProperties().get("station_status"));

                        return KeyValue.pair(k, v);
                    });
            normalizeFieldNames.to(stationCleanTopicName);
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

        DataQualityRules producer = new DataQualityRules(args[0]);
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