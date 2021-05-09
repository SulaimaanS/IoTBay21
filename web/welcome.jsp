<%@page import="iotb.model.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheets/MainStyle.css">
        <title>Welcome to IoTBay</title>
    </head>
    <% 
            User user = (User)session.getAttribute("user");
    %>
    <body>
        <div id="navContainer">
            <ul id="navbar">
                <li><a href="index.html">Home</a></li>
                <li><a href="mainpage.jsp">MainPage</a></li>
            </ul>
        </div>

        <div id="title">
            <h1>Welcome to IoTBay, ${currentUser.fName}!</h1>
        </div>

        <div id="info">
            <table id="infoTable">
                <tr><td>Name: </td><td>${user.fName} ${user.lName}</td></tr>
                <tr><td>Email: </td><td>${user.emailAddress}</td></tr>
                <tr><td>Password: </td><td>${user.password}</td></tr>
                <tr><td>Phone: </td><td>${user.phNumber}</td></tr>
            </table>
        </div>   

        <div id="footer">
            Copyright 2021, IoTBay Solutions 
        </div>
    </body>
    <jsp:include page="/ConnectionServlet" flush="true" />
</html>
