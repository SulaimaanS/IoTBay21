<%-- 
    Document   : welcome
    Created on : 20/03/2021, 7:17:43 PM
    Author     : chris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
    </head>
    <body>
        <%
            String fname = request.getParameter("fname");
        %>
        <h1>Welcome, <%= fname %> </h1>
    </body>
</html>
