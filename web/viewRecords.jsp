<%-- 
    Document   : viewRecords
    Created on : 14/05/2021, 12:20:20 PM
    Author     : 1234
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment Records</title>
    </head>
    <body>
        <h1>Payment Records</h1>
        <h2>Payment Details</h2>
        <jsp:include page="/DisplayPaymentServlet" flush="true"/>
        <h2>Credit Card Details</h2>
        <jsp:include page="/DisplayCreditCardServlet" flush="true"/>
        <h2>PayPal Details</h2>
        <jsp:include page="/DisplayPaypalServlet" flush="true"/>
    </body>
</html>
