/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.model.dao;
import iotb.model.OrderLine;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author root
 */
public class OrderLineManager {
    private Statement st;
    
    public OrderLineManager(Connection con) throws SQLException {
        st = con.createStatement();
    }
    
    public OrderLine findOrderLine(int tempOrderLineProductID, int tempProductID) throws SQLException {
         String fetch = "SELECT * FROM IOTBAYADMIN.ORDERLINE where ORDERLINEPRODUCTID = " + tempOrderLineProductID + " and PRODUCTID=" +tempProductID+ "";
         ResultSet rs = st.executeQuery(fetch);
         
         while (rs.next()) {
             int orderLineProductID = rs.getInt(1);
             int productID = rs.getInt(2);
             if (orderLineProductID == tempOrderLineProductID && productID == tempProductID) {
                 int quantity = rs.getInt(3);
                 return new OrderLine(orderLineProductID, productID, quantity);
             }
         }
         return null;
    }
    
    public void addOrderLine(int orderLineProductID, int productID, int quantity) throws SQLException {
        st.executeUpdate("INSERT INTO IOTBAYADMIN.ORDERLINE " + "VALUES (" +orderLineProductID+", " +productID+", "+quantity+")");
    }
    
    public void updateOrderLine(int orderLineProductID, int productID, int quantity) throws SQLException {
         st.executeUpdate("UPDATE IOTBAYADMIN.ORDERLINE SET ORDERLINEPRODUCTID="+orderLineProductID+",PRODUCTID="+productID+",QUANTITY="+quantity+"");
    }
    
    public void deleteOrderLine(int orderLineProductID) throws SQLException {
                st.executeUpdate("DELETE FROM IOTBAYADMIN.ORDERLINE WHERE ORDERLINEPRODUCTID=" +orderLineProductID+"");
    }
    
    public ArrayList<OrderLine> fetchOrderLines(int orderLineProductID) throws SQLException {
        String fetch = "SELECT * FROM IOTBAYADMIN.ORDERLINE WHERE ORDERLINEPRODUCTID="+orderLineProductID+"";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<OrderLine> temp = new ArrayList();
        
        while (rs.next()) {
            int productID = rs.getInt(2);
            int quantity = rs.getInt(3);
            temp.add(new OrderLine(orderLineProductID, productID, quantity));
        }
        return temp;
    }
    
}
