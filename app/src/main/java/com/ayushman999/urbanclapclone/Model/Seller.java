package com.ayushman999.urbanclapclone.Model;

public class Seller {
    private String email,name,skill,uid,address;
    private long phoneNum;

    public Seller(String email, String name, String skill, String uid, String address, long phoneNum) {
        this.email = email;
        this.name = name;
        this.skill = skill;
        this.uid = uid;
        this.address=address;
        this.phoneNum = phoneNum;
    }

    public Seller() {
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSkill() {
        return skill;
    }

    public String getUid() {
        return uid;
    }

    public long getPhoneNum() {
        return phoneNum;
    }
}
