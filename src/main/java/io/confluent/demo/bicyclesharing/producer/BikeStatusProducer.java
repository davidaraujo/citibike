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
import java.util.concurrent.ThreadLocalRandom;

public class BikeStatusProducer {

    private static final Logger logger = Logger.getLogger(StationStatusProducer.class);
    private static Properties props;
    private String topic;

    BikeStatusProducer(String propertiesFile) {
        try {
            props = ClientsUtils.loadConfig(propertiesFile);
            props.put("key.serializer", StringSerializer.class);
            props.put("value.serializer", "io.confluent.kafka.serializers.json.KafkaJsonSchemaSerializer");
            props.setProperty("auto.register.schemas", "false");
            props.setProperty("use.latest.version", "true");
            topic = props.getProperty("bike.status.topic");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error in BikeStatusProducer.constructor: " + e.getMessage());
        }
    }

    public void runProducer() {
        try {
            // Get stations status from the gtfs API
            Gtfs gtfs = new Gtfs(props);

            // Set the Kafka client ID as the station name
            //props.put(ProducerConfig.CLIENT_ID_CONFIG, bike.getBike().getBikeId());
            props.put(ProducerConfig.CLIENT_ID_CONFIG, props.getProperty("bikes.producer.app"));

            // Create a producer
            Producer producer = new KafkaProducer<>(props);

            while (true) {
                List<FreeBikeStatusSingle> bikesList = gtfs.getBikeStatusList();
                int numStations = bikesList.size();

                // Get list of bike status from the gtfs API
                for (int i = 0; i < numStations; i++) {
                    FreeBikeStatusSingle bike = bikesList.get(i);

                    // insert an mock userid between 1 and 10 on the record
                    int randomBetweenOneTo10 = ThreadLocalRandom.current() .nextInt(1, 10 + 1);
                    bike.setAdditionalProperty("userid", "User_" +  randomBetweenOneTo10);
                    bike.setVersion("User_" +  randomBetweenOneTo10);


                    // Create a producer record (key = bikeId)
                    ProducerRecord record = new ProducerRecord<>(topic, bike.getBike().getBikeId(), bike);

                    // Send the record
                    producer.send(record);

                    logger.info("Bike " + bike.getBike().getBikeId()
                            + " sending record with KEY=" + record.key()
                            + " and VALUE=" + record.value());
                }
                Thread.sleep(100000);
            }
            // Close producer
            //producer.close();
        } catch (Exception e) {
            logger.error("Error in BikeStatusProducer.runProducer method: ", e);
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
                BikeStatusProducer producer = new BikeStatusProducer(args[0]);
                producer.runProducer();
            } catch (Exception e) {
                logger.error("Error in BikeStatusProducer.main method: " + e.getMessage());
            }
        }
    }
}
