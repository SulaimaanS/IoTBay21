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
import iotb.model.dao.UserManager;

public class LoginServlet extends HttpServlet {

    private UserManager manager;
    private CustomerManager customermanager;
    
    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        

        HttpSession session = request.getSession();
        String email = request.getParameter("email");//3- capture the posted email      
        String password = request.getParameter("password");//4- capture the posted password   

        manager = (UserManager)session.getAttribute("userManager");//5- retrieve the manager instance from session
        customermanager = (CustomerManager)session.getAttribute("customerManager");
        
        User user = null;
        Customer customer = null;
        
        LoginValidator validator = new LoginValidator();
        validator.clear(session);

        if (!validator.validateEmail(email)) {/*7-validate email*/
            session.setAttribute("emailErr", "Error: Email Format Incorrect");//8-set incorrect email error to the session   
            request.getRequestDispatcher("login.jsp").include(request, response);//9- redirect user back to the login.jsp    
        } else if (!validator.validatePassword(password)) {
            /*10-   validate password  */
            session.setAttribute("passErr", "Error: Password Format Incorect");//11-set incorrect password error to the session   
            request.getRequestDispatcher("login.jsp").include(request, response);//12- redirect user back to the login.jsp  
        } else {
            try{
                //user = manager.readUser(email, password);//6- find user by email and password
                user = manager.readUser(email,password);
                customer = customermanager.readCustomer(user.getUserID());
                if (user != null){
                    System.out.println("Login Successful");
                    session = request.getSession(true);
                    session.setAttribute("user", user);
                    session.setAttribute("customer", customer);
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
            }
        } 

    }
}
