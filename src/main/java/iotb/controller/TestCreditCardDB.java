/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.controller;

import iotb.model.dao.CreditCardManager;
import iotb.model.dao.DBConnector;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author 1234
 */
public class TestCreditCardDB {
    
    public static final Scanner in = new Scanner(System.in);
    public static CreditCardManager manager;
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
        DBConnector connector = new DBConnector();
        Connection con = connector.openConnection();
        manager = new CreditCardManager(con);
        
        char c;
        help();
        
        while ((c=readChoice()) != 'x') {
            switch(c) {
                case 'c': addCreditCard(); break;
                case 'r': readCreditCard(); break;
                case 'u': updateCreditCard(); break;
                case 'd': deleteCreditCard(); break;
                default: help(); break;
            }
        }
 
    }
    
    // CREATE
    public static void addCreditCard() throws SQLException, ParseException {
            System.out.println("Card Number: ");
            String cardNumber = in.nextLine();
            System.out.println("Expiry Date: ");
            String expiryDate = in.nextLine();
            System.out.println("Holder Name: ");
            String holderName = in.nextLine();
            System.out.println("CVV: ");
            String cvv = in.nextLine();
            
            manager.addCreditCard(cardNumber, expiryDate, holderName, cvv);
            System.out.println("Credit Card successfully added");
        }
    
    // READ - by card number
    
    public static void readCreditCard() throws SQLException {
        System.out.println("Enter card number: ");
        String cardNumber = in.nextLine();
        manager.readCreditCard(cardNumber);
    }
    
    // UPDATE
    
    public static void updateCreditCard() throws SQLException, ParseException {
        System.out.println("Card Number: ");
        String cardNumber = in.nextLine();
        System.out.println("Expiry Date: ");
        String expiryDate = in.nextLine();
        System.out.println("Holder Name: ");
        String holderName = in.nextLine();
        System.out.println("CVV: ");
        String cvv = in.nextLine();
            
        manager.updateCreditCard(cardNumber, expiryDate, holderName, cvv);
        System.out.println("Credit Card successfully added");
    }
    
    // DELETE - by card number
    
    public static void deleteCreditCard() throws SQLException {
        System.out.println("Card Number: ");
        String cardNumber = in.nextLine();
        manager.deleteCreditCard(cardNumber);
    }
    
    public static void help() {
        System.out.println("User CRUD operations: \n"
                + "C - Create credit card \n"
                + "R - Read credit card \n"
                + "U - Update credit card \n"
                + "D - Delete cred card \n"
                + "X - Exit \n");
    }
    
    public static char readChoice() {
        System.out.println("Choices C/R/U/D/X: ");
        return in.nextLine().charAt(0);
    }
}
