
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
@Schema(value="{\n" +
        "  \"$schema\": \"http://json-schema.org/draft-07/schema\",\n" +
        "  \"$id\": \"https://github.com/NABSA/gbfs/blob/v2.3/gbfs.md#station_informationjson\",\n" +
        "  \"description\": \"Details including system operator, system location, year implemented, URL, contact info, time zone.\",\n" +
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
        "      \"description\": \"The station information.\",\n" +
        "      \"type\": \"object\",\n" +
        "      \"properties\": {\n" +
        "        \"station_id\": {\n" +
        "          \"description\": \"Identifier of a station.\",\n" +
        "          \"type\": \"string\"\n" +
        "        },\n" +
        "        \"name\": {\n" +
        "          \"description\": \"Public name of the station.\",\n" +
        "          \"type\": \"string\"\n" +
        "        },\n" +
        "        \"short_name\": {\n" +
        "          \"description\": \"Short name or other type of identifier.\",\n" +
        "          \"type\": \"string\"\n" +
        "        },\n" +
        "        \"lat\": {\n" +
        "          \"description\": \"The latitude of the station.\",\n" +
        "          \"type\": \"number\",\n" +
        "          \"minimum\": -90,\n" +
        "          \"maximum\": 90\n" +
        "        },\n" +
        "        \"lon\": {\n" +
        "          \"description\": \"The longitude fo the station.\",\n" +
        "          \"type\": \"number\",\n" +
        "          \"minimum\": -180,\n" +
        "          \"maximum\": 180\n" +
        "        },\n" +
        "        \"address\": {\n" +
        "          \"description\": \"Address where station is located.\",\n" +
        "          \"type\": \"string\"\n" +
        "        },\n" +
        "        \"cross_street\": {\n" +
        "          \"description\": \"Cross street or landmark where the station is located.\",\n" +
        "          \"type\": \"string\"\n" +
        "        },\n" +
        "        \"region_id\": {\n" +
        "          \"description\": \"Identifier of the region where the station is located.\",\n" +
        "          \"type\": \"string\"\n" +
        "        },\n" +
        "        \"post_code\": {\n" +
        "          \"description\": \"Postal code where station is located.\",\n" +
        "          \"type\": \"string\"\n" +
        "        },\n" +
        "        \"rental_methods\": {\n" +
        "          \"description\": \"Payment methods accepted at this station.\",\n" +
        "          \"type\": \"array\",\n" +
        "          \"items\": {\n" +
        "            \"type\": \"string\",\n" +
        "            \"enum\": [\n" +
        "              \"KEY\",\n" +
        "              \"CREDITCARD\",\n" +
        "              \"PAYPASS\",\n" +
        "              \"APPLEPAY\",\n" +
        "              \"ANDROIDPAY\",\n" +
        "              \"TRANSITCARD\",\n" +
        "              \"ACCOUNTNUMBER\",\n" +
        "              \"PHONE\"\n" +
        "            ]\n" +
        "          },\n" +
        "          \"minItems\": 1\n" +
        "        },\n" +
        "        \"is_virtual_station\": {\n" +
        "          \"description\": \"Is this station a location with or without physical infrastructure? (added in v2.1-RC)\",\n" +
        "          \"type\": \"boolean\"\n" +
        "        },\n" +
        "        \"station_area\": {\n" +
        "          \"description\": \"A multipolygon that describes the area of a virtual station (added in v2.1-RC).\",\n" +
        "          \"type\": \"object\",\n" +
        "          \"required\": [\n" +
        "            \"type\",\n" +
        "            \"coordinates\"\n" +
        "          ],\n" +
        "          \"properties\": {\n" +
        "            \"type\": {\n" +
        "              \"type\": \"string\",\n" +
        "              \"enum\": [\n" +
        "                \"MultiPolygon\"\n" +
        "              ]\n" +
        "            },\n" +
        "            \"coordinates\": {\n" +
        "              \"type\": \"array\",\n" +
        "              \"items\": {\n" +
        "                \"type\": \"array\",\n" +
        "                \"items\": {\n" +
        "                  \"type\": \"array\",\n" +
        "                  \"minItems\": 4,\n" +
        "                  \"items\": {\n" +
        "                    \"type\": \"array\",\n" +
        "                    \"minItems\": 2,\n" +
        "                    \"items\": {\n" +
        "                      \"type\": \"number\"\n" +
        "                    }\n" +
        "                  }\n" +
        "                }\n" +
        "              }\n" +
        "            }\n" +
        "          }\n" +
        "        },\n" +
        "        \"parking_type\": {\n" +
        "          \"description\": \"Type of parking station. Added in v2.3\",\n" +
        "          \"type\": \"string\",\n" +
        "          \"enum\": [\n" +
        "            \"parking_lot\",\n" +
        "            \"street_parking\",\n" +
        "            \"underground_parking\",\n" +
        "            \"sidewalk_parking\",\n" +
        "            \"other\"\n" +
        "          ]\n" +
        "        },\n" +
        "        \"parking_hoop\": {\n" +
        "          \"description\": \"Are parking hoops present at this station? Added in v2.3\",\n" +
        "          \"type\": \"boolean\"\n" +
        "        },\n" +
        "        \"contact_phone\": {\n" +
        "          \"description\": \"Contact phone of the station. Added in v2.3\",\n" +
        "          \"type\": \"string\"\n" +
        "        },\n" +
        "        \"capacity\": {\n" +
        "          \"description\": \"Number of total docking points installed at this station, both available and unavailable.\",\n" +
        "          \"type\": \"integer\",\n" +
        "          \"minimum\": 0\n" +
        "        },\n" +
        "        \"vehicle_capacity\": {\n" +
        "          \"description\": \"An object where each key is a vehicle_type_id and the value is a number presenting the total number of vehicles of this type that can park within the station_area (added in v2.1-RC).\",\n" +
        "          \"type\": \"object\",\n" +
        "          \"additionalProperties\": {\n" +
        "            \"type\": \"number\"\n" +
        "          }\n" +
        "        },\n" +
        "        \"is_valet_station\": {\n" +
        "          \"description\": \"Are valet services provided at this station? (added in v2.1-RC)\",\n" +
        "          \"type\": \"boolean\"\n" +
        "        },\n" +
        "        \"is_charging_station\": {\n" +
        "          \"description\": \"Does the station support charging of electric vehicles? (added in v2.3-RC)\",\n" +
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
        "              \"description\": \"URI that can be used on iOS to launch the rental app for this station (added in v1.1).\",\n" +
        "              \"type\": \"string\",\n" +
        "              \"format\": \"uri\"\n" +
        "            },\n" +
        "            \"web\": {\n" +
        "              \"description\": \"URL that can be used by a web browser to show more information about renting a vehicle at this station (added in v1.1).\",\n" +
        "              \"type\": \"string\",\n" +
        "              \"format\": \"uri\"\n" +
        "            }\n" +
        "          }\n" +
        "        },\n" +
        "        \"vehicle_type_capacity\": {\n" +
        "          \"description\": \"An object where each key is a vehicle_type_id and the value is a number representing the total docking points installed at this station for each vehicle type (added in v2.1-RC).\",\n" +
        "          \"type\": \"object\",\n" +
        "          \"additionalProperties\": {\n" +
        "            \"type\": \"number\"\n" +
        "          }\n" +
        "        }\n" +
        "      },\n" +
        "      \"required\": [\n" +
        "        \"station_id\",\n" +
        "        \"name\",\n" +
        "        \"lat\",\n" +
        "        \"lon\"\n" +
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
