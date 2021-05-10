/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.model.dao;

import iotb.model.Staff;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author alaw8
 */
public class StaffManager {
    
    private Statement statement;

    public StaffManager(Connection connection) throws SQLException {
        statement = connection.createStatement();
    }
    
    //Create Operation
    public void addStaff(int userID) throws SQLException{
        String columns = "INSERT INTO STAFFTABLE(USERID)";
        String values = "VALUES ('"+userID+"')";
        statement.executeUpdate(columns + values);
    }

    //Read Operation - Read user by id
    public Staff readStaff(int staffID) throws SQLException{
        String query = "SELECT * FROM STAFFTABLE WHERE USERID = " + staffID + "";
        ResultSet rs = statement.executeQuery(query);

        while (rs.next()) {
            Integer userID = rs.getInt(2);

            return new Staff(userID,staffID);
        }
        return null;
    }

    //Update Operation - Update user by id
    public void updateStaff(int staffID, int userID) throws SQLException{
        String update = "UPDATE STAFFTABLE SET USERID='" + userID + "' WHERE STAFFID=" + staffID + "";
        statement.executeUpdate(update);
    }

    //Delete Operation - Delete user by id
    public void deleteStaff(int staffID) throws SQLException{
        String delete = "DELETE FROM CUSTOMERTABLE WHERE USERID=" + staffID + "";
        statement.executeUpdate(delete);
    }
}
