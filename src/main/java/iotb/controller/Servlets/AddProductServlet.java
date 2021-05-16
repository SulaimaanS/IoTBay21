package iotb.controller.Servlets;

import iotb.controller.LoginValidator;
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
import iotb.model.dao.UserManager;

public class AddProductServlet extends HttpServlet {

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1- retrieve the current session
        HttpSession session = request.getSession();
        //2- create an instance of the Validator class  
        LoginValidator validator = new LoginValidator();
        //3- capture the posted email      
        String email = request.getParameter("email");
        String id = request.getParameter("id");
        //4- capture the posted password    
        String password = request.getParameter("password");
        //5- retrieve the manager instance from session   
        UserManager manager = (UserManager) session.getAttribute("manager");
        User user = null;
        try {
            //6- find user by email and password
            user = manager.readUser(email,password);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!validator.validateEmail(email)) {/*7-validate email*/
            //8-set incorrect email error to the session      
            session.setAttribute("emailErr", "Error: Email Format Incorect");
            //9- redirect user back to the login.jsp     
            request.getRequestDispatcher("login.jsp").include(request, response);
        } else if (!validator.validatePassword(password)) {
            /*10-   validate password  */
            //11-set incorrect password error to the session   
            session.setAttribute("passErr", "Error: Password Format Incorect");
            //12- redirect user back to the login.jsp      
            request.getRequestDispatcher("login.jsp").include(request, response);
        } else if (user != null) {
            //13-save the logged in user object to the session  
            session.setAttribute("user", user);
            //14- redirect user to the main.jsp    
            request.getRequestDispatcher("index.jsp").include(request, response);
        } else {
            //15-set user does not exist error to the session    
            session.setAttribute("existErr", "Error: User does not exist");
            //16- redirect user back to the login.jsp       
            request.getRequestDispatcher("login.jsp").include(request, response);
        }
    }
}
