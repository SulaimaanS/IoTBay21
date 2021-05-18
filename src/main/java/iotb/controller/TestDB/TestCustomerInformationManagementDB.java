/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.controller.TestDB;

import iotb.model.CustomerInformationManagement;
import iotb.model.dao.CustomerInformationManagementManager;
import iotb.model.dao.DatabaseConnector;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author timmy
 */
public class TestCustomerInformationManagementDB {
    private static Scanner in = new Scanner(System.in);
    private DatabaseConnector connector;
    private Connection con;
    private CustomerInformationManagementManager db;

    public static void main(String[] args) throws SQLException, ParseException{
        (new TestCustomerInformationManagementDB()).runQueries();
    }

    public TestCustomerInformationManagementDB() {
        try {
            connector = new DatabaseConnector();
            con = connector.connection();
            db = new CustomerInformationManagementManager(con);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TestCustomerInformationManagementDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private char readChoice() {
        System.out.print("Operations CRUDS or * to exit: ");
        return in.nextLine().charAt(0);
    }

    private void runQueries() throws SQLException, ParseException{
        char c;

        while ((c = readChoice()) != '*') {
            switch (c) {
                case 'C': ;
                    testAdd();
                    break;
                case 'R': ;
                    testRead();
                    break;
                case 'U': ;
                    testUpdate();
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

    private void testAdd() throws SQLException, ParseException {
        //System.out.print("Customer id: ");
        //String customerID = in.nextLine();
        //int id = Integer.parseInt(customerID);
        //System.out.println("");

        //System.out.print("Customer type: ");
        //String type = in.nextLine();

        System.out.print("Customer first name: ");
        String fName = in.nextLine();

        System.out.print("Customer last name: ");
        String lName = in.nextLine();
        
        System.out.print("Customer email: ");
        String email = in.nextLine();
        
        System.out.print("Customer password: ");
        String password = in.nextLine();

        System.out.print("Customer phone: ");
        String phone = in.nextLine();


        System.out.print("Customer date of birth: ");
        String date = in.nextLine();
        //Date dob=(Date) new SimpleDateFormat("dd-MM-yyyy").parse(date); 
        //Date dob = Date.valueOf(date);

        //System.out.print("Customer gender: ");
        //String gender = in.nextLine();

        System.out.print("Customer street number: ");
        String streetNumber = in.nextLine();
        //int streetNum = Integer.parseInt(streetNumber);

        System.out.print("Customer street name: ");
        String streetName = in.nextLine();

        System.out.print("Customer post code: ");
        String postCode = in.nextLine();
        
       
        //int code = Integer.parseInt(postCode);

        //System.out.print("Customer orderID: ");
        //String orderID = in.nextLine();
        //int order = Integer.parseInt(orderID);

        System.out.print("Customer registration: ");
        String registered = in.nextLine();
        //boolean registration = Boolean.parseBoolean(registered);

        db.addCustomerInformation(fName, lName, email, password, phone, date, Integer.parseInt(streetNumber),
                streetName, Integer.parseInt(postCode), Boolean.parseBoolean(registered));

        System.out.println("Customer is added to the database.");
    }

    private void testRead() throws SQLException {
        System.out.print("Customer first name: ");
        String fName = in.nextLine();
        System.out.print("Customer last name: ");
        String lName = in.nextLine();
        System.out.print("Customer email: ");
        String email = in.nextLine();
        CustomerInformationManagement customer = db.findCustomerInformation(fName, lName, email);
        //System.out.println("Hi");
        if (customer != null) {
            System.out.println("Customer " + customer.getfName() + " exists in the database.");
        } else {
            System.out.println("Customer does not exist.");
        }
    }

    private void testUpdate() throws ParseException {

        System.out.print("Customer email: ");
        String email = in.nextLine();

        try {
            if (db.checkCustomerInformation(email)) {

                System.out.print("Customer first name: ");
                String fName = in.nextLine();

                System.out.print("Customer last name: ");
                String lName = in.nextLine();

                System.out.print("Customer date of birth: ");
                String dob = in.nextLine();

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
                /*
        System.out.print("Customer orderID: ");
        String orderID = in.nextLine();
                 */
                db.updateCustomerInformation(fName, lName, dob, email, password, phone, Integer.parseInt(streetNumber),
                        streetName, Integer.parseInt(postCode));
                System.out.println("Customer has been updated");
            } else {
                System.out.println("Customer does not exist");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestCustomerInformationManagementDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void testDelete() {
        //System.out.print("Customer first name: ");
        //String fName = in.nextLine();
        //System.out.print("Customer last name: ");
        //String lName = in.nextLine();
        //System.out.print("Customer type: ");
        //String type = in.nextLine();
        System.out.print("Customer email: ");
        String email = in.nextLine();

        try {
            if (db.checkCustomerInformation(email)) {
                db.deleteCustomerInformation(email);
                System.out.println("Customer has been deleted");
            } else {
                System.out.println("Customer does not exist");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestCustomerInformationManagementDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
private void showAll(){
    try{
        ArrayList<CustomerInformationManagement> customers = db.fectCustomerInformations();
        System.out.println("CUSTOMER INFORMATION TABLE: ");
        customers.stream().forEach((customer) -> {
            System.out.printf("%-20s %-30s %-20s %-10s %-20s %-30s %-20s %-10s %-20s %-30s %-20s \n", customer.getCustomerID(),
                    customer.getfName(), customer.getlName(), customer.getEmail(),
                    customer.getPassword(), customer.getPhone(), customer.getDob(), 
                    customer.getStreetNumber(), customer.getStreetName(), customer.getPostCode(), 
                    customer.getRegistered());
        });
        System.out.println();
    }
    catch(SQLException ex){
        Logger.getLogger(TestCustomerInformationManagementDB.class.getName()).log(Level.SEVERE, null, ex);

    }
}
}
