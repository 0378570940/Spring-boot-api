package com.example.demo.models.mappers;

import com.example.demo.entitys.UserEntity;
import com.example.demo.models.dto.UserDto;
import com.example.demo.models.ins.UserIn;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class UserMappers {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(UserMappers.class, args);
    }

    public UserEntity toUserDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        userDto.setAge(userEntity.getAge());
        userDto.setEmail(userEntity.getEmail());
        userDto.setName(userEntity.getName());
        userDto.setId(userEntity.getId());
        return userEntity;
    }


    public UserDto getfindAll(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        userDto.setAge(userEntity.getAge());
        userDto.setEmail(userEntity.getEmail());
        userDto.setName(userEntity.getName());
        userDto.setId(userEntity.getId());
        return userDto;
    }

    public UserEntity mapUpdate(UserEntity userEntity, UserIn userIn) {
        userEntity.setAge(userIn.getAge());
        userEntity.setEmail(userIn.getEmail());
        userEntity.setName(userIn.getName());
        return userEntity;
    }

    public UserIn toUserIn(UserEntity userEntity) {
        UserIn userIn = new UserIn();
        userIn.setAge(userEntity.getAge());
        userIn.setEmail(userEntity.getEmail());
        userIn.setName(userEntity.getName());
        return userIn;
    }
}
