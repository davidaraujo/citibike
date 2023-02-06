-- WARNING: Run the script ./load-station-region-info.sh before creating the streams and tables below


CREATE STREAM active WITH (KAFKA_TOPIC = 'active', VALUE_FORMAT = 'JSON_SR');
SELECT station->NUM_DOCKS_AVAILABLE FROM active EMIT CHANGES;

CREATE TABLE station_information (ID STRING PRIMARY KEY) WITH (KAFKA_TOPIC = 'station.information', VALUE_FORMAT = 'JSON_SR');

CREATE STREAM station_availability_rate WITH (KAFKA_TOPIC = 'availability.rate',VALUE_FORMAT = 'JSON_SR') AS
    SELECT station_information.id as station_id,
           station_information.station->name as station_name,
           station_information.station->lat as latitude,
           station_information.station->lon as longitude,
           station_information.station->capacity,
           active.station->num_bikes_available,
           (active.station->num_bikes_available)/ cast(station_information.station->capacity as double) as ratio
        FROM active
        INNER JOIN station_information ON active.station->station_id = station_information.id;

CREATE STREAM station_bike_repair WITH (KAFKA_TOPIC = 'repair',VALUE_FORMAT = 'JSON_SR') AS
    SELECT station_information.id as station_id,
           station_information.station->name as station_name,
           station_information.station->lat as latitude,
           station_information.station->lon as longitude,
           active.station->NUM_BIKES_DISABLED
        FROM active
        INNER JOIN station_information ON active.station->station_id = station_information.id
        WHERE active.station->NUM_BIKES_DISABLED > 0;

-- TODO
CREATE STREAM station_needing_bike_repair WITH (KAFKA_TOPIC = 'station-repair',VALUE_FORMAT = 'JSON_SR') AS
    SELECT station_information.id as station_id,
           station_information.name as station_name,
           station_information.lat as latitude,
           station_information.lon as longitude,
           station_status_clean.bikes_disabled
        FROM station_status_clean
        LEFT JOIN station_information ON cast(station_status_clean.station_id as int) = station_information.id
        WHERE station_status_clean.bikes_disabled > 0;
