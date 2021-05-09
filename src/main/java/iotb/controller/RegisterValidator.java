package iotb.controller;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;

public class RegisterValidator implements Serializable {

    private String emailPattern = "^[A-Za-z0-9+_.-]+@(.+)$";
    private String namePattern = "/^[a-z ,.'-]+$/i";
    //([A-Z][a-z]+[\\s])+[A-Z][a-z]*
    private String passwordPattern = "[a-z0-9]{4,}";
    private String dobPattern = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
    private String numberPattern = "^\\d{10}$";
    private String postcodePattern = "^\\d{4}$";
    
    public RegisterValidator() {
    }

    public boolean validate(String pattern, String input) {
        Pattern regEx = Pattern.compile(pattern);
        Matcher match = regEx.matcher(input);
        return match.matches();
    }

    public boolean checkEmpty(String email, String password) {
        return email.isEmpty() || password.isEmpty();
    }

    public boolean validateEmail(String email) {
        return validate(emailPattern, email);
    }

    public boolean validateName(String name) {
        return validate(namePattern, name);
    }

    public boolean validatePassword(String password) {
        return validate(passwordPattern, password);
    }
    
    public boolean validateDob(String dob) {
        return validate(dobPattern, dob);
    }
    
    public boolean validateNum(String number) {
        return validate(numberPattern, number);
    }
    
    public boolean validatePostCode(String postcode) {
        return validate(passwordPattern, postcode);
    }

    public void clear(HttpSession session){
        session.setAttribute("emailErr", "Enter Email");
        session.setAttribute("fnameErr", "Enter First Name");
        session.setAttribute("lnameErr", "Enter First Name");
        session.setAttribute("passErr", "Enter Password");
        session.setAttribute("dobErr", "Enter Date of Birth");
        session.setAttribute("phoneErr", "Enter Phone Number");
        session.setAttribute("streetNumErr", "Enter Street Number");
        session.setAttribute("streetNameErr", "Enter Street Name");
        session.setAttribute("postcodeErr", "Enter Postcode");
        session.setAttribute("existErr","");          
    }
}
