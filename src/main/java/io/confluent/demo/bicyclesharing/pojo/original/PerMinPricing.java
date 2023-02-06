
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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "start",
    "rate",
    "interval",
    "end"
})
public class PerMinPricing {

    /**
     * Number of minutes that have to elapse before this segment starts applying (added in v2.1-RC2).
     * (Required)
     * 
     */
    @JsonProperty("start")
    @JsonPropertyDescription("Number of minutes that have to elapse before this segment starts applying (added in v2.1-RC2).")
    private Integer start;
    /**
     * Rate that is charged for each minute interval after the start (added in v2.1-RC2).
     * (Required)
     * 
     */
    @JsonProperty("rate")
    @JsonPropertyDescription("Rate that is charged for each minute interval after the start (added in v2.1-RC2).")
    private Double rate;
    /**
     * Interval in minutes at which the rate of this segment is either reapplied (added in v2.1-RC2).
     * (Required)
     * 
     */
    @JsonProperty("interval")
    @JsonPropertyDescription("Interval in minutes at which the rate of this segment is either reapplied (added in v2.1-RC2).")
    private Integer interval;
    /**
     * The minute at which the rate will no longer apply (added in v2.1-RC2).
     * 
     */
    @JsonProperty("end")
    @JsonPropertyDescription("The minute at which the rate will no longer apply (added in v2.1-RC2).")
    private Integer end;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Number of minutes that have to elapse before this segment starts applying (added in v2.1-RC2).
     * (Required)
     * 
     */
    @JsonProperty("start")
    public Integer getStart() {
        return start;
    }

    /**
     * Number of minutes that have to elapse before this segment starts applying (added in v2.1-RC2).
     * (Required)
     * 
     */
    @JsonProperty("start")
    public void setStart(Integer start) {
        this.start = start;
    }

    /**
     * Rate that is charged for each minute interval after the start (added in v2.1-RC2).
     * (Required)
     * 
     */
    @JsonProperty("rate")
    public Double getRate() {
        return rate;
    }

    /**
     * Rate that is charged for each minute interval after the start (added in v2.1-RC2).
     * (Required)
     * 
     */
    @JsonProperty("rate")
    public void setRate(Double rate) {
        this.rate = rate;
    }

    /**
     * Interval in minutes at which the rate of this segment is either reapplied (added in v2.1-RC2).
     * (Required)
     * 
     */
    @JsonProperty("interval")
    public Integer getInterval() {
        return interval;
    }

    /**
     * Interval in minutes at which the rate of this segment is either reapplied (added in v2.1-RC2).
     * (Required)
     * 
     */
    @JsonProperty("interval")
    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    /**
     * The minute at which the rate will no longer apply (added in v2.1-RC2).
     * 
     */
    @JsonProperty("end")
    public Integer getEnd() {
        return end;
    }

    /**
     * The minute at which the rate will no longer apply (added in v2.1-RC2).
     * 
     */
    @JsonProperty("end")
    public void setEnd(Integer end) {
        this.end = end;
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
        sb.append(PerMinPricing.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("start");
        sb.append('=');
        sb.append(((this.start == null)?"<null>":this.start));
        sb.append(',');
        sb.append("rate");
        sb.append('=');
        sb.append(((this.rate == null)?"<null>":this.rate));
        sb.append(',');
        sb.append("interval");
        sb.append('=');
        sb.append(((this.interval == null)?"<null>":this.interval));
        sb.append(',');
        sb.append("end");
        sb.append('=');
        sb.append(((this.end == null)?"<null>":this.end));
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
        result = ((result* 31)+((this.start == null)? 0 :this.start.hashCode()));
        result = ((result* 31)+((this.interval == null)? 0 :this.interval.hashCode()));
        result = ((result* 31)+((this.end == null)? 0 :this.end.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.rate == null)? 0 :this.rate.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PerMinPricing) == false) {
            return false;
        }
        PerMinPricing rhs = ((PerMinPricing) other);
        return ((((((this.start == rhs.start)||((this.start!= null)&&this.start.equals(rhs.start)))&&((this.interval == rhs.interval)||((this.interval!= null)&&this.interval.equals(rhs.interval))))&&((this.end == rhs.end)||((this.end!= null)&&this.end.equals(rhs.end))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.rate == rhs.rate)||((this.rate!= null)&&this.rate.equals(rhs.rate))));
    }

}
