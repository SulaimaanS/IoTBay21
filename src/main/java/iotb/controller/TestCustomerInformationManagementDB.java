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
import iotb.model.CustomerInformationManagement;
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

/*
public static void main(String[] args) throws SQLException {
    
    try {

        DatabaseConnector connector = new DatabaseConnector();
        Connection con = connector.connection();

        CustomerInformationManagementManager db = new CustomerInformationManagementManager(con);

        //System.out.print("Customer id: ");
        //String customerID = in.nextLine();

        System.out.print("Customer type: ");
        String type = in.nextLine();

        System.out.print("Customer first name: ");
        String fName = in.nextLine();

        System.out.print("Customer last name: ");
        String lName = in.nextLine();

        System.out.print("Customer date of birth: ");
        String dob = in.nextLine();
        
        System.out.print("Customer gender: ");
        String gender = in.nextLine();
        
        System.out.print("Customer email: ");
        String email = in.nextLine();
        
        System.out.print("Customer password: ");
        String password = in.nextLine();
        
        System.out.print("Customer phone: ");
        String phone = in.nextLine();
        
        System.out.print("Customer street number: ");
        String streetNumber = in.nextLine();
        
        System.out.print("Customer street name: ");
        String streetName = in.nextLine();
        
        System.out.print("Customer post code: ");
        String postCode = in.nextLine();
        
        System.out.print("Customer orderID: ");
        String orderID = in.nextLine();
        
        System.out.print("Customer registration: ");
        String registered = in.nextLine();
        
        System.out.print("User id: ");
        String userID = in.nextLine();

        db.addCustomer(type, fName, lName, dob, gender, email, password, phone, streetNumber, 
        streetName, postCode, orderID, userID, registered);

        System.out.println("Customer is added to the database.");
        connector.closeConnection();
        } 
    
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TestCustomerInformationManagementDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
}*/

public static void main(String[] args) throws SQLException{
    (new TestCustomerInformationManagementDB()).runQueries();
}

private char readChoice(){
    System.out.print("Operations CRUDS or * to exit:");
    return in.nextLine().charAt(0);
}

private void runQueries() throws SQLException{
    char c;
    
    while((c = readChoice()) != '*'){
        switch(c){
            case 'C': ;
                testAdd();
                break;
            case 'R': ;
                testRead();
                break;
            case 'D': ;
                testDelete();
                break;
            case 'S': ;
                showAll();
                break;
            default:
                System.out.println("Unknown Command");
        }
    }
}

private void testAdd(){
        System.out.print("Customer id: ");
        String id = in.nextLine();
        
        System.out.print("Customer type: ");
        String type = in.nextLine();

        System.out.print("Customer first name: ");
        String fName = in.nextLine();

        System.out.print("Customer last name: ");
        String lName = in.nextLine();

        System.out.print("Customer date of birth: ");
        String dob = in.nextLine();
        
        System.out.print("Customer gender: ");
        String gender = in.nextLine();
        
        System.out.print("Customer email: ");
        String email = in.nextLine();
        
        System.out.print("Customer password: ");
        String password = in.nextLine();
        
        System.out.print("Customer phone: ");
        String phone = in.nextLine();
        
        System.out.print("Customer street number: ");
        String streetNumber = in.nextLine();
        
        System.out.print("Customer street name: ");
        String streetName = in.nextLine();
        
        System.out.print("Customer post code: ");
        String postCode = in.nextLine();
        
        System.out.print("Customer orderID: ");
        String orderID = in.nextLine();
        
        System.out.print("Customer registration: ");
        String registered = in.nextLine();
        
        System.out.print("User id: ");
        String userID = in.nextLine();
    
    try{
        db.addCustomer(type, fName, lName, dob, gender, email, password, phone, streetNumber, 
        streetName, postCode, orderID, userID, registered);
    }
    catch(SQLException ex){
       Logger.getLogger(TestCustomerInformationManagementDB.class.getName()).log(Level.SEVERE, null, ex); 
    }
    System.out.println("Customer is added to the database.");
}

private void testRead() throws SQLException{
    System.out.print("Customer first name: ");
    String fName = in.nextLine();
    System.out.print("Customer last name");
    String lName = in.nextLine();
    System.out.print("Customer type:");
    String type = in.nextLine();
    CustomerInformationManagement customer = db.findCustomer(fName, lName, type);
    if(customer != null){
        System.out.println("Customer " + customer.getfName() +" exists in the database.");
    }
    else{
        System.out.println("Customer does not exist.");
    }
}

private void testUpdate(){
    System.out.print("Customer first name: ");
    String fName = in.nextLine();
    System.out.print("Customer last name");
    String lName = in.nextLine();
    System.out.print("Customer type:");
    String type = in.nextLine();
    
    try{
        if(db.checkCustomer(fName, lName, type)){
        
        System.out.print("Customer date of birth: ");
        String dob = in.nextLine();
            
        System.out.print("Customer gender: ");
        String gender = in.nextLine();
        
        System.out.print("Customer email: ");
        String email = in.nextLine();
        
        System.out.print("Customer password: ");
        String password = in.nextLine();
        
        System.out.print("Customer phone: ");
        String phone = in.nextLine();
        
        System.out.print("Customer street number: ");
        String streetNumber = in.nextLine();
        
        System.out.print("Customer street name: ");
        String streetName = in.nextLine();
        
        System.out.print("Customer post code: ");
        String postCode = in.nextLine();
        
        System.out.print("Customer orderID: ");
        String orderID = in.nextLine();
        
        System.out.print("User id: ");
        String userID = in.nextLine();
        
            db.updateCustomer(fName, lName, dob, gender, email, password, phone, streetNumber,
            streetName, postCode);
        }
        else{
            System.out.println("Customer does not exist");
        }
    }
    catch(SQLException ex){
        Logger.getLogger(TestCustomerInformationManagementDB.class.getName()).log(Level.SEVERE, null, ex);
    }
}

private void testDelete(){
    System.out.print("Customer first name: ");
    String fName = in.nextLine();
    System.out.print("Customer last name");
    String lName = in.nextLine();
    System.out.print("Customer type:");
    String type = in.nextLine();
    System.out.print("Customer email:");
    String email = in.nextLine();
    
    try{
        if(db.checkCustomer(fName, lName, type)){
            db.deleteCustomer(email);
        }
        else{
            System.out.println("Customer does not exist");
        }
    }
    
    catch (SQLException ex){
        Logger.getLogger(TestCustomerInformationManagementDB.class.getName()).log(Level.SEVERE, null, ex);
    }
}

private void showAll(){
    try{
        ArrayList<CustomerInformationManagement> customers = db.fectCustomers();
        System.out.println("CUSTOMER INFORMATION TABLE: ");
        customers.stream().forEach((customer) -> {
            System.out.printf("%-20s %-30s %-20s %-10 \n", customer.getCustomerID(), customer.getType(),
                    customer.getfName(), customer.getlName(), customer.getDob(), customer.getGender(),
                    customer.getEmail(), customer.getPassword(), customer.getPhone(), 
                    customer.getStreetNumber(), customer.getStreetName(), customer.getPostCode(), 
                    customer.getOrderID(), customer.getRegistered());
        });
        System.out.println();
    }
    catch(SQLException ex){
        Logger.getLogger(TestCustomerInformationManagementDB.class.getName()).log(Level.SEVERE, null, ex);

    }
}


}
