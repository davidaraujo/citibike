export region=nyc_dedicated

### Demo
# Stations: stations producer, data quality KStreams, route stations by status KStreams, stations availability consumers
# Bikes: bikes producer, trips consumer

## ------------------------- Stations producer
# StationStatusProducer
java -cp ../bin/demo-bicycle-sharing-1.0-SNAPSHOT-jar-with-dependencies.jar io.confluent.demo.bicyclesharing.producer.StationStatusProducer bicyclesharing.$region.properties &
# StationInformationProducer
#java -cp ../bin/demo-bicycle-sharing-1.0-SNAPSHOT-jar-with-dependencies.jar  io.confluent.demo.bicyclesharing.producer.StationInformationProducer bicyclesharing.$region.properties &
# SystemRegionsProducer
#java -cp ../bin/demo-bicycle-sharing-1.0-SNAPSHOT-jar-with-dependencies.jar  io.confluent.demo.bicyclesharing.producer.SystemRegionsProducer bicyclesharing.$region.properties &
# RegionRouting
#java -cp ../bin/demo-bicycle-sharing-1.0-SNAPSHOT-jar-with-dependencies.jar  io.confluent.demo.bicyclesharing.streamprocessing.RegionRouting bicyclesharing.$region.properties &

## ------------------------- KStreams for stations
# Run data quality rules validation
java -cp ../bin/demo-bicycle-sharing-1.0-SNAPSHOT-jar-with-dependencies.jar io.confluent.demo.bicyclesharing.streamprocessing.DataQualityRules bicyclesharing.$region.properties &

# Route stations to different topics based on status
java -cp ../bin/demo-bicycle-sharing-1.0-SNAPSHOT-jar-with-dependencies.jar io.confluent.demo.bicyclesharing.streamprocessing.BranchStationsByStatus bicyclesharing.$region.properties &

## ------------------------- Stations consumer
# GenericConsumer
java -cp ../bin/demo-bicycle-sharing-1.0-SNAPSHOT-jar-with-dependencies.jar  io.confluent.demo.bicyclesharing.consumer.GenericConsumer bicyclesharing.$region.properties stations.availability "WebAppGroup" "WebApp.1" &
java -cp ../bin/demo-bicycle-sharing-1.0-SNAPSHOT-jar-with-dependencies.jar  io.confluent.demo.bicyclesharing.consumer.GenericConsumer bicyclesharing.$region.properties stations.availability "MobileAppGroup" "MobileApp.2" &


## ------------------------- Bikes producer
# BikeStatusProducer
java -cp ../bin/demo-bicycle-sharing-1.0-SNAPSHOT-jar-with-dependencies.jar io.confluent.demo.bicyclesharing.producer.BikeStatusProducer bicyclesharing.$region.properties &

## ------------------------- Bikes consumer
# GenericConsumer
java -cp ../bin/demo-bicycle-sharing-1.0-SNAPSHOT-jar-with-dependencies.jar  io.confluent.demo.bicyclesharing.consumer.GenericConsumer bicyclesharing.$region.properties trips "BikesMapGroup" "BikesMap.1" &
