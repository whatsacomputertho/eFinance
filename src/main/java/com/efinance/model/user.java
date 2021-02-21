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
     * @param fName First name of the user
     * @param lName Last name of the user
     * @param userID ID belonging to the user's account
     * @param userPass Password of the user
     * @param address Address of the user
     * @param phoneNum Phone number of the user
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
     * This method will allow the user to select a data field to update and eventually will allow
     * the user to update their selected piece of information. Once updated, it will return the result.
     * @return 
     */
    private String updateUserInfo(){
        String userInfo = "";
        return userInfo;
    }
    /**
     * This will allow the user to authenticate their information
     * Once authentication is complete, method will return status of authentication
     * @return 
     */
    private boolean authenticate(){
        boolean status = false;
        return status;
    }
    /**
     * Returns the user's first name
     * @return fName
     */
    public String getfName() {
        return fName;
    }

    /**
     * Set's the user's first name
     * @param fName Users first name
     */
    public void setfName(String fName) {
        this.fName = fName;
    }

    /**
     * Returns the user's last name
     * @return lName
     */
    public String getlName() {
        return lName;
    }

    /**
     * Sets the user's last name
     * @param lName Users last name
     */
    public void setlName(String lName) {
        this.lName = lName;
    }

    /**
     * Returns the user's ID
     * @return userID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * Sets the user's ID
     * @param userID ID assigned to the users account
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * Returns the user's password
     * @return userPass
     */
    public String getUserPass() {
        return userPass;
    }

    /**
     * Sets the user's password
     * @param userPass Password the user chose
     */
    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    /**
     * Returns the user's address
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set's the user's address
     * @param address Address of the user
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns the user's phone number
     * @return phoneNum
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * Sets the user's phone number
     * @param phoneNum Phone number of the user
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    
}
