package iotb.controller.Servlets;

import iotb.model.Customer;
import iotb.model.User;
import iotb.model.dao.CustomerManager;
import iotb.model.dao.UserManager;
import java.io.IOException;
import java.io.PrintWriter;
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
public class DeleteCustomerServlet extends HttpServlet {

    private UserManager usermanager;
    private CustomerManager customermanager;
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();        

        usermanager = (UserManager)session.getAttribute("userManager");
        customermanager = (CustomerManager)session.getAttribute("customerManager");
        User user = (User)session.getAttribute("user");

        try{
            customermanager.deleteCustomer(user.getUserID());
            usermanager.deleteUser(user.getUserID());
            request.getRequestDispatcher("logout.jsp").include(request, response);  
            }catch (SQLException | NullPointerException ex) {
                System.out.println(ex.getMessage() == null ? "User does not exist" : "welcome");
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                request.getRequestDispatcher("customerprofile.jsp").include(request, response);
            }
        } 
}

