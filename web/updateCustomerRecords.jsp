<%-- 
    Document   : updateCustomerRecords
    Created on : 16/05/2021, 5:27:07 AM
    Author     : timmy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="stylesheets/MainStyle.css">
        <title>Update Customer Record Page</title>
    </head>
    
    <% 
            String existErr = (String) session.getAttribute("existErr");
            String firstnameErr = (String) session.getAttribute("firstnameErr");
            String lastnameErr = (String) session.getAttribute("lastnameErr");
            String emailErr = (String) session.getAttribute("emailErr");
            String passErr = (String) session.getAttribute("passErr");
            String updated = (String) session.getAttribute("updated");
        %>
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
        <h1>Fill in the form to update customer record</h1>
        <form action="CustomerInformationManagementAddServlet" method="post">
            <table> 
            <tr><td>First Name</td><td><input type="text" placeholder="Enter first name" name="fName" required="true"/></td></tr>
            <tr><td>Last Name</td><td><input type="text" placeholder="Enter last name" name="lName" required="true"/></td></tr>
            <tr><td>Date of birth</td><td><input type="text" placeholder="Enter date of birth" name="dob" required="true"/></td></tr>
            <tr><td>Gender</td><td><input type="text" placeholder="Enter gender" name="gender" required="true"/></td></tr>
            <tr><td>Email address</td><td><input type="text" placeholder="Enter email address" name="email" required="true"/></td></tr>
            <tr><td>Password</td><td><input type="text" placeholder="Enter password" name="password" required="true"/></td></tr>  
            <tr><td>Phone number</td><td><input type="text" placeholder="Enter phone number" name="phone" required="true"/></td></tr>   
            <tr><td>Street number</td><td><input type="text" placeholder="Enter street number" name="streetNumber" required="true"/></td></tr>
            <tr><td>Street name</td><td><input type="text" placeholder="Enter street name" name="streetName" required="true"/></td></tr>
            <tr><td>Post code</td><td><input type="text" placeholder="Enter post code" name="postCode" required="true"/></td></tr>
            <tr>
                <td>
                    <input type="submit" value="Add">
                </td>
                <td> <a href="customerInformationManagement.jsp"> Cancel </a></td>
            </tr>
            </table>
        </form>
    </body>
    <div id="footer">
        Copyright 2021, IoTBay Solutions 
    </div>
</html>
