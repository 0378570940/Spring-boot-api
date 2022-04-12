package com.example.demo.services;

import com.example.demo.entitys.UserEntity;
import com.example.demo.mappers.LoginMappers;
import com.example.demo.models.bo.ResultBo;
import com.example.demo.models.dto.ReponseData;
import com.example.demo.models.dto.UserDto;
import com.example.demo.models.ins.LoginIn;
import com.example.demo.models.out.SignUpOut;
import com.example.demo.models.out.UserLoginOut;
import com.example.demo.provider.JwtLogin;
import com.example.demo.repositories.LoginRepositories;
import com.example.demo.repositories.SignUpRepositories;
import com.mysql.cj.exceptions.PasswordExpiredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class LoginServices {
    @Autowired
    private LoginRepositories loginRepositories;
    @Autowired
    private SignUpRepositories signUpRepositories;
    @Autowired
    private JwtLogin jwtLogin;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private LoginMappers loginMapper;

    public UserDto signIn(LoginIn loginIn) {
        UserEntity userEntity = loginRepositories.findFirstByName(loginIn.getName());
        if (userEntity == null) throw new PasswordExpiredException("Không tim thấ user");
        if (!loginIn.getPassword().equals(userEntity.getPassWord())) {
            throw new PasswordExpiredException("Mặt khẩu không tồn tại");
        }
        UserDto userDto = new UserDto();
        userEntity = loginMapper.loginMapper(userEntity, userDto);
        String token = jwtLogin.generateJwtToken(userEntity);
        userDto.setToken(token);
        return userDto;
    }

    public ResponseEntity<?> signUp(UserEntity userEntity) {
        if (loginRepositories.existsByName(userEntity.getName())) {
            return new ResponseEntity<>("Tên người dùng đã được sử dụng!", HttpStatus.BAD_REQUEST);
        }
        if (loginRepositories.existsByEmail(userEntity.getEmail())) {
            return new ResponseEntity<>("Email này đã được sử!", HttpStatus.BAD_REQUEST);
        }
        loginMapper.signUpMapper(signUpRepositories.save(userEntity));
        SignUpOut signUpOut = new SignUpOut();
        String token = jwtLogin.generateJwtToken(userEntity);
        signUpOut.setToken(token);
        return new ResponseEntity<>("Tạo người dùng thành công", HttpStatus.OK);
    }

    public ResponseEntity<?> verifyToken(String token) {
        long userId = Long.parseLong(jwtLogin.parseToken(token));
        UserEntity userEntity = loginRepositories.findById(userId);
        UserLoginOut userLoginOut = new UserLoginOut();
        if (userEntity == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if (userEntity.getStatus().equals(ResultBo.Status.ACTIVE.name()))
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        if (pressedDate().before(userEntity.getExpire_date())) return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        loginMapper.tokenId(userEntity, userLoginOut);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private ReponseData pressedDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate now = LocalDate.now();
        return new ReponseData(dtf.format(now));
    }

    public String pressedDate(String date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(date);
        LocalDate now = LocalDate.now();
        return dtf.format(now);
    }


}
