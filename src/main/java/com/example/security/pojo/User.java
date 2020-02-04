package com.example.security.pojo;
public class User {
    private Integer uid;//uid
    private String password;//password
    private String mobile;//mobile
    private String username;//username
    public User(Integer uid, String password, String mobile, String username) {
        this.uid = uid;
        this.password = password;
        this.mobile = mobile;
        this.username = username;
    }
    public User() {
        super();
    }
    public Integer getUid() {
        return uid;
    }
    public void setUid(Integer uid) {
        this.uid = uid;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    @Override
    public String toString() {
        return "User{" + "uid=" + uid +
                ","
                + "password=" + password +
                ","
                + "mobile=" + mobile +
                ","
                + "username=" + username +
                ","
                +
        '}';
    }
}
