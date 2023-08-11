
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
 * Describes the capacity and rental availability of the station
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "last_updated",
    "ttl",
    "version",
    "station"
})
@Schema(value="{\n" +
        "  \"$schema\": \"http://json-schema.org/draft-07/schema\",\n" +
        "  \"$id\": \"https://github.com/NABSA/gbfs/blob/v2.3/gbfs.md#station_statusjson\",\n" +
        "  \"description\": \"Describes the capacity and rental availability of the station\",\n" +
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
        "    \"station\": {\n" +
        "      \"type\": \"object\",\n" +
        "      \"properties\": {\n" +
        "        \"station_id\": {\n" +
        "          \"description\": \"Identifier of a station.\",\n" +
        "          \"type\": \"string\"\n" +
        "        },\n" +
        "        \"num_bikes_available\": {\n" +
        "          \"description\": \"Number of vehicles of any type physically available for rental at the station.\",\n" +
        "          \"type\": \"integer\",\n" +
        "          \"minimum\": 0\n" +
        "        },\n" +
        "        \"vehicle_types_available\": {\n" +
        "          \"description\": \"Array of objects displaying the total number of each vehicle type at the station (added in v2.1-RC).\",\n" +
        "          \"type\": \"array\",\n" +
        "          \"minItems\": 1,\n" +
        "          \"items\": {\n" +
        "            \"type\": \"object\",\n" +
        "            \"properties\": {\n" +
        "              \"vehicle_type_id\": {\n" +
        "                \"description\": \"The vehicle_type_id of vehicle at the station (added in v2.1-RC).\",\n" +
        "                \"type\": \"string\"\n" +
        "              },\n" +
        "              \"count\": {\n" +
        "                \"description\": \"A number representing the total amount of this vehicle type at the station (added in v2.1-RC).\",\n" +
        "                \"type\": \"integer\",\n" +
        "                \"minimum\": 0\n" +
        "              }\n" +
        "            },\n" +
        "            \"required\": [\n" +
        "              \"vehicle_type_id\",\n" +
        "              \"count\"\n" +
        "            ]\n" +
        "          }\n" +
        "        },\n" +
        "        \"num_bikes_disabled\": {\n" +
        "          \"description\": \"Number of disabled vehicles of any type at the station.\",\n" +
        "          \"type\": \"integer\",\n" +
        "          \"minimum\": 0\n" +
        "        },\n" +
        "        \"num_docks_available\": {\n" +
        "          \"description\": \"Number of functional docks physically at the station.\",\n" +
        "          \"type\": \"integer\",\n" +
        "          \"minimum\": 0\n" +
        "        },\n" +
        "        \"num_docks_disabled\": {\n" +
        "          \"description\": \"Number of empty but disabled docks at the station.\",\n" +
        "          \"type\": \"integer\",\n" +
        "          \"minimum\": 0\n" +
        "        },\n" +
        "        \"is_installed\": {\n" +
        "          \"description\": \"Is the station currently on the street?\",\n" +
        "          \"type\": \"boolean\"\n" +
        "        },\n" +
        "        \"is_renting\": {\n" +
        "          \"description\": \"Is the station currently renting vehicles?\",\n" +
        "          \"type\": \"boolean\"\n" +
        "        },\n" +
        "        \"is_returning\": {\n" +
        "          \"description\": \"Is the station accepting vehicle returns?\",\n" +
        "          \"type\": \"boolean\"\n" +
        "        },\n" +
        "        \"last_reported\": {\n" +
        "          \"description\": \"The last time this station reported its status to the operator's backend in POSIX time.\",\n" +
        "          \"type\": \"integer\",\n" +
        "          \"minimum\": 1450155600\n" +
        "        },\n" +
        "        \"vehicle_docks_available\": {\n" +
        "          \"description\": \"Object displaying available docks by vehicle type (added in v2.1-RC).\",\n" +
        "          \"type\": \"array\",\n" +
        "          \"items\": {\n" +
        "            \"type\": \"object\",\n" +
        "            \"properties\": {\n" +
        "              \"vehicle_type_ids\": {\n" +
        "                \"description\": \"An array of strings where each string represents a vehicle_type_id that is able to use a particular type of dock at the station (added in v2.1-RC).\",\n" +
        "                \"type\": \"array\",\n" +
        "                \"items\": {\n" +
        "                  \"type\": \"string\"\n" +
        "                }\n" +
        "              },\n" +
        "              \"count\": {\n" +
        "                \"description\": \"A number representing the total number of available docks for the defined vehicle type (added in v2.1-RC).\",\n" +
        "                \"type\": \"integer\",\n" +
        "                \"minimum\": 0\n" +
        "              }\n" +
        "            },\n" +
        "            \"required\": [\n" +
        "              \"vehicle_type_ids\",\n" +
        "              \"count\"\n" +
        "            ]\n" +
        "          }\n" +
        "        }\n" +
        "      },\n" +
        "      \"required\": [\n" +
        "        \"station_id\",\n" +
        "        \"num_bikes_available\",\n" +
        "        \"is_installed\",\n" +
        "        \"is_renting\",\n" +
        "        \"is_returning\",\n" +
        "        \"last_reported\"\n" +
        "      ]\n" +
        "    }\n" +
        "  },\n" +
        "  \"required\": [\n" +
        "    \"last_updated\",\n" +
        "    \"ttl\",\n" +
        "    \"version\",\n" +
        "    \"station\"\n" +
        "  ]\n" +
        "}\n",refs = {})
public class StationStatusSingle {

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
     * 
     * (Required)
     * 
     */
    @JsonProperty("station")
    private Station__1 station;
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
     * 
     * (Required)
     * 
     */
    @JsonProperty("station")
    public Station__1 getStation() {
        return station;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("station")
    public void setStation(Station__1 station) {
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
        sb.append(StationStatusSingle.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        if ((other instanceof StationStatusSingle) == false) {
            return false;
        }
        StationStatusSingle rhs = ((StationStatusSingle) other);
        return ((((((this.station == rhs.station)||((this.station!= null)&&this.station.equals(rhs.station)))&&((this.lastUpdated == rhs.lastUpdated)||((this.lastUpdated!= null)&&this.lastUpdated.equals(rhs.lastUpdated))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.ttl == rhs.ttl)||((this.ttl!= null)&&this.ttl.equals(rhs.ttl))))&&((this.version == rhs.version)||((this.version!= null)&&this.version.equals(rhs.version))));
    }

}
