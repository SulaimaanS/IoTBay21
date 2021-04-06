<%@page import="iotb.model.User" %>
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
            String streetNumber = request.getParameter("streetnumber");
            String streetName = request.getParameter("streetname");
            String postCode = request.getParameter("postcode");
            String tempID = "1";

        %>
        <%
                User currentUser = new User(tempID, firstName, lastName, email, password, dob, gender, phoneNumber, streetNumber, streetName, postCode);
                session.setAttribute("currentUser", currentUser);      
        %>
    </head>
    <body>
        <div>
            <h1>Welcome to IoTBay, ${currentUser.fName}!</h1>
        </div>

        <div>
            <table class="table">            
                <tr><td>Email: </td><td>${currentUser.emailAddress}</td></tr>
                <tr><td>Phone: </td><td>${currentUser.phNumber}</td></tr>
                <tr><td>Gender: </td><td>${currentUser.gender}</td></tr>
                <tr><td>Date of Birth: </td><td>${currentUser.dob}</td></tr>            
            </table>
        </div>        

    </body>
</html>
