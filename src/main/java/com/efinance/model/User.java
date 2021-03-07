package com.efinance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * User class structures user data within the eFinance system
 */
@Entity
public class User
{
    /**
     * userID signifies the User's ID 
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="userid")
    private Integer userid;
    
    /**
     * fName data field is for User's first name
     */
    @Column(name="fname")
    private String fname;
    
    /**
     * lName data field is for User's last name
     */
    @Column(name="lname")
    private String lname;
    
    /**
     * phoneNum is the data field for the User's phone number
     */
    @Column(name="email")
    private String email;
    
    /**
     * userPass signifies the User's password
     */
    @Column(name="userpass")
    private String userpass;
    
    /**
     * userType enumeration specifies the different types of users which are customers and employees
     */
    public enum UserType {CUSTOMER, LOANOFFICER, LOANCONSULTANT, ACCOUNTMANAGER};
    
    /**
     * The type instance of the UserType enumeration signifies a particular user's type
     */
    @Column(name="usertype")
    @Enumerated(EnumType.STRING)
    private UserType usertype;

    /**
     * No Parameter Constructor
     */
    public User(){}

    /**
     * Returns the user ID
     * @return userID
     */
    public Integer getUserID()
    {
        return userid;
    }

    /**
     * Sets the User's ID
     * @param userID ID assigned to the users account
     */
    public void setUserID(Integer userid)
    {
        this.userid = userid;
    }
    
    /**
     * Returns the User's first name
     * @return fName
     */
    public String getFname()
    {
        return fname;
    }

    /**
     * Set's the User's first name
     * @param fName Users first name
     */
    public void setFname(String fname)
    {
        this.fname = fname;
    }

    /**
     * Returns the User's last name
     * @return lName
     */
    public String getLname()
    {
        return lname;
    }

    /**
     * Sets the User's last name
     * @param lName Users last name
     */
    public void setLname(String lname)
    {
        this.lname = lname;
    }

    /**
     * Returns the User's password
     * @return userPass
     */
    public String getUserpass()
    {
        return userpass;
    }

    /**
     * Sets the User's password
     * @param userPass Password the User chose
     */
    public void setUserpass(String userpass)
    {
        this.userpass = userpass;
    }

    /**
     * Returns the User's email
     * @return email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * Sets the User's email
     * @param email User's email
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * Returns the user's type
     * @return type
     */
    public UserType getUsertype()
    {
        return usertype;
    }

    /**
     * Sets the user's type
     * @param userType user's type i.e. customer, loan officer, etc.
     */
    public void setUserType(UserType usertype)
    {
        this.usertype = usertype;
    }
}