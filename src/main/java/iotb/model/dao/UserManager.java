package iotb.model.dao;

import iotb.model.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

public class UserManager {

    private Statement statement;

    public UserManager(Connection connection) throws SQLException {
        statement = connection.createStatement();
    }

    //Create Operation
    public void addUser(String firstName, String lastName, String email, String password, String phonenum) throws SQLException, ParseException {
        String columns = "INSERT INTO USERTABLE(FIRSTNAME, LASTNAME, PASSWORD, PHONENUMBER, EMAILADDRESS)";
        String values = "VALUES ('" + firstName + "','" + lastName + "','" + password + "','" + phonenum + "','" + email + "')";
        statement.executeUpdate(columns + values);
    }

    //Read Operation - Read user by id
    public User readUser(String email, String password) throws SQLException {
        String query = "SELECT * FROM USERTABLE WHERE EMAILADDRESS = '" + email + "' AND PASSWORD = '"+password+"'";
        ResultSet rs = statement.executeQuery(query);

        while (rs.next()) {

            Integer id = rs.getInt(1);
            String firstname = rs.getString(2);
            String lastname = rs.getString(3);
            String emailaddress = rs.getString(4);
            String pass = rs.getString(5);
            String phonenum = rs.getString(6);
            
            return new User(id, firstname, lastname, emailaddress, pass, phonenum);
        }
        return null;
    }

    //Update Operation - Update user by id
    public void updateUser(int userID, String firstName, String lastName, String email, String password, String phonenum) throws SQLException, ParseException {
        String update = "UPDATE USERTABLE SET FIRSTNAME='" + firstName + "',LASTNAME='" + lastName + "',EMAILADDRESS='" + email + "',PASSWORD='" + password + "',PHONENUMBER='" + phonenum + "' WHERE USERID=" + userID + "";
        statement.executeUpdate(update);
    }

    //Delete Operation - Delete user by id
    public void deleteUser(int userID) throws SQLException {
        String delete = "DELETE FROM USERTABLE WHERE USERID=" + userID + "";
        statement.executeUpdate(delete);
    }
}
