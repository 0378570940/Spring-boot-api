package com.example.demo.models.ins;

public class SignUpIn {
    private String name;
    private String password;
    private String gmail;

    public SignUpIn() {
    }

    public SignUpIn(String name, String password, String gmail) {
        this.name = name;
        this.password = password;
        this.gmail = gmail;
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
}
