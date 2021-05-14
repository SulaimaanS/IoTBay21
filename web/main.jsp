<%@page import="iotb.model.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheets/interface.css">
        <title>Main Page</title>
    </head>

    <body>
        
        <ul>
            <li><a href="main.jsp">Main</a></li>
            <li><a href="logout.jsp">Logout</a></li>
        </ul>
        
        <h1>Main Page</h1>
        <a href="deletePayment.jsp">Remove Payment details</a>
        <a href="updateCreditCard.jsp">Update my Credit Card details</a>
        <a href="updatePaypal.jsp">Update my PayPal Account details</a>
        <a href="updatePayment.jsp">Update my Payment details</a>
        <a href="viewRecords.jsp">View Payment Details</a>
    </body>
</html>
