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
        <form action="addressServlet">
        <c:forEach var="acc" items="${cart.accs}">
             ${acc.accessory.name} <br>   
             ${acc.price} <br>  
             ${acc.quentity} <br>  ${acc.amount}
        </c:forEach> <br>
        <h1> Total ${cart.total} Bath </h1>
        <c:if test="${sessionScope.username != null}">
            <h1>Get Point ${cart.point} </h1>
             Use Point <input type="text" name="use_point" value="" />
        </c:if>
        <input type="submit" value="Buy" />
        </form>
      <c:if test="${e_point == 1}">
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script>swal("You didn't have enough point");</script>  
    </c:if>
        <c:if test="${e_point == 2}">
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script>swal("Point can't be negative number");</script>  
    </c:if>
        <c:if test="${e_point == 3}">
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script>swal("Total price can't be negative number please enter use point same amount with total price");</script>  
    </c:if>
    </body>
</html>