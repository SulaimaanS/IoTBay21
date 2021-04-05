<%-- 
    Document   : welcome
    Created on : 20/03/2021, 7:17:43 PM
    Author     : alaw8
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to IoTBay</title>
        <% 
            String firstName = request.getParameter("firstname");
            String lastName = request.getParameter("lastname");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String dob = request.getParameter("dob");
            String gender = request.getParameter("gender");
            String phoneNumber = request.getParameter("phonenumber");            
            String steetNumber = request.getParameter("streetnumber");
            String streetName = request.getParameter("streetname");
            String postCode = request.getParameter("postcode");
        %>
    </head>
    <body>
        <h1>Welcome to IoTBay, <%=firstName%></h1>

        <table class="table">            
            <tr><td>Name:</td><td><%=firstName%> <%=lastName%></td></tr>
            <tr><td>Email:</td><td><%=email%></td></tr>
            <tr><td>Password:</td><td><%=password%></td></tr>
            <tr><td>Phone:</td><td><%=phoneNumber%></td></tr>
            <tr><td>Gender:</td><td><%=gender%></td></tr>
            <tr><td>Date of Birth:</td><td><%=dob%></td></tr>            
        </table>
    </body>
</html>
