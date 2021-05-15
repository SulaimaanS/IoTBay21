/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.controller;

import java.sql.*;

import java.util.*;

import java.util.logging.*;
import iotb.model.Customer;
import iotb.model.User;
import iotb.model.dao.DatabaseConnector;
import iotb.model.dao.CustomerInformationManagementManager;

/**
 *
 * @author timmy
 */
public class TestCustomerInformationManagementDB {
    private static Scanner in = new Scanner(System.in);
    private DatabaseConnector connector;
    private Connection con;
    private CustomerInformationManagementManager db;


public static void main(String[] args) throws SQLException {

    try {

        DatabaseConnector connector = new DatabaseConnector();
        Connection con = connector.connection();

        CustomerInformationManagementManager db = new CustomerInformationManagementManager(con);

        System.out.print("User email: ");
        String email = in.nextLine();

        System.out.print("User name: ");
        String name = in.nextLine();

        System.out.print("User password: ");
        String password = in.nextLine();

        System.out.print("User gender: ");
        String gender = in.nextLine();

        System.out.print("User favorite color: ");
        String favcol = in.nextLine();

        db.addUser(email, name, password, gender, favcol);

        System.out.println("User is added to the database.");
        connector.closeConnection();
        } 
    
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TestCustomerInformationManagementDB.class.getName()).log(Level.SEVERE, null, ex);
        }

}

}
