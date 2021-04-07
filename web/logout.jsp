
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="refresh" content="3; url=index.html" charset=UTF-8">
        <title>Logout</title>
    </head>
    <body>
        <div id="title">
            <h1>You have been logged out</h1>
            <%
                session.invalidate();
            %>
        </div>
            
        <div>
            <h2>You will be redirected in 3 seconds</h2>
            <h3> Click here to return to the homepage if not redirected</h3>
            <button onclick="location.href = 'index.html'">Redirect</button>
        </div>
        
        <div id="footer">
            sample footer text
        </div>
    </body>
</html>
