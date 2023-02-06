package io.confluent.demo.bicyclesharing.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StationAvailability {

//    @JsonProperty
//    public int ALL_BIKES_AVAILABLE;

    @JsonProperty
    public int NUM_BIKES_AVAILABLE;

 //   @JsonProperty
 //   public int EBIKES_AVAILABLE;

    @JsonProperty
    public int CAPACITY;

    @JsonProperty
    public double LATITUDE;

    @JsonProperty
    public double LONGITUDE;

    @JsonProperty
    public double RATIO;

    @JsonProperty
    public String STATION_NAME;

   // public int getALL_BIKES_AVAILABLE() {
   //     return ALL_BIKES_AVAILABLE;
  //  }

    public int getNUM_BIKES_AVAILABLE() {
        return NUM_BIKES_AVAILABLE;
    }

    // public int getEBIKES_AVAILABLE() { return EBIKES_AVAILABLE; }

    public String getSTATION_NAME() { return STATION_NAME; }

    public int getCAPACITY() {
        return CAPACITY;
    }

    public double getLATITUDE() {
        return LATITUDE;
    }

    public double getLONGITUDE() {
        return LONGITUDE;
    }

    public double getRATIO() {
        return RATIO;
    }

    public StationAvailability() {
    }

    public StationAvailability( int NUM_BIKES_AVAILABLE,  int CAPACITY, double LATITUDE, double LONGITUDE, double RATIO, String STATION_NAME) {
        this( NUM_BIKES_AVAILABLE,  CAPACITY, LATITUDE, LONGITUDE, RATIO, STATION_NAME, null);
    }

    public StationAvailability( int num_bikes_available, int capacity, double latitude, double longitude, double ratio, String station_name, Object o) {
    }

    /*
    public StationAvailability(int ALL_BIKES_AVAILABLE, int NUM_BIKES_AVAILABLE, int EBIKES_AVAILABLE, int CAPACITY, double LATITUDE, double LONGITUDE, double RATIO, String STATION_NAME) {
        this(ALL_BIKES_AVAILABLE, NUM_BIKES_AVAILABLE, EBIKES_AVAILABLE, CAPACITY, LATITUDE, LONGITUDE, RATIO, STATION_NAME, null);
    }

    public StationAvailability(int all_bikes_available, int bikes_available, int ebikes_available, int capacity, double latitude, double longitude, double ratio, String station_name, Object o) {
    }

     */
}