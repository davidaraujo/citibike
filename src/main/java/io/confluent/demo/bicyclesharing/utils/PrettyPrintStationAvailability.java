package io.confluent.demo.bicyclesharing.utils;

import io.confluent.demo.bicyclesharing.pojo.StationAvailability;
public class PrettyPrintStationAvailability {

    public static void print(String clientId, String topicName, StationAvailability value) throws Exception {

        ASCIIArtGenerator art = new ASCIIArtGenerator();
        double availability = value.getRATIO();
        int availableBikes = value.getNUM_BIKES_AVAILABLE();
        String stationName = value.getSTATION_NAME();

        if (availability >= 0.5)
            System.out.print( ColouredSystemOutPrintln.ANSI_BLACK + ColouredSystemOutPrintln.ANSI_BG_GREEN);
        else if (availability >= 0.1)
            System.out.print( ColouredSystemOutPrintln.ANSI_BLACK + ColouredSystemOutPrintln.ANSI_BG_YELLOW);
        else System.out.print( ColouredSystemOutPrintln.ANSI_BLACK + ColouredSystemOutPrintln.ANSI_BG_RED);

        System.out.print( ColouredSystemOutPrintln.ANSI_BLACK + ColouredSystemOutPrintln.ANSI_BRIGHT_BG_WHITE);
        System.out.print("The station on ");
        System.out.print(stationName);
        System.out.println(" has " + availableBikes + " bikes available ...       \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
        System.out.print(ColouredSystemOutPrintln.ANSI_BRIGHT_BG_WHITE);
        if (availability >= 0.5)
            System.out.print(ColouredSystemOutPrintln.ANSI_BG_GREEN + ColouredSystemOutPrintln.ANSI_BLACK);
        else if (availability >= 0.1)
            System.out.print( ColouredSystemOutPrintln.ANSI_BG_YELLOW + ColouredSystemOutPrintln.ANSI_BLACK);
        else System.out.print( ColouredSystemOutPrintln.ANSI_BG_RED + ColouredSystemOutPrintln.ANSI_BLACK);

        art.bike();
        System.out.println("\n" + ColouredSystemOutPrintln.ANSI_BG_BLACK);

/*
        System.out.print(ColouredSystemOutPrintln.ANSI_BLACK + ColouredSystemOutPrintln.ANSI_BG_GREEN);
        System.out.printf(
                 clientId +
                        " producing record to topic " +
                        ColouredSystemOutPrintln.ANSI_WHITE + ColouredSystemOutPrintln.ANSI_BG_PURPLE +
                        topicName +
                        ColouredSystemOutPrintln.ANSI_BLACK + ColouredSystemOutPrintln.ANSI_BG_GREEN +
                        " partition [%d] @ offset %d" + ColouredSystemOutPrintln.ANSI_RESET,
                partition, offset);
        System.out.print("\n" + ColouredSystemOutPrintln.ANSI_WHITE + ColouredSystemOutPrintln.ANSI_BG_BLUE);
        System.out.println(ColouredSystemOutPrintln.ANSI_BRIGHT_PURPLE + "key = " +  ColouredSystemOutPrintln.ANSI_WHITE  + key);

        if (formatType.equals("avro")) {
            JSONObject json = new JSONObject(value);
            System.out.print(ColouredSystemOutPrintln.ANSI_BRIGHT_PURPLE + "value = " + ColouredSystemOutPrintln.ANSI_WHITE  + json.toString(8));
        }
        else
            System.out.print(ColouredSystemOutPrintln.ANSI_BRIGHT_PURPLE +  "value = \n" + ColouredSystemOutPrintln.ANSI_WHITE  + value);
        System.out.println(ColouredSystemOutPrintln.ANSI_RESET);
    }

    public static void consumerRecord(String groupId, String clientId, String topicName, long partition, long offset, String key, String value, String formatType) {
        System.out.print(ColouredSystemOutPrintln.ANSI_BLACK + ColouredSystemOutPrintln.ANSI_BG_GREEN);
        System.out.printf(
                clientId +" @ " + groupId +
                        " consuming record from topic " +
                        ColouredSystemOutPrintln.ANSI_WHITE + ColouredSystemOutPrintln.ANSI_BG_PURPLE +
                        topicName +
                        ColouredSystemOutPrintln.ANSI_BLACK + ColouredSystemOutPrintln.ANSI_BG_GREEN +
                        " partition [%d] @ offset %d" + ColouredSystemOutPrintln.ANSI_RESET,
                partition, offset);
        if (groupId.startsWith("OnGroundService"))
            System.out.print("\n" + ColouredSystemOutPrintln.ANSI_BLACK + ColouredSystemOutPrintln.ANSI_BG_YELLOW);
        else if (groupId.startsWith("InFlightService"))
            System.out.print("\n" + ColouredSystemOutPrintln.ANSI_BLACK + ColouredSystemOutPrintln.ANSI_BG_CYAN);
        else if (groupId.startsWith("UnidentifiedService"))
            System.out.print("\n" + ColouredSystemOutPrintln.ANSI_WHITE + ColouredSystemOutPrintln.ANSI_BG_RED);
        else
            System.out.print("\n" + ColouredSystemOutPrintln.ANSI_BLACK + ColouredSystemOutPrintln.ANSI_BG_CYAN);

        System.out.println("key = " + key);
        if (formatType.equals("avro")) {
            JSONObject json = new JSONObject(value);
            System.out.print("value = " + json.toString(8));
        }
        else
            System.out.print("value = " + value);
        System.out.println(ColouredSystemOutPrintln.ANSI_RESET);
    }

 */
}
}
