/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.controller;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;

/**
 *
 * @author timmy
 */
public class CustomerInformationManagementValidator {
    private String emailPattern = "([a-zA-Z0-9]+)(([._-])([a-zA-Z0-9]+))*(@)([a-z]+)(.)([a-z]{3})((([.])[a-z]{0,2})*)";
    private String namePattern = "([A-Z][a-z]+[\\s])+[A-Z][a-z]*";
    private String numberPattern = "[1-9][0-9]";
    private String phoneNumber = "^\\d{10}$";
    private String passwordPattern = "[a-z0-9]{4,}";
    private String firstNamePattern = "[A-Z][a-z]";
    private String lastNamePattern = "[A-Z][a-z]";
    private String streetNamePattern = "";
    private String genderPattern = "";
    
    public CustomerInformationManagementValidator(){
    
    }
    
    public boolean validate(String pattern, String input){
        Pattern regEx = Pattern.compile(pattern);
        Matcher match = regEx.matcher(input);
        return match.matches();
    }

    public boolean validateEmail(String email) {
        return validate(emailPattern, email);
    }

    public boolean validateFirstName(String fName) {
        return validate(namePattern, fName);
    }
    
    public boolean validateLastName(String lName) {
        return validate(namePattern, lName);
    }

    public boolean validatePassword(String password) {
        return validate(passwordPattern, password);
    }
    
    public boolean validateStreetNumber(String streetNumber) {
        return validate(namePattern, streetNumber);
    }
    
    public boolean validatePostCode(String password) {
        return validate(passwordPattern, password);
    }
    
    public boolean validateCustomerID(String password) {
        return validate(passwordPattern, password);
    }
    
    public boolean validateGender(String gender) {
        return validate(genderPattern, gender);
    }
    
    
    
    
    public void clear(HttpSession session){
        session.setAttribute("emailErr", "Enter email");
        session.setAttribute("passErr", "Enter password");
        session.setAttribute("existErr", "");
        session.setAttribute("firstnameErr", "Enter first name ");
        session.setAttribute("lastnameErr", "Enter last name");
        
    }
    
    
}
