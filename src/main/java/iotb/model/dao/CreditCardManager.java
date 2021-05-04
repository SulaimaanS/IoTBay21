/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.model.dao;

import iotb.model.CreditCard;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author 1234
 */
public class CreditCardManager {
    
    private Statement st;
    
    public CreditCardManager(Connection connection) throws SQLException {
        st = connection.createStatement();
    }
    
    // CREATE
    public void addCreditCard(String cardNumber, String expiryDate, String holderName, String cvv) throws SQLException, ParseException {
        Date d = DateFormat.getDateInstance().parse(expiryDate);
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        String formattedDate = formatter.format(d);
        
        String columns = "INSER INTO CREDITCARDTABLE(CARDNUMBER, EXPIRYDATE, HOLDERNAME, CVV)";
        String values = "VALUES ('"+cardNumber+"','"+formattedDate+"','"+holderName+"','"+cvv+"')"; //NOTE INT MIGHT BE A PROBLEM
        st.executeUpdate(columns + values);
    }
    
    // READ - by card number
    public CreditCard readCreditCard(String cardNumber)throws SQLException {
        String query = "SELECT * FROM CREDITCARDTABLE WHERE CARDNUMBER = "+cardNumber+"";
        ResultSet rs = st.executeQuery(query);
        
        while (rs.next()) {
            String cardID = rs.getString(1);
            String cardNo = rs.getString(2);
            String expiryDate = rs.getString(3);
            String holderName = rs.getString(4);
            String cvv = rs.getString(5);
            
            return new CreditCard(cardID, cardNo, expiryDate, holderName, cvv);
        }
        
        return null;
    }
    
    // UPDATE - all credit card details
    
    public void updateCreditCard(String cardNumber, String expiryDate, String holderName, String cvv) throws SQLException, ParseException {
        Date d = DateFormat.getDateInstance().parse(expiryDate);
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        String formattedDate = formatter.format(d);
        
        String update = "UPDATE CREDITCARDTABLE SET CARDNUMBER = '"+cardNumber+"', SET EXPIRYDATE = '"+formattedDate+"', SET HOLDERNAME = '"+holderName+"', SET CVV = '"+cvv+"'"; // NOTE INT MIGHT BE A PROBLEM
        st.executeUpdate(update);
    }
    
    // DELETE - by card number
    
    public void deleteCreditCard(String cardNumber) throws SQLException {
        String delete = "DELETE FROM CREDITCARDTABLE WHERE CARDNUMBER = "+ cardNumber +"";
        st.executeUpdate(delete);
    }
}
