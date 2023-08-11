# Consumer to launch during the demo to show in real time on the lineage graph - gets the consumer group and client name from the script argument
export region=nyc

java -cp  ../bin/demo-bicycle-sharing-1.0-SNAPSHOT-jar-with-dependencies.jar -Dlog4j2.configurationFile=log4j.properties io.confluent.demo.bicyclesharing.consumer.StationAvailabilityConsumer bicyclesharing.$region.properties stations.color "$*" "$*"