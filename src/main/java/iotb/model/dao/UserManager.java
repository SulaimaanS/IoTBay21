package iotb.model.dao;

import iotb.model.User;
import java.sql.Connection;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class UserManager {
    private Statement statement;
    
    public UserManager(Connection connection) throws SQLException{
        statement = connection.createStatement();
    }
    
    //Create Operation
    public void addUser(String firstName, String lastName, String email,String dob, String password,String gender, String phonenum, int streetnum , String streetname, int postcode) throws SQLException, ParseException{
        String columns = "INSERT INTO USERTABLE(FIRSTNAME, LASTNAME, PASSWORD, DOB,GENDER, PHONENUMBER, EMAILADDRESS, STREETNUMBER, STREETNAME, POSTCODE)";
        Date d = DateFormat.getDateInstance().parse(dob);
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        String strDate = formatter.format(d);
        //String values = "VALUES ('John', 'Seed', 'password', '02/02/2020','Male', '123123123', 'somethin@email.com', 23 , 'phlips street', 1233 )";
        String values = "VALUES ('"+firstName+"','"+lastName+"','"+password+"','"+strDate+"','"+gender+"','"+phonenum+"','"+email+"',"+streetnum+",'"+streetname+"',"+postcode+")";
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
