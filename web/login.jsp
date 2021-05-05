<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="stylesheets/MainStyle.css">
    </head>
    <body>      
        <div id="navContainer">
            <ul id="navbar">
                <li><a href="index.html">Home</a></li>
                <li><a href="register.jsp">Register</a></li>
            </ul>
        </div>

        <div id="title">
            <h1>Login to IoTBay</h1>
        </div>

        <div id="loginform">
            <form action="LoginServlet" method="post"> 
                <table id="loginTable">
                    <tr>    
                        <td  align="right">Email:</td>    
                        <td class="style1"><input type="text" name="email" required/></td>    
                    </tr> 
                    <tr>    
                        <td  align="right">Password:</td>    
                        <td class="style1"><input type="password" name="password" required/></td>    
                    </tr>                      
                    <tr>                       
                        <td colspan="2" id="submitButton"><input class="button" type="submit" value="Login"></td>
                    </tr>
                </table>
            </form>
        </div>
        <div id="footer">
            Copyright 2021, IoTBay Solutions 
        </div>
    </body>
</html>
