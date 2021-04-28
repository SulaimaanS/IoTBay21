package iotb.model.dao;

import iotb.model.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserManager {
    private Statement statement;
    
    public UserManager(Connection connection) throws SQLException{
        statement = connection.createStatement();
    }
    
    //Create Operation
    public void addUser(String firstName, String lastName, String email, String password, String dob, String gender, String phonenum, String streetnum , String streetname, String postcode) throws SQLException{
        String columns = "INSERT INTO IOTBAYADMIN.USERTABLE(FIRSTNAME, LASTNAME, EMAILADDRESS, PASSWORD, DOB, GENDER, PHONENUMBER, STREETNUMBER, STREETNAME,POSTCODE)";
        String values = "VALUES('"+firstName+"','"+lastName+"','"+email+"','"+password+"','"+dob+"','"+gender+"','"+phonenum+"','"+streetnum+"','"+streetname+"','"+postcode+"')"; 
        statement.executeUpdate(columns+values);
    }
    
    //Read Operation - Read user by email and password
    public User readUser(String email, String pass) throws SQLException{
        String query = "SELECT * FROM \"USERS\" WHERE EMAIL = '"+email+"' AND PASSWORD = '"+pass+"'"; 
        ResultSet rs = statement.executeQuery(query);
        
        while(rs.next()){
            //fetch the ID and password from the row in the result set
            //compare the ID and the password to the input one
            //feth the rest of the data once found
            //create a User object and return it
        }
        
        return null;
    }
    
    //Update Operation - Update user by email
    public void updateUser(String email){
        
    }
    
    //Delete Operation - Delete user by email
    public void deleteUser(String email){
    
    }
}
