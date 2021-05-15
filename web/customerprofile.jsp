<%@page import="iotb.model.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheets/MainStyle.css">
        <title>Customer Page</title>
    </head>
    
    <body>
        <div id="navContainer">
            <ul id="navbar">
                <li><a href="index.jsp">Home</a></li>
                <li><a href="updatecustomer.jsp">Edit Profile</a></li>
                <li><a href="logoutcustomer.jsp">Logout</a></li>
        </div>

        <div id="title">
            <h1>${user.fName}'s Page</h1>
        </div>

        <div id="info">
            <table id="infoTable">
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <td>
                </tr>
                <tr>
                    <td>
                        ${user.fName} ${user.lName}
                    </td>
                    <td>
                        ${user.emailAddress}
                    </td>
                </tr>
            </table>
        </div>    
        
        <form action="DeleteCustomerServlet" method="Post">
            <input type="submit" value="Delete Account">
        </form>
        
        <div id="footer">
            Copyright 2021, IoTBay Solutions 
        </div>
    </body>
    <jsp:include page="/ConnectionServlet" flush="true" />
</html>
