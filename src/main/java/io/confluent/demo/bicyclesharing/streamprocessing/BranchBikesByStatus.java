package io.confluent.demo.bicyclesharing.streamprocessing;

import io.confluent.common.utils.TestUtils;
import io.confluent.demo.bicyclesharing.pojo.FreeBikeStatusSingle;
import io.confluent.demo.bicyclesharing.pojo.StationInformationSingle;
import io.confluent.demo.bicyclesharing.utils.ClientsUtils;
import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import io.confluent.kafka.streams.serdes.json.KafkaJsonSchemaSerde;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.log4j.Logger;

import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class BranchBikesByStatus {
    private static final Logger logger = Logger.getLogger(BranchBikesByStatus.class);
    private static Properties streamsConfiguration;
    private static String bikeStatusTopicName, bikeDisable, bikeEnable;

    BranchBikesByStatus(String propertiesFile) {
        try {
            streamsConfiguration = ClientsUtils.loadConfig(propertiesFile);
            streamsConfiguration.put("default.key.serde", Serdes.String().getClass().getName());
            streamsConfiguration.put(StreamsConfig.APPLICATION_ID_CONFIG, "branch-by-bike-status");
            streamsConfiguration.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
            streamsConfiguration.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, KafkaJsonSchemaSerde.class);
            streamsConfiguration.put("json.value.type", "io.confluent.demo.bicyclesharing.pojo.FreeBikeStatus");
            bikeStatusTopicName = streamsConfiguration.getProperty("bike.status.topic");
            bikeDisable = streamsConfiguration.getProperty("bike.disable.topic");
            bikeEnable = streamsConfiguration.getProperty("bike.enable.topic");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error in constructor: " + e.getMessage());
        }
    }

    private static KafkaStreams routeEventsByRegion() {

        try {
            final StreamsBuilder builder = new StreamsBuilder();

            // Build KStream for the bike.status
           /* final KStream<String, FreeBikeStatus> bikeStatus = builder.stream(bikeStatusTopicName);

            final KStream<String, FreeBikeStatus>[] branches = bikeStatus.branch(
                    (id, event) -> event.getData().getBikes().get(0).getIsDisabled(),
                    (id, event) -> !event.getData().getBikes().get(0).getIsDisabled());
            branches[0].to(bikeDisable);
            branches[1].to(bikeEnable);
*/
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

        BranchBikesByStatus producer = new BranchBikesByStatus(args[0]);
        final KafkaStreams streams = producer.routeEventsByRegion();

        final CountDownLatch latch = new CountDownLatch(1);

        // Attach shutdown handler to catch Control-C.
        Runtime.getRuntime().addShutdownHook(new Thread("streams-bike-shutdown-hook") {
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