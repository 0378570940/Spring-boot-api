package com.example.demo.entitys;

import javax.persistence.*;
import java.io.File;
import java.util.stream.Stream;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "age")
    private int age;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "token")
    private String token;
    @Column(name = "Expire_date")
    private String Expire_date;
    @Column(name = "Status")
    private String Status;
    @Column(name = "interest")
    private String interest;
    @Column(name = "Driver")
    private String Driver;
    @Column(name = "gender")
    private String gender;
    @Column(name = "hometown")
    private String hometown;
    @Column(name = "facebook")
    private String facebook;
    @Column(name = "SDT")
    private String SDT;
    @Column(name = "Dateofbirth")
    private String Dateofbirth;
    @Column(name = "maritalstatus")
    private String maritalstatus;
    @Column(name = "Work")
    private String Work;
    @Column(name = "img")
    @Lob
    private byte[] img;

    public UserEntity(String signUpInName, String facebook, String driver, String name, String email, String encode) {
    }

    public UserEntity() {

    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDateofbirth() {
        return Dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        Dateofbirth = dateofbirth;
    }

    public String getMaritalstatus() {
        return maritalstatus;
    }

    public void setMaritalstatus(String maritalstatus) {
        this.maritalstatus = maritalstatus;
    }

    public String getWork() {
        return Work;
    }

    public void setWork(String work) {
        Work = work;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getDriver() {
        return Driver;
    }

    public void setDriver(String driver) {
        Driver = driver;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getExpire_date() {
        return Expire_date;
    }

    public void setExpire_date(String expire_date) {
        Expire_date = expire_date;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserEntity(long id, int age, String name, String password, String email, String token, String expire_date, byte[] img) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.password = password;
        this.email = email;
        this.token = token;
        Expire_date = expire_date;
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


    public Stream<Object> stream() {
        return null;
    }

    public void getPassWord(int code, String msg) {

    }

    public void setId(String token1) {

    }
}
