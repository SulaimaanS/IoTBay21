package iotb.controller.Servlets;

import iotb.controller.LoginValidator;
import iotb.model.Staff;
import iotb.model.User;
import iotb.model.dao.LogManager;
import iotb.model.dao.StaffManager;
import iotb.model.dao.UserManager;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
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
    private LogManager logmanager;

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        usermanager = (UserManager) session.getAttribute("userManager");
        staffmanager = (StaffManager) session.getAttribute("staffManager");
        logmanager = (LogManager) session.getAttribute("logManager");

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
            try {
                user = usermanager.readUser(email, password);
                staff = staffmanager.readStaff(user.getUserID());
                System.out.println("Login Successful");
                session = request.getSession(true);
                session.setAttribute("user", user);
                session.setAttribute("staff", staff);
                Date date = new Date();
                logmanager.addStaffLog(staff.getStaffID(), date, "Login");
                request.getRequestDispatcher("staffhome.jsp").include(request, response);
            } catch (SQLException | NullPointerException ex) {
                session.setAttribute("existErr", "Staff Does Not Exist In The Database");
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                request.getRequestDispatcher("stafflogin.jsp").include(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(StaffLoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
