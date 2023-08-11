# CitiBike demo 

Confluent Cloud demo using bike sharing systems real-time data feeds from [General Bikeshare Feed Specification format](https://github.com/MobilityData/gbfs).

This demo can be tailored (simple change in a config file) to use a different [bike sharing systems across the world](https://github.com/NABSA/gbfs/blob/master/systems.csv). 

## Data
The demo uses 2 data feeds from a bike sharing system, **stations** and **bikes**.

* Stations inform the current status of a bike station, example of a record:  
```
{"legacy_id":"309","is_returning":1,"num_bikes_disabled":0,"is_renting":1,"num_bikes_available":8,"is_installed":1,"station_status":"active","num_docks_disabled":0,"last_reported":1651445609,"station_id":"5c17e1c8-5d21-4309-afcb-e69da27acf31","eightd_has_available_keys":false,"num_docks_available":15,"num_ebikes_available":0}
```
* Bikes inform the current position of a bike on the street, example of a record:
```
{"is_disabled":0,"lon":-121.94418833333333,"type":"electric_bike","name":"057b404a7646a98aba39312342eea5b7","rental_uris":{"ios":"https://sfo.lft.to/lastmile_qr_scan","android":"https://sfo.lft.to/lastmile_qr_scan"},"bike_id":"057b404a7646a98aba39312342eea5b7","lat":37.327099,"is_reserved":0}
```

## Compile and create jar
```
mvn assembly:assembly -DdescriptorId=jar-with-dependencies -DskipGenPOJO
```

## Before you start
1. Create a topic with name `stations.raw.topic` and add the [schema](src/schemas/station_information_single.json).
2. Run the [script](src/main/scripts/load-station-region-info.sh) to populate the topic `stations.info`.

## Start and stop the demo
1. Update the properties [file](src/main/resources/bicyclesharing.nyc.properties) with your Kafka cluster and Schema Registry endpoint and keys.
2. Update the location to your properties file and jar on the start-demo.sh [file](src/main/scripts/start-demo.sh)
3. Run `./start-demo.sh` to start all producers and consumers of the demo.
4. Run `./stop-demo.sh` to stop all producers and consumers of the demo.

