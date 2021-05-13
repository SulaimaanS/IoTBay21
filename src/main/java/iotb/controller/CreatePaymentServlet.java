/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.controller;

import iotb.model.Payment;
import iotb.model.dao.PaymentManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jboss.logging.Logger;

/**
 *
 * @author 1234
 */
public class CreatePaymentServlet extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String orderID = request.getParameter("orderID");
        String paymentType = request.getParameter("paymentType");
        
        PaymentManager manager = (PaymentManager) session.getAttribute("paymentManager");
        validator.clear(session);
        
        if(!validator.validatePaymentType(paymentType)) {
            session.setAttribute("paymentTypeErr", "Error: Payment type does not exist");
        } else {
            try {
                manager.addPayment(Integer.parseInt(orderID), Integer.parseInt(paymentType));
                // Payment payment = new Payment(paymentID, orderID, paymentType);
                // session.setAttribute("payment", payment);
                request.getRequestDispatcher("addCreditCard.jsp").include(request, response);
                
            } catch (SQLException ex) {
                Logger.getLogger(CreatePaymentServlet.class.getName()).log(Logger.Level.FATAL, manager, ex);
            }
        }
    }

    

}
