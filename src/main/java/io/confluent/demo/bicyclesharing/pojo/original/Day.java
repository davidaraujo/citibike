
package io.confluent.demo.bicyclesharing.pojo.original;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Day {

    SUN("sun"),
    MON("mon"),
    TUE("tue"),
    WED("wed"),
    THU("thu"),
    FRI("fri"),
    SAT("sat");
    private final String value;
    private final static Map<String, Day> CONSTANTS = new HashMap<String, Day>();

    static {
        for (Day c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    private Day(String value) {
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
    public static Day fromValue(String value) {
        Day constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
