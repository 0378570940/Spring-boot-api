package com.example.demo.services;

import com.example.demo.entitys.UserEntity;
import com.example.demo.provider.JwtUser;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


@Service
public class JwtServices {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUser jwtUser;

    //thêm ảnh vào database post
    public ResponseEntity<?> create(long id, MultipartFile file) throws IOException {
        //Đặt dữ liệu biểu mẫu thành thực thể
        UserEntity userEntity = userRepository.findAllById(id);
        if (userEntity == null) return new ResponseEntity<>("không tải được hồ sơ nào cả", HttpStatus.BAD_REQUEST);
        userEntity.setId(id);
        userEntity.setImg(file.getBytes());
        // Lưu các bản ghi vào cơ sở dữ liệu
        userRepository.save(userEntity);
        return new ResponseEntity<>("Hồ sơ được lưu vào cơ sở dữ liệu", HttpStatus.OK);
    }


    public void saveToFile(String jwtUser) {
        try {
            File newTextFile = new File("D:\\Inteliji\\hello.txt");
            FileWriter fw = new FileWriter(newTextFile);
            fw.write(jwtUser);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ResponseEntity<?> authenticateUser() {
        String jwt = jwtUser.genTokenJwt();
        saveToFile(jwt);
        return new ResponseEntity<>(jwt, HttpStatus.OK);
    }
}
