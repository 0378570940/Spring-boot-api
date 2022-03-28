package com.example.demo.services;

import com.example.demo.entitys.UserEntity;
import com.example.demo.models.ins.LoginIn;
import com.example.demo.provider.JwtLogin;
import com.example.demo.provider.SimpleGrantedAuthority;
import com.example.demo.repositories.LoginRepositories;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class LoginServices {
    @Autowired
    private LoginRepositories loginRepositories;
    @Autowired
    private JwtLogin jwtLogin;

    public ResponseEntity<?> signIn(LoginIn loginIn){
        UserEntity userEntity = loginRepositories.findFirstByName(loginIn.getName());
        String token = jwtLogin.createLoginToken(userEntity);
        return new ResponseEntity<>(token,HttpStatus.OK);
    }


//    public ResponseEntity<?> signin(LoginIn loginIn) {
//        UserEntity userEntity = loginRepositories.findFirstByName(loginIn.getName());
//        jwtLogin.createLoginToken(userEntity.getName(), userEntity.getEmail(), new String[]{});
//        return new ResponseEntity<>(HttpStatus.OK);
//    }



//    public String createLoginToken(String name, String email, String[] LoginIns){
//        String KEY = "1234567890";
//        Claims claims = Jwts.claims().setSubject(name);
//        claims.put("LoginIns", Stream.of(LoginIns)
//                .map(s -> new SimpleGrantedAuthority(s)).collect(Collectors.toList()));
//        Date dta = new Date();
//        String token = Jwts.builder()
//                .setClaims(claims)
//                .setIssuedAt(dta)
//                .setExpiration(new Date(dta.getTime() + 115 * 60 * 1000))
//                .signWith(SignatureAlgorithm.HS256,KEY)
//                .compact();
//        return token;
//    }

//    public String signin(String name, String password) {
//        String token = jwtLogin.createLoginToken(name);
//        LoginIn loginIn =new LoginIn();
//        loginIn.setUser(name);
//        loginIn.setToken();
//        UserEntity userEntity = loginRepositories.findFirstByName(name);
//        return jwtLogin.createLoginToken(userEntity.getName(), userEntity.getEmail(), new String[]{});
////        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
