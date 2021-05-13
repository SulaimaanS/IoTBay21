<%@page import="iotb.model.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheets/MainStyle.css">
        <title>Main Page</title>
        <% 
            User currentUser = (User)session.getAttribute("currentUser");
        %>
    </head>

    <body>
        <%
            if (session.getAttribute("currentUser") != null)
            {
        %>
        <div id="navContainer">
            <ul id="navbar">
                <li><a href="index.html">Home</a></li>
                <li><a href="welcome.jsp">Welcome</a></li>
                <li><a href="logout.jsp">Logout</a></li>
        </div>

        <div id="title">
            <h1>MainPage</h1>
        </div>

        <div id="info">
            <table id="infoTable">
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Address</th>
                    <td>
                </tr>
                <tr>
                    <td>
                        ${currentUser.fName} ${currentUser.lName}
                    </td>
                    <td>
                        ${currentUser.emailAddress}
                    </td>
                    <td>${currentUser.streetNumber} ${currentUser.streetName}, ${currentUser.postCode}</td>
                </tr>
            </table>
        </div>    

        <% } else { %>

        <h2>You are not logged in</h2>
        <input type=button onClick="location.href = 'index.html'"
               value="Home">
        <%}%>

        <div id="footer">
            Copyright 2021, IoTBay Solutions 
        </div>
    </body>
</html>
