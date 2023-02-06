
package io.confluent.demo.bicyclesharing.pojo.original;

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
 * Contains rental app information in the android and ios JSON objects (added in v1.1).
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "android",
    "ios"
})
public class RentalApps {

    /**
     * Contains rental app download and app discovery information for the Android platform. (added in v1.1)
     * 
     */
    @JsonProperty("android")
    @JsonPropertyDescription("Contains rental app download and app discovery information for the Android platform. (added in v1.1)")
    private Android android;
    /**
     * Contains rental information for the iOS platform (added in v1.1).
     * 
     */
    @JsonProperty("ios")
    @JsonPropertyDescription("Contains rental information for the iOS platform (added in v1.1).")
    private Ios ios;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Contains rental app download and app discovery information for the Android platform. (added in v1.1)
     * 
     */
    @JsonProperty("android")
    public Android getAndroid() {
        return android;
    }

    /**
     * Contains rental app download and app discovery information for the Android platform. (added in v1.1)
     * 
     */
    @JsonProperty("android")
    public void setAndroid(Android android) {
        this.android = android;
    }

    /**
     * Contains rental information for the iOS platform (added in v1.1).
     * 
     */
    @JsonProperty("ios")
    public Ios getIos() {
        return ios;
    }

    /**
     * Contains rental information for the iOS platform (added in v1.1).
     * 
     */
    @JsonProperty("ios")
    public void setIos(Ios ios) {
        this.ios = ios;
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
        sb.append(RentalApps.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("android");
        sb.append('=');
        sb.append(((this.android == null)?"<null>":this.android));
        sb.append(',');
        sb.append("ios");
        sb.append('=');
        sb.append(((this.ios == null)?"<null>":this.ios));
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
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.ios == null)? 0 :this.ios.hashCode()));
        result = ((result* 31)+((this.android == null)? 0 :this.android.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RentalApps) == false) {
            return false;
        }
        RentalApps rhs = ((RentalApps) other);
        return ((((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties)))&&((this.ios == rhs.ios)||((this.ios!= null)&&this.ios.equals(rhs.ios))))&&((this.android == rhs.android)||((this.android!= null)&&this.android.equals(rhs.android))));
    }

}
