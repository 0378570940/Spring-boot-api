package com.example.demo.models.dto;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class UserDto {
    private long id;
    private int age;
    private String name;
    private String email;
    private String token;

    public UserDto() {
    }

    public UserDto(String wrong_username_or_password, HttpStatus forbidden) {

    }
    public UserDto(long id, int age, String name, String email, String password, String token) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserDto(String email, long id, String name, int age) {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserDto orElseThrow(Object o) {
        return null;
    }

    public void setId(String token1) {

    }
}
