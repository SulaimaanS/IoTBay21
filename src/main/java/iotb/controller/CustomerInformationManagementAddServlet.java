/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.controller;

import iotb.model.CustomerInformationManagement;
import iotb.model.dao.CustomerInformationManagementManager;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author timmy
 */
public class CustomerInformationManagementAddServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*
     private Statement st;
     public CustomerInformationManagementAddServlet(Connection con) throws SQLException {       
        st = con.createStatement();   
    }
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
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

        //CustomerInformationManagement customer = new CustomerInformationManagement(customerID, type, fName, lName, dob, gender, email, password, phone, streetNumber, streetName, postCode, orderID, registered);
        /*
        CustomerInformationManagementManager manager = (CustomerInformationManagementManager) session.getAttribute("manager");
        CustomerInformationManagement customer = null;
        
        try{
            customer = manager.findCustomer(fName, lName, type);
            if(customer == null){
                session.setAttribute("customer" , customer);
                session.setAttribute("updated", "Customer was not added to the record");
                manager.addCustomer(customerID, type, fName, lName, dob, gender, email, password, phone, streetNumber, streetName, postCode, orderID, registered);
                request.getRequestDispatcher("createCustomerRecords.jsp").include(request, response);
            }
            else{
                session.setAttribute("updated", "Customer was not added to the record");
                request.getRequestDispatcher("createCustomerRecords.jsp").include(request, response);
            }
        
        }
        
       
        catch (SQLException ex) {
            Logger.getLogger(CustomerInformationManagementAddServlet.class.getName()).log(Level.SEVERE, null, ex);
        
    }
         */
        //CustomerInformationManagement customer = manager.findCustomer(fName, lName, type);
        CustomerInformationManagementManager manager = (CustomerInformationManagementManager) session.getAttribute("customerInformationManagementManager");
        //CustomerInformationManagement customer = new CustomerInformationManagement(customerID, type, fName, lName, dob, gender, email, password, phone, streetNumber, streetName, postCode, orderID, registered);
        //customer = manager.findCustomer(fName, lName, type);        //customer = manager.findCustomer(fName, lName, type);

        try {
            //session.setAttribute("customer" , customer);
            manager.addCustomer(type, fName, lName, dob, gender, email, password, phone, streetNumber, streetName, postCode, registered);
            session.setAttribute("updated", "Customer is added to the record");
            //st.executeUpdate("INSERT INTO CUSINFOMANTABLE (CUSTOMERID, CUSTOMERTYPE, FIRSTNAME, LASTNAME, DOB, GENDER, EMAILADDRESS, PASSWORD, PHONENUMBER, STREETNUMBER, STREETNAME, POSTCODE, ORDERID, REGISTERED) VALUES ('"+customerID+"', '"+type+"', '"+fName+"', '"+lName+"', '"+dob+"', '"+gender+"', '"+email+"', '"+password+"', '"+phone+"', '"+streetNumber+"', '"+streetName+"', '"+postCode+"', '"+orderID+"', '"+registered+"' )" );
            request.getRequestDispatcher("createCustomerRecords.jsp").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerInformationManagementAddServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        //session.setAttribute("updated", "Customer is added to the record");
        //response.sendRedirect("createCustomerRecords.jsp");
    }

}
