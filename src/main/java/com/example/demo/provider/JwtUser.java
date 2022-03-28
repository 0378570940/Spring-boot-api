package com.example.demo.provider;

import com.example.demo.models.ins.UserIn;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import sun.security.util.Password;

import java.util.Date;

@Component
public class JwtUser {
//    @Value()

    @Bean
    public Password Password() {
        return new BCryptPassword();
    }

    static final long EXPIRATIONTIME = 864_000_000; // 10 days

    static final String KEY = "ThisIsASecret";
    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";

    public String genTokenJwt() {
        UserIn userIn = new UserIn();
        String token = Jwts.builder()
                .setSubject(userIn.getName())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512, KEY)
                .compact();
        return token;
    }

    // Lấy thông tin user từ jwt
    public String getUserUsernameFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(KEY)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser()
                    .setSigningKey(KEY)
                    .parseClaimsJws(authToken);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private class BCryptPassword extends Password {
    }
}
