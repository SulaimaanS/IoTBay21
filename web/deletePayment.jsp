<%-- 
    Document   : deletePayment
    Created on : 14/05/2021, 7:33:11 PM
    Author     : 1234
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheets/interface.css">
        <title>Remove Payment Details</title>
    </head>
    <body>
        
        <% 
            String deleted = (String) session.getAttribute("deleted");
        %>
        
        <ul>
            <li><a href="main.jsp">Main</a></li>
            <li><a href="logout.jsp">Logout</a></li>
        </ul>
        
        <h1>Remove Payment Details</h1><span><%=(deleted != null ? deleted : "")%></span>
        <form method="post" action="DeletePaymentServlet">
            <table>
                <tr><td>Payment ID: </td><td><input type="text" placeholder="Enter existing Payment ID" name="paymentID"></td></tr>
                <tr><td></td><td><input type="submit" value="Remove Payment"></td></tr>
            </table>
        </form>
    </body>
</html>
