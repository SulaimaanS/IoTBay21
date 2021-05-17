package iotb.model;

import java.util.Date;

public class Customer {

    private Integer userID;
    private Integer customerID;
    private Date dob;
    private Integer streetNumber;
    private String streetName;
    private Integer postCode;
    private Boolean registered;

    public Customer(Integer userID, Integer customerID, Date dob, Integer streetNumber, String streetName, Integer postCode, Boolean registered) { //Returns customer
        this.userID = userID;
        this.customerID = customerID;
        this.dob = dob;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.postCode = postCode;
        this.registered = registered;
    }

    public Integer getUserID() { //Returns userID of the Customer
        return userID;
    }

    public void setUserID(Integer userID) { //Sets User ID to new userID passed to it
        this.userID = userID;
    }

    public Integer getCustomerID() { //Returns CustomerID of the Customer
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
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
