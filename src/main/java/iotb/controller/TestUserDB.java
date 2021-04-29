/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.controller;

import iotb.model.dao.DatabaseConnector;
import iotb.model.dao.UserManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author alaw8
 */
public class TestUserDB {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    public static final Scanner in = new Scanner(System.in);
    public static UserManager manager; 
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException{
        DatabaseConnector connector = new DatabaseConnector(); 
        Connection con = connector.connection(); 
        manager = new UserManager(con);
        char c; 
        help();
        while ((c=readChoice()) != 'x'){
            switch(c){
                case 'c': addUser();break;
                case 'r': readUser();break;
                case 'u': updateUser();break;
                case 'd': deleteUser();break;
                default:help(); break;
            }
        }
    }

    public static void addUser()throws SQLException, ParseException {
             System.out.print("First Name: ");
             String firstName = in.nextLine();
             System.out.print("Last Name: ");
             String lastName = in.nextLine();
             System.out.print("Email: ");
             String email = in.nextLine();
             System.out.print("Password: ");
             String password = in.nextLine();
             System.out.print("Date of Birth: ");
             String dob = in.nextLine();
             System.out.print("Gender: ");
             String gender = in.nextLine();
             System.out.print("Phone Number: ");
             String phonenum = in.nextLine();
             System.out.print("Street Number: ");
             String streetnum = in.nextLine();
             System.out.print("Street Name: ");
             String streetname = in.nextLine();
             System.out.print("Postcode: ");
             String postcode = in.nextLine();
             manager.addUser(firstName, lastName, email,dob, password, gender, phonenum, Integer.parseInt(streetnum), streetname, Integer.parseInt(postcode));
             System.out.println("A user has been added to the database");   
        }
    
        public static void updateUser(){}
        public static void readUser(){}
        public static void deleteUser(){}
        
        public static char readChoice(){
            System.out.print("Choices C/R/U/D/X: ");
            return in.nextLine().charAt(0);
        }
        
        public static void help(){
             System.out.println("User CRUD operations: \n" + 
                     "C - Create User\n" + 
                     "R - Read User\n" + 
                     "U - Update User\n" + 
                     "D - Delete User\n");
        }
    }

