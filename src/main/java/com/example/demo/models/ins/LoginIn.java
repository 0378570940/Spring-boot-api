package com.example.demo.models.ins;

public class LoginIn {
    private String name;
    private String password;
    public LoginIn() {
    }

    public LoginIn(String name, String password) {
        this.name = name;
        this.password = password;
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
}
