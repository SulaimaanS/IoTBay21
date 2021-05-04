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
 * @author 1234
 */
public class PaymentManager {
    
    private Statement statement;
    
    public PaymentManager(Connection connection) throws SQLException {
        statement = connection.createStatement();
    }
    
    public void addPaymentMethod(){
        // to complete
    }
}
