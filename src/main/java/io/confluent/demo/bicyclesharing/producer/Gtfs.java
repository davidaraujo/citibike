package io.confluent.demo.bicyclesharing.producer;

import io.confluent.demo.bicyclesharing.pojo.*;
import io.confluent.demo.bicyclesharing.pojo.original.*;
import io.confluent.demo.bicyclesharing.pojo.original.Bike;
import io.confluent.demo.bicyclesharing.pojo.original.Region;
import io.confluent.demo.bicyclesharing.pojo.original.Station;
import io.confluent.demo.bicyclesharing.pojo.original.Station__1;
import io.confluent.demo.bicyclesharing.utils.ClientsUtils;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.log4j.Logger;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.Properties;

public class Gtfs {

    private static final Logger logger = Logger.getLogger(Gtfs.class);
    private String stationStationUrl, stationInformationUrl, systemRegionsUrl, bikeStatusUrl;
    private Hashtable stationsInformation;

    public Gtfs(Properties props) {
        try {
            stationStationUrl = props.getProperty("station.status.url");
            stationInformationUrl  = props.getProperty("station.information.url");
            systemRegionsUrl = props.getProperty("system.regions.url");
            bikeStatusUrl = props.getProperty("bike.status.url");

            fillStationInformation();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error in Gtfs constructor: " + e.getMessage());
        }
    }

    private void fillStationInformation() {
        try {
            RestTemplate restTemplate = new RestTemplate();

            // Fetch station information
            io.confluent.demo.bicyclesharing.pojo.original.StationInformation stationInformationPojo
                    = restTemplate.getForObject(stationInformationUrl, io.confluent.demo.bicyclesharing.pojo.original.StationInformation.class);

            // Create a hashtable with key station ID and value station name
            stationsInformation = new Hashtable();
            io.confluent.demo.bicyclesharing.pojo.original.Station station;
            Iterator stationIterator = stationInformationPojo.getData().getStations().iterator();
            while (stationIterator.hasNext()) {
                station = ((io.confluent.demo.bicyclesharing.pojo.original.Station) stationIterator.next());
                //System.out.println("new hash entry: " + station.getStationId() + " and " + station.getName());
                stationsInformation.put(station.getStationId(), station.getName()); // + "," + station.getLat() + "," + station.getLon() + "," + station.getCapacity());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error("Error in Gtfs fillStationInformation: " + e.getMessage());
        }
    }

    public List     getStationStatusList() {
        List stationStatusList = new ArrayList();
        try {
            // Fetch stations status from the gtfs API directly into a StationStatus pojo
            RestTemplate restTemplate = new RestTemplate();
            StationStatus stationStatusOriginalPojo
                    = restTemplate.getForObject(stationStationUrl, StationStatus.class);
            Data__4 stationStatusData = stationStatusOriginalPojo.getData();
            List<io.confluent.demo.bicyclesharing.pojo.original.Station__1> stationStatusStations = stationStatusData.getStations();
            int numStations = stationStatusStations.size();

            // Iterate over the list of stations and create a list
            for (int i = 0; i < numStations; i++) {
                // Create POJO for just one station
                StationStatusSingle newStationStatus = new StationStatusSingle();

                // Copy version, ttl and last updated from original POJO to new single POJO
                //newStationStatus.setVersion(stationStatusOriginalPojo.getVersion());
                newStationStatus.setVersion("2.4");
                newStationStatus.setTtl(stationStatusOriginalPojo.getTtl());
                newStationStatus.setLastUpdated(stationStatusOriginalPojo.getLastUpdated());

                // Create new StationStatus pojo with 1 station status (io.confluent.demo.bicyclesharing.pojo.StationStatus)
                Station__1 stationOriginalPojo = stationStatusStations.get(i);
                io.confluent.demo.bicyclesharing.pojo.Station__1 stationPojo = new io.confluent.demo.bicyclesharing.pojo.Station__1();

                // Copy values
                stationPojo.setStationId(stationOriginalPojo.getStationId()); // "station_id"
                stationPojo.setIsInstalled(stationOriginalPojo.getIsInstalled()); // "is_installed"
                stationPojo.setIsRenting(stationOriginalPojo.getIsRenting()); // "is_renting"
                stationPojo.setIsReturning(stationOriginalPojo.getIsReturning()); // "is_returning"
                stationPojo.setLastReported(stationOriginalPojo.getLastReported()); // "last_reported"
                stationPojo.setNumBikesAvailable(stationOriginalPojo.getNumBikesAvailable()); // "num_bikes_available"
                stationPojo.setNumBikesDisabled(stationOriginalPojo.getNumBikesDisabled()); // "num_bikes_disabled"
                stationPojo.setNumDocksAvailable(stationOriginalPojo.getNumDocksAvailable()); // "num_docks_available"
                stationPojo.setNumDocksDisabled(stationOriginalPojo.getNumDocksDisabled()); // "num_docks_disabled"
                stationPojo.setIsRenting(stationOriginalPojo.getIsRenting());
                //stationPojo.setVehicleDocksAvailable(stationOriginalPojo.getVehicleDocksAvailable()); // "vehicle_docks_available"
                //stationPojo.setVehicleTypesAvailable(stationOriginalPojo.getVehicleTypesAvailable()); // "vehicle_types_available"
                stationPojo.setIsInstalled(stationOriginalPojo.getIsInstalled());
                stationPojo.setIsInstalled(stationOriginalPojo.getIsInstalled());

                if (stationOriginalPojo.getAdditionalProperties().containsKey("station_status"))
                    stationPojo.setAdditionalProperty("station_status", stationOriginalPojo.getAdditionalProperties().get("station_status"));
                if (stationOriginalPojo.getAdditionalProperties().containsKey("status"))
                    stationPojo.setAdditionalProperty("status", stationOriginalPojo.getAdditionalProperties().get("status"));

                // Add station name as an additional property
                if (stationsInformation.get(stationOriginalPojo.getStationId()) != null)
                stationPojo.setAdditionalProperty("station_name", stationsInformation.get(stationOriginalPojo.getStationId()));
                else
                    stationPojo.setAdditionalProperty("station_name", "Unknown");

                newStationStatus.setStation(stationPojo);
                stationStatusList.add(newStationStatus);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error("Error in Gtfs getStationStatusList: " + e.getMessage());
        }
        return stationStatusList;
    }

    public List getStationInformationList() {

        List stationInformationList = new ArrayList();

        try {
            // Fetch stations status from the gtfs API directly into a StationStatus pojo
            RestTemplate restTemplate = new RestTemplate();
            StationInformation stationInformationOriginalPojo
                    = restTemplate.getForObject(stationInformationUrl, StationInformation.class);
            Data__3 stationInformationData = stationInformationOriginalPojo.getData();
            List<io.confluent.demo.bicyclesharing.pojo.original.Station> stationsInformation = stationInformationData.getStations();
            int numStations = stationsInformation.size();

            // Iterate over the list of stations and create a list
            for (int i = 0; i < numStations; i++) {
                // Create POJO for just one station
                StationInformationSingle stationInformationPojo = new StationInformationSingle();

                // Copy version, ttl and last updated from original POJO to new single POJO
                stationInformationPojo.setVersion(stationInformationOriginalPojo.getVersion());
                stationInformationPojo.setTtl(stationInformationOriginalPojo.getTtl());
                stationInformationPojo.setLastUpdated(stationInformationOriginalPojo.getLastUpdated());

                // Create new StationStatus pojo with 1 station status (io.confluent.demo.bicyclesharing.pojo.StationStatus)
                Station stationOriginalPojo = stationsInformation.get(i);
                io.confluent.demo.bicyclesharing.pojo.Station stationPojo = new io.confluent.demo.bicyclesharing.pojo.Station();

                // Copy values
                stationPojo.setStationId(stationOriginalPojo.getStationId()); // "station_id"
                stationPojo.setName(stationOriginalPojo.getName()); // "name"
                stationPojo.setShortName(stationOriginalPojo.getShortName()); // "short_name",
                stationPojo.setLat(stationOriginalPojo.getLat());// "lat",
                stationPojo.setLon(stationOriginalPojo.getLon());// "lon",
                stationPojo.setAddress(stationOriginalPojo.getAddress());// "address",
                stationPojo.setCrossStreet(stationOriginalPojo.getCrossStreet());// "cross_street",
                stationPojo.setRegionId(stationOriginalPojo.getRegionId());// "region_id",
                stationPojo.setPostCode(stationOriginalPojo.getPostCode());// "post_code",
                // stationPojo.setRentalMethods(stationOriginalPojo.getRentalMethods());// "rental_methods",
                stationPojo.setIsVirtualStation(stationOriginalPojo.getIsVirtualStation());// "is_virtual_station",
                // stationPojo.setStationArea(stationOriginalPojo.getStationArea());// "station_area",
                // stationPojo.setParkingType(stationOriginalPojo.getParkingType());// "parking_type",
                stationPojo.setParkingHoop(stationOriginalPojo.getParkingHoop());// "parking_hoop",
                stationPojo.setContactPhone(stationOriginalPojo.getContactPhone());// "contact_phone",
                stationPojo.setCapacity(stationOriginalPojo.getCapacity());// "capacity",
                // stationPojo.setVehicleCapacity(stationOriginalPojo.getVehicleCapacity());// "vehicle_capacity",
                stationPojo.setIsValetStation(stationOriginalPojo.getIsValetStation());// "is_valet_station",
                stationPojo.setIsChargingStation(stationOriginalPojo.getIsChargingStation());// "is_charging_station",
                // stationPojo.setRentalUris(stationOriginalPojo.getRentalUris());// "rental_uris",
                // stationPojo.setVehicleCapacity(stationOriginalPojo.getVehicleCapacity());// "vehicle_type_capacity"
                stationInformationPojo.setStation(stationPojo);

                // Add station information to list
                stationInformationList.add(stationInformationPojo);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error("Error in Gtfs getStationStatusList: " + e.getMessage());
        }
        return stationInformationList;
    }

    public List getSystemRegionsList() {

        List regionsList = new ArrayList();

        try {
            // Fetch regions from the gtfs API directly into a SystemRegion pojo
            RestTemplate restTemplate = new RestTemplate();
            SystemRegions mainOriginal
                    = restTemplate.getForObject(systemRegionsUrl, SystemRegions.class);
            List<io.confluent.demo.bicyclesharing.pojo.original.Region> regionsMainOriginal = mainOriginal.getData().getRegions();
            int numRegions = regionsMainOriginal.size();

            // Iterate over the list of regions and create a list
            for (int i = 0; i < numRegions; i++) {

                // Create POJO for just one region
                SystemRegionSingle regionPojo = new SystemRegionSingle();

                // Copy version, ttl and last updated from original POJO to new single POJO
                regionPojo.setVersion(mainOriginal.getVersion());
                regionPojo.setTtl(mainOriginal.getTtl());
                regionPojo.setLastUpdated(mainOriginal.getLastUpdated());

                // Create new StationStatus pojo with 1 station status (io.confluent.demo.bicyclesharing.pojo.StationStatus)
                Region regionOriginalPojo = regionsMainOriginal.get(i);
                io.confluent.demo.bicyclesharing.pojo.Region newRegion = new io.confluent.demo.bicyclesharing.pojo.Region();

                // Copy values
                newRegion.setRegionId(regionOriginalPojo.getRegionId()); // "regional_id"
                newRegion.setName(regionOriginalPojo.getName()); // "name"
                regionPojo.setRegion(newRegion);
                regionsList.add(regionPojo);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error("Error in Gtfs getStationStatusList: " + e.getMessage());
        }
        return regionsList;
    }

    public List getBikeStatusList() {

        List bikesList = new ArrayList();

        try {
            // Fetch bike status from the gtfs API directly into a FreeBikeStatus pojo
            RestTemplate restTemplate = new RestTemplate();
            FreeBikeStatus mainOriginal
                    = restTemplate.getForObject(bikeStatusUrl, FreeBikeStatus.class);
            List<io.confluent.demo.bicyclesharing.pojo.original.Bike> bikeMainOriginal = mainOriginal.getData().getBikes();
            int numRegions = bikeMainOriginal.size();

            // Iterate over the list of regions and create a list
            for (int i = 0; i < numRegions; i++) {

                // Create POJO for just one region
                FreeBikeStatusSingle bikePojo = new FreeBikeStatusSingle();

                // Copy version, ttl and last updated from original POJO to new single POJO
                bikePojo.setVersion(mainOriginal.getVersion());
                bikePojo.setTtl(mainOriginal.getTtl());
                bikePojo.setLastUpdated(mainOriginal.getLastUpdated());

                // Create new Bike pojo with 1 bike (io.confluent.demo.bicyclesharing.pojo.Bike)
                Bike bikeOriginalPojo = bikeMainOriginal.get(i);
                io.confluent.demo.bicyclesharing.pojo.Bike newBike = new io.confluent.demo.bicyclesharing.pojo.Bike();

                // Copy values
                newBike.setIsDisabled(bikeOriginalPojo.getIsDisabled());
                newBike.setBikeId(bikeOriginalPojo.getBikeId());
                newBike.setLon(bikeOriginalPojo.getLon());
                newBike.setLat(bikeOriginalPojo.getLat());
                newBike.setAvailableUntil(bikeOriginalPojo.getAvailableUntil());
                newBike.setCurrentFuelPercent(bikeOriginalPojo.getCurrentFuelPercent());
                newBike.setCurrentRangeMeters(bikeOriginalPojo.getCurrentRangeMeters());
                newBike.setHomeStationId(bikeOriginalPojo.getHomeStationId());
                newBike.setIsDisabled(bikeOriginalPojo.getIsDisabled());
                newBike.setIsReserved(bikeOriginalPojo.getIsReserved());
                newBike.setLastReported(bikeOriginalPojo.getLastReported());
                newBike.setPricingPlanId(bikeOriginalPojo.getPricingPlanId());
                //newBike.setRentalUris(bikeOriginalPojo.getRentalUris().);
                //newBike.setVehicleEquipment(bikeOriginalPojo.getVehicleEquipment());
                newBike.setPricingPlanId(bikeOriginalPojo.getPricingPlanId());
                newBike.setPricingPlanId(bikeOriginalPojo.getPricingPlanId());

                bikePojo.setBike(newBike);

                bikesList.add(bikePojo);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error("Error in Gtfs getBikeStatusList: " + e.getMessage());
        }
        return bikesList;
    }
}
