package com.example.demo.provider;

import com.example.demo.entitys.UserEntity;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Component
public class JwtLogin {
    //    @Autowired
//    private Global global;
    static final String KEY = "1234567890";
    private static final String ISSUER = "https://gpcoder.com";
    public static final String SECRET = "SECRET_KEY";
    public static final String TOKEN_PREFIX = "Bearer ";

    public String generateJwtToken(UserEntity userEntity) {
//        Claims claim = Jwts.claims().setSubject(String.valueOf(userEntity));
        Date now = new Date();
//        claim.put("id", userEntity.getId());
        return Jwts.builder()
                .setSubject(Long.toString(userEntity.getId()))
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + 115 * 60 * 1000))
                .signWith(SignatureAlgorithm.HS256, KEY)
                .compact();
    }

    public String parseToken(String token) {
        return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody().getSubject();
    }

    public Date expireToken(String token) {
        return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody().getExpiration();
    }

    private class TokenRefreshException extends Throwable {
        public TokenRefreshException(String token, String s) {

        }
    }
}
