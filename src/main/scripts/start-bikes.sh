export region=nyc

## ------------------------- Bike Stream
# BikeStatusProducer
java -cp ../bin/demo-bicycle-sharing-1.0-SNAPSHOT-jar-with-dependencies.jar io.confluent.demo.bicyclesharing.producer.BikeStatusProducer bicyclesharing.$region.properties &
# Bikes maps consumer
java -cp ../bin/demo-bicycle-sharing-1.0-SNAPSHOT-jar-with-dependencies.jar io.confluent.demo.bicyclesharing.consumer.GenericConsumer bicyclesharing.$region.properties bike "BikeMaps" "BikeMaps" &
