package com.example.demo.config;

import lombok.Data;
import org.springframework.http.HttpStatus;

public class Constant {

    public enum MetaData {
        SUCCESS(1, "Success"),
        ERROR(2, "Error");


        private int code;
        private String msg;

        public String getMsg() {
            return this.msg;
        }

        public int getCode() {
            return this.code;
        }

        MetaData(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }
    }

}
