/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.controller.Servlets;

import iotb.controller.RegisterValidator;
import iotb.model.Customer;
import iotb.model.User;
import iotb.model.dao.CustomerManager;
import iotb.model.dao.UserManager;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alaw8
 */
public class UpdateCustomerServlet extends HttpServlet {

   private UserManager usermanager;
   private CustomerManager customermanager;
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
        HttpSession session = request.getSession();
        String fName = request.getParameter("firstname");
        String lName = request.getParameter("lastname"); 
        String email = request.getParameter("email");    
        String password = request.getParameter("password"); 
        String dob = request.getParameter("dob"); 
        String phonenum = request.getParameter("phonenumber"); 
        String streetnum = request.getParameter("streetnumber"); 
        String streetname = request.getParameter("streetname"); 
        String postcode = request.getParameter("postcode"); 

        usermanager = (UserManager)session.getAttribute("userManager");
        customermanager = (CustomerManager)session.getAttribute("customerManager");
        
        RegisterValidator validator = new RegisterValidator();
        validator.clear(session);

        if (!validator.validateEmail(email)) {
            session.setAttribute("emailErr", "Email Format Incorrect"); 
            request.getRequestDispatcher("updatecustomer.jsp").include(request, response);  
        } else if (!validator.validateName(fName)) {
            session.setAttribute("fnameErr", "First Name Format Incorrect");  
            request.getRequestDispatcher("updatecustomer.jsp").include(request, response);  
        } else if (!validator.validateName(lName)) {
            session.setAttribute("lnameErr", "Last Name Format Incorrect");  
            request.getRequestDispatcher("updatecustomer.jsp").include(request, response);  
        } else if (!validator.validatePassword(password)) {
            session.setAttribute("passErr", "Password Format Incorrect");  
            request.getRequestDispatcher("updatecustomer.jsp").include(request, response);  
        } else if (!validator.validateDob(dob)) {
            session.setAttribute("dobErr", "DOB Format Incorrect");  
            request.getRequestDispatcher("updatecustomer.jsp").include(request, response);  
        } else if (!validator.validatePhoneNum(phonenum)) {
            session.setAttribute("phoneErr","Phone Number Format Incorrect");  
            request.getRequestDispatcher("updatecustomer.jsp").include(request, response);  
        } else if (!validator.validateNum(streetnum)) {
            session.setAttribute("streetNumErr", "Street Number Format Incorrect");  
            request.getRequestDispatcher("updatecustomer.jsp").include(request, response);  
        } else if (!validator.validatestreetName(streetname)) {
            session.setAttribute("streetNameErr", "Street Name Format Incorrect");  
            request.getRequestDispatcher("updatecustomer.jsp").include(request, response);  
        } else if (!validator.validatePostCode(postcode)) {
            session.setAttribute("postcodeErr", "Post Code Format Incorrect");  
            request.getRequestDispatcher("updatecustomer.jsp").include(request, response);  
        } else {
            try{
                User user = usermanager.readUser(email,password);                
                if (user == null){
                    session.setAttribute("existErr", "User Does Not Exist!");
                    request.getRequestDispatcher("updatecustomer.jsp").include(request, response);
                }else{
                    usermanager.updateUser(usermanager.getID(email,password),fName,lName,email,password,phonenum);
                    String updatedemail = request.getParameter("email");    
                    String updatedpassword = request.getParameter("password"); 
                    int userID = usermanager.getID(updatedemail,updatedpassword);
                    customermanager.updateCustomer(userID, customermanager.getID(userID),dob,Integer.parseInt(streetnum),streetname,Integer.parseInt(postcode),true);
                    User updateduser = new User(usermanager.getID(updatedemail,updatedpassword),fName,lName,email,password,phonenum);
                    Customer customer = customermanager.readCustomer(user.getUserID());
                    session.setAttribute("user",updateduser);
                    session.setAttribute("customer",customer);
                    request.getRequestDispatcher("customerprofile.jsp").include(request, response);
                }
            }catch (SQLException | NullPointerException ex) {
                System.out.println(ex.getMessage() == null ? "User does not exist" : "welcome");
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                request.getRequestDispatcher("updatecustomer.jsp").include(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
}
