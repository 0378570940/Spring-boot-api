package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.Watchable;

@RestControllerAdvice
public class CustomExceptuon {
    @ExceptionHandler(NotFuondExcaption.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorRespone httpNotFuondExcaption(NotFuondExcaption ex, Watchable req){
        return new ErrorRespone(HttpStatus.NOT_FOUND, ex.getMessage());
    }
}
