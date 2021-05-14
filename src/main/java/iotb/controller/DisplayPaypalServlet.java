/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.controller;

import iotb.model.dao.PaypalManager;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 1234
 */
public class DisplayPaypalServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        
        
        PaypalManager manager = (PaypalManager) session.getAttribute("paypalManager");
        
        try {
            out.println("<table border=1 width=50% height=50%>");
            out.println("<tr><th>PayPal ID</th><th>Payment ID</th><th>PayPal Username</th><th>PayPal Password</th></tr>");
            String allRecords = manager.fetchPaypal();
            out.println(allRecords);
            out.println("</table>");
            
        } catch (Exception e){
            out.println("Error");
        }
        
    }

}