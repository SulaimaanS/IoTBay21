/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.controller;

import iotb.model.Payment;
import iotb.model.dao.DBConnector;
import iotb.model.dao.PaymentManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author 1234
 */
public class TestPaymentDB {
    
    public static final Scanner in = new Scanner(System.in);
    public static PaymentManager manager;
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
        DBConnector connector = new DBConnector();
        Connection con = connector.openConnection();
        manager = new PaymentManager(con);
        
        char c;
        help();
        
        while ((c=readChoice()) != 'x') {
            switch(c) {
                case 'c': addPayment(); break;
                case 'r': readPayment(); break;
                case 'u': updatePayment(); break;
                case 'd': deletePayment(); break;
                default: help(); break;
            }
        }
 
    }
    
    // CREATE - requires an existing orderID
    
    public static void addPayment() throws SQLException, ParseException {
            System.out.println("OrderID: ");
            String orderID = in.nextLine();    
            System.out.println("Payment Type (1 or 2): ");
            String paymentType = in.nextLine();    
            
            
            manager.addPayment(Integer.parseInt(orderID), Integer.parseInt(paymentType)); //Note: convert orderID and paymentType to int
            System.out.println("Payment successfully added");
        }
    
    // READ - by paymentID - checks whether payment is existing
    
    public static void readPayment() throws SQLException {
        System.out.println("Enter PaymentID: ");
        String paymentID = in.nextLine();
        Payment payment = manager.readPayment(Integer.parseInt(paymentID));
        String exists = (payment != null) ? "Payment exists in the database" : "Payment does not exist";
        System.out.println(exists);
    }
    
    // UPDATE - by paymentID
    
    public static void updatePayment() throws SQLException, ParseException {
        System.out.println("Payment to be updated by PaymentID: ");
        String paymentID = in.nextLine();
        System.out.println("OrderID: ");
        String orderID = in.nextLine();
        System.out.println("Payment Type (1 or 2): ");
        String paymentType = in.nextLine();
            
        manager.updateCreditCard(Integer.parseInt(paymentID), Integer.parseInt(orderID), Integer.parseInt(paymentType));
        System.out.println("Credit Card successfully updated");
    }
    
    // DELETE - by paymentID
    
    public static void deletePayment() throws SQLException {
        System.out.println("Enter PaymentID: ");
        String paymentID = in.nextLine();
        manager.deletePayment(Integer.parseInt(paymentID));
        System.out.println("Payment successfully deleted");
    }
    
    public static void help() {
        System.out.println("User CRUD operations: \n"
                + "C - Create payment \n"
                + "R - Read payment \n"
                + "U - Update payment \n"
                + "D - Delete payment \n"
                + "X - Exit \n");
    }
    
    public static char readChoice() {
        System.out.println("Choices C/R/U/D/X: ");
        return in.nextLine().charAt(0);
    }
}
