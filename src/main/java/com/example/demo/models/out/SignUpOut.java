package com.example.demo.models.out;

public class SignUpOut {
    private String name;
    private String password;
    private String email;
    private String token;
    private String interest;
    private String Driver;
    private String gender;
    private String hometown;
    private String facebook;
    private String SDT;
    private String Dateofbirth;
    private String maritalstatus;
    private String Work;

    public SignUpOut() {
    }

    public String getToken() {
        return token;
    }

    public SignUpOut(String name, String password, String email, String token, String interest, String driver, String gender, String hometown, String facebook, String SDT, String dateofbirth, String maritalstatus, String work) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.token = token;
        this.interest = interest;
        Driver = driver;
        this.gender = gender;
        this.hometown = hometown;
        this.facebook = facebook;
        this.SDT = SDT;
        Dateofbirth = dateofbirth;
        this.maritalstatus = maritalstatus;
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

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
