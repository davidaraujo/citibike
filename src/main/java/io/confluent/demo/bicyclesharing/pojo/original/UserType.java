
package io.confluent.demo.bicyclesharing.pojo.original;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserType {

    MEMBER("member"),
    NONMEMBER("nonmember");
    private final String value;
    private final static Map<String, UserType> CONSTANTS = new HashMap<String, UserType>();

    static {
        for (UserType c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    private UserType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    @JsonValue
    public String value() {
        return this.value;
    }

    @JsonCreator
    public static UserType fromValue(String value) {
        UserType constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
