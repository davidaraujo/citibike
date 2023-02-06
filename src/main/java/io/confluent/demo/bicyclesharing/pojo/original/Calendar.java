
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
    "start_month",
    "start_day",
    "start_year",
    "end_month",
    "end_day",
    "end_year"
})
public class Calendar {

    /**
     * Starting month for the system operations.
     * (Required)
     * 
     */
    @JsonProperty("start_month")
    @JsonPropertyDescription("Starting month for the system operations.")
    private Integer startMonth;
    /**
     * Starting day for the system operations.
     * (Required)
     * 
     */
    @JsonProperty("start_day")
    @JsonPropertyDescription("Starting day for the system operations.")
    private Integer startDay;
    /**
     * Starting year for the system operations.
     * 
     */
    @JsonProperty("start_year")
    @JsonPropertyDescription("Starting year for the system operations.")
    private Integer startYear;
    /**
     * End month for the system operations.
     * (Required)
     * 
     */
    @JsonProperty("end_month")
    @JsonPropertyDescription("End month for the system operations.")
    private Integer endMonth;
    /**
     * End day for the system operations.
     * (Required)
     * 
     */
    @JsonProperty("end_day")
    @JsonPropertyDescription("End day for the system operations.")
    private Integer endDay;
    /**
     * End year for the system operations.
     * 
     */
    @JsonProperty("end_year")
    @JsonPropertyDescription("End year for the system operations.")
    private Integer endYear;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Starting month for the system operations.
     * (Required)
     * 
     */
    @JsonProperty("start_month")
    public Integer getStartMonth() {
        return startMonth;
    }

    /**
     * Starting month for the system operations.
     * (Required)
     * 
     */
    @JsonProperty("start_month")
    public void setStartMonth(Integer startMonth) {
        this.startMonth = startMonth;
    }

    /**
     * Starting day for the system operations.
     * (Required)
     * 
     */
    @JsonProperty("start_day")
    public Integer getStartDay() {
        return startDay;
    }

    /**
     * Starting day for the system operations.
     * (Required)
     * 
     */
    @JsonProperty("start_day")
    public void setStartDay(Integer startDay) {
        this.startDay = startDay;
    }

    /**
     * Starting year for the system operations.
     * 
     */
    @JsonProperty("start_year")
    public Integer getStartYear() {
        return startYear;
    }

    /**
     * Starting year for the system operations.
     * 
     */
    @JsonProperty("start_year")
    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    /**
     * End month for the system operations.
     * (Required)
     * 
     */
    @JsonProperty("end_month")
    public Integer getEndMonth() {
        return endMonth;
    }

    /**
     * End month for the system operations.
     * (Required)
     * 
     */
    @JsonProperty("end_month")
    public void setEndMonth(Integer endMonth) {
        this.endMonth = endMonth;
    }

    /**
     * End day for the system operations.
     * (Required)
     * 
     */
    @JsonProperty("end_day")
    public Integer getEndDay() {
        return endDay;
    }

    /**
     * End day for the system operations.
     * (Required)
     * 
     */
    @JsonProperty("end_day")
    public void setEndDay(Integer endDay) {
        this.endDay = endDay;
    }

    /**
     * End year for the system operations.
     * 
     */
    @JsonProperty("end_year")
    public Integer getEndYear() {
        return endYear;
    }

    /**
     * End year for the system operations.
     * 
     */
    @JsonProperty("end_year")
    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
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
        sb.append(Calendar.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("startMonth");
        sb.append('=');
        sb.append(((this.startMonth == null)?"<null>":this.startMonth));
        sb.append(',');
        sb.append("startDay");
        sb.append('=');
        sb.append(((this.startDay == null)?"<null>":this.startDay));
        sb.append(',');
        sb.append("startYear");
        sb.append('=');
        sb.append(((this.startYear == null)?"<null>":this.startYear));
        sb.append(',');
        sb.append("endMonth");
        sb.append('=');
        sb.append(((this.endMonth == null)?"<null>":this.endMonth));
        sb.append(',');
        sb.append("endDay");
        sb.append('=');
        sb.append(((this.endDay == null)?"<null>":this.endDay));
        sb.append(',');
        sb.append("endYear");
        sb.append('=');
        sb.append(((this.endYear == null)?"<null>":this.endYear));
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
        result = ((result* 31)+((this.startMonth == null)? 0 :this.startMonth.hashCode()));
        result = ((result* 31)+((this.startDay == null)? 0 :this.startDay.hashCode()));
        result = ((result* 31)+((this.endDay == null)? 0 :this.endDay.hashCode()));
        result = ((result* 31)+((this.startYear == null)? 0 :this.startYear.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.endMonth == null)? 0 :this.endMonth.hashCode()));
        result = ((result* 31)+((this.endYear == null)? 0 :this.endYear.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Calendar) == false) {
            return false;
        }
        Calendar rhs = ((Calendar) other);
        return ((((((((this.startMonth == rhs.startMonth)||((this.startMonth!= null)&&this.startMonth.equals(rhs.startMonth)))&&((this.startDay == rhs.startDay)||((this.startDay!= null)&&this.startDay.equals(rhs.startDay))))&&((this.endDay == rhs.endDay)||((this.endDay!= null)&&this.endDay.equals(rhs.endDay))))&&((this.startYear == rhs.startYear)||((this.startYear!= null)&&this.startYear.equals(rhs.startYear))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.endMonth == rhs.endMonth)||((this.endMonth!= null)&&this.endMonth.equals(rhs.endMonth))))&&((this.endYear == rhs.endYear)||((this.endYear!= null)&&this.endYear.equals(rhs.endYear))));
    }

}
