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

public class UpdateProductServlet extends HttpServlet {

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        LoginValidator validator = new LoginValidator();
        String email = request.getParameter("email");
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        UserManager manager = (UserManager) session.getAttribute("manager");
        User user = null;
        try {
            user = manager.readUser(email, password);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!validator.validateEmail(email)) {
            session.setAttribute("emailErr", "Error: Email Format Incorect");
            request.getRequestDispatcher("login.jsp").include(request, response);
        } else if (!validator.validatePassword(password)) {
            session.setAttribute("passErr", "Error: Password Format Incorect");
            request.getRequestDispatcher("login.jsp").include(request, response);
        } else if (user != null) {
            session.setAttribute("user", user);
            request.getRequestDispatcher("index.jsp").include(request, response);
        } else {
            session.setAttribute("existErr", "Error: User does not exist");
            request.getRequestDispatcher("login.jsp").include(request, response);
        }
    }
}
