package io.confluent.demo.bicyclesharing.streamprocessing;

import io.confluent.demo.bicyclesharing.pojo.StationStatusSingle;

public class MyStationStatus {

    private StationStatusSingle stationStatus;
    public MyStationStatus(StationStatusSingle station, String region) {
        station.setAdditionalProperty("region", region);
        stationStatus = station;
    }

    public StationStatusSingle getStationStatus() {
        return stationStatus;
    }
}
