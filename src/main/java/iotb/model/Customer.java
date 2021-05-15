package iotb.model;

import java.io.Serializable;

//TBD

public class Customer {
    private String userID;
    private String customerID;
    private String type;
    private String orderID;
    private String registered;

    public Customer(String userID, String customerID, String type, String orderID, String registered) {
        this.userID = userID;
        this.customerID = customerID;
        this.orderID = orderID;
        this.type = type;
        this.registered = registered;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
    public String getType() {
        return type;
    }

    public void setType(String userID) {
        this.type = type;
    }
    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }
    
    
}
