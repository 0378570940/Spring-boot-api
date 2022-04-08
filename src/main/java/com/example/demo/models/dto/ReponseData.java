package com.example.demo.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReponseData {
    private int code;
    private String msg;
    private Object data;

    public ReponseData(String format) {

    }

    public boolean before(String expire_date) {
        return false;
    }
}
