-- WARNING: Run the script ./load-station-region-info.sh before creating the streams and tables below
CREATE STREAM online WITH (KAFKA_TOPIC = 'stations.online', VALUE_FORMAT = 'JSON_SR');
SELECT station->NUM_DOCKS_AVAILABLE FROM online EMIT CHANGES;

CREATE TABLE station_information (ID STRING PRIMARY KEY) WITH (KAFKA_TOPIC = 'stations.info', VALUE_FORMAT = 'JSON_SR');

CREATE STREAM calculate_color_code WITH (KAFKA_TOPIC = 'stations.color',VALUE_FORMAT = 'JSON_SR') AS
    SELECT station_information.id as station_id,
           station_information.station->name as station_name,
           station_information.station->lat as latitude,
           station_information.station->lon as longitude,
           station_information.station->capacity,
           online.station->num_bikes_available,
           (online.station->num_bikes_available)/ cast(station_information.station->capacity as double) as ratio
        FROM online
        INNER JOIN station_information ON online.station->station_id = station_information.id;


