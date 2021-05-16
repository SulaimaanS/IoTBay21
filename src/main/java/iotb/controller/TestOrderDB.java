/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.controller;
import java.util.*;
import java.sql.*;
import java.util.logging.*;
import iotb.model.Order;
import iotb.model.dao.DatabaseConnector;
import iotb.model.dao.OrderManager;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author root
 */
public class TestOrderDB {
    private static Scanner in = new Scanner(System.in);
    private DatabaseConnector connector;
    private Connection con;
    private OrderManager db;
    
    public static void main(String[] args) throws SQLException {
        (new TestOrderDB()).runQueries();
    }
    
    public TestOrderDB() {
        try {
            connector = new DatabaseConnector();
            con = connector.connection();
            db = new OrderManager(con);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TestOrderDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private char readChoice() {
        System.out.println("Operation CRUDS or * to exit: ");
        return in.nextLine().charAt(0);
    }
    
    private void runQueries() throws SQLException {
        char c;
        
        while ((c = readChoice()) != '*') {
            switch (c) {
                case 'C': testAdd(); break;
                case 'R': testRead(); break;
                case 'U': testUpdate(); break;
                case 'D': testDelete(); break;
                default: System.out.println("Unknown Command. (C/R/U/D/S/*) "); break;
            }
        }
    }
    
    
    
    private void testAdd() {
        System.out.print("Order ID: ");
        int orderID = in.nextInt();
        System.out.print("Product ID: ");
        int productID = in.nextInt();
        System.out.print("Product Quantity: ");
        int productQuantity = in.nextInt();
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.print("Order Total: ");
        int orderTotal = in.nextInt();
        System.out.print("User ID: ");
        int userID = in.nextInt();
        
        try {
            db.addOrder(orderID, productID, productQuantity, date, orderTotal, userID);
        } catch (SQLException ex) {
            Logger.getLogger(TestOrderDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Order is added to the database."); 
    }
    
    private void testRead() throws SQLException {
        System.out.print("Order ID: ");
        int orderID = in.nextInt();
        Order order = db.findOrder(orderID);
        if (order != null) {
            System.out.println("Order found");
        }
        else {
            System.out.println("Order was not found");
        }
    }
    
    private void testUpdate() throws SQLException {
        System.out.println("Order ID: ");
        int orderID = in.nextInt();
        
        try {
            if (db.checkOrderID(orderID)) {
                System.out.print("Product ID: ");
                int productID = in.nextInt();
                System.out.print("Product Quantity: ");
                int productQuantity = in.nextInt();
                String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                System.out.println("Order Total: ");
                int orderTotal = in.nextInt();
                System.out.println("User ID: ");
                int userID = in.nextInt();
                db.updateOrder(orderID, productQuantity, date, orderTotal);
            }
            else {
                System.out.println("Order was not found.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestOrderDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void testDelete()  {
        System.out.println("Order ID: ");
        int orderID = in.nextInt();
        
        try {
            if (db.checkOrderID(orderID)) {
                db.deleteOrder(orderID);
            }
            else {
                System.out.println("Order was not found.");
            }
        } catch (SQLException ex) {
             Logger.getLogger(TestOrderDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
