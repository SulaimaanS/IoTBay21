/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.model;

import java.util.Date;

/**
 *
 * @author root
 */
public class Order {
    private int orderID;
    private int productID;
    private int productQuantity;
    private String dateOrdered;
    private float orderTotal;
    private int userID;

    public Order(int orderID, int productID, int productQuantity, String dateOrdered, float orderTotal, int userID) {
        this.orderID = orderID;
        this.productID = productID;
        this.productQuantity = productQuantity;
        this.dateOrdered = dateOrdered;
        this.orderTotal = orderTotal;
        this.userID = userID;
    }
    
    

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(String dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public float getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(float orderTotal) {
        this.orderTotal = orderTotal;
    }
    
    public int getUserID() {
        return userID;
    }
    
    public void setUserID(int userID) {
        this.userID = userID;
    }
    
}
