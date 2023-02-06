
package io.confluent.demo.bicyclesharing.pojo.original;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "plan_id",
    "url",
    "name",
    "currency",
    "price",
    "is_taxable",
    "description",
    "per_km_pricing",
    "per_min_pricing",
    "surge_pricing"
})
public class Plan {

    /**
     * Identifier of a pricing plan in the system.
     * (Required)
     * 
     */
    @JsonProperty("plan_id")
    @JsonPropertyDescription("Identifier of a pricing plan in the system.")
    private String planId;
    /**
     * URL where the customer can learn more about this pricing plan.
     * 
     */
    @JsonProperty("url")
    @JsonPropertyDescription("URL where the customer can learn more about this pricing plan.")
    private URI url;
    /**
     * Name of this pricing plan.
     * (Required)
     * 
     */
    @JsonProperty("name")
    @JsonPropertyDescription("Name of this pricing plan.")
    private String name;
    /**
     * Currency used to pay the fare in ISO 4217 code.
     * (Required)
     * 
     */
    @JsonProperty("currency")
    @JsonPropertyDescription("Currency used to pay the fare in ISO 4217 code.")
    private String currency;
    /**
     * Fare price.
     * (Required)
     * 
     */
    @JsonProperty("price")
    @JsonPropertyDescription("Fare price.")
    private Double price;
    /**
     * Will additional tax be added to the base price?
     * (Required)
     * 
     */
    @JsonProperty("is_taxable")
    @JsonPropertyDescription("Will additional tax be added to the base price?")
    private Boolean isTaxable;
    /**
     * Customer-readable description of the pricing plan.
     * (Required)
     * 
     */
    @JsonProperty("description")
    @JsonPropertyDescription("Customer-readable description of the pricing plan.")
    private String description;
    /**
     * Array of segments when the price is a function of distance travelled, displayed in kilometers (added in v2.1-RC2).
     * 
     */
    @JsonProperty("per_km_pricing")
    @JsonPropertyDescription("Array of segments when the price is a function of distance travelled, displayed in kilometers (added in v2.1-RC2).")
    private List<PerKmPricing> perKmPricing = new ArrayList<PerKmPricing>();
    /**
     * Array of segments when the price is a function of time travelled, displayed in minutes (added in v2.1-RC2).
     * 
     */
    @JsonProperty("per_min_pricing")
    @JsonPropertyDescription("Array of segments when the price is a function of time travelled, displayed in minutes (added in v2.1-RC2).")
    private List<PerMinPricing> perMinPricing = new ArrayList<PerMinPricing>();
    /**
     * Is there currently an increase in price in response to increased demand in this pricing plan? (added in v2.1-RC2)
     * 
     */
    @JsonProperty("surge_pricing")
    @JsonPropertyDescription("Is there currently an increase in price in response to increased demand in this pricing plan? (added in v2.1-RC2)")
    private Boolean surgePricing;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Identifier of a pricing plan in the system.
     * (Required)
     * 
     */
    @JsonProperty("plan_id")
    public String getPlanId() {
        return planId;
    }

    /**
     * Identifier of a pricing plan in the system.
     * (Required)
     * 
     */
    @JsonProperty("plan_id")
    public void setPlanId(String planId) {
        this.planId = planId;
    }

    /**
     * URL where the customer can learn more about this pricing plan.
     * 
     */
    @JsonProperty("url")
    public URI getUrl() {
        return url;
    }

    /**
     * URL where the customer can learn more about this pricing plan.
     * 
     */
    @JsonProperty("url")
    public void setUrl(URI url) {
        this.url = url;
    }

    /**
     * Name of this pricing plan.
     * (Required)
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name of this pricing plan.
     * (Required)
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Currency used to pay the fare in ISO 4217 code.
     * (Required)
     * 
     */
    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    /**
     * Currency used to pay the fare in ISO 4217 code.
     * (Required)
     * 
     */
    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Fare price.
     * (Required)
     * 
     */
    @JsonProperty("price")
    public Double getPrice() {
        return price;
    }

    /**
     * Fare price.
     * (Required)
     * 
     */
    @JsonProperty("price")
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Will additional tax be added to the base price?
     * (Required)
     * 
     */
    @JsonProperty("is_taxable")
    public Boolean getIsTaxable() {
        return isTaxable;
    }

    /**
     * Will additional tax be added to the base price?
     * (Required)
     * 
     */
    @JsonProperty("is_taxable")
    public void setIsTaxable(Boolean isTaxable) {
        this.isTaxable = isTaxable;
    }

    /**
     * Customer-readable description of the pricing plan.
     * (Required)
     * 
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * Customer-readable description of the pricing plan.
     * (Required)
     * 
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Array of segments when the price is a function of distance travelled, displayed in kilometers (added in v2.1-RC2).
     * 
     */
    @JsonProperty("per_km_pricing")
    public List<PerKmPricing> getPerKmPricing() {
        return perKmPricing;
    }

    /**
     * Array of segments when the price is a function of distance travelled, displayed in kilometers (added in v2.1-RC2).
     * 
     */
    @JsonProperty("per_km_pricing")
    public void setPerKmPricing(List<PerKmPricing> perKmPricing) {
        this.perKmPricing = perKmPricing;
    }

    /**
     * Array of segments when the price is a function of time travelled, displayed in minutes (added in v2.1-RC2).
     * 
     */
    @JsonProperty("per_min_pricing")
    public List<PerMinPricing> getPerMinPricing() {
        return perMinPricing;
    }

    /**
     * Array of segments when the price is a function of time travelled, displayed in minutes (added in v2.1-RC2).
     * 
     */
    @JsonProperty("per_min_pricing")
    public void setPerMinPricing(List<PerMinPricing> perMinPricing) {
        this.perMinPricing = perMinPricing;
    }

    /**
     * Is there currently an increase in price in response to increased demand in this pricing plan? (added in v2.1-RC2)
     * 
     */
    @JsonProperty("surge_pricing")
    public Boolean getSurgePricing() {
        return surgePricing;
    }

    /**
     * Is there currently an increase in price in response to increased demand in this pricing plan? (added in v2.1-RC2)
     * 
     */
    @JsonProperty("surge_pricing")
    public void setSurgePricing(Boolean surgePricing) {
        this.surgePricing = surgePricing;
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
        sb.append(Plan.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("planId");
        sb.append('=');
        sb.append(((this.planId == null)?"<null>":this.planId));
        sb.append(',');
        sb.append("url");
        sb.append('=');
        sb.append(((this.url == null)?"<null>":this.url));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("currency");
        sb.append('=');
        sb.append(((this.currency == null)?"<null>":this.currency));
        sb.append(',');
        sb.append("price");
        sb.append('=');
        sb.append(((this.price == null)?"<null>":this.price));
        sb.append(',');
        sb.append("isTaxable");
        sb.append('=');
        sb.append(((this.isTaxable == null)?"<null>":this.isTaxable));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
        sb.append(',');
        sb.append("perKmPricing");
        sb.append('=');
        sb.append(((this.perKmPricing == null)?"<null>":this.perKmPricing));
        sb.append(',');
        sb.append("perMinPricing");
        sb.append('=');
        sb.append(((this.perMinPricing == null)?"<null>":this.perMinPricing));
        sb.append(',');
        sb.append("surgePricing");
        sb.append('=');
        sb.append(((this.surgePricing == null)?"<null>":this.surgePricing));
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
        result = ((result* 31)+((this.perKmPricing == null)? 0 :this.perKmPricing.hashCode()));
        result = ((result* 31)+((this.price == null)? 0 :this.price.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.isTaxable == null)? 0 :this.isTaxable.hashCode()));
        result = ((result* 31)+((this.description == null)? 0 :this.description.hashCode()));
        result = ((result* 31)+((this.planId == null)? 0 :this.planId.hashCode()));
        result = ((result* 31)+((this.currency == null)? 0 :this.currency.hashCode()));
        result = ((result* 31)+((this.perMinPricing == null)? 0 :this.perMinPricing.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.url == null)? 0 :this.url.hashCode()));
        result = ((result* 31)+((this.surgePricing == null)? 0 :this.surgePricing.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Plan) == false) {
            return false;
        }
        Plan rhs = ((Plan) other);
        return ((((((((((((this.perKmPricing == rhs.perKmPricing)||((this.perKmPricing!= null)&&this.perKmPricing.equals(rhs.perKmPricing)))&&((this.price == rhs.price)||((this.price!= null)&&this.price.equals(rhs.price))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.isTaxable == rhs.isTaxable)||((this.isTaxable!= null)&&this.isTaxable.equals(rhs.isTaxable))))&&((this.description == rhs.description)||((this.description!= null)&&this.description.equals(rhs.description))))&&((this.planId == rhs.planId)||((this.planId!= null)&&this.planId.equals(rhs.planId))))&&((this.currency == rhs.currency)||((this.currency!= null)&&this.currency.equals(rhs.currency))))&&((this.perMinPricing == rhs.perMinPricing)||((this.perMinPricing!= null)&&this.perMinPricing.equals(rhs.perMinPricing))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.url == rhs.url)||((this.url!= null)&&this.url.equals(rhs.url))))&&((this.surgePricing == rhs.surgePricing)||((this.surgePricing!= null)&&this.surgePricing.equals(rhs.surgePricing))));
    }

}
