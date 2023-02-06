
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
 * Response data in the form of name:value pairs.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "system_id",
    "language",
    "name",
    "short_name",
    "operator",
    "url",
    "purchase_url",
    "start_date",
    "phone_number",
    "email",
    "feed_contact_email",
    "timezone",
    "license_url",
    "brand_assets",
    "terms_url",
    "terms_last_updated",
    "privacy_url",
    "privacy_last_updated",
    "rental_apps"
})
public class Data__8 {

    /**
     * Identifier for this vehicle share system. This should be globally unique (even between different systems).
     * (Required)
     * 
     */
    @JsonProperty("system_id")
    @JsonPropertyDescription("Identifier for this vehicle share system. This should be globally unique (even between different systems).")
    private String systemId;
    /**
     * The language that will be used throughout the rest of the files. It must match the value in the gbfs.json file.
     * (Required)
     * 
     */
    @JsonProperty("language")
    @JsonPropertyDescription("The language that will be used throughout the rest of the files. It must match the value in the gbfs.json file.")
    private String language;
    /**
     * Name of the system to be displayed to customers.
     * (Required)
     * 
     */
    @JsonProperty("name")
    @JsonPropertyDescription("Name of the system to be displayed to customers.")
    private String name;
    /**
     * Optional abbreviation for a system.
     * 
     */
    @JsonProperty("short_name")
    @JsonPropertyDescription("Optional abbreviation for a system.")
    private String shortName;
    /**
     * Name of the operator
     * 
     */
    @JsonProperty("operator")
    @JsonPropertyDescription("Name of the operator")
    private String operator;
    /**
     * The URL of the vehicle share system.
     * 
     */
    @JsonProperty("url")
    @JsonPropertyDescription("The URL of the vehicle share system.")
    private URI url;
    /**
     * URL where a customer can purchase a membership.
     * 
     */
    @JsonProperty("purchase_url")
    @JsonPropertyDescription("URL where a customer can purchase a membership.")
    private URI purchaseUrl;
    /**
     * Date that the system began operations.
     * 
     */
    @JsonProperty("start_date")
    @JsonPropertyDescription("Date that the system began operations.")
    private String startDate;
    /**
     * A single voice telephone number for the specified system that presents the telephone number as typical for the system's service area.
     * 
     */
    @JsonProperty("phone_number")
    @JsonPropertyDescription("A single voice telephone number for the specified system that presents the telephone number as typical for the system's service area.")
    private String phoneNumber;
    /**
     * Email address actively monitored by the operator's customer service department.
     * 
     */
    @JsonProperty("email")
    @JsonPropertyDescription("Email address actively monitored by the operator's customer service department.")
    private String email;
    /**
     * A single contact email address for consumers of this feed to report technical issues (added in v1.1).
     * 
     */
    @JsonProperty("feed_contact_email")
    @JsonPropertyDescription("A single contact email address for consumers of this feed to report technical issues (added in v1.1).")
    private String feedContactEmail;
    /**
     * The time zone where the system is located.
     * (Required)
     * 
     */
    @JsonProperty("timezone")
    @JsonPropertyDescription("The time zone where the system is located.")
    private String timezone;
    /**
     * A fully qualified URL of a page that defines the license terms for the GBFS data for this system.
     * 
     */
    @JsonProperty("license_url")
    @JsonPropertyDescription("A fully qualified URL of a page that defines the license terms for the GBFS data for this system.")
    private URI licenseUrl;
    /**
     * An object where each key defines one of the items listed below (added in v2.3-RC).
     * 
     */
    @JsonProperty("brand_assets")
    @JsonPropertyDescription("An object where each key defines one of the items listed below (added in v2.3-RC).")
    private BrandAssets brandAssets;
    /**
     * A fully qualified URL pointing to the terms of service (added in v2.3-RC)
     * 
     */
    @JsonProperty("terms_url")
    @JsonPropertyDescription("A fully qualified URL pointing to the terms of service (added in v2.3-RC)")
    private URI termsUrl;
    /**
     * The date that the terms of service provided at terms_url were last updated (added in v2.3-RC)
     * 
     */
    @JsonProperty("terms_last_updated")
    @JsonPropertyDescription("The date that the terms of service provided at terms_url were last updated (added in v2.3-RC)")
    private String termsLastUpdated;
    /**
     * A fully qualified URL pointing to the privacy policy for the service (added in v2.3-RC).
     * 
     */
    @JsonProperty("privacy_url")
    @JsonPropertyDescription("A fully qualified URL pointing to the privacy policy for the service (added in v2.3-RC).")
    private URI privacyUrl;
    /**
     * The date that the privacy policy provided at privacy_url was last updated (added in v2.3-RC).
     * 
     */
    @JsonProperty("privacy_last_updated")
    @JsonPropertyDescription("The date that the privacy policy provided at privacy_url was last updated (added in v2.3-RC).")
    private String privacyLastUpdated;
    /**
     * Contains rental app information in the android and ios JSON objects (added in v1.1).
     * 
     */
    @JsonProperty("rental_apps")
    @JsonPropertyDescription("Contains rental app information in the android and ios JSON objects (added in v1.1).")
    private RentalApps rentalApps;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Identifier for this vehicle share system. This should be globally unique (even between different systems).
     * (Required)
     * 
     */
    @JsonProperty("system_id")
    public String getSystemId() {
        return systemId;
    }

    /**
     * Identifier for this vehicle share system. This should be globally unique (even between different systems).
     * (Required)
     * 
     */
    @JsonProperty("system_id")
    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    /**
     * The language that will be used throughout the rest of the files. It must match the value in the gbfs.json file.
     * (Required)
     * 
     */
    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    /**
     * The language that will be used throughout the rest of the files. It must match the value in the gbfs.json file.
     * (Required)
     * 
     */
    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Name of the system to be displayed to customers.
     * (Required)
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name of the system to be displayed to customers.
     * (Required)
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Optional abbreviation for a system.
     * 
     */
    @JsonProperty("short_name")
    public String getShortName() {
        return shortName;
    }

    /**
     * Optional abbreviation for a system.
     * 
     */
    @JsonProperty("short_name")
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /**
     * Name of the operator
     * 
     */
    @JsonProperty("operator")
    public String getOperator() {
        return operator;
    }

    /**
     * Name of the operator
     * 
     */
    @JsonProperty("operator")
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * The URL of the vehicle share system.
     * 
     */
    @JsonProperty("url")
    public URI getUrl() {
        return url;
    }

    /**
     * The URL of the vehicle share system.
     * 
     */
    @JsonProperty("url")
    public void setUrl(URI url) {
        this.url = url;
    }

    /**
     * URL where a customer can purchase a membership.
     * 
     */
    @JsonProperty("purchase_url")
    public URI getPurchaseUrl() {
        return purchaseUrl;
    }

    /**
     * URL where a customer can purchase a membership.
     * 
     */
    @JsonProperty("purchase_url")
    public void setPurchaseUrl(URI purchaseUrl) {
        this.purchaseUrl = purchaseUrl;
    }

    /**
     * Date that the system began operations.
     * 
     */
    @JsonProperty("start_date")
    public String getStartDate() {
        return startDate;
    }

    /**
     * Date that the system began operations.
     * 
     */
    @JsonProperty("start_date")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * A single voice telephone number for the specified system that presents the telephone number as typical for the system's service area.
     * 
     */
    @JsonProperty("phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * A single voice telephone number for the specified system that presents the telephone number as typical for the system's service area.
     * 
     */
    @JsonProperty("phone_number")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Email address actively monitored by the operator's customer service department.
     * 
     */
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    /**
     * Email address actively monitored by the operator's customer service department.
     * 
     */
    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * A single contact email address for consumers of this feed to report technical issues (added in v1.1).
     * 
     */
    @JsonProperty("feed_contact_email")
    public String getFeedContactEmail() {
        return feedContactEmail;
    }

    /**
     * A single contact email address for consumers of this feed to report technical issues (added in v1.1).
     * 
     */
    @JsonProperty("feed_contact_email")
    public void setFeedContactEmail(String feedContactEmail) {
        this.feedContactEmail = feedContactEmail;
    }

    /**
     * The time zone where the system is located.
     * (Required)
     * 
     */
    @JsonProperty("timezone")
    public String getTimezone() {
        return timezone;
    }

    /**
     * The time zone where the system is located.
     * (Required)
     * 
     */
    @JsonProperty("timezone")
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    /**
     * A fully qualified URL of a page that defines the license terms for the GBFS data for this system.
     * 
     */
    @JsonProperty("license_url")
    public URI getLicenseUrl() {
        return licenseUrl;
    }

    /**
     * A fully qualified URL of a page that defines the license terms for the GBFS data for this system.
     * 
     */
    @JsonProperty("license_url")
    public void setLicenseUrl(URI licenseUrl) {
        this.licenseUrl = licenseUrl;
    }

    /**
     * An object where each key defines one of the items listed below (added in v2.3-RC).
     * 
     */
    @JsonProperty("brand_assets")
    public BrandAssets getBrandAssets() {
        return brandAssets;
    }

    /**
     * An object where each key defines one of the items listed below (added in v2.3-RC).
     * 
     */
    @JsonProperty("brand_assets")
    public void setBrandAssets(BrandAssets brandAssets) {
        this.brandAssets = brandAssets;
    }

    /**
     * A fully qualified URL pointing to the terms of service (added in v2.3-RC)
     * 
     */
    @JsonProperty("terms_url")
    public URI getTermsUrl() {
        return termsUrl;
    }

    /**
     * A fully qualified URL pointing to the terms of service (added in v2.3-RC)
     * 
     */
    @JsonProperty("terms_url")
    public void setTermsUrl(URI termsUrl) {
        this.termsUrl = termsUrl;
    }

    /**
     * The date that the terms of service provided at terms_url were last updated (added in v2.3-RC)
     * 
     */
    @JsonProperty("terms_last_updated")
    public String getTermsLastUpdated() {
        return termsLastUpdated;
    }

    /**
     * The date that the terms of service provided at terms_url were last updated (added in v2.3-RC)
     * 
     */
    @JsonProperty("terms_last_updated")
    public void setTermsLastUpdated(String termsLastUpdated) {
        this.termsLastUpdated = termsLastUpdated;
    }

    /**
     * A fully qualified URL pointing to the privacy policy for the service (added in v2.3-RC).
     * 
     */
    @JsonProperty("privacy_url")
    public URI getPrivacyUrl() {
        return privacyUrl;
    }

    /**
     * A fully qualified URL pointing to the privacy policy for the service (added in v2.3-RC).
     * 
     */
    @JsonProperty("privacy_url")
    public void setPrivacyUrl(URI privacyUrl) {
        this.privacyUrl = privacyUrl;
    }

    /**
     * The date that the privacy policy provided at privacy_url was last updated (added in v2.3-RC).
     * 
     */
    @JsonProperty("privacy_last_updated")
    public String getPrivacyLastUpdated() {
        return privacyLastUpdated;
    }

    /**
     * The date that the privacy policy provided at privacy_url was last updated (added in v2.3-RC).
     * 
     */
    @JsonProperty("privacy_last_updated")
    public void setPrivacyLastUpdated(String privacyLastUpdated) {
        this.privacyLastUpdated = privacyLastUpdated;
    }

    /**
     * Contains rental app information in the android and ios JSON objects (added in v1.1).
     * 
     */
    @JsonProperty("rental_apps")
    public RentalApps getRentalApps() {
        return rentalApps;
    }

    /**
     * Contains rental app information in the android and ios JSON objects (added in v1.1).
     * 
     */
    @JsonProperty("rental_apps")
    public void setRentalApps(RentalApps rentalApps) {
        this.rentalApps = rentalApps;
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
        sb.append(Data__8 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("systemId");
        sb.append('=');
        sb.append(((this.systemId == null)?"<null>":this.systemId));
        sb.append(',');
        sb.append("language");
        sb.append('=');
        sb.append(((this.language == null)?"<null>":this.language));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("shortName");
        sb.append('=');
        sb.append(((this.shortName == null)?"<null>":this.shortName));
        sb.append(',');
        sb.append("operator");
        sb.append('=');
        sb.append(((this.operator == null)?"<null>":this.operator));
        sb.append(',');
        sb.append("url");
        sb.append('=');
        sb.append(((this.url == null)?"<null>":this.url));
        sb.append(',');
        sb.append("purchaseUrl");
        sb.append('=');
        sb.append(((this.purchaseUrl == null)?"<null>":this.purchaseUrl));
        sb.append(',');
        sb.append("startDate");
        sb.append('=');
        sb.append(((this.startDate == null)?"<null>":this.startDate));
        sb.append(',');
        sb.append("phoneNumber");
        sb.append('=');
        sb.append(((this.phoneNumber == null)?"<null>":this.phoneNumber));
        sb.append(',');
        sb.append("email");
        sb.append('=');
        sb.append(((this.email == null)?"<null>":this.email));
        sb.append(',');
        sb.append("feedContactEmail");
        sb.append('=');
        sb.append(((this.feedContactEmail == null)?"<null>":this.feedContactEmail));
        sb.append(',');
        sb.append("timezone");
        sb.append('=');
        sb.append(((this.timezone == null)?"<null>":this.timezone));
        sb.append(',');
        sb.append("licenseUrl");
        sb.append('=');
        sb.append(((this.licenseUrl == null)?"<null>":this.licenseUrl));
        sb.append(',');
        sb.append("brandAssets");
        sb.append('=');
        sb.append(((this.brandAssets == null)?"<null>":this.brandAssets));
        sb.append(',');
        sb.append("termsUrl");
        sb.append('=');
        sb.append(((this.termsUrl == null)?"<null>":this.termsUrl));
        sb.append(',');
        sb.append("termsLastUpdated");
        sb.append('=');
        sb.append(((this.termsLastUpdated == null)?"<null>":this.termsLastUpdated));
        sb.append(',');
        sb.append("privacyUrl");
        sb.append('=');
        sb.append(((this.privacyUrl == null)?"<null>":this.privacyUrl));
        sb.append(',');
        sb.append("privacyLastUpdated");
        sb.append('=');
        sb.append(((this.privacyLastUpdated == null)?"<null>":this.privacyLastUpdated));
        sb.append(',');
        sb.append("rentalApps");
        sb.append('=');
        sb.append(((this.rentalApps == null)?"<null>":this.rentalApps));
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
        result = ((result* 31)+((this.privacyUrl == null)? 0 :this.privacyUrl.hashCode()));
        result = ((result* 31)+((this.licenseUrl == null)? 0 :this.licenseUrl.hashCode()));
        result = ((result* 31)+((this.systemId == null)? 0 :this.systemId.hashCode()));
        result = ((result* 31)+((this.privacyLastUpdated == null)? 0 :this.privacyLastUpdated.hashCode()));
        result = ((result* 31)+((this.timezone == null)? 0 :this.timezone.hashCode()));
        result = ((result* 31)+((this.rentalApps == null)? 0 :this.rentalApps.hashCode()));
        result = ((result* 31)+((this.language == null)? 0 :this.language.hashCode()));
        result = ((result* 31)+((this.operator == null)? 0 :this.operator.hashCode()));
        result = ((result* 31)+((this.url == null)? 0 :this.url.hashCode()));
        result = ((result* 31)+((this.purchaseUrl == null)? 0 :this.purchaseUrl.hashCode()));
        result = ((result* 31)+((this.phoneNumber == null)? 0 :this.phoneNumber.hashCode()));
        result = ((result* 31)+((this.termsUrl == null)? 0 :this.termsUrl.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.feedContactEmail == null)? 0 :this.feedContactEmail.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.shortName == null)? 0 :this.shortName.hashCode()));
        result = ((result* 31)+((this.termsLastUpdated == null)? 0 :this.termsLastUpdated.hashCode()));
        result = ((result* 31)+((this.startDate == null)? 0 :this.startDate.hashCode()));
        result = ((result* 31)+((this.email == null)? 0 :this.email.hashCode()));
        result = ((result* 31)+((this.brandAssets == null)? 0 :this.brandAssets.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Data__8) == false) {
            return false;
        }
        Data__8 rhs = ((Data__8) other);
        return (((((((((((((((((((((this.privacyUrl == rhs.privacyUrl)||((this.privacyUrl!= null)&&this.privacyUrl.equals(rhs.privacyUrl)))&&((this.licenseUrl == rhs.licenseUrl)||((this.licenseUrl!= null)&&this.licenseUrl.equals(rhs.licenseUrl))))&&((this.systemId == rhs.systemId)||((this.systemId!= null)&&this.systemId.equals(rhs.systemId))))&&((this.privacyLastUpdated == rhs.privacyLastUpdated)||((this.privacyLastUpdated!= null)&&this.privacyLastUpdated.equals(rhs.privacyLastUpdated))))&&((this.timezone == rhs.timezone)||((this.timezone!= null)&&this.timezone.equals(rhs.timezone))))&&((this.rentalApps == rhs.rentalApps)||((this.rentalApps!= null)&&this.rentalApps.equals(rhs.rentalApps))))&&((this.language == rhs.language)||((this.language!= null)&&this.language.equals(rhs.language))))&&((this.operator == rhs.operator)||((this.operator!= null)&&this.operator.equals(rhs.operator))))&&((this.url == rhs.url)||((this.url!= null)&&this.url.equals(rhs.url))))&&((this.purchaseUrl == rhs.purchaseUrl)||((this.purchaseUrl!= null)&&this.purchaseUrl.equals(rhs.purchaseUrl))))&&((this.phoneNumber == rhs.phoneNumber)||((this.phoneNumber!= null)&&this.phoneNumber.equals(rhs.phoneNumber))))&&((this.termsUrl == rhs.termsUrl)||((this.termsUrl!= null)&&this.termsUrl.equals(rhs.termsUrl))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.feedContactEmail == rhs.feedContactEmail)||((this.feedContactEmail!= null)&&this.feedContactEmail.equals(rhs.feedContactEmail))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.shortName == rhs.shortName)||((this.shortName!= null)&&this.shortName.equals(rhs.shortName))))&&((this.termsLastUpdated == rhs.termsLastUpdated)||((this.termsLastUpdated!= null)&&this.termsLastUpdated.equals(rhs.termsLastUpdated))))&&((this.startDate == rhs.startDate)||((this.startDate!= null)&&this.startDate.equals(rhs.startDate))))&&((this.email == rhs.email)||((this.email!= null)&&this.email.equals(rhs.email))))&&((this.brandAssets == rhs.brandAssets)||((this.brandAssets!= null)&&this.brandAssets.equals(rhs.brandAssets))));
    }

}
