package iotb.model.dao;

import iotb.model.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserManager {
    private Statement statement;
    
    public UserManager(Connection connection) throws SQLException{
        statement = connection.createStatement();
    }
    
    //Create Operation
    public void addUser(String firstName, String lastName, String email, String password, String dob, String gender, String phonenum, int streetnum , String streetname, int postcode) throws SQLException, ParseException{
        String columns = "INSERT INTO IOTBAYADMIN.USERTABLE(FIRSTNAME, LASTNAME, EMAILADDRESS, PASSWORD, DOB, GENDER, PHONENUMBER, STREETNUMBER, STREETNAME,POSTCODE)";
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dob);
        String values = "VALUES('"+firstName+"','"+lastName+"','"+email+"','"+password+"','"+date+"','"+gender+"','"+phonenum+"','"+streetnum+"','"+streetname+"','"+postcode+"')"; 
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
