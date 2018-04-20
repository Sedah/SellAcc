<%-- 
    Document   : AddProduct
    Created on : Apr 16, 2018, 5:00:55 PM
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
        <form action="UpdateServlet">
            Description :<input type="text" name="desp" value="" /> <br><br>
            Price : <input type="text" name="price" value="" /> <br><br>
            Image URL : <input type="text" name="image" value="" /> <br><br>
            <input type="submit" value="Submit" />
        </form>
    </body>
</html>
