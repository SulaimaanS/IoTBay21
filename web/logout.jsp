
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
    </head>
    <body>
        <div id='title'>
            <h1>You have been logged out</h1>
            <%
                session.invalidate();
            %>
        </div>
        
        <div>
            <h2> Click here to return to the login screen</h2>
            <button>Return to login</button>
        </div>  
    </body>
</html>
