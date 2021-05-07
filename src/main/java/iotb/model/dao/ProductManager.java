package iotb.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductManager {
    private Statement statement;
    
    public ProductManager(Connection connection) throws SQLException{
        statement = connection.createStatement();
    }
    
    public void addProduct(){
    }
    
    public void readProduct(){
    }
    
    public void updateProduct(){
    }
    
    public void deleteProduct(){
    }
}
