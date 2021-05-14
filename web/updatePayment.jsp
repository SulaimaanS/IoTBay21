<%-- 
    Document   : updatePayment
    Created on : 14/05/2021, 3:52:03 PM
    Author     : 1234
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheets/interface.css">
        <title>Update Payment Details</title>
    </head>
    <body>
        
        <%
             String updated = (String)session.getAttribute("updated");
        %>
        
        <ul>
            <li><a href="main.jsp">Main</a></li>
            <li><a href="logout.jsp">Logout</a></li>
        </ul>
        
        <h1>Update Payment Details</h1><span><%=(updated != null ? updated : "")%></span>
        <form method="post" action="UpdatePaymentServlet">
            <table>
                <tr><td>Existing Payment ID: </td><td><input type="text" placeholder="Enter existing Payment ID" name="paymentID"></td></tr>
                <tr><td>Existing Order ID: </td><td><input type="text" placeholder="Enter existing Order ID" name="orderID"></td></tr>
                <tr>
                    <td>Payment Type: </td>
                    <td>
                        <input type="radio" id="creditCard" name="paymentType" value="1">
                        <label for="creditCard">Credit Card</label>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="radio" id="paypal" name="paymentType" value="2">
                        <label for="paypal">PayPal</label>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Add Payment"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
