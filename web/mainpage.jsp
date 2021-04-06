<%@page import="iotb.model.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheets/MainStyle.css">
        <title>Main Page</title>
        <% 
            User currentUser = (User)session.getAttribute("currentUser");
        %>
    </head>
    
    <body>
        <div id="title">
        <h1>Main Page</h1>
        </div>
            
        <div>
            <button type="button" onclick="location.href = 'logout.jsp'"> Logout</button>
        </div>
        <div>
            <table>
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Address</th>
                    <td>
                </tr>
                <tr>
                    <td>
                        ${currentUser.fName} ${currentUser.lName}
                    </td>
                    <td>
                        ${currentUser.emailAddress}
                    </td>
                    <td>${currentUser.streetNumber} ${currentUser.streetName}, ${currentUser.postCode}</td>
                </tr>
            </table>
        </div>
                
        <div id="footer">
            sample footer text
        </div>
    </body>
</html>
