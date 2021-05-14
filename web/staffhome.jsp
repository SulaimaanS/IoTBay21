<%@page import="iotb.model.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% 
            User user = (User)session.getAttribute("user");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheets/MainStyle.css">
        <title>Staff Home</title>
    </head>
    

    <body>
        <%
            if (session.getAttribute("user") != null)
            {
        %>
        <div id="navContainer">
            <ul id="navbar">
                <li><a href="index.html">Home</a></li>
                <li><a href="updatestaff.jsp">Edit Profile</a></li>
                <li><a href="logout.jsp">Logout</a></li>
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

        <% } else { %>

        <h2>You are not logged in</h2>
        <input type=button onClick="location.href = 'index.html'"
               value="Home">
        <%}%>

        <form action="DeleteStaffServlet" method="Post">
            <input type="submit" value="Delete Account">
        </form>
        
        <div id="footer">
            Copyright 2021, IoTBay Solutions 
        </div>
    </body>
    <jsp:include page="/ConnectionServlet" flush="true" />
</html>