package iotb.model.dao;

import iotb.model.AccessLog;
import iotb.model.Customer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author alaw8
 */
public class LogManager {

    private Statement statement;

    public LogManager(Connection connection) throws SQLException {
        statement = connection.createStatement();
    }

    public void addCustomerLog(int userID, Date date) throws ParseException, SQLException {
        String columns = "INSERT INTO APPLICATIONLOGTABLE(USERID,ACCESSED)";
        System.out.println(date);
        String values = "VALUES (" + userID + ",'"+date +"')";
        statement.executeUpdate(columns + values);
    }
    
    public void addStaffLog(int staffID, Date date) throws ParseException, SQLException {
        String columns = "INSERT INTO APPLICATIONLOGTABLE(STAFFID, ACCESSED)";
        String values = "VALUES (" + staffID + ",'" + date + "')";
        statement.executeUpdate(columns + values);
    }

    public AccessLog readCustomerLog(int userID) throws SQLException {
        String query = "SELECT * FROM APPLICATIONLOGTABLE WHERE USERID = "+userID+"";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Integer logid = rs.getInt(1);
            Integer userid = rs.getInt(2);
            Date accessdate = rs.getDate(4);
            return new AccessLog(logid,userid,null,accessdate);
        }
        return null;
    }
    
    public AccessLog readStaffLog(int staffID) throws SQLException {
        String query = "SELECT * FROM APPLICATIONLOGTABLE WHERE USERID = "+staffID+"";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Integer logid = rs.getInt(1);
            Integer staffid = rs.getInt(3);
            Date accessdate = rs.getDate(4);
            return new AccessLog(logid,null,staffid,accessdate);
        }
        return null;
    }

    public void deleteLog(int ID) throws SQLException {
        String delete = "DELETE FROM APPLICATIONLOGTABLE WHERE USERID="+ID+" OR STAFFID="+ID+"";
        statement.executeUpdate(delete);
    }
    
    public int getLogID(int ID) throws SQLException{
        String query = "SELECT * FROM CUSTOMERTABLE WHERE USERID="+ID+" OR STAFFID="+ID+"";
        ResultSet rs = statement.executeQuery(query);

        while (rs.next()) {
            Integer id = rs.getInt(1);  
            return id;
        }
        return 0;
    }
}
