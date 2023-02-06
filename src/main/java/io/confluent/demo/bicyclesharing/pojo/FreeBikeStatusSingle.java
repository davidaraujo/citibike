
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
import io.confluent.kafka.schemaregistry.annotations.Schema;


/**
 * Describes the vehicles that are available for rent (as of v2.1-RC2).
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "last_updated",
    "ttl",
    "version",
    "bike"
})
@Schema(value="{\n" +
        "  \"$schema\": \"http://json-schema.org/draft-07/schema\",\n" +
        "  \"$id\": \"https://github.com/NABSA/gbfs/blob/v2.3/gbfs.md#free_bike_statusjson\",\n" +
        "  \"description\": \"Describes the vehicles that are available for rent (as of v2.1-RC2).\",\n" +
        "  \"type\": \"object\",\n" +
        "  \"properties\": {\n" +
        "    \"last_updated\": {\n" +
        "      \"description\": \"Last time the data in the feed was updated in POSIX time.\",\n" +
        "      \"type\": \"integer\",\n" +
        "      \"minimum\": 1450155600\n" +
        "    },\n" +
        "    \"ttl\": {\n" +
        "      \"description\": \"Number of seconds before the data in the feed will be updated again (0 if the data should always be refreshed).\",\n" +
        "      \"type\": \"integer\",\n" +
        "      \"minimum\": 0\n" +
        "    },\n" +
        "    \"version\": {\n" +
        "      \"description\": \"GBFS version number to which the feed conforms, according to the versioning framework (added in v1.1).\",\n" +
        "      \"type\": \"string\",\n" +
        "      \"const\": \"2.3\"\n" +
        "    },\n" +
        "    \"bike\": {\n" +
        "      \"description\": \"The bike information.\",\n" +
        "      \"type\": \"object\",\n" +
        "      \"properties\": {\n" +
        "        \"bike_id\": {\n" +
        "          \"description\": \"Rotating (as of v2.0) identifier of a vehicle.\",\n" +
        "          \"type\": \"string\"\n" +
        "        },\n" +
        "        \"lat\": {\n" +
        "          \"description\": \"The latitude of the vehicle.\",\n" +
        "          \"type\": \"number\",\n" +
        "          \"minimum\": -90,\n" +
        "          \"maximum\": 90\n" +
        "        },\n" +
        "        \"lon\": {\n" +
        "          \"description\": \"The longitude of the vehicle.\",\n" +
        "          \"type\": \"number\",\n" +
        "          \"minimum\": -180,\n" +
        "          \"maximum\": 180\n" +
        "        },\n" +
        "        \"is_reserved\": {\n" +
        "          \"description\": \"Is the vehicle currently reserved?\",\n" +
        "          \"type\": \"boolean\"\n" +
        "        },\n" +
        "        \"is_disabled\": {\n" +
        "          \"description\": \"Is the vehicle currently disabled (broken)?\",\n" +
        "          \"type\": \"boolean\"\n" +
        "        },\n" +
        "        \"rental_uris\": {\n" +
        "          \"description\": \"Contains rental uris for Android, iOS, and web in the android, ios, and web fields (added in v1.1).\",\n" +
        "          \"type\": \"object\",\n" +
        "          \"properties\": {\n" +
        "            \"android\": {\n" +
        "              \"description\": \"URI that can be passed to an Android app with an intent (added in v1.1).\",\n" +
        "              \"type\": \"string\",\n" +
        "              \"format\": \"uri\"\n" +
        "            },\n" +
        "            \"ios\": {\n" +
        "              \"description\": \"URI that can be used on iOS to launch the rental app for this vehicle (added in v1.1).\",\n" +
        "              \"type\": \"string\",\n" +
        "              \"format\": \"uri\"\n" +
        "            },\n" +
        "            \"web\": {\n" +
        "              \"description\": \"URL that can be used by a web browser to show more information about renting this vehicle (added in v1.1).\",\n" +
        "              \"type\": \"string\",\n" +
        "              \"format\": \"uri\"\n" +
        "            }\n" +
        "          }\n" +
        "        },\n" +
        "        \"vehicle_type_id\": {\n" +
        "          \"description\": \"The vehicle_type_id of this vehicle (added in v2.1-RC).\",\n" +
        "          \"type\": \"string\"\n" +
        "        },\n" +
        "        \"last_reported\": {\n" +
        "          \"description\": \"The last time this vehicle reported its status to the operator's backend in POSIX time (added in v2.1-RC).\",\n" +
        "          \"type\": \"number\",\n" +
        "          \"minimum\": 1450155600\n" +
        "        },\n" +
        "        \"current_range_meters\": {\n" +
        "          \"description\": \"The furthest distance in meters that the vehicle can travel without recharging or refueling with the vehicle's current charge or fuel (added in v2.1-RC).\",\n" +
        "          \"type\": \"number\",\n" +
        "          \"minimum\": 0\n" +
        "        },\n" +
        "        \"current_fuel_percent\": {\n" +
        "          \"description\": \"This value represents the current percentage, expressed from 0 to 1, of fuel or battery power remaining in the vehicle. Added in v2.3-RC.\",\n" +
        "          \"type\": \"number\",\n" +
        "          \"minimum\": 0\n" +
        "        },\n" +
        "        \"station_id\": {\n" +
        "          \"description\": \"Identifier referencing the station_id if the vehicle is currently at a station (added in v2.1-RC2).\",\n" +
        "          \"type\": \"string\"\n" +
        "        },\n" +
        "        \"home_station_id\": {\n" +
        "          \"description\": \"The station_id of the station this vehicle must be returned to (added in v2.3-RC).\",\n" +
        "          \"type\": \"string\"\n" +
        "        },\n" +
        "        \"pricing_plan_id\": {\n" +
        "          \"description\": \"The plan_id of the pricing plan this vehicle is eligible for (added in v2.2).\",\n" +
        "          \"type\": \"string\"\n" +
        "        },\n" +
        "        \"vehicle_equipment\": {\n" +
        "          \"description\": \"List of vehicle equipment provided by the operator in addition to the accessories already provided in the vehicle. Added in v2.3.\",\n" +
        "          \"type\": \"array\",\n" +
        "          \"items\": {\n" +
        "            \"enum\": [\n" +
        "              \"child_seat_a\",\n" +
        "              \"child_seat_b\",\n" +
        "              \"child_seat_c\",\n" +
        "              \"winter_tires\",\n" +
        "              \"snow_chains\"\n" +
        "            ]\n" +
        "          }\n" +
        "        },\n" +
        "        \"available_until\": {\n" +
        "          \"description\": \"The date and time when any rental of the vehicle must be completed. Added in v2.3.\",\n" +
        "          \"type\": \"string\",\n" +
        "          \"pattern\": \"^([0-9]{4})-([0-9]{2})-([0-9]{2})T([0-9]{2}):([0-9]{2}):([0-9]{2})([A-Z])$\"\n" +
        "        }\n" +
        "      }\n" +
        "    }\n" +
        "  },\n" +
        "  \"required\": [\n" +
        "    \"last_updated\",\n" +
        "    \"ttl\",\n" +
        "    \"version\",\n" +
        "    \"bike\"\n" +
        "  ]\n" +
        "}\n",refs = {})
public class FreeBikeStatusSingle {

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
     * The bike information.
     * (Required)
     * 
     */
    @JsonProperty("bike")
    @JsonPropertyDescription("The bike information.")
    private Bike bike;
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
     * The bike information.
     * (Required)
     * 
     */
    @JsonProperty("bike")
    public Bike getBike() {
        return bike;
    }

    /**
     * The bike information.
     * (Required)
     * 
     */
    @JsonProperty("bike")
    public void setBike(Bike bike) {
        this.bike = bike;
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
        sb.append(FreeBikeStatusSingle.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        sb.append("bike");
        sb.append('=');
        sb.append(((this.bike == null)?"<null>":this.bike));
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
        result = ((result* 31)+((this.lastUpdated == null)? 0 :this.lastUpdated.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.ttl == null)? 0 :this.ttl.hashCode()));
        result = ((result* 31)+((this.version == null)? 0 :this.version.hashCode()));
        result = ((result* 31)+((this.bike == null)? 0 :this.bike.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FreeBikeStatusSingle) == false) {
            return false;
        }
        FreeBikeStatusSingle rhs = ((FreeBikeStatusSingle) other);
        return ((((((this.lastUpdated == rhs.lastUpdated)||((this.lastUpdated!= null)&&this.lastUpdated.equals(rhs.lastUpdated)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.ttl == rhs.ttl)||((this.ttl!= null)&&this.ttl.equals(rhs.ttl))))&&((this.version == rhs.version)||((this.version!= null)&&this.version.equals(rhs.version))))&&((this.bike == rhs.bike)||((this.bike!= null)&&this.bike.equals(rhs.bike))));
    }

}
