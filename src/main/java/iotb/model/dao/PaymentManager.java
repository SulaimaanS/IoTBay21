/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.model.dao;

import iotb.model.Payment;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

/**
 *
 * @author 1234
 */
public class PaymentManager {
    
    private Statement st;
    
    public PaymentManager(Connection connection) throws SQLException {
        st = connection.createStatement();
    }
    
    // CREATE - requires an existing orderID
    
    public void addPayment(int orderID, int paymentType) throws SQLException{
        String columns = "INSERT INTO PAYMENTTABLE(ORDERID, PAYMENTTYPE)";
        String values = "VALUES ("+orderID+","+paymentType+")"; 
        st.executeUpdate(columns + values);
    }
    
    // READ - by paymentID
    
    public Payment readPayment(int searchPaymentID) throws SQLException {
        String query = "SELECT * FROM PAYMENTTABLE WHERE PAYMENTID = "+searchPaymentID+"";
        ResultSet rs = st.executeQuery(query);
        
        while (rs.next()) {
            String paymentID = rs.getString(1);
            String orderID = rs.getString(2);
            String paymentType = rs.getString(3);
            
            return new Payment(paymentID, orderID, paymentType);
        }
        
        return null;
    }
    
    // UPDATE - by paymentID
    
    public void updateCreditCard(int paymentID, int orderID, int paymentType) throws SQLException, ParseException {
        
        
        // Requires an existing orderID to be assigned to
        // Payment type can only be changed to 1 or 2 - a validator will handle this requirement
        
        String update = "UPDATE PAYMENTTABLE SET ORDERID = "+orderID+",  PAYMENTTYPE = "+paymentType+" WHERE PAYMENTID="+paymentID+"";
        st.executeUpdate(update);
    }
    
    // DELETE - by paymentID
    
    public void deletePayment(int paymentID) throws SQLException {
        String delete = "DELETE FROM PAYMENTTABLE WHERE PAYMENTID = "+paymentID+"";
        st.executeUpdate(delete);
    }
}
