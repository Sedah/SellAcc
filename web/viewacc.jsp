<%-- 
    Document   : selecttoview
    Created on : Mar 31, 2018, 12:02:56 PM
    Author     : Chronical
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        ${acc.name} <br>  
        ${acc.description} <br>   
        ${acc.price} <br>   
        ${acc.image} <br> 

        <h1>Comment</h1>
        <c:forEach var="comm" items="${comm_list}">
        ${comm.name} <br>  
        ${comm.review} <br>   
        ${comm.date} <br>   
        </c:forEach> 
        <h1>Drop Comment</h1>
        <form action="commServlet" method="POST">
            name : <input type="text" name="name" value="" /> <br> <br>
            email : <input type="text" name="email" value="" /> (โปรดใช้อีเมลเดียวกับที่เคยสมัครสมาชิกหรือสั่งซื้อสินค้า)<br> <br>
            review : <textarea name="review" rows="8" cols="30"></textarea> <br> <br>
            <input type="hidden" name="acc_id" value="${acc.acc_id}" />
            <input type="submit" value="Submit" />
        </form>
    <c:if test="${param.value == 1}">
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script>swal("Comment Complete");</script>  
    </c:if>
    <c:if test="${param.value == 0}">
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script>swal("ไม่สามารถคอมเมนต์ได้ โปรดทำการสั่งซื้อสินค้าก่อนทำการคอมเมนต์");</script>  
    </c:if>

</body>
</html>
