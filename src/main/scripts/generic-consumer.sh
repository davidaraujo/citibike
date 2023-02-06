export region=nyc

## ------------------------- Generic consumer with args topicname, groupid, consumerid
# GenericConsumer
java -cp ../bin/demo-bicycle-sharing-1.0-SNAPSHOT-jar-with-dependencies.jar  io.confluent.demo.bicyclesharing.consumer.GenericConsumer bicyclesharing.$region.properties "$1" "$2" "$3"
