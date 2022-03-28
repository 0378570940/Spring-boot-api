package com.example.demo.controller;

import com.example.demo.models.ins.UserIn;
import com.example.demo.models.out.UserOut;
import com.example.demo.provider.JwtUser;
import com.example.demo.services.JwtServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class JwtController {
    @Autowired
    private JwtServices jwtServices;

//    @GetMapping("/users")
//    public String findal(){
//        return userService.findalll();
//    }

    //lưu ảnh vào database post
    @PostMapping("/users")
    public ResponseEntity<?> create(@RequestParam long id, @RequestParam MultipartFile file) throws IOException {
        return jwtServices.create(id,file);
    }

    //
//    @PostMapping("/saves")
//    public void uploadFile(UserIn userIn) {
//        jwtServices.downloadFile(userIn);
//    }

    @PostMapping("/savess")
    public ResponseEntity<?> save(){
        return jwtServices.authenticateUser();
    }
}
