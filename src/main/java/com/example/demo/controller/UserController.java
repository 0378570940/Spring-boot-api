package com.example.demo.controller;

import com.example.demo.entitys.UserEntity;
import com.example.demo.models.dto.ReponseData;
import com.example.demo.models.ins.UserIn;
import com.example.demo.services.LoginServices;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private LoginServices loginServices;

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    //cách1: thêm thông tin
    public ResponseEntity<?> createUser(@RequestBody UserEntity userEntity) {
        return userService.create(userEntity);
    }

//    @GetMapping("/user")
//    //cách1: in ra thông tin
//    public ResponseEntity<?> finaAll() {
//        return userService.finaAll();
//    }

    @GetMapping("/user/{id}")
    //cách 1: in ra thông tin bằng id
    public ResponseEntity<?> getUserId(@PathVariable long id) {
        return userService.finaById(id);
    }

    @PutMapping("/user/{id}")
    //sửa thông tin khách hàng theo id
    public ResponseEntity<?> updateUser(@PathVariable long id, @RequestBody UserIn userIn) {
        return userService.update(id, userIn);
    }

    @DeleteMapping("/user/{id}")
    //cách 2: xóa thông tin khách hành
    public ResponseEntity<ReponseData> delete(@PathVariable long id) {
        ReponseData reponseData = userService.delete(id);
        return new ResponseEntity<>(reponseData, HttpStatus.OK);
    }

    @GetMapping("/user")
    //in ra token thông tin khách hàng
    public ResponseEntity<?> getUser(@RequestHeader(name = "Authorization") String token) {
        return loginServices.verifyToken(token);
    }

}
