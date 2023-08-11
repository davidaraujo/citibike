
package io.confluent.demo.bicyclesharing.pojo;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * ksql.users
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "gender",
    "regionid",
    "registertime",
    "userid"
})
public class RidersValue {

    @JsonProperty("gender")
    private String gender;
    @JsonProperty("regionid")
    private String regionid;
    @JsonProperty("registertime")
    private Integer registertime;
    @JsonProperty("userid")
    private String userid;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    @JsonProperty("regionid")
    public String getRegionid() {
        return regionid;
    }

    @JsonProperty("regionid")
    public void setRegionid(String regionid) {
        this.regionid = regionid;
    }

    @JsonProperty("registertime")
    public Integer getRegistertime() {
        return registertime;
    }

    @JsonProperty("registertime")
    public void setRegistertime(Integer registertime) {
        this.registertime = registertime;
    }

    @JsonProperty("userid")
    public String getUserid() {
        return userid;
    }

    @JsonProperty("userid")
    public void setUserid(String userid) {
        this.userid = userid;
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
        sb.append(RidersValue.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("gender");
        sb.append('=');
        sb.append(((this.gender == null)?"<null>":this.gender));
        sb.append(',');
        sb.append("regionid");
        sb.append('=');
        sb.append(((this.regionid == null)?"<null>":this.regionid));
        sb.append(',');
        sb.append("registertime");
        sb.append('=');
        sb.append(((this.registertime == null)?"<null>":this.registertime));
        sb.append(',');
        sb.append("userid");
        sb.append('=');
        sb.append(((this.userid == null)?"<null>":this.userid));
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
        result = ((result* 31)+((this.gender == null)? 0 :this.gender.hashCode()));
        result = ((result* 31)+((this.registertime == null)? 0 :this.registertime.hashCode()));
        result = ((result* 31)+((this.regionid == null)? 0 :this.regionid.hashCode()));
        result = ((result* 31)+((this.userid == null)? 0 :this.userid.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RidersValue) == false) {
            return false;
        }
        RidersValue rhs = ((RidersValue) other);
        return ((((((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties)))&&((this.gender == rhs.gender)||((this.gender!= null)&&this.gender.equals(rhs.gender))))&&((this.registertime == rhs.registertime)||((this.registertime!= null)&&this.registertime.equals(rhs.registertime))))&&((this.regionid == rhs.regionid)||((this.regionid!= null)&&this.regionid.equals(rhs.regionid))))&&((this.userid == rhs.userid)||((this.userid!= null)&&this.userid.equals(rhs.userid))));
    }

}
