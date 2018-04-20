<%-- 
    Document   : payment
    Created on : Apr 14, 2018, 10:39:55 AM
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
        <form action="paymentServlet">
            เลขที่ใบสั่งซื้อสินค้า <input type="text" name="order_id" value="" /> <br><br>
            วันที่โอน <input type="text" name="date" value="" />(ex. 2018-03-20)<br><br>
            เวลาที่โอน <input type="text" name="time" value="" /> (ex. 15:18:00)<br><br>
            จำนวนเงิน <input type="text" name="amount" value="" /><br><br>
            รูปสลิปการโอน <input type="text" name="image" value="" /> (โปรดอัพโหลดไฟล์ในเว็บฝากรูปต่างๆแล้วนำ url มาใส่)<br><br>
            <input type="submit" value="submit" />
        </form>
        <c:if test="${payment == 1}">
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script>swal("ไม่พบเลข order id นี้ โปรดตรวจสอบหมายเลขและกรอกใหม่อีกครั้ง");</script>  
    </c:if>
        <c:if test="${payment == 1}">
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script>swal("โปรดกรอกวันและเวลาให้ถูกต้องตามตัวอย่าง");</script>  
    </c:if>
    </body>
</html>
