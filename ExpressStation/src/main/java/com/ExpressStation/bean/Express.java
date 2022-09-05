package com.ExpressStation.bean;

import java.util.Date;

public class Express {
    private String e_id;
    private String u_name;
    private String u_phone;
    private String address;
    private String code;
    private String status;
    private Date date;

    public Express(){}

    public Express(String e_id, String u_name, String u_phone, String address, String code, String status) {
        this.e_id = e_id;
        this.u_name = u_name;
        this.u_phone = u_phone;
        this.address = address;
        this.code = code;
        this.status = status;
    }

    public String getE_id() {
        return e_id;
    }

    public void setE_id(String e_id) {
        this.e_id = e_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_phone() {
        return u_phone;
    }

    public void setU_phone(String u_phone) {
        this.u_phone = u_phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
