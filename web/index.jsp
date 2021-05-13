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
        <title>Landing Page</title>
    </head>
    <body>
        <h1>Landing Page</h1>
        <a href="createPayment.jsp">Add Payment Information</a>
        <jsp:include page="/ConnectionServlet" flush="true"/>
    </body>
</html>
