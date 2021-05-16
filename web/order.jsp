<%-- 
    Document   : order
    Created on : 20/03/2021, 7:21:57 PM
    Author     : alaw8
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="iotb.model.Order"%>
<%@page import="iotb.model.OrderLine"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order</title>
    </head>
    <%
        Order order = (Order)session.getAttribute("order");
        ArrayList<OrderLine> orderLine = (ArrayList<OrderLine>)session.getAttribute("orderLine");
        request.setAttribute("orderLine", orderLine);
     %>
     
     
    
    <body>
        <h1>Order</h1>
        
        <table>
            <tr>
                <td>Order ID: </td>
                <td>${order.orderID}</td>
            </tr>
            <tr>
                 <td>Product ID: </td>
                <td>${order.productID}</td>
            </tr>
            <tr>
                 <td>Quantity: </td>
                <td>${order.productQuantity}</td>
            </tr>
        </table>
    </body>
</html>
