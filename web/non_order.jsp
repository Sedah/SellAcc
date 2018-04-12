<%-- 
    Document   : non_order
    Created on : Apr 12, 2018, 7:07:09 PM
    Author     : Chronical
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="addOrder">
            name <input type="text" name="name" value="" /> <br>
            email <input type="text" name="email" value="" /> <br>
            address <br>
            province <input type="text" name="province" value="" /> <br>
            district <input type="text" name="district" value="" /> <br>
            house_num <input type="text" name="h_num" value="" /> <br>
            street <input type="text" name="street" value="" /> <br>
            area <input type="text" name="area" value="" /> <br>
            postcode <input type="text" name="postcode" value="" /> <br>
            
            <input type="submit" value="address" />
        </form>
    </body>
</html>
