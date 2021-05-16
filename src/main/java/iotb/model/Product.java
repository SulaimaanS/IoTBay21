package iotb.model;

import java.io.Serializable;

public class Product implements Serializable {

    private int productID;
    private String productName;
    private String productDescription;
    private String productCategory;
    private float productPrice;
    private int productStock;

    public Product(int productID, String productName, String productDescription, String productCategory, float productPrice, int productStock) {
        this.productID = productID;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
        this.productStock = productStock;
    }

    public int getProductID() {
        return productID;
    }

    public void setUserID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setproductName(String productName) {
        this.productName = productName;
    }

    public String getproductDescription() {
        return productDescription;
    }

    public void setproductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getproductCategory() {
        return productCategory;
    }

    public void setproductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public float getproductPrice() {
        return productPrice;
    }

    public void setproductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public int getproductStock() {
        return productStock;
    }

    public void setproductStock(int productStock) {
        this.productStock = productStock;
    }
}
