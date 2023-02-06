
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
 * An object where each key defines one of the items listed below (added in v2.3-RC).
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "brand_last_modified",
    "brand_terms_url",
    "brand_image_url",
    "brand_image_url_dark",
    "color"
})
public class BrandAssets {

    /**
     * Date that indicates the last time any included brand assets were updated (added in v2.3-RC).
     * (Required)
     * 
     */
    @JsonProperty("brand_last_modified")
    @JsonPropertyDescription("Date that indicates the last time any included brand assets were updated (added in v2.3-RC).")
    private String brandLastModified;
    /**
     * A fully qualified URL pointing to the location of a page that defines the license terms of brand icons, colors or other trademark information (added in v2.3-RC).
     * 
     */
    @JsonProperty("brand_terms_url")
    @JsonPropertyDescription("A fully qualified URL pointing to the location of a page that defines the license terms of brand icons, colors or other trademark information (added in v2.3-RC).")
    private URI brandTermsUrl;
    /**
     * A fully qualified URL pointing to the location of a graphic file representing the brand for the service (added in v2.3-RC). 
     * (Required)
     * 
     */
    @JsonProperty("brand_image_url")
    @JsonPropertyDescription("A fully qualified URL pointing to the location of a graphic file representing the brand for the service (added in v2.3-RC). ")
    private URI brandImageUrl;
    /**
     * A fully qualified URL pointing to the location of a graphic file representing the brand for the service for use in dark mode (added in v2.3-RC).
     * 
     */
    @JsonProperty("brand_image_url_dark")
    @JsonPropertyDescription("A fully qualified URL pointing to the location of a graphic file representing the brand for the service for use in dark mode (added in v2.3-RC).")
    private URI brandImageUrlDark;
    /**
     * Color used to represent the brand for the service (added in v2.3-RC)
     * 
     */
    @JsonProperty("color")
    @JsonPropertyDescription("Color used to represent the brand for the service (added in v2.3-RC)")
    private String color;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Date that indicates the last time any included brand assets were updated (added in v2.3-RC).
     * (Required)
     * 
     */
    @JsonProperty("brand_last_modified")
    public String getBrandLastModified() {
        return brandLastModified;
    }

    /**
     * Date that indicates the last time any included brand assets were updated (added in v2.3-RC).
     * (Required)
     * 
     */
    @JsonProperty("brand_last_modified")
    public void setBrandLastModified(String brandLastModified) {
        this.brandLastModified = brandLastModified;
    }

    /**
     * A fully qualified URL pointing to the location of a page that defines the license terms of brand icons, colors or other trademark information (added in v2.3-RC).
     * 
     */
    @JsonProperty("brand_terms_url")
    public URI getBrandTermsUrl() {
        return brandTermsUrl;
    }

    /**
     * A fully qualified URL pointing to the location of a page that defines the license terms of brand icons, colors or other trademark information (added in v2.3-RC).
     * 
     */
    @JsonProperty("brand_terms_url")
    public void setBrandTermsUrl(URI brandTermsUrl) {
        this.brandTermsUrl = brandTermsUrl;
    }

    /**
     * A fully qualified URL pointing to the location of a graphic file representing the brand for the service (added in v2.3-RC). 
     * (Required)
     * 
     */
    @JsonProperty("brand_image_url")
    public URI getBrandImageUrl() {
        return brandImageUrl;
    }

    /**
     * A fully qualified URL pointing to the location of a graphic file representing the brand for the service (added in v2.3-RC). 
     * (Required)
     * 
     */
    @JsonProperty("brand_image_url")
    public void setBrandImageUrl(URI brandImageUrl) {
        this.brandImageUrl = brandImageUrl;
    }

    /**
     * A fully qualified URL pointing to the location of a graphic file representing the brand for the service for use in dark mode (added in v2.3-RC).
     * 
     */
    @JsonProperty("brand_image_url_dark")
    public URI getBrandImageUrlDark() {
        return brandImageUrlDark;
    }

    /**
     * A fully qualified URL pointing to the location of a graphic file representing the brand for the service for use in dark mode (added in v2.3-RC).
     * 
     */
    @JsonProperty("brand_image_url_dark")
    public void setBrandImageUrlDark(URI brandImageUrlDark) {
        this.brandImageUrlDark = brandImageUrlDark;
    }

    /**
     * Color used to represent the brand for the service (added in v2.3-RC)
     * 
     */
    @JsonProperty("color")
    public String getColor() {
        return color;
    }

    /**
     * Color used to represent the brand for the service (added in v2.3-RC)
     * 
     */
    @JsonProperty("color")
    public void setColor(String color) {
        this.color = color;
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
        sb.append(BrandAssets.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("brandLastModified");
        sb.append('=');
        sb.append(((this.brandLastModified == null)?"<null>":this.brandLastModified));
        sb.append(',');
        sb.append("brandTermsUrl");
        sb.append('=');
        sb.append(((this.brandTermsUrl == null)?"<null>":this.brandTermsUrl));
        sb.append(',');
        sb.append("brandImageUrl");
        sb.append('=');
        sb.append(((this.brandImageUrl == null)?"<null>":this.brandImageUrl));
        sb.append(',');
        sb.append("brandImageUrlDark");
        sb.append('=');
        sb.append(((this.brandImageUrlDark == null)?"<null>":this.brandImageUrlDark));
        sb.append(',');
        sb.append("color");
        sb.append('=');
        sb.append(((this.color == null)?"<null>":this.color));
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
        result = ((result* 31)+((this.brandImageUrlDark == null)? 0 :this.brandImageUrlDark.hashCode()));
        result = ((result* 31)+((this.brandTermsUrl == null)? 0 :this.brandTermsUrl.hashCode()));
        result = ((result* 31)+((this.color == null)? 0 :this.color.hashCode()));
        result = ((result* 31)+((this.brandImageUrl == null)? 0 :this.brandImageUrl.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.brandLastModified == null)? 0 :this.brandLastModified.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BrandAssets) == false) {
            return false;
        }
        BrandAssets rhs = ((BrandAssets) other);
        return (((((((this.brandImageUrlDark == rhs.brandImageUrlDark)||((this.brandImageUrlDark!= null)&&this.brandImageUrlDark.equals(rhs.brandImageUrlDark)))&&((this.brandTermsUrl == rhs.brandTermsUrl)||((this.brandTermsUrl!= null)&&this.brandTermsUrl.equals(rhs.brandTermsUrl))))&&((this.color == rhs.color)||((this.color!= null)&&this.color.equals(rhs.color))))&&((this.brandImageUrl == rhs.brandImageUrl)||((this.brandImageUrl!= null)&&this.brandImageUrl.equals(rhs.brandImageUrl))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.brandLastModified == rhs.brandLastModified)||((this.brandLastModified!= null)&&this.brandLastModified.equals(rhs.brandLastModified))));
    }

}
