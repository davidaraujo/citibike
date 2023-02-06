
package io.confluent.demo.bicyclesharing.pojo.original;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Trip
 * <p>
 * Citi Bike Trip Information
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ride_id",
    "rideable_type",
    "started_at",
    "ended_at",
    "start_station_name",
    "start_station_id",
    "end_station_name",
    "end_station_id",
    "start_lat",
    "start_lng",
    "end_lat",
    "end_lng",
    "member_casual"
})
public class Trip {

    /**
     * Ride ID
     * (Required)
     * 
     */
    @JsonProperty("ride_id")
    @JsonPropertyDescription("Ride ID")
    private String rideId;
    /**
     * Rideable type
     * (Required)
     * 
     */
    @JsonProperty("rideable_type")
    @JsonPropertyDescription("Rideable type")
    private String rideableType;
    /**
     * Started at
     * (Required)
     * 
     */
    @JsonProperty("started_at")
    @JsonPropertyDescription("Started at")
    private String startedAt;
    /**
     * Ended at
     * (Required)
     * 
     */
    @JsonProperty("ended_at")
    @JsonPropertyDescription("Ended at")
    private String endedAt;
    /**
     * Start station name
     * (Required)
     * 
     */
    @JsonProperty("start_station_name")
    @JsonPropertyDescription("Start station name")
    private String startStationName;
    /**
     * Start station ID
     * (Required)
     * 
     */
    @JsonProperty("start_station_id")
    @JsonPropertyDescription("Start station ID")
    private String startStationId;
    /**
     * End station name
     * (Required)
     * 
     */
    @JsonProperty("end_station_name")
    @JsonPropertyDescription("End station name")
    private String endStationName;
    /**
     * End station ID
     * (Required)
     * 
     */
    @JsonProperty("end_station_id")
    @JsonPropertyDescription("End station ID")
    private String endStationId;
    /**
     * Start latitude
     * (Required)
     * 
     */
    @JsonProperty("start_lat")
    @JsonPropertyDescription("Start latitude")
    private String startLat;
    /**
     * Start longitude
     * (Required)
     * 
     */
    @JsonProperty("start_lng")
    @JsonPropertyDescription("Start longitude")
    private String startLng;
    /**
     * End latitude
     * (Required)
     * 
     */
    @JsonProperty("end_lat")
    @JsonPropertyDescription("End latitude")
    private String endLat;
    /**
     * End Longitude
     * (Required)
     * 
     */
    @JsonProperty("end_lng")
    @JsonPropertyDescription("End Longitude")
    private String endLng;
    /**
     * Member or casual ride
     * (Required)
     * 
     */
    @JsonProperty("member_casual")
    @JsonPropertyDescription("Member or casual ride")
    private String memberCasual;

    /**
     * Ride ID
     * (Required)
     * 
     */
    @JsonProperty("ride_id")
    public String getRideId() {
        return rideId;
    }

    /**
     * Ride ID
     * (Required)
     * 
     */
    @JsonProperty("ride_id")
    public void setRideId(String rideId) {
        this.rideId = rideId;
    }

    /**
     * Rideable type
     * (Required)
     * 
     */
    @JsonProperty("rideable_type")
    public String getRideableType() {
        return rideableType;
    }

    /**
     * Rideable type
     * (Required)
     * 
     */
    @JsonProperty("rideable_type")
    public void setRideableType(String rideableType) {
        this.rideableType = rideableType;
    }

    /**
     * Started at
     * (Required)
     * 
     */
    @JsonProperty("started_at")
    public String getStartedAt() {
        return startedAt;
    }

    /**
     * Started at
     * (Required)
     * 
     */
    @JsonProperty("started_at")
    public void setStartedAt(String startedAt) {
        this.startedAt = startedAt;
    }

    /**
     * Ended at
     * (Required)
     * 
     */
    @JsonProperty("ended_at")
    public String getEndedAt() {
        return endedAt;
    }

    /**
     * Ended at
     * (Required)
     * 
     */
    @JsonProperty("ended_at")
    public void setEndedAt(String endedAt) {
        this.endedAt = endedAt;
    }

    /**
     * Start station name
     * (Required)
     * 
     */
    @JsonProperty("start_station_name")
    public String getStartStationName() {
        return startStationName;
    }

    /**
     * Start station name
     * (Required)
     * 
     */
    @JsonProperty("start_station_name")
    public void setStartStationName(String startStationName) {
        this.startStationName = startStationName;
    }

    /**
     * Start station ID
     * (Required)
     * 
     */
    @JsonProperty("start_station_id")
    public String getStartStationId() {
        return startStationId;
    }

    /**
     * Start station ID
     * (Required)
     * 
     */
    @JsonProperty("start_station_id")
    public void setStartStationId(String startStationId) {
        this.startStationId = startStationId;
    }

    /**
     * End station name
     * (Required)
     * 
     */
    @JsonProperty("end_station_name")
    public String getEndStationName() {
        return endStationName;
    }

    /**
     * End station name
     * (Required)
     * 
     */
    @JsonProperty("end_station_name")
    public void setEndStationName(String endStationName) {
        this.endStationName = endStationName;
    }

    /**
     * End station ID
     * (Required)
     * 
     */
    @JsonProperty("end_station_id")
    public String getEndStationId() {
        return endStationId;
    }

    /**
     * End station ID
     * (Required)
     * 
     */
    @JsonProperty("end_station_id")
    public void setEndStationId(String endStationId) {
        this.endStationId = endStationId;
    }

    /**
     * Start latitude
     * (Required)
     * 
     */
    @JsonProperty("start_lat")
    public String getStartLat() {
        return startLat;
    }

    /**
     * Start latitude
     * (Required)
     * 
     */
    @JsonProperty("start_lat")
    public void setStartLat(String startLat) {
        this.startLat = startLat;
    }

    /**
     * Start longitude
     * (Required)
     * 
     */
    @JsonProperty("start_lng")
    public String getStartLng() {
        return startLng;
    }

    /**
     * Start longitude
     * (Required)
     * 
     */
    @JsonProperty("start_lng")
    public void setStartLng(String startLng) {
        this.startLng = startLng;
    }

    /**
     * End latitude
     * (Required)
     * 
     */
    @JsonProperty("end_lat")
    public String getEndLat() {
        return endLat;
    }

    /**
     * End latitude
     * (Required)
     * 
     */
    @JsonProperty("end_lat")
    public void setEndLat(String endLat) {
        this.endLat = endLat;
    }

    /**
     * End Longitude
     * (Required)
     * 
     */
    @JsonProperty("end_lng")
    public String getEndLng() {
        return endLng;
    }

    /**
     * End Longitude
     * (Required)
     * 
     */
    @JsonProperty("end_lng")
    public void setEndLng(String endLng) {
        this.endLng = endLng;
    }

    /**
     * Member or casual ride
     * (Required)
     * 
     */
    @JsonProperty("member_casual")
    public String getMemberCasual() {
        return memberCasual;
    }

    /**
     * Member or casual ride
     * (Required)
     * 
     */
    @JsonProperty("member_casual")
    public void setMemberCasual(String memberCasual) {
        this.memberCasual = memberCasual;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Trip.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("rideId");
        sb.append('=');
        sb.append(((this.rideId == null)?"<null>":this.rideId));
        sb.append(',');
        sb.append("rideableType");
        sb.append('=');
        sb.append(((this.rideableType == null)?"<null>":this.rideableType));
        sb.append(',');
        sb.append("startedAt");
        sb.append('=');
        sb.append(((this.startedAt == null)?"<null>":this.startedAt));
        sb.append(',');
        sb.append("endedAt");
        sb.append('=');
        sb.append(((this.endedAt == null)?"<null>":this.endedAt));
        sb.append(',');
        sb.append("startStationName");
        sb.append('=');
        sb.append(((this.startStationName == null)?"<null>":this.startStationName));
        sb.append(',');
        sb.append("startStationId");
        sb.append('=');
        sb.append(((this.startStationId == null)?"<null>":this.startStationId));
        sb.append(',');
        sb.append("endStationName");
        sb.append('=');
        sb.append(((this.endStationName == null)?"<null>":this.endStationName));
        sb.append(',');
        sb.append("endStationId");
        sb.append('=');
        sb.append(((this.endStationId == null)?"<null>":this.endStationId));
        sb.append(',');
        sb.append("startLat");
        sb.append('=');
        sb.append(((this.startLat == null)?"<null>":this.startLat));
        sb.append(',');
        sb.append("startLng");
        sb.append('=');
        sb.append(((this.startLng == null)?"<null>":this.startLng));
        sb.append(',');
        sb.append("endLat");
        sb.append('=');
        sb.append(((this.endLat == null)?"<null>":this.endLat));
        sb.append(',');
        sb.append("endLng");
        sb.append('=');
        sb.append(((this.endLng == null)?"<null>":this.endLng));
        sb.append(',');
        sb.append("memberCasual");
        sb.append('=');
        sb.append(((this.memberCasual == null)?"<null>":this.memberCasual));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.startLat == null)? 0 :this.startLat.hashCode()));
        result = ((result* 31)+((this.endStationName == null)? 0 :this.endStationName.hashCode()));
        result = ((result* 31)+((this.startedAt == null)? 0 :this.startedAt.hashCode()));
        result = ((result* 31)+((this.rideId == null)? 0 :this.rideId.hashCode()));
        result = ((result* 31)+((this.memberCasual == null)? 0 :this.memberCasual.hashCode()));
        result = ((result* 31)+((this.endLat == null)? 0 :this.endLat.hashCode()));
        result = ((result* 31)+((this.endedAt == null)? 0 :this.endedAt.hashCode()));
        result = ((result* 31)+((this.endStationId == null)? 0 :this.endStationId.hashCode()));
        result = ((result* 31)+((this.rideableType == null)? 0 :this.rideableType.hashCode()));
        result = ((result* 31)+((this.startStationId == null)? 0 :this.startStationId.hashCode()));
        result = ((result* 31)+((this.endLng == null)? 0 :this.endLng.hashCode()));
        result = ((result* 31)+((this.startStationName == null)? 0 :this.startStationName.hashCode()));
        result = ((result* 31)+((this.startLng == null)? 0 :this.startLng.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Trip) == false) {
            return false;
        }
        Trip rhs = ((Trip) other);
        return ((((((((((((((this.startLat == rhs.startLat)||((this.startLat!= null)&&this.startLat.equals(rhs.startLat)))&&((this.endStationName == rhs.endStationName)||((this.endStationName!= null)&&this.endStationName.equals(rhs.endStationName))))&&((this.startedAt == rhs.startedAt)||((this.startedAt!= null)&&this.startedAt.equals(rhs.startedAt))))&&((this.rideId == rhs.rideId)||((this.rideId!= null)&&this.rideId.equals(rhs.rideId))))&&((this.memberCasual == rhs.memberCasual)||((this.memberCasual!= null)&&this.memberCasual.equals(rhs.memberCasual))))&&((this.endLat == rhs.endLat)||((this.endLat!= null)&&this.endLat.equals(rhs.endLat))))&&((this.endedAt == rhs.endedAt)||((this.endedAt!= null)&&this.endedAt.equals(rhs.endedAt))))&&((this.endStationId == rhs.endStationId)||((this.endStationId!= null)&&this.endStationId.equals(rhs.endStationId))))&&((this.rideableType == rhs.rideableType)||((this.rideableType!= null)&&this.rideableType.equals(rhs.rideableType))))&&((this.startStationId == rhs.startStationId)||((this.startStationId!= null)&&this.startStationId.equals(rhs.startStationId))))&&((this.endLng == rhs.endLng)||((this.endLng!= null)&&this.endLng.equals(rhs.endLng))))&&((this.startStationName == rhs.startStationName)||((this.startStationName!= null)&&this.startStationName.equals(rhs.startStationName))))&&((this.startLng == rhs.startLng)||((this.startLng!= null)&&this.startLng.equals(rhs.startLng))));
    }

}
