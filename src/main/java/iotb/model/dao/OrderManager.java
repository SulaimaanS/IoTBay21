/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.model.dao;
import iotb.model.Order;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author root
 */
public class OrderManager {
    private Statement st;
    
    public OrderManager(Connection con) throws SQLException {
        st = con.createStatement();
    }
    
    public Order findOrder(int tempOrderID) throws SQLException {
        String fetch = "SELECT * FROM IOTBAYADMIN.ORDERS WHERE ORDERID = " + tempOrderID + ""; // might be wrong due to missing apostrophe
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()) {
            int orderID = rs.getInt(1);
            if (orderID == tempOrderID) {
                int productID = rs.getInt(2);
                int productQuantity = rs.getInt(3);
                String dateOrdered = rs.getString(4);
                int orderTotal = rs.getInt(5);
                int userID = rs.getInt(6);
                return new Order(orderID, productID, productQuantity, dateOrdered, orderTotal, userID);
            }
        }
        return null;
    }
    
    public void addOrder(int orderID, int productID, int productQuantity, String dateOrdered, int orderTotal, int userID) throws SQLException {
                st.executeUpdate("INSERT INTO IOTBAYADMIN.ORDERS " + "VALUES ('" + orderID + "', '" + productID + "', '" + productQuantity + "'. '" + dateOrdered + "'. '" + orderTotal + "', '" + userID + "' )");
                
    }
    
    public void updateOrder(int orderID, int productQuantity, String dateOrdered, int orderTotal)  throws SQLException{
        st.executeUpdate("UPDATE IOTBAYADMIN.ORDERS SET PRODUCTQUANTITY='"+productQuantity+"',DATEORDERED="+dateOrdered+",ORDERTOTAL="+orderTotal+"' WHERE ORDERID="+orderID + "'" );
    }
    
    public void deleteOrder(int orderID) throws SQLException {
        st.executeUpdate("DELETE FROM IOTBAYADMIN.ORDERS WHERE ORDERID=" + orderID + "");
    }
    
    public ArrayList<Order> fetchOrders(int userID) throws SQLException {
        String fetch ="SELECT * FROM ORDERS WHERE USERID = '" + userID + "'";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Order> temp = new ArrayList();
        
        while (rs.next()) {
            int orderID = rs.getInt(1);
            int productID = rs.getInt(2);
            int productQuantity = rs.getInt(3);
            String dateOrdered = rs.getString(4);
            int orderTotal = rs.getInt(5);
            temp.add(new Order(orderID, productID, productQuantity, dateOrdered, orderTotal, userID));
        }
        return temp;
    }
    
    public boolean checkOrderID(int orderID) throws SQLException {
        String fetch = "SELECT * FROM IOTBAYADMIN.ORDERS WHERE ORDERID = '" + orderID + "'";
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()) {
            String tempOrderID = rs.getString(1);
            if (tempOrderID.equals(orderID)) {
                return true;
            }            
        }
        return false;
    }
}
