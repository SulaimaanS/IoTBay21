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
        <title>JSP Page</title>
        <% 
            String firstName = request.getParameter("name");
            String lastName = request.getParameter("email");
            String dob = request.getParameter("dob");
            String gender = request.getParameter("gender");
            String email = request.getParameter("password");
            String password = request.getParameter("favcol");
            String phoneNumber = request.getParameter("phonenum");            
            String steetNumber = request.getParameter("streetnumber");
            String streetName = request.getParameter("streetname");
            String postCode = request.getParameter("postcode");
    %>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
