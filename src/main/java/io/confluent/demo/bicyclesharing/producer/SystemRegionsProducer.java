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

public class SystemRegionsProducer {

    private static final Logger logger = Logger.getLogger(SystemRegionsProducer.class);
    private static Properties props;
    private String systemRegionsTopic, systemRegionsUrl;

    SystemRegionsProducer(String propertiesFile) {
        try {
            props = ClientsUtils.loadConfig(propertiesFile);
            props.put("key.serializer", StringSerializer.class);
            props.put("value.serializer", "io.confluent.kafka.serializers.json.KafkaJsonSchemaSerializer");
            props.setProperty("auto.register.schemas", "false");
            props.setProperty("use.latest.version", "true");
            systemRegionsTopic = props.getProperty("system.regions.topic");
            systemRegionsUrl = props.getProperty("system.regions.url");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error in constructor: " + e.getMessage());
        }
    }

    public void runProducer() {
        try {
            // Get system regions from the gtfs API
            Gtfs gtfs = new Gtfs(props);

            List<SystemRegionSingle> regionsList = gtfs.getSystemRegionsList();
            int numRegions = regionsList.size();

            for (int i = 0; i < numRegions; i++) {

                String regionId = regionsList.get(i).getRegion().getRegionId();
                String regionName = regionsList.get(i).getRegion().getName();

                // Set the Kafka client ID as the station
                props.put(ProducerConfig.CLIENT_ID_CONFIG, regionName);

                // Create a producer
                Producer producer = new KafkaProducer<>(props);

                // Create a producer record (key = stationId)
                ProducerRecord record = new ProducerRecord<>(systemRegionsTopic, regionId, regionsList.get(i));

                // Send the record
                producer.send(record);
                // log.error("Loop count #" + loopCount + " - record#" + numRecords++ + " of total " + numStations + " for station name " + stationStatusPOJO.getStationName() + ".");

                // Close producer
                producer.close();

                logger.info("Region " + regionId
                        + " sending record with KEY=" + record.key()
                        + " and VALUE=" + record.value());
            }
            logger.info("Finished loading region information to topic " + systemRegionsTopic);
        } catch (Exception e) {
            logger.error("Error in runProducer method: ", e);
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
                SystemRegionsProducer producer = new SystemRegionsProducer(args[0]);
                producer.runProducer();
            } catch (Exception e) {
                logger.error("Error in main method: " + e.getMessage());
            }
        }
    }
}