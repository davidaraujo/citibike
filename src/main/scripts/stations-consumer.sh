export region=nyc

## ------------------------- Stations consumer from stations.availability topic
# StationAvailabilityConsumer
java -cp ../bin/demo-bicycle-sharing-1.0-SNAPSHOT-jar-with-dependencies.jar  io.confluent.demo.bicyclesharing.consumer.StationAvailabilityConsumer bicyclesharing.$region.properties stations.availability "$*" "$*"
