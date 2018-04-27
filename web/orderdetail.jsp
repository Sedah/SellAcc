<%-- 
    Document   : orderdetail
    Created on : Apr 27, 2018, 3:03:59 PM
    Author     : Chronical
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        order_id = ${ord_s.order_id} buy date = ${ord_s.buy_date} 
        use point ${ord_s.use_point} receive point = ${ord_s.recieve_point} total price = ${ord_s.total_price}
         <table border="1">
            <thead>
                <tr>
                    <th>Item number</th>
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="ord" items="${ordlist}">
                    <tr> 
                        
                        <td>${ord.item_num} </td>
                        <td>${ord.accessory.name} </td>
                        <td>${ord.quentity}</td>
                        <td>${ord.price} </td>
                    </tr>
                </c:forEach>
        </tbody>
    </table>
    </body>
</html>
