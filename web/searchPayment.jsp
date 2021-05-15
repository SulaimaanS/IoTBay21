<%-- 
    Document   : searchPayment
    Created on : 15/05/2021, 1:07:07 PM
    Author     : 1234
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheets/interface.css">
        <title>Search Payment Record</title>
    </head>
    <body>
        
        <%
            String existErr = (String) session.getAttribute("existErr");
            String paymentDateErr = (String) session.getAttribute("paymentDateErr");
            String searchedpaymentID = (String) session.getAttribute("searchedpaymentID");
            String orderID = (String) session.getAttribute("orderID");
            String paymentType = (String) session.getAttribute("paymentType");
            String searchedpaymentDate = (String) session.getAttribute("searchedpaymentDate");
        %>
        
        <ul>
            <li><a href="main.jsp">IoTBay</a></li>
            <li><a href="main.jsp">Main</a></li>
            <li><a href="LogoutServlet">Logout</a></li>
        </ul>
        
        <h1>Search Payment Record</h1>
        <span><%=(paymentDateErr != null ? paymentDateErr : "")%></span>
        <span><%=(existErr != null ? existErr : "")%></span>
        <form method="post" action="SearchPaymentServlet">
            <table>
                <td>Search Payment History: </td>
                <td><input type="text" placeholder="" name="paymentID"></td>
                <td><input type="date" name="paymentDate"></td>
                <td><input type="submit" value="Search"> </td>
            </table>
        </form>
        
        <table class="records">
            <tr><th>Payment ID</th><th>Order ID</th><th>Payment Type</th><th>Payment Date</th></tr>
            <tr>
                <td><%=(searchedpaymentID != null ? searchedpaymentID : "")%></td>
                <td><%=(orderID != null ? orderID : "")%></td>
                <td><%=(paymentType != null ? paymentType : "")%></td>
                <td><%=(searchedpaymentDate != null ? searchedpaymentDate : "")%></td>
            </tr>
        </table>
    </body>
    <footer>
            <p>IoTBay Solutions Pty Ltd</p>
        </footer>
</html>
