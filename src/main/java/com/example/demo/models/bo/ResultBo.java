package com.example.demo.services;

import com.example.demo.entitys.UserEntity;

public class ResultService extends UserEntity {
    private Status status = Status.ACTIVE.DELETE.EXPIRED;
    public enum Status{
         ACTIVE,DELETE,EXPIRED
    }

    public ResultService() {
    }

    public ResultService(Status status) {
        this.status = status;
    }

    public String getStatus() {
        return String.valueOf(status);
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
