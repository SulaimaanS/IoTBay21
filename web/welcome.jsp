<%@page import="iotb.model.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheets/MainStyle.css">
        <title>Welcome to IoTBay</title>

        <%
            String tempID = "1";
            String fName = request.getParameter("firstname");
            String lName = request.getParameter("lastname");
            String emailAddress = request.getParameter("email");
            String password = request.getParameter("password");
            String dob = request.getParameter("dob");
            String gender = request.getParameter("gender");
            String phNumber = request.getParameter("phonenumber");
            String streetNumber = request.getParameter("streetnumber");
            String streetName = request.getParameter("streetname");
            String postCode = request.getParameter("postcode");
        %>
        <%
            User currentUser = new User(tempID, fName, lName, emailAddress,
                    password, dob, gender, phNumber, streetNumber,
                    streetName, postCode);
            session.setAttribute("currentUser", currentUser);
        %>
    </head>
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
                <tr><td>Name: </td><td>${currentUser.fName} ${currentUser.lName}</td></tr>
                <tr><td>Email: </td><td>${currentUser.emailAddress}</td></tr>
                <tr><td>Password: </td><td>${currentUser.password}</td></tr>
                <tr><td>Date of Birth: </td><td>${currentUser.dob}</td></tr>
                <tr><td>Gender: </td><td>${currentUser.gender}</td></tr>
                <tr><td>Phone: </td><td>${currentUser.phNumber}</td></tr>
                <tr><td>Address: </td><td>${currentUser.streetNumber} ${currentUser.streetName}, ${currentUser.postCode}</td></tr>   
            </table>
        </div>   

        <div id="footer">
            Copyright 2021, IoTBay Solutions 
        </div>
    </body>
    <jsp:include page="/ConnectionServlet" flush="true" />
</html>
