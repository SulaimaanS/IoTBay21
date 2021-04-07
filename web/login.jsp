
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <div id="title">
        <h1>Login to IoTBay</h1>
        </div>
        
        <div>
        <form action="welcome.jsp" method="post"> 
            <table id="login">
                <tr>    
                    <td  align="right">Email:</td>    
                    <td class="style1"><input type="text" name="email" required/></td>    
                </tr> 
                <tr>    
                    <td  align="right">Password:</td>    
                    <td class="style1"><input type="password" name="password" required/></td>    
                </tr>   
                <tr>
                    <td><input class="button" type="submit" value="Login"></td>
                </tr>
                <input type="hidden" name="login">
            </table>
        </form>
        </div>
        
        <div id="footer">
            sample footer text
        </div>
    </body>
</html>
