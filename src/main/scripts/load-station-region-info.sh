export region=nyc

## ------------------------- Station Information and System Regions
# StationInformationProducer
java -cp ../bin/demo-bicycle-sharing-1.0-SNAPSHOT-jar-with-dependencies.jar  io.confluent.demo.bicyclesharing.producer.StationInformationProducer bicyclesharing.$region.properties &
# SystemRegionsProducer
#java -cp ../bin/demo-bicycle-sharing-1.0-SNAPSHOT-jar-with-dependencies.jar  io.confluent.demo.bicyclesharing.producer.SystemRegionsProducer bicyclesharing.$region.properties &
