package iotb.controller.Servlets;

import iotb.model.Customer;
import iotb.model.Staff;
import iotb.model.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import iotb.model.dao.LogManager;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogoutServlet extends HttpServlet {

    private LogManager logmanager;

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
        Customer customer = (Customer) session.getAttribute("customer");
        Staff staff = (Staff) session.getAttribute("staff");
        logmanager = (LogManager) session.getAttribute("logManager");
        Date date = new Date();

        if (user != null && customer != null) {
            try {
                System.out.println(user.getUserID());
                logmanager.addCustomerLog(user.getUserID(), date, "Logout");
            } catch (ParseException | SQLException ex) {
                Logger.getLogger(LogoutServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (user != null && staff != null) {
            try {
                logmanager.addStaffLog(staff.getStaffID(), date, "Logout");
            } catch (ParseException | SQLException ex) {
                Logger.getLogger(LogoutServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        session.invalidate();
        request.getRequestDispatcher("index.jsp").include(request, response);
    }
}
