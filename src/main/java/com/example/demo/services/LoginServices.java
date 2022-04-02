package com.example.demo.services;

import com.example.demo.config.Constant;
import com.example.demo.entitys.UserEntity;
import com.example.demo.models.dto.HeaderDto;
import com.example.demo.models.dto.ReponseData;
import com.example.demo.models.dto.UserDto;
import com.example.demo.models.ins.HeaderIn;
import com.example.demo.models.ins.LoginIn;
import com.example.demo.models.mappers.LoginMappers;
import com.example.demo.models.mappers.UserMappers;
import com.example.demo.provider.JwtLogin;
import com.example.demo.repositories.LoginRepositories;
import com.mysql.cj.exceptions.PasswordExpiredException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.HttpCookie;
import java.util.Date;

@Service
public class LoginServices {
    @Autowired
    private LoginRepositories loginRepositories;
    @Autowired
    private JwtLogin jwtLogin;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private LoginMappers loginMapper;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserMappers mappers;

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

//    public UserDto loginHeader(JwtLogin jwtLogin) {
//        UserEntity userEntity = loginRepositories.findFirstByToken();
//        UserDto userDto = new UserDto();
////        userEntity = loginMapper.loginMapper(userEntity, userDto);
//        userDto.setName(userEntity.getName());
//        String token1 = jwtLogin.parseToken(userEntity);
//        userDto.setToken(token1);
//        return userDto;
//    }

    public ResponseEntity<?> getUser(String token) {
        String tokenId = jwtLogin.parseToken(token);
        UserEntity userEntity = loginRepositories.findFirstById(Long.valueOf(tokenId));
        HeaderDto headerDto = new HeaderDto();
        loginMapper.tokenId(userEntity, headerDto);
        String tokenCheck = jwtLogin.checkExpireToken(token);
        headerDto.setStatus(tokenCheck);
        String tokenCreate = jwtLogin.generateJwtToken(userEntity);
        headerDto.setToken(tokenCreate);
        Date tokenExpire = jwtLogin.expireToken(token);
        headerDto.setExpire_date(tokenExpire);
        return new ResponseEntity<>(headerDto, HttpStatus.OK);
    }

}
