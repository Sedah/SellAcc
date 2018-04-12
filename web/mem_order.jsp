<%-- 
    Document   : mem_order
    Created on : Apr 12, 2018, 4:17:08 PM
    Author     : Chronical
--%>

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
        <h1> Enter your address</h1>
        <form action="addOrder">
            Select your address : <select name="add_id">
                <c:forEach var="add" items="${add_list}">
                    <option value=${add.add_id}>${add.province} ${add.district} ${add.house_num}
                        ${add.street} ${add.area} ${add.postcode}</option>
                    </c:forEach> 
            </select>
            <input type="submit" value="Submit" />
        </form>


    </body>
</html>
