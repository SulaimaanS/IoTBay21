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
    
    //Read Operation - Read user by id
    public User readUser(int userID) throws SQLException{
        String query = "SELECT * FROM USERTABLE WHERE USERID = "+userID+""; 
        ResultSet rs = statement.executeQuery(query);
        
        while(rs.next()){
            String id = rs.getString(1);
            String firstname = rs.getString(2);
            String lastname = rs.getString(3);
            String email = rs.getString(4);
            String password = rs.getString(5);
            String dob = rs.getString(6);
            String gender = rs.getString(7);
            String phonenum = rs.getString(8);
            String streetnum = rs.getString(9);
            String streetname = rs.getString(10);
            String postcode = rs.getString(11);
            
            return new User(id,firstname, lastname, email, password, dob, gender, phonenum, streetnum, streetname, postcode);
        }
        return null;
    }
    
    //Update Operation - Update user by id
    public void updateUser(int userID, String firstName, String lastName, String email,String dob, String password,String gender, String phonenum, int streetnum , String streetname, int postcode) throws SQLException, ParseException{
        Date d = DateFormat.getDateInstance().parse(dob);
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        String strDate = formatter.format(d);
        String update = "UPDATE USERTABLE SET FIRSTNAME='"+firstName+"',LASTNAME='"+lastName+"',EMAILADDRESS='"+email+"',DOB='"+strDate+"',PASSWORD='"+password+"',GENDER='"+gender+"',PHONENUMBER='"+phonenum+"',STREETNUMBER="+streetnum+",STREETNAME='"+streetname+"',POSTCODE="+postcode+" WHERE USERID="+userID+"";
        statement.executeUpdate(update);
    }
    
    //Delete Operation - Delete user by id
    public void deleteUser(int userID) throws SQLException{
        String delete = "DELETE FROM USERTABLE WHERE USERID="+userID+"";
        statement.executeUpdate(delete);
    }
}

