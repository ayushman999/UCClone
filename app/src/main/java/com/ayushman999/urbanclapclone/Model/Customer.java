package com.ayushman999.urbanclapclone.Model;

public class Customer {
    private String email,name,uid,address;
    private int phoneNum;

    public Customer(String email, String name, String uid, String address, int phoneNum) {
        this.email = email;
        this.name = name;
        this.uid = uid;
        this.address=address;
        this.phoneNum = phoneNum;
    }

    public Customer() {
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

    public String getUid() {
        return uid;
    }

    public int getPhoneNum() {
        return phoneNum;
    }
}
