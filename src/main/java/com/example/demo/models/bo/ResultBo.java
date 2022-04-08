package com.example.demo.models.bo;

import com.example.demo.entitys.UserEntity;

public class ResultBo {
    private Status status = Status.ACTIVE.DELETE.EXPIRED;
    public enum Status{
         ACTIVE,DELETE,EXPIRED
    }

    public ResultBo() {
    }

    public ResultBo(Status status) {
        this.status = status;
    }

    public String getStatus() {
        return String.valueOf(status);
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
