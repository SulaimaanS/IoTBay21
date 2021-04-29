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
        String values = "VALUES ('"+firstName+"','"+lastName+"','"+password+"','"+strDate+"','"+gender+"','"+phonenum+"','"+email+"',"+streetnum+",'"+streetname+"',"+postcode+")";
        statement.executeUpdate(columns+values);
    }
    
    //Read Operation - Read user by email and password
    public User readUser(int customerID) throws SQLException{
        String query = "SELECT * FROM CUSTOMERTABLE WHERE CUSTOMERID = '"+customerID+"'"; 
        ResultSet rs = statement.executeQuery(query);
        
        while(rs.next()){
            int userID = Integer.parseInt(rs.getString(1));
            //fetch the ID and password from the row in the result set
            //compare the ID and the password to the input one
            //feth the rest of the data once found
            //create a User object and return it
        }
        
        return null;
    }
    
    public User readUser(int ID, String password) throws SQLException{
        String fetch ="SELECT * FROM ISDUSER.\"USER\" WHERE ID="+ID+" AND PASSWORD='"+password+"'";//read from where ID = and password = 
        
        ResultSet rs = st.executeQuery(fetch);
        
        while(rs.next()){
            int userID = Integer.parseInt(rs.getString(1));
            String userPass = rs.getString(4);
            
            if(userID == ID && userPass.equals(password)){
                 String name = rs.getString(2);
                 String email = rs.getString(3);
                 String phone = rs.getString(5);
                 String gender = rs.getString(6);
                 String dob = rs.getString(7);
                 
                 return new User(ID,name,email,password,phone,gender,dob);
            }
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
