/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author alaw8
 */
public class CustomerManager {
    private Statement statement;
    
    public CustomerManager(Connection connection) throws SQLException{
        statement = connection.createStatement();
    }
    
    public void addCustomer(){
    }
    
    public void readCustomer(){
    }
    
    public void updateCustomer(){
    }
    
    public void deleteCustomer(){
    }
}
