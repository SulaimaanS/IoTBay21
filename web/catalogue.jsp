<%@page import="iotb.model.dao.ProductManager"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="iotb.model.*" %>


<html>
    <head>
        <title>Products</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="stylesheets/MainStyle.css">
 
    </head>
    
    <body>
        <div id="navContainer">
            <ul id="navbar">
                <li><a href="index.jsp">Home</a></li>
                <li><a href="login.jsp">Login</a></li>
                <li><a href="register.jsp">Register</a></li>
                <li><a href="staffportal.jsp">Staff Portal</a></li>
                <li><a href="listproduct.jsp">Products</a></li>
            </ul>
        </div>

        <div id="title">
              <h1>Products</h1>
        </div>

        <div id="info">
        <div id="navContainer">
            <ul id="navbar">
                <li><a href="addproduct.jsp">Add a Product</a></li>
                <li><a href="updateproduct.jsp">Update a Product</a></li>
                <li><a href="removeproduct.jsp">Remove a Product</a></li>
                <li><form action="ListProductServlet" method="Post"> <input type="submit" value="List Products"></form></li>
            </ul>
        </div>
        <div id="info">

        </div>
        <div id="info">
        </div>
        <jsp:include page="/ConnectionServlet" flush="true"/>
        <div id="footer">
            Copyright 2021, IoTBay Solutions 
        </div>
    </body>
</html>
