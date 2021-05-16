<%@page import="iotb.model.dao.ProductManager"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="iotb.model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>Landing</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="stylesheets/MainStyle.css">
 
    <%
            ArrayList<Product> products = (ArrayList<Product>) session.getAttribute("products");
    %>
    </head>
    <body action="ListProductServlet">
        <div id="navContainer">
            <ul id="navbar">
                <li><a href="index.jsp">Home</a></li>
                <li><a href="login.jsp">Login</a></li>
                <li><a href="register.jsp">Register</a></li>
                <li><a href="staffportal.jsp">Staff Portal</a></li>
                <li><a href="catalogue.jsp">Catalogue</a></li>
            </ul>
        </div>

        <div id="title">
            <h1>Items for Sale</h1>
        </div>
        <div id="info">
        <table id="addProductTable">
            <tr>
                <td>Product Name</td>
                <td>Product Description</td>
                <td>Product Category</td>
                <td>Product Price</td>
                <td>Product Stock</td>
            </tr>
            <%
                if (products != null) {
                    for (Product p: products){
            %>
            <tr>
                <td><%=p.getProductName()%></td>
            </tr>
            <%}%>
        <%}%>
        </table>
        <jsp:include page="/ConnectionServlet" flush="true"/>
        </div>
        <div id="footer">
            Copyright 2021, IoTBay Solutions 
        </div>
    </body>
</html>
