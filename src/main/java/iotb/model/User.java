package iotb.model;

import java.io.Serializable;

public class User implements Serializable {

    private Integer userID;
    private String fName;
    private String lName;
    private String emailAddress;
    private String password;
    private String phNumber;

    public User(Integer userID, String fName, String lName, String emailAddress, String password, String phNumber) {
        this.userID = userID;
        this.fName = fName;
        this.lName = lName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.phNumber = phNumber;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhNumber() {
        return phNumber;
    }

    public void setPhNumber(String phNumber) {
        this.phNumber = phNumber;
    }

}
