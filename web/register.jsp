<%-- 
    Document   : register
    Created on : 20/03/2021, 7:17:37 PM
    Author     : alaw8
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register to IoTBay</title>
    </head>
    
    <body>
        <h1>Register to IoTBay</h1>
        <form action="welcome.jsp" method="POST"> 
        <table id="register"; cellspacing="5px" cellpadding="5%"; align="left">
         <tr>    
                <td  align="right">First Name:</td>    
                <td class="style1"><input type="text" name="fname"/></td>    
         </tr>  
         <tr>    
                <td  align="right">Last Name:</td>    
                <td class="style1"><input type="text" name="lname"/></td>    
         </tr>
         <tr>    
                <td  align="right">Date of Birth:</td>    
                <td class="style1"><input type="date" name="dob"/></td>    
         </tr>
         <tr>    
                <td  align="right">Gender:</td>    
                <td class="style1">
                    <select id="gender" name="gender">
                        <option value="male">Male</option>
                        <option value="female">Female</option>
                        <option value="other">Other</option>
                    </select>
                </td>    
         </tr>
         <tr>    
                <td  align="right">Phone Number</td>    
                <td class="style1"><input type="tel" name="phonenum" placeholder="0xxxxxxxxx" pattern="[0-9]{10}" required/></td>    
         </tr> 
         <tr>    
                <td  align="right">Password:</td>    
                <td class="style1"><input type="password" name="password"/></td>    
         </tr>   
         <tr>    
                <td  align="right">Email:</td>    
                <td class="style1"><input type="text" name="email"/></td>    
         </tr> 
         <tr>    
                <td  align="right">Street Number:</td>    
                <td class="style1"><input type="number" name="email"/></td>    
         </tr>
         <tr>    
                <td  align="right">Street Name:</td>    
                <td class="style1"><input type="text" name="streetname"/></td>    
         </tr>  
         <tr>    
                <td  align="right">Post Code:</td>    
                <td class="style1"><input inputmode="numeric" name="postcode" pattern="[0-9]{4}"/></td>    
         </tr>
         <tr>
             <td align="center">
                 <input type="submit" value="Register">
             </td>
         </tr>
        </table>
        </form>
    </body>
</html>
