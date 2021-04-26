package iotb.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UserManager {
    private Statement statement;
    
    public UserManager(Connection connection) throws SQLException{
        statement = connection.createStatement();
    }
    
    public void addUser(String firstName, String lastName, String password, String dob, String phoneNumber, String emailAddress, String streetNumber, String streetName, String postCode) throws SQLException{
        String columns = "";
        String values = "";
        statement.executeUpdate(columns + values);
    }
}
