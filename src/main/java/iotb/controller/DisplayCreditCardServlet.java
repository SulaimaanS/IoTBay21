/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.controller;

import iotb.model.dao.CreditCardManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 1234
 */
public class DisplayCreditCardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        
        
        CreditCardManager manager = (CreditCardManager) session.getAttribute("creditCardManager");
        
        try {
            out.println("<table border=1 width=50% height=50%>");
            out.println("<tr><th>Payment ID</th><th>Card ID</th><th>Card Number</th><th>Expiry Date</th><th>Holder Name</th><th>CVV</th></tr>");
            String allRecords = manager.fetchCreditCard();
            out.println(allRecords);
            out.println("</table>");
            
        } catch (Exception e){
            out.println("Error");
        }
        
    }

}
