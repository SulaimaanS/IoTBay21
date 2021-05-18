/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.model.dao;

import iotb.model.CustomerInformationManagement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author timmy
 */
public class CustomerInformationManagementManager {

    private Statement st;

    public CustomerInformationManagementManager(Connection con) throws SQLException {
        st = con.createStatement();
    }

    public CustomerInformationManagement findCustomerInformation(String fName, String lName, String email)
            throws SQLException {

        String fetch = "SELECT \n"
                + "CUSTOMERTABLE.CUSTOMERID, \n"
                + "USERTABLE.FIRSTNAME, USERTABLE.LASTNAME,  USERTABLE.EMAILADDRESS, \n"
                + "USERTABLE.PASSWORD, USERTABLE.PHONENUMBER, CUSTOMERTABLE.DOB, CUSTOMERTABLE.STREETNUMBER, CUSTOMERTABLE.STREETNAME, CUSTOMERTABLE.POSTCODE,CUSTOMERTABLE.REGISTERED\n"
                + "FROM USERTABLE\n"
                + "INNER JOIN CUSTOMERTABLE ON USERTABLE.USERID = CUSTOMERTABLE.USERID WHERE FIRSTNAME= '" + fName + "' AND  LASTNAME= '" + lName + "' AND EMAILADDRESS='" + email + "' ";

        /*SELECT 
CUSTOMERTABLE.CUSTOMERID, 
USERTABLE.FIRSTNAME, USERTABLE.LASTNAME, USERTABLE.EMAILADDRESS,  
USERTABLE.PASSWORD, USERTABLE.PHONENUMBER, CUSTOMERTABLE.DOB, CUSTOMERTABLE.STREETNUMBER, CUSTOMERTABLE.STREETNAME, CUSTOMERTABLE.POSTCODE,
CUSTOMERTABLE.REGISTERED
FROM USERTABLE
INNER JOIN CUSTOMERTABLE ON USERTABLE.USERID = CUSTOMERTABLE.USERID*/
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            String customerFName = rs.getString(2);
            String customerLName = rs.getString(3);
            String customerEmail = rs.getString(4);
            if (customerFName.equals(fName) && customerLName.equals(lName) && customerEmail.equals(email)) {
                Integer customerID = rs.getInt(1);
                Date customerDOB = rs.getDate(7);
                String customerPassword = rs.getString(5);
                String customerPhone = rs.getString(6);
                Integer customerStreetNumber = rs.getInt(8);
                String customerStreetName = rs.getString(9);
                Integer customerPostcode = rs.getInt(10);
                Boolean customerRegistered = rs.getBoolean(11);

                return new CustomerInformationManagement(customerID, customerFName, customerLName,
                        customerEmail, customerPassword, customerPhone, customerDOB,
                        customerStreetNumber, customerStreetName, customerPostcode, customerRegistered);
            }

        }
        return null;
    }

    //Add a user-data into the database   
    public void addCustomerInformation(String fName, String lName, String email, String password, String phone, String dob, Integer streetNumber, String streetName, Integer postCode, Boolean registered) throws SQLException, ParseException {                   //code for add-operation       
        Date d = DateFormat.getDateInstance().parse(dob);
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        String dFormatted = formatter.format(d);
        st.executeUpdate("INSERT INTO USERTABLE (FIRSTNAME, LASTNAME,  EMAILADDRESS, PASSWORD, PHONENUMBER) VALUES('" + fName + "', '" + lName + "', '" + email + "', '" + password + "', '" + phone + "') ");
        st.executeUpdate("INSERT INTO CUSTOMERTABLE (USERID, DOB, STREETNUMBER, STREETNAME, POSTCODE, REGISTERED) VALUES( (SELECT USERID FROM USERTABLE WHERE EMAILADDRESS = '"+email+"') '" + dFormatted + "', '" + streetNumber + "', '" + streetName + "', '" + postCode + "', '" + registered +"' )");  
    }

//update a user details in the database   
    public void updateCustomerInformation(String fName, String lName,
            String email, String password, String phone, String dob, int streetNumber, String streetName,
            int postCode) throws SQLException, ParseException {
        Date d = DateFormat.getDateInstance().parse(dob);
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        String dFormatted = formatter.format(d);
        st.executeUpdate("UPDATE USERTABLE SET FIRSTNAME='" + fName + "',LASTNAME='" + lName + "',PASSWORD='" + password + "',PHONENUMBER='" + phone + "',STREETNUMBER='" + streetNumber + "',STREETNAME='" + streetName + "',POSTCODE='" + postCode + "'WHERE EMAILADDRESS='" + email + "'");
        st.executeUpdate("UPDATE CUSTOMERTABLE SET FIRSTNAME='" + fName + "',LASTNAME='" + lName + "',DOB= '" + dob + "',PASSWORD='" + password + "',PHONENUMBER='" + phone + "',STREETNUMBER='" + streetNumber + "',STREETNAME='" + streetName + "',POSTCODE='" + postCode + "'WHERE EMAILADDRESS='" + email + "'");
    }
//delete a user from the database   

    public void deleteCustomerInformation(String email) throws SQLException {
        st.executeUpdate("DELETE FROM USERTABLE WHERE EMAILADDRESS ='" + email + "' ");

    }

    public ArrayList<CustomerInformationManagement> fectCustomerInformations() throws SQLException {
        String fetch = "SELECT \n"
                + "CUSTOMERTABLE.CUSTOMERID, \n"
                + "USERTABLE.FIRSTNAME, USERTABLE.LASTNAME,  USERTABLE.EMAILADDRESS, \n"
                + "USERTABLE.PASSWORD, USERTABLE.PHONENUMBER, CUSTOMERTABLE.DOB, CUSTOMERTABLE.STREETNUMBER, CUSTOMERTABLE.STREETNAME, CUSTOMERTABLE.POSTCODE,CUSTOMERTABLE.REGISTERED\n"
                + "FROM USERTABLE\n"
                + "INNER JOIN CUSTOMERTABLE ON USERTABLE.USERID = CUSTOMERTABLE.USERID";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<CustomerInformationManagement> temp = new ArrayList();

        while (rs.next()) {
            Integer customerID = rs.getInt(1);
            String customerFName = rs.getString(2);
            String customerLName = rs.getString(3);
            String customerEmail = rs.getString(4);
            String customerPassword = rs.getString(5);
            String customerPhone = rs.getString(6);
            Date customerDOB = rs.getDate(7);
            Integer customerStreetNumber = rs.getInt(8);
            String customerStreetName = rs.getString(9);
            Integer customerPostcode = rs.getInt(10);
            Boolean customerRegistered = rs.getBoolean(11);

            temp.add(new CustomerInformationManagement(customerID, customerFName, customerLName,
                    customerEmail, customerPassword, customerPhone, customerDOB,
                    customerStreetNumber, customerStreetName, customerPostcode, customerRegistered));
        }
        return temp;
    }

    public boolean checkCustomerInformation(String email) throws SQLException {
       String fetch = "SELECT \n"
                + "CUSTOMERTABLE.CUSTOMERID, \n"
                + "USERTABLE.FIRSTNAME, USERTABLE.LASTNAME,  USERTABLE.EMAILADDRESS, \n"
                + "USERTABLE.PASSWORD, USERTABLE.PHONENUMBER, CUSTOMERTABLE.DOB, CUSTOMERTABLE.STREETNUMBER, CUSTOMERTABLE.STREETNAME, CUSTOMERTABLE.POSTCODE,CUSTOMERTABLE.REGISTERED\n"
                + "FROM USERTABLE\n"
                + "INNER JOIN CUSTOMERTABLE ON USERTABLE.USERID = CUSTOMERTABLE.USERID WHERE EMAILADRESS='"+email+"'";
        
       ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            //String customerFName = rs.getString(3);
            //String customerLName = rs.getString(4);
            //String customerType = rs.getString(2);
            //if(customerFName.equals(fName) && customerLName.equals(lName) && customerType.equals(type)){
            String customerEmail = rs.getString(4);
            if (customerEmail.equals(email)) {
                return true;
            }
        }
        return false;

    }
}
