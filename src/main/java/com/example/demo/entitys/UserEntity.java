package com.example.demo.entitys;

import javax.persistence.*;
import java.io.File;
import java.net.URI;
import java.util.Iterator;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "age")
    private int age;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "img")
    @Lob
    private byte[] img;

    public UserEntity() {
    }

    public UserEntity(long id, int age, String name, String password, String email, byte[] img) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.password = password;
        this.email = email;
        this.img = img;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return password;
    }

    public void setPassWord(String passWord) {
        this.password = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public File getFile() {
        return null;
    }

    public String getFilename() {
        return null;
    }
}
