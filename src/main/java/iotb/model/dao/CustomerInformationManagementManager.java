/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.model.dao;

import iotb.model.User;
import iotb.model.Customer;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author timmy
 */
public class CustomerInformationManagementManager {
    private Statement st;
    public CustomerInformationManagementManager(Connection con) throws SQLException {       
    st = con.createStatement();   
}
    
    public User findUser(String fNamae, String lName, String type) throws SQLException {       
   //setup the select sql query string       
   //execute this query using the statement field       
   //add the results to a ResultSet       
   //search the ResultSet for a user using the parameters  
   String fetch = "select * FROM ISDUSER.USERS where EMAIL = '" + email +"'  and PASSWORD='"+ password +"'" ;
   ResultSet rs = st.executeQuery(fetch);
   
   while(rs.next()){
       String userEmail = rs.getString(1);
       String userPass = rs.getString(3);
       if(userEmail.equals(email) && userPass.equals(password)){
           String userName = rs.getString(2);
           String userGender = rs.getString(4);
           String userFavCol = rs.getString(5);
           return new User(userEmail, userName, userPass,userGender, userFavCol);
       }
       
   }
   return null;   
}


}
