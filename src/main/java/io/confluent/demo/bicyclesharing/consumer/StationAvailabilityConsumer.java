package io.confluent.demo.bicyclesharing.consumer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.confluent.demo.bicyclesharing.pojo.StationAvailability;
import io.confluent.demo.bicyclesharing.utils.*;
import org.apache.kafka.clients.consumer.*;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class StationAvailabilityConsumer implements Runnable {

    private static final Logger logger = Logger.getLogger(StationAvailabilityConsumer.class.getName());
    private static Properties props;
    private String topicNames;
    private String groupId;
    private String clientId;

    public StationAvailabilityConsumer(String propertiesFile,
                                       String topicNames,
                                       String groupId,
                                       String clientId) {
        try {
            props = ClientsUtils.loadConfig(propertiesFile);
            props.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
            props.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "io.confluent.kafka.serializers.json.KafkaJsonSchemaDeserializer");
            if (groupId != null)
                props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
            if (clientId != null)
                props.put(ConsumerConfig.CLIENT_ID_CONFIG, clientId);
            props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
            this.topicNames = topicNames;
            this.groupId = groupId;
            this.clientId = clientId;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void runConsumer() throws Exception {

        // Create a consumer
        final Consumer<String, JsonNode> consumer = new KafkaConsumer<String, JsonNode>(props);

        try {
            // Subscribe to topic(s)
            consumer.subscribe(Arrays.asList(topicNames.split(",")));

            // Print stations stock with art work
            ASCIIArtGenerator art = new ASCIIArtGenerator();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.print(ColouredSystemOutPrintln.ANSI_BRIGHT_PURPLE);
            art.bigBike();
            System.out.println("\n");
            ASCIIArtService.print(clientId);

            Thread.sleep(3000);

            while (true) {
                ConsumerRecords<String, JsonNode> records = consumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, JsonNode> record : records) {
                    StationAvailability station = new ObjectMapper().convertValue(record.value(), new TypeReference<StationAvailability>() {
                    });
                    PrettyPrintStationAvailability.print("", "", station);
                    /*
                    System.out.println("Station name: " + station.getSTATION_NAME());
                    System.out.println("Capacity: " + station.getCAPACITY());
                    System.out.println("Bikes available: " + station.getALL_BIKES_AVAILABLE());
                    System.out.println("Push bikes available: " + station.getBIKES_AVAILABLE());
                    System.out.println("Electric bikes available: " + station.getEBIKES_AVAILABLE());
                    System.out.println("Latitude: " + station.getLATITUDE());
                    System.out.println("Longitude: " + station.getLONGITUDE());
                    System.out.println("Bikes ratio: " + station.getRATIO());
                    art.bike();
                    */
                }
            }
        } catch (Exception e) {
            logger.error("Error in runConsumer method: " + e.getMessage());
        } finally {
            consumer.close();
            logger.info("Closed the consumer connection");
        }
    }

    /**
     * @param args resourcesDir propertiesFile topicName groupID clientID
     * @param args [0] The properties filename
     * @param args [1] The name of the topic to subscribe
     * @param args [2] The group Id
     * @param args [3] The client Id
     * @return Nothing.
     */
    public static void main(final String[] args) throws Exception {
        int numArgs = args.length;

        if (numArgs < 4) {
            logger.error("Please provide command line arguments: propertiesFile topicNames(comma separated) groupID clientID");
            System.exit(1);
        }
        String propertiesFile = args[0];
        String topicName = args[1];
        String groupId = args[2];
        String clientId = args[3];

        StationAvailabilityConsumer consumer = new StationAvailabilityConsumer(propertiesFile, topicName, groupId, clientId);
        consumer.runConsumer();
    }

    @Override
    public void run() {
        try {
            this.runConsumer();
        } catch (IOException e) {
            logger.error("IOException in run method: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            logger.error("Exception in run method: " + e.getMessage());
            e.printStackTrace();
        }
    }
}