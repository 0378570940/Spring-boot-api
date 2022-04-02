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

import java.util.List;
import java.util.stream.Collectors;

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
    //cách2
//    public ReponseData create(UserEntity userEntity) {
//        ReponseData reponseData = new ReponseData();
//        reponseData.setMsg("Success");
//        reponseData.setData(userRepository.save(userEntity));
//        return reponseData;
//    }

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
    //cách 2
//    public ReponseData findAll(){
//        ReponseData reponseData = new ReponseData();
//        reponseData.setMsg("Success");
//        reponseData.setData(userRepository.findAll());
//        return reponseData;
//    }
    //cách3
//    public List<UserDto> findAll() {
//        List<UserEntity> userEntity = userRepository.findAllBy();
//        List<UserDto> userDtoList = new ArrayList<>();
//        for (UserEntity userEntity1 : userEntity) {
//            userDtoList.add(UserMappers.toUserDto(userEntity1));
//        }
//        return userDtoList;
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
//    public ResponseEntity<?> finaById(long id) {
//        UserEntity userEntity = userRepository.findAllById(id);
//        if (userEntity == null)
//        return new ResponseEntity<>("in ra không thành công",HttpStatus.NO_CONTENT);//
//        userEntity = mappers.toUserDto(userEntity);
//        userRepository.save(userEntity);
//        return new ResponseEntity<>("in ra thông tin thành công", HttpStatus.OK);//Status code 200 (trả về thành công get)
//    }
    //cách2
//    public ReponseData findAllBy(long id){
//        ReponseData reponseData = new ReponseData();
//        reponseData.setMsg("Success");
//        reponseData.setData(userRepository.findAllById(id));
//        return reponseData;
//    }
    //cách3
//    public UserDto findAllBy(long id) {
//        UserEntity userEntitys = userRepository.findAllById(id);
//        if (userEntitys.getId() == id) {
//            return UserMappers.toUserDto(userEntitys);
//        }
//        throw new NotFuondExcaption("không tông tại trong hệ thống");
//    }


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
    //cách2
//    public UserOut update(long id, UserEntity userEntity) {
//        UserEntity userEntitie = userRepository.findUserById(id);
//        if (userEntitie != null) {
//            userEntitie.setAge(userEntity.getAge());
//            userEntitie.setEmail(userEntity.getEmail());
//            userEntitie.setName(userEntity.getName());
//            userRepository.save(userEntitie);
//            return new UserOut(true, "update success");
//        }
//        return new UserOut(false, "user not exist");
//    }

    //xóa thông tin
    //cách 1
//    public ResponseEntity<?> delete(long id){
//        try {
//            userRepository.deleteAllById(id);
//            return new ResponseEntity<>("không tồn tại bản ghi nào", HttpStatus.BAD_REQUEST);
//        }catch (Exception e){
//            e.printStackTrace();
//            return new ResponseEntity<>("xóa thành công", HttpStatus.OK);
//        }
//    }
    //cách 2
    public ReponseData delete(long id) {
        try {
            userRepository.deleteById(id);
            return new ReponseData(Constant.MetaData.SUCCESS.getCode(), Constant.MetaData.SUCCESS.getMsg(), null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReponseData(Constant.MetaData.ERROR.getCode(), Constant.MetaData.ERROR.getMsg(), null);
        }
    }

    public UserEntity getUserById(long id) {
        return null;
    }

//    public ResponseEntity<List<UserEntity>> findAllById(long id) {
//        return null;
//    }

    // jwt tokem
//    public String findalll(){
//          UserEntity userEntity =userRepository.findAllBy();
//        return rjwtMappers.createToken(userEntity.getName(), userEntity.getEmail(), userEntity.getAge(), userEntity.getPassWord(), new String[]{"CUSTOMER"});
//    }
}
