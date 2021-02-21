/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efinance.model;

/**
 *
 * @author Owner
 */
public class user
{
    
    private String fName;
    private String lName;
    private String userID;
    private String userPass;
    private String address;
    private String phoneNum;
    private enum userType {CUSTOMER, EMPLOYEE};

    public user(String fName, String lName, String userID, String userPass, String address, String phoneNum) {
        this.fName = fName;
        this.lName = lName;
        this.userID = userID;
        this.userPass = userPass;
        this.address = address;
        this.phoneNum = phoneNum;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    
}
