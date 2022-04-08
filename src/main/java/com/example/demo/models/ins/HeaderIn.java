package com.example.demo.models.ins;

import com.example.demo.models.dto.HeaderDto;

public class HeaderIn {
    private String token;
    private String name;
    private String password;
    private String gmail;
    private String data;

    public HeaderIn() {
    }

    public HeaderIn(String token, String name, String password, String gmail, String data) {
        this.token = token;
        this.name = name;
        this.password = password;
        this.gmail = gmail;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public HeaderIn(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public HeaderDto getData(String tokenString) {
        return null;
    }
}
