
package io.confluent.demo.bicyclesharing.pojo;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Details including system operator, system location, year implemented, URL, contact info, time zone.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "last_updated",
    "ttl",
    "version",
    "station"
})
public class StationInformationSingle {

    /**
     * Last time the data in the feed was updated in POSIX time.
     * (Required)
     * 
     */
    @JsonProperty("last_updated")
    @JsonPropertyDescription("Last time the data in the feed was updated in POSIX time.")
    private Integer lastUpdated;
    /**
     * Number of seconds before the data in the feed will be updated again (0 if the data should always be refreshed).
     * (Required)
     * 
     */
    @JsonProperty("ttl")
    @JsonPropertyDescription("Number of seconds before the data in the feed will be updated again (0 if the data should always be refreshed).")
    private Integer ttl;
    /**
     * GBFS version number to which the feed conforms, according to the versioning framework (added in v1.1).
     * (Required)
     * 
     */
    @JsonProperty("version")
    @JsonPropertyDescription("GBFS version number to which the feed conforms, according to the versioning framework (added in v1.1).")
    private String version;
    /**
     * The station information.
     * (Required)
     * 
     */
    @JsonProperty("station")
    @JsonPropertyDescription("The station information.")
    private Station station;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Last time the data in the feed was updated in POSIX time.
     * (Required)
     * 
     */
    @JsonProperty("last_updated")
    public Integer getLastUpdated() {
        return lastUpdated;
    }

    /**
     * Last time the data in the feed was updated in POSIX time.
     * (Required)
     * 
     */
    @JsonProperty("last_updated")
    public void setLastUpdated(Integer lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    /**
     * Number of seconds before the data in the feed will be updated again (0 if the data should always be refreshed).
     * (Required)
     * 
     */
    @JsonProperty("ttl")
    public Integer getTtl() {
        return ttl;
    }

    /**
     * Number of seconds before the data in the feed will be updated again (0 if the data should always be refreshed).
     * (Required)
     * 
     */
    @JsonProperty("ttl")
    public void setTtl(Integer ttl) {
        this.ttl = ttl;
    }

    /**
     * GBFS version number to which the feed conforms, according to the versioning framework (added in v1.1).
     * (Required)
     * 
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * GBFS version number to which the feed conforms, according to the versioning framework (added in v1.1).
     * (Required)
     * 
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * The station information.
     * (Required)
     * 
     */
    @JsonProperty("station")
    public Station getStation() {
        return station;
    }

    /**
     * The station information.
     * (Required)
     * 
     */
    @JsonProperty("station")
    public void setStation(Station station) {
        this.station = station;
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
        sb.append(StationInformationSingle.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("lastUpdated");
        sb.append('=');
        sb.append(((this.lastUpdated == null)?"<null>":this.lastUpdated));
        sb.append(',');
        sb.append("ttl");
        sb.append('=');
        sb.append(((this.ttl == null)?"<null>":this.ttl));
        sb.append(',');
        sb.append("version");
        sb.append('=');
        sb.append(((this.version == null)?"<null>":this.version));
        sb.append(',');
        sb.append("station");
        sb.append('=');
        sb.append(((this.station == null)?"<null>":this.station));
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
        result = ((result* 31)+((this.station == null)? 0 :this.station.hashCode()));
        result = ((result* 31)+((this.lastUpdated == null)? 0 :this.lastUpdated.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.ttl == null)? 0 :this.ttl.hashCode()));
        result = ((result* 31)+((this.version == null)? 0 :this.version.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof StationInformationSingle) == false) {
            return false;
        }
        StationInformationSingle rhs = ((StationInformationSingle) other);
        return ((((((this.station == rhs.station)||((this.station!= null)&&this.station.equals(rhs.station)))&&((this.lastUpdated == rhs.lastUpdated)||((this.lastUpdated!= null)&&this.lastUpdated.equals(rhs.lastUpdated))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.ttl == rhs.ttl)||((this.ttl!= null)&&this.ttl.equals(rhs.ttl))))&&((this.version == rhs.version)||((this.version!= null)&&this.version.equals(rhs.version))));
    }

}
