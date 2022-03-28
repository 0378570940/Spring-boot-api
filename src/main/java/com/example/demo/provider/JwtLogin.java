package com.example.demo.provider;

import com.example.demo.entitys.UserEntity;
import com.example.demo.models.ins.LoginIn;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class JwtLogin {
    //    @Autowired
//    private Global global;
    static final String KEY = "1234567890";
    private static final String ISSUER = "https://gpcoder.com";

    public String createLoginToken(UserEntity loginIn) {
        Claims claims = Jwts.claims().setSubject(loginIn.getName());
//        claims.put("roles", user.getRoles());
        Date now = new Date();
        JwtBuilder builder = Jwts.builder() //Được định cấu hình và sau đó được sử dụng để tạo chuỗi tuần tự nhỏ gọn JWT
                .setClaims(claims).setId(UUID.randomUUID().toString()) //Đặt giá trị jti Yêu cầu JWT (JWT ID)
                .setIssuedAt(now) // Sets the JWT Claims iat (issued at) value
                .setIssuer(ISSUER) // Sets the JWT Claims iss (issuer) value
                .setExpiration(new Date(now.getTime() + 115 * 60 * 1000)) // Sets the JWT Claims exp (expiration) value
                .signWith(SignatureAlgorithm.HS256, KEY);
        return builder.compact();
    }

}
