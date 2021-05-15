package iotb.controller.Servlets;

import iotb.model.User;
import iotb.model.dao.StaffManager;
import iotb.model.dao.UserManager;
import java.io.IOException;
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
public class DeleteStaffServlet extends HttpServlet {

    private UserManager usermanager;
    private StaffManager staffmanager;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        usermanager = (UserManager) session.getAttribute("userManager");
        staffmanager = (StaffManager) session.getAttribute("staffManager");
        User user = (User) session.getAttribute("user");

        try {
            staffmanager.deleteStaff(user.getUserID());
            System.out.println("Staff has been deleted");
            usermanager.deleteUser(user.getUserID());
            request.getRequestDispatcher("logout.jsp").include(request, response);
        } catch (SQLException | NullPointerException ex) {
            System.out.println(ex.getMessage() == null ? "User does not exist" : "welcome");
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.getRequestDispatcher("staffhome.jsp").include(request, response);
        }
    }
}
