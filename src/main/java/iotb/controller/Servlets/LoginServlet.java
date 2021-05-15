package iotb.controller.Servlets;

import iotb.controller.LoginValidator;
import iotb.model.Customer;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import iotb.model.User;
import iotb.model.dao.CustomerManager;
import iotb.model.dao.LogManager;
import iotb.model.dao.UserManager;
import java.text.ParseException;
import java.util.Date;

public class LoginServlet extends HttpServlet {

    private UserManager manager;
    private CustomerManager customermanager;
    private LogManager logmanager;
    
    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        

        HttpSession session = request.getSession();
        String email = request.getParameter("email");     
        String password = request.getParameter("password"); 

        manager = (UserManager)session.getAttribute("userManager");
        customermanager = (CustomerManager)session.getAttribute("customerManager");
        logmanager = (LogManager)session.getAttribute("logManager");
        
        
        User user = null;
        Customer customer = null;
        
        LoginValidator validator = new LoginValidator();
        validator.clear(session);

        if (!validator.validateEmail(email)) {
            session.setAttribute("emailErr", "Error: Email Format Incorrect");
            request.getRequestDispatcher("login.jsp").include(request, response); 
        } else if (!validator.validatePassword(password)) {
            /*10-   validate password  */
            session.setAttribute("passErr", "Error: Password Format Incorect");
            request.getRequestDispatcher("login.jsp").include(request, response);
        } else {
            try{
                user = manager.readUser(email,password);
                customer = customermanager.readCustomer(user.getUserID());
                if (user != null && customer != null){
                    System.out.println("Login Successful");
                    session = request.getSession(true);
                    session.setAttribute("user", user);
                    session.setAttribute("customer", customer);
                    Date date = new Date();
                    logmanager.addCustomerLog(user.getUserID(),date,"Login");
                    request.getRequestDispatcher("customerprofile.jsp").include(request, response);
                }
                else{
                    System.out.println("Login Failed");
                    session.setAttribute("existErr", "User Does Not Exist In The Database");
                    request.getRequestDispatcher("login.jsp").include(request, response);
                }
            }catch (SQLException | NullPointerException ex) {
                System.out.println(ex.getMessage() == null ? "User does not exist" : "welcome");
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                request.getRequestDispatcher("login.jsp").include(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 

    }
}
