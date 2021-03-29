<%-- 
    Document   : mainpage
    Created on : 28/03/2021, 10:46:11 PM
    Author     : razor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheets/MainStyle.css">
        <title>Main Page</title>
        <% 
            String firstName = request.getParameter("fname");
            String lastName = request.getParameter("lname");
            String dob = request.getParameter("dob");
            String gender = request.getParameter("gender");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String phoneNumber = request.getParameter("phonenum");            
            String steetNumber = request.getParameter("streetnumber");
            String streetName = request.getParameter("streetname");
            String postCode = request.getParameter("postcode");
        %>
    </head>
    
    <body>
        <div id="title">
        <h1>IoTBay</h1>
        </div>
            
        <div id="prebody">
            <h2> Hi, <%=email%></h2>
            <button type="button" onclick="location.href = 'logout.jsp'"> Logout To Home Page</button>
        </div>
        
        <div id="body">
            <table>
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <td>
                </tr>
                <tr>
                    <td>
                        <%=firstName%> <%=lastName%>
                    </td>
                    <td>
                        <%=email%>
                    </td>
                </tr>
            </table>
        </div>
        
        <div id="footer">
            sample footer text
        </div>
    </body>
</html>
