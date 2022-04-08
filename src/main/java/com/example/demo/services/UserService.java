package com.example.demo.services;

import com.example.demo.config.Constant;
import com.example.demo.entitys.UserEntity;
import com.example.demo.models.dto.ReponseData;
import com.example.demo.models.dto.UserDto;
import com.example.demo.models.ins.UserIn;
import com.example.demo.models.mappers.UserMappers;
import com.example.demo.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMappers mappers;

    @Autowired
    private ModelMapper modelMapper;


    // cập nhật thông tin post
    //cách1
    public ResponseEntity<?> create(UserEntity userEntity) {
        UserEntity userEntity1 = mappers.toUserDto(userRepository.save(userEntity));
        return new ResponseEntity<>(userEntity1, HttpStatus.OK);
    }


    // sâu toàn bộ thông tin get
    //cách1
//    public ResponseEntity<?> finaAll() {
//
//        List<UserEntity> userEntityList = userRepository.findAll();
//        List<UserDto> userDto = userEntityList.stream()
//                .map(post -> modelMapper.map(post, UserDto.class))
//                .collect(Collectors.toList());
//        return new ResponseEntity<>(userDto, HttpStatus.OK);
//    }


    //lấy thông tin id get
    //cách1
    public ResponseEntity<?> finaById(long id) {
        UserEntity userEntity = userRepository.findAllById(id);
        if (userEntity == null)
            return new ResponseEntity<>("không tìm thấy thông tin nào cả", HttpStatus.BAD_REQUEST);
        UserDto userDto = modelMapper.map(userEntity, UserDto.class);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    //sửa thông tin put
    //cách1
    public ResponseEntity<?> update(long id, UserIn userIn) {
        // lấy thông tin bản ghi cần cật nhật ở db
        UserEntity userEntity = userRepository.findUserById(id);
        // check xem có tồn tại ko nếu ko thì trả ra kq là ko thể cập nhật
        if (userEntity == null)
            return new ResponseEntity<>("ko có bản ghi tồn tại", HttpStatus.BAD_REQUEST);//Status code 204 (xóa thành công)
        // nếu có thì cập nhật dữ liệu cho bản ghi
        userEntity = mappers.mapUpdate(userEntity, userIn);
        // save vào db
        userRepository.save(userEntity);
        return new ResponseEntity<>("cập nhật thành công", HttpStatus.OK);//Status code 200 (trả về thành công get)
    }

    public ReponseData delete(long id) {
        try {
            userRepository.deleteById(id);
            return new ReponseData(Constant.MetaData.SUCCESS.getCode(), Constant.MetaData.SUCCESS.getMsg(), null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReponseData(Constant.MetaData.ERROR.getCode(), Constant.MetaData.ERROR.getMsg(), null);
        }
    }


}
