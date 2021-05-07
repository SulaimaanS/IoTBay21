package iotb.model;

import java.io.Serializable;

public class Product implements Serializable {

    private String productID;
    private String productName;
    private String productDescription;
    private String productCategory;
    private String productPrice;
    private String productStock;

    public Product(String productID, String productName, String productDescription, String productCategory, String productPrice, String productStock) {
        this.productID = productID;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
        this.productStock = productStock;
    }

    public String getProductID() {
        return productID;
    }

    public void setUserID(String productID) {
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
    
    public String getproductPrice() {
        return productPrice;
    }

    public void setproductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
    
    public String getproductStock() {
        return productStock;
    }

    public void setproductStock(String productStock) {
        this.productStock = productStock;
    }    
}
