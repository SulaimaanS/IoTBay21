/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.controller;

import java.util.Scanner;
import iotb.model.dao.CustomerManager;
import iotb.model.dao.DatabaseConnector;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;


/**
 *
 * @author alaw8
 */
public class TestCustomerDB {
    public static final Scanner in = new Scanner(System.in);
    public static CustomerManager manager; 
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException{
        DatabaseConnector connector = new DatabaseConnector(); 
        Connection con = connector.connection(); 
        manager = new CustomerManager(con);
        char c; 
        help();
        while ((c=readChoice()) != 'x'){
            switch(c){
                case 'c': addCustomer();break;
                case 'r': readCustomer();break;
                case 'u': updateCustomer();break;
                case 'd': deleteCustomer();break;
                default:help(); break;
            }
        }
    }
    
    public static void addCustomer(){
        }    
    
    public static void readCustomer(){
        }    
        
    public static void updateCustomer(){
        }
        
    public static void deleteCustomer(){
        }
        
    public static char readChoice(){
        System.out.print("Choices C/R/U/D/X: ");
        return in.nextLine().charAt(0);
    }        
        
    public static void help(){
        System.out.println("User CRUD operations: \n" + 
            "C - Create User\n" + 
            "R - Read User\n" + 
            "U - Update User\n" + 
            "D - Delete User\n"+ 
            "X - Exit\n");
    }        
}
