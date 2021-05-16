<%-- 
    Document   : deleteCustomerRecords
    Created on : 16/05/2021, 5:26:46 AM
    Author     : timmy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="stylesheets/MainStyle.css">
        <title>Delete Customer Page</title>
    </head>
    <body>
        <div id="navContainer">
            <ul id="navbar">
                <li><a href="index.html">Home</a></li>
                <li><a href="createCustomerRecords.jsp">Create</a></li>
                <li><a href="deleteCustomerRecords.jsp">Read</a></li>
                <li><a href="updateCustomerRecords.jsp">Update</a></li>
                <li><a href="deleteCustomerRecords.jsp">Delete</a></li>
                <li><a href="logout.jsp">Logout</a></li>
            </ul>
        </div>

        <%
            String existErr = (String) session.getAttribute("existErr");
            String firstnameErr = (String) session.getAttribute("firstnameErr");
            String lastnameErr = (String) session.getAttribute("lastnameErr");
            String emailErr = (String) session.getAttribute("emailErr");
            String passErr = (String) session.getAttribute("passErr");
            String updated = (String) session.getAttribute("updated");
        %>

        <h1>Fill in the form to delete customer record</h1>
        <form action="CustomerInformationManagementAddServlet" method="post">
            <table> 
                <tr><td>Email address</td><td><input type="text" placeholder="Enter email address" name="email" required="true"/></td></tr>
                <tr>
                    <td>
                        <input type="submit" value="Add">
                    </td>
                    <td> <a href="customerInformationManagement.jsp"> Cancel </a></td>
                </tr>
            </table>
        </form>
        <h1> <%=(updated != null ? updated : "")%> </h1>
    </body>
    <div id="footer">
        Copyright 2021, IoTBay Solutions 
    </div>
</html>
