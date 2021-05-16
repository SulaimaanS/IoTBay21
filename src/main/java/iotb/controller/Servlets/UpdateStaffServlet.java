package iotb.controller.Servlets;

import iotb.controller.UpdateValidator;
import iotb.model.Staff;
import iotb.model.User;
import iotb.model.dao.StaffManager;
import iotb.model.dao.UserManager;
import java.io.IOException;
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
public class UpdateStaffServlet extends HttpServlet {

    private UserManager usermanager;
    private StaffManager staffmanager;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String fName = request.getParameter("firstname");
        String lName = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String dob = request.getParameter("dob");
        String phonenum = request.getParameter("phonenumber");

        usermanager = (UserManager) session.getAttribute("userManager");
        staffmanager = (StaffManager) session.getAttribute("staffManager");

        UpdateValidator validator = new UpdateValidator();
        validator.clear(session);

        if (!validator.validateEmail(email)) {
            session.setAttribute("emailErr", "Email Format Incorrect");
            request.getRequestDispatcher("updatestaff.jsp").include(request, response);
        } else if (!validator.validateName(fName)) {
            session.setAttribute("fnameErr", "First Name Format Incorrect");
            request.getRequestDispatcher("updatestaff.jsp").include(request, response);
        } else if (!validator.validateName(lName)) {
            session.setAttribute("lnameErr", "Last Name Format Incorrect");
            request.getRequestDispatcher("updatestaff.jsp").include(request, response);
        } else if (!validator.validatePassword(password)) {
            session.setAttribute("passErr", "Password Format Incorrect");
            request.getRequestDispatcher("updatestaff.jsp").include(request, response);
        } else if (!validator.validateDob(dob)) {
            session.setAttribute("dobErr", "DOB Format Incorrect");
            request.getRequestDispatcher("updatestaff.jsp").include(request, response);
        } else if (!validator.validatePhoneNum(phonenum)) {
            session.setAttribute("phoneErr", "Phone Number Format Incorrect");
            request.getRequestDispatcher("updatestaff.jsp").include(request, response);
        } else {
            try {
                User user = (User) session.getAttribute("user");
                int userID = user.getUserID();
                usermanager.updateUser(userID, fName, lName, email, password, phonenum);
                User updateduser = new User(userID, fName, lName, email, password, phonenum);
                Staff staff = staffmanager.readStaff(user.getUserID());
                session.setAttribute("user", updateduser);
                session.setAttribute("staff", staff);
                request.getRequestDispatcher("staffhome.jsp").include(request, response);
            } catch (SQLException | NullPointerException ex) {
                System.out.println(ex.getMessage() == null ? "Failed to update staff" : "Error");
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                request.getRequestDispatcher("updatestaff.jsp").include(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
