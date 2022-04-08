package com.example.demo.controller;

import com.example.demo.models.ins.LoginIn;
import com.example.demo.services.LoginServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    private LoginServices loginServices;

//    @GetMapping("/signIn")
//    public LoginIn signIn(@RequestParam String name, @RequestParam String password){
//        return loginServices.signin(name,password);
//    }

    @PostMapping("/signIn")
    public Object signIn(@RequestBody LoginIn loginIn){
        try {
            return loginServices.signIn(loginIn);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @GetMapping("/user")
    public ResponseEntity<?> getUser(@RequestHeader(name = "Authorization") String token){
//        System.out.println(token);
        return loginServices.getUser(token);
    }

    @GetMapping("/users")
    public Object verifyToken(@RequestHeader(name = "Authorization") String token){
//        System.out.println(token);
        return loginServices.verifyToken(token);
    }
}
