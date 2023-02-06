# Bikeshare Confluent Demo

## General Bikeshare Feed Specification (GTFS) 

All  live feeds across the world can be found [here](https://github.com/NABSA/gbfs/blob/master/systems.csv)

## How to generate POJOs from JSON Schemas

## How to compile
```
mvn assembly:assembly -DdescriptorId=jar-with-dependencies -DskipGenPOJO
```

## If you want to run the custom apps in a remove machine (e.g. EC2 instance): 
```
scp target/demo-bicycle-sharing-1.0-SNAPSHOT-jar-with-dependencies.jar <>:.
```

## How to run

## How to prepare Confluent Cloud (Terraform)

## What does the demo show

Join station_status with station_information and split to multiple topics by region (join with system_regions)

station_information
{"region_id":"5","rental_methods":["KEY","CREDITCARD"],"legacy_id":"309","name":"San Jose City Hall","capacity":23,"rental_uris":{"android":"https://sfo.lft.to/lastmile_qr_scan","ios":"https://sfo.lft.to/lastmile_qr_scan"},"eightd_has_key_dispenser":false,"station_id":"5c17e1c8-5d21-4309-afcb-e69da27acf31","short_name":"SJ-M10-1","lat":37.337391,"has_kiosk":true,"electric_bike_surcharge_waiver":false,"lon":-121.886995,"external_id":"5c17e1c8-5d21-4309-afcb-e69da27acf31","station_type":"classic","eightd_station_services":[]}

station_status
{"legacy_id":"309","is_returning":1,"num_bikes_disabled":0,"is_renting":1,"num_bikes_available":8,"is_installed":1,"station_status":"active","num_docks_disabled":0,"last_reported":1651445609,"station_id":"5c17e1c8-5d21-4309-afcb-e69da27acf31","eightd_has_available_keys":false,"num_docks_available":15,"num_ebikes_available":0}

system_regions
{"region_id":"5","name":"San Jose"}

bike_status
{"is_disabled":0,"lon":-121.94418833333333,"type":"electric_bike","name":"057b404a7646a98aba39312342eea5b7","rental_uris":{"ios":"https://sfo.lft.to/lastmile_qr_scan","android":"https://sfo.lft.to/lastmile_qr_scan"},"bike_id":"057b404a7646a98aba39312342eea5b7","lat":37.327099,"is_reserved":0}
