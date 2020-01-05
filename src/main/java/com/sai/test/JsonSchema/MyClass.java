package com.sai.test.JsonSchema;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public class MyClass {

    @JsonProperty("A1")
    private String A1;
    @JsonProperty("A2")
    private String A2  ;
    @JsonProperty("A3")
    private String A3  ;
    @JsonProperty("A4")
    private MyClass.A4 A4  ;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    @JsonProperty("A4")
    public MyClass.A4 getA4() {
        return A4;
    }

    /**
     *
     * @param A4
     *     The startDayOfWeek
     */
    @JsonProperty("A4")
    public void setA4(MyClass.A4 A4) {
        this.A4 = A4;
    }

    public static enum A4 {

        REPLACE("Replace");
        private final String value;
        private static Map<String, MyClass.A4> constants = new HashMap<String, MyClass.A4>();

        static {
            for (MyClass.A4 c: values()) {
                constants.put(c.value, c);
            }
        }

        private A4(String value) {
            this.value = value;
        }



        @JsonValue
        @Override
        public String toString() {
            return this.value;
        }

        @JsonCreator
        public static MyClass.A4 fromValue(String value) {
            MyClass.A4 constant = constants.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
