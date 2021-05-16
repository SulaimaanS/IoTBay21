/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.controller;

import iotb.model.CustomerInformationManagement;
import iotb.model.dao.CustomerInformationManagementManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author timmy
 */
public class CustomerInformationManagementCreateServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        CustomerInformationManagementValidator validator = new CustomerInformationManagementValidator();
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String fName = request.getParameter("firstName");
        String lName = request.getParameter("lastName");
        String customerID = request.getParameter("customerID");
        String type = request.getParameter("type");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String streetNumber = request.getParameter("streetNumber");
        String streetName = request.getParameter("streetName");
        String postCode = request.getParameter("postCode");
        String orderID = request.getParameter("orderID");
        String registered = request.getParameter("registered");
      
        
        CustomerInformationManagementManager manager = (CustomerInformationManagementManager) session.getAttribute("manager");
        CustomerInformationManagement customer = null;
        
        if(!validator.validateEmail(email)){
            session.setAttribute("emailErr", "Error Email Format Incorrect");
        }
        else if(!validator.validateFirstName(fName)){
            session.setAttribute("firstnameErr", "Error First Name Format Incorrect");
        }
        else if(!validator.validateLastName(lName)){
            session.setAttribute("lastnameErr", "Error Last Name Format Incorrect");
        }
        
        else{
            try{
                //customer = manager.addCustomer(customerID, type, fName, lName, dob, gender, email, password, phone, streetNumber, streetName, postCode, orderID, registered);
                customer = manager.findCustomer(fName, lName, type);
                if(customer != null){
                    //manager.addCustomer(customerID, type, fName, lName, dob, gender, email, password, phone, streetNumber, streetName, postCode, orderID, registered);
                    session.setAttribute("existErr", "Customer has been added to the database!" );
                    request.getRequestDispatcher("createCustomerRecords.jsp");
                }
                else{
                    session.setAttribute("existErr", "Customer already exists in the database!");
                    request.getRequestDispatcher("createCustomerRecords.jsp");
                }
            }
            catch(SQLException | NullPointerException ex){
                System.out.println(ex.getMessage() == null ? "Failed to add customer record" : "Failed to add customer");
            }
        
        }
        
    }

    

}
