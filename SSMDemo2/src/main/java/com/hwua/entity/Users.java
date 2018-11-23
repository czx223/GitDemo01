package com.hwua.entity;

public class Users {
    private Integer uid;

    private String uname;

    private String uage;

    private String uaddress;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public String getUage() {
        return uage;
    }

    public void setUage(String uage) {
        this.uage = uage == null ? null : uage.trim();
    }

    public String getUaddress() {
        return uaddress;
    }

    public void setUaddress(String uaddress) {
        this.uaddress = uaddress == null ? null : uaddress.trim();
    }
}