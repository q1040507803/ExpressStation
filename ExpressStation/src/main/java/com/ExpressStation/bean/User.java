package com.ExpressStation.bean;

public class User {
    private String u_id;
    private String name;
    private String pwd;
    private String phone;
    private int role;

    public User(){}

    public User(String u_id, String name, String pwd, String phone, int role) {
        this.u_id = u_id;
        this.name = name;
        this.pwd = pwd;
        this.phone = phone;
        this.role = role;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return getU_id()+getPwd();
    }
}