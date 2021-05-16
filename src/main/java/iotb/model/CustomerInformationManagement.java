/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.model;

/**
 *
 * @author timmy
 */
public class CustomerInformationManagement {
    private String customerID;
    private String type;
    private String fName;
    private String lName;
    private String dob;
    private String gender;
    private String email;
    private String password;
    private String phone;
    private String streetNumber;
    private String streetName;
    private String postCode;
    private String registered;

    public CustomerInformationManagement(String customerID, String type, String fName, String lName, 
            String dob, String gender, String email, String password, String phone, String streetNumber, 
            String streetName, String postCode, String registered) {
        this.customerID = customerID;
        this.fName = fName;
        this.lName = lName;
        this.dob = dob;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.postCode = postCode;
        this.registered = registered;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }
    
}
