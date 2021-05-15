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
            <li><a href="main.jsp">IoTBay</a></li>
            <li><a href="main.jsp">Main</a></li>
            <li><a href="LogoutServlet">Logout</a></li>
        </ul>
        
        <h1>Main Page</h1>
        <h2>Payment options:</h2>
        <div class="vertical-menu">
        <a href="searchPayment.jsp">Search Payment History</a>
        <a href="viewRecords.jsp">View Payment Records</a>
        <a href="updatePayment.jsp">Update my Payment details</a>
        <a href="deletePayment.jsp">Remove my Payment details</a>
        </div>
        <h2>Credit Card options:</h2>
        <div class="vertical-menu">
        <a href="addCreditCard.jsp">Add Credit Card</a>
        <a href="updateCreditCard.jsp">Update my Credit Card details</a>
        <a href="deleteCreditCard.jsp">Remove Credit Card details</a>
        </div>
        <h2>PayPal options:</h2>
        <div class="vertical-menu">
        <a href="addPaypal.jsp">Add PayPal Account</a>
        <a href="updatePaypal.jsp">Update my PayPal Account details</a>
        <a href="deletePaypal.jsp">Remove PayPal Account</a>
        </div>
              
    </body>
    <footer>
            <p>IoTBay Solutions Pty Ltd</p>
        </footer>
</html>
