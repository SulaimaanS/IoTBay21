<%-- 
    Document   : updatePaypal
    Created on : 14/05/2021, 3:22:38 PM
    Author     : 1234
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update my PayPal Account Details</title>
    </head>
    <body>
        
        <%
            String paypalUsernameErr = (String)session.getAttribute("paypalUsernameErr");
            String paypalPasswordErr = (String)session.getAttribute("paypalPasswordErr");
            String updated = (String)session.getAttribute("updated");
        %>
        
        <h1>Update my PayPal Account Details</h1><span><%=(updated != null ? updated : "")%></span>
        <form method="post" action="UpdatePaypalServlet">
            <table>
                <tr><td>PayPal ID: </td><td><input type="text" placeholder="Enter existing PayPal ID" name="paypalID"></td></tr>
                <tr><td>Payment ID: </td><td><input type="text" placeholder="Enter existing Payment ID" name="paymentID"></td></tr>
                <tr><td>PayPal Username: </td><td><input type="text" placeholder="<%=(paypalUsernameErr != null ? paypalUsernameErr : "Enter PayPal username")%>" name="paypalUsername"></td></tr>
                <tr><td>PayPal Password: </td><td><input type="text" placeholder="<%=(paypalPasswordErr != null ? paypalPasswordErr : "Enter PayPal password")%>" name="paypalPassword"></td></tr>
                <tr><td></td><td><input type="submit" value="Update PayPal details"></td></tr>
            </table>
        </form>
    </body>
</html>
