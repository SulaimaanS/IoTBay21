/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.model.dao;

import iotb.model.Customer;
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
 * @author alaw8
 */
public class CustomerManager {

    private Statement statement;

    public CustomerManager(Connection connection) throws SQLException {
        statement = connection.createStatement();
    }

    public void addCustomer(int userID, String dob, int streetNum, String streetName, int postCode, boolean registered) throws ParseException, SQLException {
        String columns = "INSERT INTO CUSTOMERTABLE(USERID, DOB, STREETNUMBER, STREETNAME, POSTCODE, REGISTERED)";
        Date d = DateFormat.getDateInstance().parse(dob);
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        String strDate = formatter.format(d);
        String values = "VALUES (" + userID + ",'" + strDate + "'," + streetNum + ",'" + streetName + "'," + postCode + "," + registered + ")";
        statement.executeUpdate(columns + values);
    }

    public Customer readCustomer(int userID) throws SQLException {
        String query = "SELECT * FROM CUSTOMERTABLE WHERE USERID = " + userID + "";
        ResultSet rs = statement.executeQuery(query);

        while (rs.next()) {
            Integer customerid = rs.getInt(1);
            Integer userid = rs.getInt(2);
            Date dob = rs.getDate(3);
            Integer streetnumber = rs.getInt(4);
            String streetname = rs.getString(5);
            Integer postcode = rs.getInt(6);
            Boolean registered = rs.getBoolean(7);

            return new Customer(userid, customerid, dob, streetnumber, streetname, postcode, registered);
        }
        return null;
    }

    public void updateCustomer(int userID, int customerID, String dob, int streetNumber, String streetName, int postCode, Boolean registered) throws SQLException, ParseException {
        Date d = DateFormat.getDateInstance().parse(dob);
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        String strDate = formatter.format(d);
        String update = "UPDATE CUSTOMERTABLE SET USERID=" + userID + ",DOB='" + strDate + "',STREETNUMBER=" + streetNumber + ",STREETNAME='" + streetName + "',POSTCODE=" + postCode + ",REGISTERED=" + registered + " WHERE CUSTOMERID= " + customerID + " ";
        statement.executeUpdate(update);
    }

    public void deleteCustomer(int userID) throws SQLException {
        String delete = "DELETE FROM CUSTOMERTABLE WHERE USERID=" + userID + "";
        statement.executeUpdate(delete);
    }
    
    public int getID(int userID) throws SQLException{
        String query = "SELECT * FROM CUSTOMERTABLE WHERE USERID = "+userID+"";
        ResultSet rs = statement.executeQuery(query);

        while (rs.next()) {
            Integer id = rs.getInt(1);  
            return id;
        }
        return 0;
    }
}
