<%@page import="iotb.model.dao.ProductManager"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="iotb.model.*" %>


<html>
    <head>
        <title>Landing</title>
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
                <li><a href="listproduct.jsp">Catalogue</a></li>
            </ul>
        </div>

        <div id="title">
              <h1>Catalogue</h1>
        </div>

        <div id="info">
        <a href="addproduct.jsp">Add Product</a>
        <a href="updateproduct.jsp">Update Product</a>
        <a href="removeproduct.jsp">Remove Product</a>      
        <a href="searchproduct.jsp">Search Product</a>      
        <a href="listproduct.jsp">List Products</a>      
        </div>
        <div id="info">
        </div>
        <jsp:include page="/ConnectionServlet" flush="true"/>
        <div id="footer">
            Copyright 2021, IoTBay Solutions 
        </div>
    </body>
</html>
