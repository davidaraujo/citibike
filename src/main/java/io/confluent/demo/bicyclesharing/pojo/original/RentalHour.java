
package io.confluent.demo.bicyclesharing.pojo.original;

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
    "user_types",
    "days",
    "start_time",
    "end_time"
})
public class RentalHour {

    /**
     * Array of member and nonmember value(s) indicating that this set of rental hours applies to either members or non-members only.
     * (Required)
     * 
     */
    @JsonProperty("user_types")
    @JsonPropertyDescription("Array of member and nonmember value(s) indicating that this set of rental hours applies to either members or non-members only.")
    private List<UserType> userTypes = new ArrayList<UserType>();
    /**
     * An array of abbreviations (first 3 letters) of English names of the days of the week for which this object applies.
     * (Required)
     * 
     */
    @JsonProperty("days")
    @JsonPropertyDescription("An array of abbreviations (first 3 letters) of English names of the days of the week for which this object applies.")
    private List<Day> days = new ArrayList<Day>();
    /**
     * Start time for the hours of operation of the system.
     * (Required)
     * 
     */
    @JsonProperty("start_time")
    @JsonPropertyDescription("Start time for the hours of operation of the system.")
    private String startTime;
    /**
     * End time for the hours of operation of the system.
     * (Required)
     * 
     */
    @JsonProperty("end_time")
    @JsonPropertyDescription("End time for the hours of operation of the system.")
    private String endTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Array of member and nonmember value(s) indicating that this set of rental hours applies to either members or non-members only.
     * (Required)
     * 
     */
    @JsonProperty("user_types")
    public List<UserType> getUserTypes() {
        return userTypes;
    }

    /**
     * Array of member and nonmember value(s) indicating that this set of rental hours applies to either members or non-members only.
     * (Required)
     * 
     */
    @JsonProperty("user_types")
    public void setUserTypes(List<UserType> userTypes) {
        this.userTypes = userTypes;
    }

    /**
     * An array of abbreviations (first 3 letters) of English names of the days of the week for which this object applies.
     * (Required)
     * 
     */
    @JsonProperty("days")
    public List<Day> getDays() {
        return days;
    }

    /**
     * An array of abbreviations (first 3 letters) of English names of the days of the week for which this object applies.
     * (Required)
     * 
     */
    @JsonProperty("days")
    public void setDays(List<Day> days) {
        this.days = days;
    }

    /**
     * Start time for the hours of operation of the system.
     * (Required)
     * 
     */
    @JsonProperty("start_time")
    public String getStartTime() {
        return startTime;
    }

    /**
     * Start time for the hours of operation of the system.
     * (Required)
     * 
     */
    @JsonProperty("start_time")
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * End time for the hours of operation of the system.
     * (Required)
     * 
     */
    @JsonProperty("end_time")
    public String getEndTime() {
        return endTime;
    }

    /**
     * End time for the hours of operation of the system.
     * (Required)
     * 
     */
    @JsonProperty("end_time")
    public void setEndTime(String endTime) {
        this.endTime = endTime;
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
        sb.append(RentalHour.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("userTypes");
        sb.append('=');
        sb.append(((this.userTypes == null)?"<null>":this.userTypes));
        sb.append(',');
        sb.append("days");
        sb.append('=');
        sb.append(((this.days == null)?"<null>":this.days));
        sb.append(',');
        sb.append("startTime");
        sb.append('=');
        sb.append(((this.startTime == null)?"<null>":this.startTime));
        sb.append(',');
        sb.append("endTime");
        sb.append('=');
        sb.append(((this.endTime == null)?"<null>":this.endTime));
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
        result = ((result* 31)+((this.days == null)? 0 :this.days.hashCode()));
        result = ((result* 31)+((this.userTypes == null)? 0 :this.userTypes.hashCode()));
        result = ((result* 31)+((this.startTime == null)? 0 :this.startTime.hashCode()));
        result = ((result* 31)+((this.endTime == null)? 0 :this.endTime.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RentalHour) == false) {
            return false;
        }
        RentalHour rhs = ((RentalHour) other);
        return ((((((this.days == rhs.days)||((this.days!= null)&&this.days.equals(rhs.days)))&&((this.userTypes == rhs.userTypes)||((this.userTypes!= null)&&this.userTypes.equals(rhs.userTypes))))&&((this.startTime == rhs.startTime)||((this.startTime!= null)&&this.startTime.equals(rhs.startTime))))&&((this.endTime == rhs.endTime)||((this.endTime!= null)&&this.endTime.equals(rhs.endTime))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
