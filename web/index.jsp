<%-- 
    Document   : index
    Created on : 13/05/2021, 2:21:01 PM
    Author     : 1234
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheets/interface.css">
        <title>Landing Page</title>
    </head>
    <body>
        
        <ul>
            <li><a href="main.jsp">IoTBay</a></li>
            <li><a href="main.jsp">Main</a></li>
            <li><a href="LogoutServlet">Logout</a></li>
        </ul>
        
        <h1>Landing Page</h1>
        <div class="vertical-menu">
        <a href="main.jsp">Main Page</a>
        <a href="createPayment.jsp">Add Payment Information</a>
        <a href="viewRecords.jsp">View Payment Details</a>
        <jsp:include page="/ConnectionServlet" flush="true"/>
        </div>

    </body>
    <footer>
            <p>IoTBay Solutions Pty Ltd</p>
        </footer>
</html>
