<%-- 
    Document   : profile
    Created on : Apr 27, 2018, 1:48:09 PM
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
        total point = ${point}
        
        <table border="1">
            <thead>
                <tr>
                    <th>Order ID</th>
                    <th>Buy Date</th>
                    <th>Status</th>
                    <th>Use point</th>
                    <th>Receive point</th>
                    <th>Total price</th>
                    <th>Address</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <c:forEach var="ord" items="${ordlist}">
                    <tr>
                        <td>${ord.order_id} </td>
                        <td>${ord.buy_date} </td>
                        <td> <c:set var = "status" scope = "session" value = "${ord.status}"/>
                            <c:choose>

                                <c:when test = "${ord.status == 'wait_verify'}">
                                    รอการชำระเงิน
                                </c:when>

                                <c:when test = "${ord.status == 'verify_pass'}">
                                    ชำระเงินสำเร็จ
                                </c:when>
                                <c:when test = "${ord.status == 'verify_not_pass'}">
                                    ชำระเงินผิดพลาด
                                </c:when>
                                <c:when test = "${ord.status == 'send'}">
                                    จัดส่งแล้ว
                                </c:when>
                                <c:when test = "${ord.status == 'cancle'}">
                                    ถูกยกเลิก
                                </c:when>

                                <c:otherwise>
                                    No comment sir...
                                </c:otherwise>
                            </c:choose></td>
                        <td>${ord.use_point} </td>
                        <td>${ord.recieve_point} </td>
                        <td>${ord.total_price}</td>
                        <td>${ord.address}</td>
                        <td><a href="vieworder?ord_id=${ord.order_id}" > View </a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
