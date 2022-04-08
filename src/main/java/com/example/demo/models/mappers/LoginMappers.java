package com.example.demo.models.mappers;

import com.example.demo.entitys.UserEntity;
import com.example.demo.models.dto.UserDto;
import com.example.demo.models.out.UserLoginOut;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class LoginMappers {


    public UserEntity loginMapper(UserEntity userEntity, UserDto userDto) {
        userDto.setId(userEntity.getId());
        userDto.setName(userEntity.getName());
        userDto.setEmail(userEntity.getEmail());
        userDto.setAge(userEntity.getAge());
        return userEntity;
    }

    public UserLoginOut tokenId(UserEntity userEntity, UserLoginOut userInOut) {
        userInOut.setId(userEntity.getId());
        userInOut.setName(userEntity.getName());
        userInOut.setEmail(userEntity.getEmail());
        userInOut.setAge(userEntity.getAge());
        userInOut.setDriver(userEntity.getDriver());
        userInOut.setInterest(userEntity.getInterest());
        userInOut.setDateofbirth(userEntity.getDateofbirth());
        userInOut.setFacebook(userEntity.getFacebook());
        userInOut.setGender(userEntity.getGender());
        userInOut.setHometown(userEntity.getHometown());
        userInOut.setMaritalstatus(userEntity.getMaritalstatus());
        userInOut.setSDT(userEntity.getSDT());
        userInOut.setWork(userEntity.getWork());
        return userInOut;
    }
}
