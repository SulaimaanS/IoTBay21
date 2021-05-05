//Use this as a backup in case the actual database connection isnt successful
package iotb.controller;

import iotb.model.dao.DatabaseConnector;
import iotb.model.dao.UserManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class LocalDataBase {
    public static final Scanner in = new Scanner(System.in);

    //take input to manually insert data
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        DatabaseConnector databaseConnector = new DatabaseConnector();
        Connection connection = databaseConnector.connection();
        UserManager userManager = new UserManager(connection);

        System.out.print("Choices a/x:");
        char c = in.nextLine().charAt(0);
        while(c != 'x'){
            System.out.print("First Name");
            String firstName = in.nextLine();
            System.out.print("Last Name");
            String lastName = in.nextLine();
            System.out.print("Password");
            String password = in.nextLine();
            System.out.print("Password");
            String dob = in.nextLine();
            System.out.print("Password");
            String phoneNumber = in.nextLine();
            System.out.print("Password");
            String emailAddress = in.nextLine();
            System.out.print("Password");
            String streetNumber = in.nextLine();
            System.out.print("Password");
            String streetName = in.nextLine();
            System.out.print("Password");
            String postCode = in.nextLine();


            //userManager.addUser();
            System.out.println("User has been added");
            System.out.print("Choices a/x:");
            c = in.nextLine().charAt(0);
        }
    }
}