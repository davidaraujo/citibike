export region=nyc

## ------------------------- Stations
# Produce stations status events
java -cp ../bin/demo-bicycle-sharing-1.0-SNAPSHOT-jar-with-dependencies.jar io.confluent.demo.bicyclesharing.producer.StationStatusProducer bicyclesharing.$region.properties &

# Branch stations by status: online and offline
java -cp ../bin/demo-bicycle-sharing-1.0-SNAPSHOT-jar-with-dependencies.jar io.confluent.demo.bicyclesharing.streamprocessing.BranchStationsByStatus bicyclesharing.$region.properties &

# Consume stations color code that indicates their bikes availability: green, yellow and red
java -cp  ../bin/demo-bicycle-sharing-1.0-SNAPSHOT-jar-with-dependencies.jar -Dlog4j2.configurationFile=log4j.properties io.confluent.demo.bicyclesharing.consumer.GenericConsumer bicyclesharing.$region.properties stations.color "Web app color map" "Web client 1" &
java -cp  ../bin/demo-bicycle-sharing-1.0-SNAPSHOT-jar-with-dependencies.jar -Dlog4j2.configurationFile=log4j.properties io.confluent.demo.bicyclesharing.consumer.GenericConsumer bicyclesharing.$region.properties stations.color "Tablet app color map" "Tablet client 1" &

## ------------------------- Bikes
# Producer
java -cp ../bin/demo-bicycle-sharing-1.0-SNAPSHOT-jar-with-dependencies.jar io.confluent.demo.bicyclesharing.producer.BikeStatusProducer bicyclesharing.$region.properties &
# Consumer
java -cp ../bin/demo-bicycle-sharing-1.0-SNAPSHOT-jar-with-dependencies.jar  io.confluent.demo.bicyclesharing.consumer.GenericConsumer bicyclesharing.$region.properties trips "BikesMapGroup" "BikesMap.1" &
