package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class ErrorRespone {
    private HttpStatus status;
    private String message;

    public ErrorRespone(HttpStatus notFound, String message) {
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
