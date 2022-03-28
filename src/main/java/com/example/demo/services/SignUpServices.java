//package com.example.demo.services;
//
//import com.example.demo.entitys.UserEntity;
//import com.example.demo.models.ins.SignUpIn;
//import com.example.demo.provider.JwtLogin;
//import com.example.demo.repositories.SignUpRepositories;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import sun.security.util.Password;
//
//@Service
//public class SignUpServices {
//    @Autowired
//    private SignUpRepositories signUpRepositories;
//
//    @Autowired
//    private JwtLogin jwtLogin;
//
//    @Autowired
//    private Password pwt;
//
//    public ResponseEntity<?> registerUser(SignUpIn signUpIn){
//            if (signUpRepositories.existsByUsername(signUpIn.getName())) {
//                return new ResponseEntity<>("tên người dùng đã sủa dụng", HttpStatus.BAD_REQUEST);
//            }
//            if (signUpRepositories.existsByEmail(signUpIn.getGmail())) {
//                return new ResponseEntity<>("gmail đã sủa dụng", HttpStatus.BAD_REQUEST);
//            }
//        UserEntity userEntity = new UserEntity(signUpIn.getName(),
//                signUpIn.getGmail(),
//                pwt.pwt(signUpIn.getPassword()));
//    }
//}
