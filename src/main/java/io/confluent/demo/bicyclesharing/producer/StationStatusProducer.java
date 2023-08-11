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

public class StationStatusProducer {

    private static final Logger logger = Logger.getLogger(StationStatusProducer.class);
    private static Properties props;
    private String topic;

    StationStatusProducer(String propertiesFile) {
        try {
            props = ClientsUtils.loadConfig(propertiesFile);
            props.put("key.serializer", StringSerializer.class);
            props.put("value.serializer", "io.confluent.kafka.serializers.json.KafkaJsonSchemaSerializer");
            props.setProperty("auto.register.schemas", "false");
            props.setProperty("use.latest.version", "true");
            // TODO test create topic and schema with code
            topic = props.getProperty("stations.raw.topic");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error in constructor: " + e.getMessage());
        }
    }

    public void runProducer() {
        try {
            while (true) {
                try {
                    // Get stations status from the gtfs API
                    Gtfs gtfs = new Gtfs(props);

                    List<StationStatusSingle> stationsList = gtfs.getStationStatusList();
                    int numStations = stationsList.size();

                    // Get list of station status from the gtfs API
                    for (int i = 0; i < numStations; i++) {
                        StationStatusSingle station = stationsList.get(i);

                        // Set the Kafka client ID as the station name
                        props.put(ProducerConfig.CLIENT_ID_CONFIG, station.getStation().getAdditionalProperties().get("station_name"));

                        // Create a producer
                        Producer producer = new KafkaProducer<>(props);

                        // Create a producer record (key = stationId)
                        ProducerRecord record = new ProducerRecord<>(topic, station.getStation().getStationId(), station);

                        // Send the record
                        producer.send(record);

                        // Close producer
                        producer.close();

                        logger.info("Station " + station.getStation().getAdditionalProperties().get("station_name")
                                + " sending record with KEY=" + record.key()
                                + " and VALUE=" + record.value());
                    }
                    Thread.sleep(100000);
                }
                catch (Exception e) {
                    logger.error("Error in StationStatusProducer.runProducer loop: ", e);
                    StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
                    for (StackTraceElement stackTrace : stackTraceElements) {
                        logger.error(stackTrace.getClassName() + "  " + stackTrace.getMethodName() + " " + stackTrace.getLineNumber());
                    }
                    e.printStackTrace();
                    continue;
                }
            }
        } catch (Exception e) {
            logger.error("Error in StationStatusProducer.runProducer method: ", e);
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
                StationStatusProducer producer = new StationStatusProducer(args[0]);
                producer.runProducer();
            } catch (Exception e) {
                logger.error("Error in StationStatusProducer.main method: " + e.getMessage());
            }
        }
    }
}
