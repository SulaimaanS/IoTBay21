<%-- 
    Document   : addCreditCard
    Created on : 13/05/2021, 5:44:39 PM
    Author     : 1234
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Credit Card</title>
    </head>
    <body>
        
        <%
            String expiryDateErr = (String) session.getAttribute("expiryDateErr");
            String cardNumberErr = (String) session.getAttribute("cardNumberErr");
            String holderNameErr = (String) session.getAttribute("holderNameErr");
            String cvvErr = (String) session.getAttribute("cvvErr");
        %>
        
        <h1>Add Credit Card</h1>
        <form method="post" action="CreateCreditCardServlet">
            <table>
                <tr><td>Existing Payment ID: </td><td><input type="text" placeholder="Enter existing Payment ID" name="paymentID"></td></tr>
                <tr><td>Card Number: </td><td><input type="text" name="cardNumber"></td></tr>
                <tr><td>Expiry date: </td><td><input type="date" name="expiryDate"></td></tr>
                <tr><td>Card Holder Name: </td><td><input type="text" name="holderName"></td></tr>
                <tr><td>CVV: </td><td><input type="text" placeholder="Enter 3-digit CVV number" name="cvv"></td><</tr>
                <tr><td></td><td><input type="submit" value="Add credit card"></td></tr>
            </table>
        </form>
    </body>
</html>
