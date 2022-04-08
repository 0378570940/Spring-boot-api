package com.example.demo.controller;

import com.example.demo.entitys.UserEntity;
import com.example.demo.models.dto.ReponseData;
import com.example.demo.models.ins.UserIn;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    //cách1
    public ResponseEntity<?> createUser(@RequestBody UserEntity userEntity) {
        return userService.create(userEntity);
    }
    //cachs 2
//    public ReponseData createUser(@RequestBody UserEntity userEntity) {
//        return userService.create(userEntity);
//    }

//    @GetMapping("/user")
//    //cách1
//    public ResponseEntity<?> finaAll() {
//        return userService.finaAll();
//    }
    //cách 2
//    public ReponseData getUser(){
//        return userService.findAll();
//    }

    @GetMapping("/user/{id}")
    //cách 1
    public ResponseEntity<?> getUserId(@PathVariable long id) {
        return userService.finaById(id);
    }
    //cách 2
//    public ReponseData getUserId(@PathVariable long id) {
//        return userService.findAllBy(id);
//    }

    @PutMapping("/user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable long id, @RequestBody UserIn userIn) {
        return userService.update(id, userIn);
    }

    @DeleteMapping("/user/{id}")
    //cách 1
//    public ResponseEntity<?> delete(@PathVariable long id){
//        return userService.delete(id);
//    }
    //cách 2
    public ResponseEntity<ReponseData> delete(@PathVariable long id) {
        ReponseData reponseData = userService.delete(id);
        return new ResponseEntity<>(reponseData, HttpStatus.OK);
    }

}
