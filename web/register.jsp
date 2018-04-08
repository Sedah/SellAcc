<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form action="/register/registerServlet" method="POST">
            register <br>
            username <input type="text" name="user" value="" /> <br>
            password <input type="text" name="pass" value="" /> <br>
            name <input type="text" name="name" value="" /> <br>
            email <input type="text" name="mail" value="" /> <br>
            add <br>
            province <input type="text" name="province" value="" /> <br>
            district <input type="text" name="district" value="" /> <br>
            house_num <input type="text" name="h_num" value="" /> <br>
            street <input type="text" name="street" value="" /> <br>
            area <input type="text" name="area" value="" /> <br>
            postcode <input type="text" name="postcode" value="" /> <br>
            <input type="submit" value="regis" />
        </form>
    <c:if test="${flag == 1}">
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script>swal("Username or Email has already used");</script>  
    </c:if>






</body>
</html>
