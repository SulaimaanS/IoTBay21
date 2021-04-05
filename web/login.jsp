<%-- 
    Document   : login
    Created on : 20/03/2021, 7:17:30 PM
    Author     : alaw8
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login to IoTBay</title>
    </head>
    <body>
        <h1>Log into IoTBay</h1>
        
        <table id="login"; cellspacing="5px" cellpadding="5%"; align="left">
         <tr>    
                <td  align="right">Email:</td>    
                <td class="style1"><input type="text" name="email" /></td>    
         </tr> 
         <tr>    
                <td  align="right">Password:</td>    
                <td class="style1"><input type="password" name="password"/></td>    
         </tr>   
         <tr>
             <td align="center">
                 <button type="button" onclick="location.href = 'mainpage.jsp'">Login</button>  
             </td>
         </tr>
        </table>
        
    </body>
</html>
