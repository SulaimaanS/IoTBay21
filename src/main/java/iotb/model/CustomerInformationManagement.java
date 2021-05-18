/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.model;

import java.util.Date;

/**
 *
 * @author timmy
 */
public class CustomerInformationManagement {
    private Integer customerID;
    private String fName;
    private String lName;
    private String email;
    private String password;
    private String phone;
    private Date dob;
    private Integer streetNumber;
    private String streetName;
    private Integer postCode;
    private Boolean registered;

    public CustomerInformationManagement(Integer customerID, String fName, String lName, 
            String email, String password, String phone, Date dob, Integer streetNumber, 
            String streetName, Integer postCode, Boolean registered) {
        this.customerID = customerID;
        this.fName = fName;
        this.lName = lName;
        this.dob = dob;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.postCode = postCode;
        this.registered = registered;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Integer getPostCode() {
        return postCode;
    }

    public void setPostCode(Integer postCode) {
        this.postCode = postCode;
    }

    public Boolean getRegistered() {
        return registered;
    }

    public void setRegistered(Boolean registered) {
        this.registered = registered;
    }
    
}
