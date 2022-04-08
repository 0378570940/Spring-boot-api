package com.example.demo.config;

public class StatusCodeConfig {
    public enum Status {
        ACTIVE,
        DELETE;

        public String value() {
            return name();
        }

        public static Status fromValue(String v) {
            return valueOf(v);
        }
    }
}
