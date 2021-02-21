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
    /**
     * fName data field is for user's first name
     */
    private String fName;
    /**
     * lName data field is for user's last name
     */
    private String lName;
    /**
     * userID signifies the user's ID 
     */
    private String userID;
    /**
     * userPass signifies the user's password
     */
    private String userPass;
    /**
     * address is the data field for the user's address
     */
    private String address;
    /**
     * phoneNum is the data field for the user's phone number
     */
    private String phoneNum;
    /**
     * userType enumeration specifies the different types of users which are customers and employees
     */
    private enum userType {CUSTOMER, EMPLOYEE};

    /**
     * All parameter constructor
     * @param fName
     * @param lName
     * @param userID
     * @param userPass
     * @param address
     * @param phoneNum 
     */
    public user(String fName, String lName, String userID, String userPass, String address, String phoneNum) {
        this.fName = fName;
        this.lName = lName;
        this.userID = userID;
        this.userPass = userPass;
        this.address = address;
        this.phoneNum = phoneNum;
    }

    /**
     * Returns fName data field which is the user's first name
     * @return 
     */
    public String getfName() {
        return fName;
    }

    /**
     * Set's the user's first name
     * @param fName 
     */
    public void setfName(String fName) {
        this.fName = fName;
    }

    /**
     * Returns the user's last name
     * @return 
     */
    public String getlName() {
        return lName;
    }

    /**
     * Sets the user's last name
     * @param lName 
     */
    public void setlName(String lName) {
        this.lName = lName;
    }

    /**
     * Returns the user's ID
     * @return 
     */
    public String getUserID() {
        return userID;
    }

    /**
     * Sets the user's ID
     * @param userID 
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * Returns the user's password
     * @return 
     */
    public String getUserPass() {
        return userPass;
    }

    /**
     * Sets the user's password
     * @param userPass 
     */
    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    /**
     * Returns the user's address
     * @return 
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set's the user's address
     * @param address 
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Return's the user's phone number
     * @return 
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * Sets the user's phone number
     * @param phoneNum 
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    
}
