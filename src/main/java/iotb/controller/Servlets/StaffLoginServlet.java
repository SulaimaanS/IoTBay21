/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.controller.Servlets;

import iotb.controller.LoginValidator;
import iotb.model.Staff;
import iotb.model.User;
import iotb.model.dao.StaffManager;
import iotb.model.dao.UserManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
public class StaffLoginServlet extends HttpServlet {

    private UserManager usermanager;
    private StaffManager staffmanager;
    
    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        

        HttpSession session = request.getSession();
        String email = request.getParameter("email");//3- capture the posted email      
        String password = request.getParameter("password");//4- capture the posted password   

        usermanager = (UserManager)session.getAttribute("userManager");
        staffmanager = (StaffManager)session.getAttribute("staffManager");
        
        User user = null;
        Staff staff = null;
        
        LoginValidator validator = new LoginValidator();
        validator.clear(session);

        if (!validator.validateEmail(email)) {
            session.setAttribute("emailErr", "Error: Email Format Incorrect");
            request.getRequestDispatcher("stafflogin.jsp").include(request, response);
        } else if (!validator.validatePassword(password)) {
            session.setAttribute("passErr", "Error: Password Format Incorect");  
            request.getRequestDispatcher("stafflogin.jsp").include(request, response);
        } else {
            try{
                user = usermanager.readUser(email,password);
                staff = staffmanager.readStaff(user.getUserID());
                if (staff != null){
                    System.out.println("Login Successful");
                    session = request.getSession(true);
                    session.setAttribute("user", user);
                    request.getRequestDispatcher("staffhome.jsp").include(request, response);
                }
                else{
                    System.out.println("Login Failed");
                    session.setAttribute("existErr", "User Does Not Exist In The Database");
                    request.getRequestDispatcher("stafflogin.jsp").include(request, response);
                }
            }catch (SQLException | NullPointerException ex) {
                System.out.println(ex.getMessage() == null ? "User does not exist" : "welcome");
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                request.getRequestDispatcher("stafflogin.jsp").include(request, response);
            }
        } 

    }

}
