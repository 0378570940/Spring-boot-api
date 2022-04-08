package com.example.demo.controller;

import com.example.demo.services.JwtServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class JwtController {
    @Autowired
    private JwtServices jwtServices;

    //lưu ảnh vào database post
    @PostMapping("/users")
    public ResponseEntity<?> create(@RequestParam long id, @RequestParam MultipartFile file) throws IOException {
        return jwtServices.create(id, file);
    }

    @PostMapping("/savess")
    public ResponseEntity<?> save() {
        return jwtServices.authenticateUser();
    }
}
