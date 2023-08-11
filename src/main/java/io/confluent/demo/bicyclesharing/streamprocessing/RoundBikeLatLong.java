package io.confluent.demo.bicyclesharing.streamprocessing;

import io.confluent.demo.bicyclesharing.pojo.*;
import io.confluent.demo.bicyclesharing.utils.ClientsUtils;
import io.confluent.kafka.streams.serdes.json.KafkaJsonSchemaSerde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class RoundBikeLatLong {
    private static final Logger logger = Logger.getLogger(RoundBikeLatLong.class);
    private static Properties streamsConfiguration;
    private static String bikeStatusTopicName, bikeStatusRounded;

    RoundBikeLatLong(String propertiesFile) {
        try {
            streamsConfiguration = ClientsUtils.loadConfig(propertiesFile);
            streamsConfiguration.put("default.key.serde", Serdes.String().getClass().getName());
            streamsConfiguration.put(StreamsConfig.APPLICATION_ID_CONFIG, "round-latlong-100meters");
            streamsConfiguration.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
            streamsConfiguration.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, KafkaJsonSchemaSerde.class);
            streamsConfiguration.put("json.value.type", "io.confluent.demo.bicyclesharing.pojo.FreeBikeStatus");
            bikeStatusTopicName = streamsConfiguration.getProperty("bike.status.topic");
            bikeStatusRounded = streamsConfiguration.getProperty("bike.noprecision.topic");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error in constructor: " + e.getMessage());
        }
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    private static KafkaStreams routeEventsByRegion() {

        try {
            final StreamsBuilder builder = new StreamsBuilder();

            // Build KStream for the bike.status
            final KStream<String, FreeBikeStatusSingle> bikeStatus = builder.stream(bikeStatusTopicName);
            final KStream<String, Object> roundLatLong = bikeStatus.
                    map((k, v) -> {
                        Double roundLat = round(v.getBike().getLat(), 3);
                        Double roundLon = round(v.getBike().getLon(), 3);
                        Bike bike = v.getBike();
                        bike.setLat(roundLat);
                        bike.setLon(roundLon);
                        return KeyValue.pair(k, v);
                    });
            roundLatLong.to(bikeStatusRounded);
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

        RoundBikeLatLong producer = new RoundBikeLatLong(args[0]);
        final KafkaStreams streams = producer.routeEventsByRegion();

        final CountDownLatch latch = new CountDownLatch(1);

        // Attach shutdown handler to catch Control-C.
        Runtime.getRuntime().addShutdownHook(new Thread("streams-round-shutdown-hook") {
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