package com.csu.domain.user;

/**
 * Created by 温 睿诚 on 2016/9/14/0014.
 */
public class User {
    private int userid;
    private  String password;
    private  String email;
    private String username;
    private String sex;
    private String id;
    private String phone;

    public User(int userid, String password, String email, String username, String sex, String id, String phone) {
        this.userid = userid;
        this.password = password;
        this.email = email;
        this.username = username;
        this.sex = sex;
        this.id = id;
        this.phone = phone;
    }

    public User() {
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
