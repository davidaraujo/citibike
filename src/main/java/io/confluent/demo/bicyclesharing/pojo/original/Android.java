
package io.confluent.demo.bicyclesharing.pojo.original;

import java.net.URI;
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
 * Contains rental app download and app discovery information for the Android platform. (added in v1.1)
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "store_uri",
    "discovery_uri"
})
public class Android {

    /**
     * URI where the rental Android app can be downloaded from (added in v1.1).
     * (Required)
     * 
     */
    @JsonProperty("store_uri")
    @JsonPropertyDescription("URI where the rental Android app can be downloaded from (added in v1.1).")
    private URI storeUri;
    /**
     * URI that can be used to discover if the rental Android app is installed on the device (added in v1.1).
     * (Required)
     * 
     */
    @JsonProperty("discovery_uri")
    @JsonPropertyDescription("URI that can be used to discover if the rental Android app is installed on the device (added in v1.1).")
    private URI discoveryUri;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * URI where the rental Android app can be downloaded from (added in v1.1).
     * (Required)
     * 
     */
    @JsonProperty("store_uri")
    public URI getStoreUri() {
        return storeUri;
    }

    /**
     * URI where the rental Android app can be downloaded from (added in v1.1).
     * (Required)
     * 
     */
    @JsonProperty("store_uri")
    public void setStoreUri(URI storeUri) {
        this.storeUri = storeUri;
    }

    /**
     * URI that can be used to discover if the rental Android app is installed on the device (added in v1.1).
     * (Required)
     * 
     */
    @JsonProperty("discovery_uri")
    public URI getDiscoveryUri() {
        return discoveryUri;
    }

    /**
     * URI that can be used to discover if the rental Android app is installed on the device (added in v1.1).
     * (Required)
     * 
     */
    @JsonProperty("discovery_uri")
    public void setDiscoveryUri(URI discoveryUri) {
        this.discoveryUri = discoveryUri;
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
        sb.append(Android.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("storeUri");
        sb.append('=');
        sb.append(((this.storeUri == null)?"<null>":this.storeUri));
        sb.append(',');
        sb.append("discoveryUri");
        sb.append('=');
        sb.append(((this.discoveryUri == null)?"<null>":this.discoveryUri));
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
        result = ((result* 31)+((this.storeUri == null)? 0 :this.storeUri.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.discoveryUri == null)? 0 :this.discoveryUri.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Android) == false) {
            return false;
        }
        Android rhs = ((Android) other);
        return ((((this.storeUri == rhs.storeUri)||((this.storeUri!= null)&&this.storeUri.equals(rhs.storeUri)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.discoveryUri == rhs.discoveryUri)||((this.discoveryUri!= null)&&this.discoveryUri.equals(rhs.discoveryUri))));
    }

}
