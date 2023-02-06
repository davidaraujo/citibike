
package io.confluent.demo.bicyclesharing.pojo.original;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "alert_id",
    "type",
    "times",
    "station_ids",
    "region_ids",
    "url",
    "summary",
    "description",
    "last_updated"
})
public class Alert {

    /**
     * Identifier for this alert.
     * (Required)
     * 
     */
    @JsonProperty("alert_id")
    @JsonPropertyDescription("Identifier for this alert.")
    private String alertId;
    /**
     * Type of alert.
     * (Required)
     * 
     */
    @JsonProperty("type")
    @JsonPropertyDescription("Type of alert.")
    private Alert.Type type;
    /**
     * Array of objects indicating when the alert is in effect.
     * 
     */
    @JsonProperty("times")
    @JsonPropertyDescription("Array of objects indicating when the alert is in effect.")
    private List<Time> times = new ArrayList<Time>();
    /**
     * Array of identifiers of the stations for which this alert applies.
     * 
     */
    @JsonProperty("station_ids")
    @JsonPropertyDescription("Array of identifiers of the stations for which this alert applies.")
    private List<String> stationIds = new ArrayList<String>();
    /**
     * Array of identifiers of the regions for which this alert applies.
     * 
     */
    @JsonProperty("region_ids")
    @JsonPropertyDescription("Array of identifiers of the regions for which this alert applies.")
    private List<String> regionIds = new ArrayList<String>();
    /**
     * URL where the customer can learn more information about this alert.
     * 
     */
    @JsonProperty("url")
    @JsonPropertyDescription("URL where the customer can learn more information about this alert.")
    private URI url;
    /**
     * A short summary of this alert to be displayed to the customer.
     * (Required)
     * 
     */
    @JsonProperty("summary")
    @JsonPropertyDescription("A short summary of this alert to be displayed to the customer.")
    private String summary;
    /**
     * Detailed description of the alert.
     * 
     */
    @JsonProperty("description")
    @JsonPropertyDescription("Detailed description of the alert.")
    private String description;
    /**
     * Indicates the last time the info for the alert was updated.
     * 
     */
    @JsonProperty("last_updated")
    @JsonPropertyDescription("Indicates the last time the info for the alert was updated.")
    private Double lastUpdated;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Identifier for this alert.
     * (Required)
     * 
     */
    @JsonProperty("alert_id")
    public String getAlertId() {
        return alertId;
    }

    /**
     * Identifier for this alert.
     * (Required)
     * 
     */
    @JsonProperty("alert_id")
    public void setAlertId(String alertId) {
        this.alertId = alertId;
    }

    /**
     * Type of alert.
     * (Required)
     * 
     */
    @JsonProperty("type")
    public Alert.Type getType() {
        return type;
    }

    /**
     * Type of alert.
     * (Required)
     * 
     */
    @JsonProperty("type")
    public void setType(Alert.Type type) {
        this.type = type;
    }

    /**
     * Array of objects indicating when the alert is in effect.
     * 
     */
    @JsonProperty("times")
    public List<Time> getTimes() {
        return times;
    }

    /**
     * Array of objects indicating when the alert is in effect.
     * 
     */
    @JsonProperty("times")
    public void setTimes(List<Time> times) {
        this.times = times;
    }

    /**
     * Array of identifiers of the stations for which this alert applies.
     * 
     */
    @JsonProperty("station_ids")
    public List<String> getStationIds() {
        return stationIds;
    }

    /**
     * Array of identifiers of the stations for which this alert applies.
     * 
     */
    @JsonProperty("station_ids")
    public void setStationIds(List<String> stationIds) {
        this.stationIds = stationIds;
    }

    /**
     * Array of identifiers of the regions for which this alert applies.
     * 
     */
    @JsonProperty("region_ids")
    public List<String> getRegionIds() {
        return regionIds;
    }

    /**
     * Array of identifiers of the regions for which this alert applies.
     * 
     */
    @JsonProperty("region_ids")
    public void setRegionIds(List<String> regionIds) {
        this.regionIds = regionIds;
    }

    /**
     * URL where the customer can learn more information about this alert.
     * 
     */
    @JsonProperty("url")
    public URI getUrl() {
        return url;
    }

    /**
     * URL where the customer can learn more information about this alert.
     * 
     */
    @JsonProperty("url")
    public void setUrl(URI url) {
        this.url = url;
    }

    /**
     * A short summary of this alert to be displayed to the customer.
     * (Required)
     * 
     */
    @JsonProperty("summary")
    public String getSummary() {
        return summary;
    }

    /**
     * A short summary of this alert to be displayed to the customer.
     * (Required)
     * 
     */
    @JsonProperty("summary")
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * Detailed description of the alert.
     * 
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * Detailed description of the alert.
     * 
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Indicates the last time the info for the alert was updated.
     * 
     */
    @JsonProperty("last_updated")
    public Double getLastUpdated() {
        return lastUpdated;
    }

    /**
     * Indicates the last time the info for the alert was updated.
     * 
     */
    @JsonProperty("last_updated")
    public void setLastUpdated(Double lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Alert.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("alertId");
        sb.append('=');
        sb.append(((this.alertId == null)?"<null>":this.alertId));
        sb.append(',');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("times");
        sb.append('=');
        sb.append(((this.times == null)?"<null>":this.times));
        sb.append(',');
        sb.append("stationIds");
        sb.append('=');
        sb.append(((this.stationIds == null)?"<null>":this.stationIds));
        sb.append(',');
        sb.append("regionIds");
        sb.append('=');
        sb.append(((this.regionIds == null)?"<null>":this.regionIds));
        sb.append(',');
        sb.append("url");
        sb.append('=');
        sb.append(((this.url == null)?"<null>":this.url));
        sb.append(',');
        sb.append("summary");
        sb.append('=');
        sb.append(((this.summary == null)?"<null>":this.summary));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
        sb.append(',');
        sb.append("lastUpdated");
        sb.append('=');
        sb.append(((this.lastUpdated == null)?"<null>":this.lastUpdated));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
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
        result = ((result* 31)+((this.summary == null)? 0 :this.summary.hashCode()));
        result = ((result* 31)+((this.lastUpdated == null)? 0 :this.lastUpdated.hashCode()));
        result = ((result* 31)+((this.times == null)? 0 :this.times.hashCode()));
        result = ((result* 31)+((this.stationIds == null)? 0 :this.stationIds.hashCode()));
        result = ((result* 31)+((this.description == null)? 0 :this.description.hashCode()));
        result = ((result* 31)+((this.regionIds == null)? 0 :this.regionIds.hashCode()));
        result = ((result* 31)+((this.alertId == null)? 0 :this.alertId.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        result = ((result* 31)+((this.url == null)? 0 :this.url.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Alert) == false) {
            return false;
        }
        Alert rhs = ((Alert) other);
        return (((((((((((this.summary == rhs.summary)||((this.summary!= null)&&this.summary.equals(rhs.summary)))&&((this.lastUpdated == rhs.lastUpdated)||((this.lastUpdated!= null)&&this.lastUpdated.equals(rhs.lastUpdated))))&&((this.times == rhs.times)||((this.times!= null)&&this.times.equals(rhs.times))))&&((this.stationIds == rhs.stationIds)||((this.stationIds!= null)&&this.stationIds.equals(rhs.stationIds))))&&((this.description == rhs.description)||((this.description!= null)&&this.description.equals(rhs.description))))&&((this.regionIds == rhs.regionIds)||((this.regionIds!= null)&&this.regionIds.equals(rhs.regionIds))))&&((this.alertId == rhs.alertId)||((this.alertId!= null)&&this.alertId.equals(rhs.alertId))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))))&&((this.url == rhs.url)||((this.url!= null)&&this.url.equals(rhs.url))));
    }


    /**
     * Type of alert.
     * 
     */
    public enum Type {

        SYSTEM_CLOSURE("system_closure"),
        STATION_CLOSURE("station_closure"),
        STATION_MOVE("station_move"),
        OTHER("other");
        private final String value;
        private final static Map<String, Alert.Type> CONSTANTS = new HashMap<String, Alert.Type>();

        static {
            for (Alert.Type c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private Type(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static Alert.Type fromValue(String value) {
            Alert.Type constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
