<%-- 
    Document   : viewCart
    Created on : Apr 10, 2018, 3:47:11 PM
    Author     : Chronical
--%>

<%@page import="model.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Selected Accessories in Cart</h1>
        <% 
            Cart cart = (Cart) session.getAttribute("cart");
        %>
        <c:forEach var="acc" items="${cart.accs}">
             ${acc.accessory.name} <br>   
             ${acc.price} <br>  
             ${acc.quentity} <br>  ${acc.amount}
        </c:forEach> <br>
        <h1> Total ${cart.total} Bath </h1>
             
    </body>
</html>
