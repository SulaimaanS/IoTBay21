/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.model.dao;

import iotb.model.User;
import iotb.model.Customer;
import iotb.model.CustomerInformationManagement;
import java.sql.*;
import java.util.ArrayList;
//import java.util.Date;
import java.sql.Date;

/**
 *
 * @author timmy
 */
public class CustomerInformationManagementManager {
    private Statement st;
    public CustomerInformationManagementManager(Connection con) throws SQLException {       
    st = con.createStatement();   
}
    
    public CustomerInformationManagement findCustomer(String fName, String lName, String type) 
    throws SQLException {       
   
    String fetch = "SELECT * FROM IOTBAYADMIN.CUSTOMERINFORMATIONMANAGEMENT where FIRSTNAME = '" +fName+"' AND LASTNAME = '"+lName+"' AND CUSTOMERTYPE = '"+type+"'  ";
           
    ResultSet rs = st.executeQuery(fetch);
   
   while(rs.next()){
       String customerFName = rs.getString(3); 
       String customerLName = rs.getString(4);
       String customerType = rs.getString(2);
           if(customerFName.equals(fName)&& customerLName.equals(lName) && customerType.equals(type)){
           String customerID = rs.getString(1);
           String customerDOB = rs.getString(5);
           String customerGender = rs.getString(6);
           String customerEmail = rs.getString(7);
           String customerPassword = rs.getString(8);
           String customerPhone = rs.getString(9);
           String customerStreetNumber = rs.getString(10);
           String customerStreetName = rs.getString(11);
           String customerPostcode = rs.getString(12);
           String customerOrderID = rs.getString(13);
           String customerRegistered = rs.getString(14);
           
           return new CustomerInformationManagement(customerID, customerType, customerFName, customerLName,
           customerDOB, customerGender, customerEmail, customerPassword, customerPhone, 
           customerStreetNumber, customerStreetName, customerPostcode, customerOrderID, customerRegistered);
       }
       
   }
   return null;   
}
    
    //Add a user-data into the database   
public void addCustomer(int customerID, String type, String fName, String lName, Date dob, String gender, String email, String password, String phone, int streetNumber, String streetName, int postCode, int orderID, boolean registered) throws SQLException {                   //code for add-operation       
  /*st.executeUpdate("INSERT INTO IOTBAYADMIN.USERTABLE " + "VALES ('"+ fName +"', "
  + " '"+ lName + "', '"+ dob+ "', '"+gender+"' '" + email +"' '"+ password +"'"
  + " '"+phone+"' '"+ streetNumber+"' '" + streetName+"' '"+ postCode +"')");   
 st.executeUpdate("INSERT INTO IOTBAYADMIN.CUSTOMERTABLE " + "VALES ('"+ userID +"', '"+ type +"', "
  + "'"+ fName +"', " + " '"+ lName + "', '"+ dob+ "', '"+gender+"' '" + email +"' '"+ password +"'"
  + " '"+phone+"' '"+ streetNumber+"' '" + streetName+"' '"+ postCode +"' '"+ orderID+"' '"+ registered+"')"); 
*/
 st.executeUpdate("INSERT INTO CUSTOMERINFORMATIONMANAGEMENT" +
"(CUSTOMERID, CUSTOMERTYPE, FIRSTNAME, LASTNAME, DOB, GENDER, EMAILADDRESS, PASSWORD, PHONENUMBER," +
"STREETNUMBER, STREETNAME, POSTCODE, ORDERID, REGISTERED))" + "VALUES ('" +customerID+"', '" +type+ "', '"+ fName+"', '"+lName+"', '"+ dob +"', '" + gender+"', '" +email +"', '" +password +"', '" + phone +"', '" +streetNumber +"', '" + streetName +"', '" + postCode +"', '" + orderID+"', '" + registered + "' )" );

}




//update a user details in the database   
public void updateCustomer(String fName, String lName, String dob, 
String gender, String email, String password, String phone, String streetNumber, String streetName, 
String postCode) throws SQLException {       
   st.execute("UPDATE IOTBAYADMIN.USERTABLE SET EMAIL='"+ fName + "',LASTNAME='" + lName + "',DOB= '" + dob + "',GENDER='" +gender+ "'WHERE PASSWORD='" +password+ "'PHONENUMBER='" +phone+ "'STREETNUMBER='" +streetNumber+ "'WHERE STREETNAME='" +streetName+ "'POSTCODE='" +postCode+ "'WHERE EMAIL'" +email+ "'");  
   //st.execute("UPDATE IOTBAYADMIN.CUSTOMERTABLE SET USERID= '"+ userID + "',CUSTOMERTYPE='" + type + "',ORDERID= '" + orderID + "',REGISTERED='" + registered+"'");  
}       

//delete a user from the database   
public void deleteCustomer(String email) throws SQLException{       
   st.executeUpdate("DELETE FROM IOTBAYADMIN.CUSTOMERINFORMATIONMANAGEMENT WHERE EMAIL ='" + email +"' ");  

}

public ArrayList<CustomerInformationManagement> fectCustomers() throws SQLException{
    String fetch = "select * from IOTBAYADMIN.CUSTOMERINFORMATIONMANAGEMENT";
    ResultSet rs = st.executeQuery(fetch);
    ArrayList<CustomerInformationManagement> temp = new ArrayList();
    
    while(rs.next()){
        String customerID = rs.getString(1);
        String customerType = rs.getString(2);
        String customerFName = rs.getString(3);
        String customerLName = rs.getString(4);
        String customerDOB = rs.getString(5);
        String customerGender = rs.getString(6);
        String customerEmail = rs.getString(7);
        String customerPassword = rs.getString(8);
        String customerPhone = rs.getString(9);
        String customerStreetNumber = rs.getString(10);
        String customerStreetName = rs.getString(11);
        String customerPostcode = rs.getString(12);
        String customerOrderID = rs.getString(13);
        String customerRegistered = rs.getString(14);
        temp.add(new CustomerInformationManagement(customerID, customerType, customerFName, customerLName,
        customerDOB, customerGender, customerEmail, customerPassword, customerPhone, customerStreetNumber,
        customerStreetName,customerPostcode,customerOrderID, customerRegistered));
     }
    return temp;
}

public boolean checkCustomer(String fName, String lName, String type) throws SQLException{
    String fetch = "SELECT " +
"CUSTOMERTABLE.CUSTOMERID, CUSTOMERTABLE.CUSTOMERTYPE," +
"USERTABLE.FIRSTNAME, USERTABLE.LASTNAME, USERTABLE.DOB, USERTABLE.GENDER, USERTABLE.EMAILADDRESS,"
           + "USERTABLE.PASSWORD" +
"USERTABLE.PASSWORD, USERTABLE.PHONENUMBER, USERTABLE.STREETNUMBER, USERTABLE.STREETNAME, USERTABLE.POSTCODE,\n" +
"CUSTOMERTABLE.ORDERID, CUSTOMERTABLE.REGISTERED" +
"FROM USERTABLE" +
"INNER JOIN CUSTOMERTABLE ON USERTABLE.USERID = CUSTOMERTABLE.USERID" +
"WHERE USERTABLE.FIRSTNAME = '" + fName + "' AND  USERTABLE.FIRSTNAME = '" + lName + "' "
 + "AND CUSTOMERTABLE.CUSTOMERTYPE = '"+ type +"';  ";  
    ResultSet rs = st.executeQuery(fetch);
    
    while(rs.next()){
        String customerFName = rs.getString(3);
        String customerLName = rs.getString(4);
        String customerType = rs.getString(2);
        if(customerFName.equals(fName) && customerLName.equals(lName) && customerType.equals(type)){
            return true;
        }
    }
    return false;
    
}


}
