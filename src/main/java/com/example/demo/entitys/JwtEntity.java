package com.example.demo.entitys;

import lombok.Data;

import javax.persistence.*;

@Entity
public class Tbl_Jwt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "token")
    private String token;
    @Column(name = "expire_date")
    private String expire_date;
    @Column(name = "status")
    private String status;

    public Tbl_Jwt() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(String expire_date) {
        this.expire_date = expire_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
