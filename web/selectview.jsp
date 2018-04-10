<%-- 
    Document   : viewacc
    Created on : Mar 31, 2018, 1:06:34 PM
    Author     : Chronical
--%>

<%@page import="model.Accessory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
            <c:forEach var="acc" items="${acc_list}">
                <form action="ProcessSelection">
                <a href="/SellAcc/viewAcc?id=${acc.acc_id}">Acc1</a>
                ${acc.name} <br>  
                ${acc.description} <br>   
                ${acc.price} <br>   
                ${acc.image} <br>   
                quentity <input type="text" name="quentity" value="" /> <br>
                <input type="submit" name ="add" value="Add" /> <br>
                <input type="hidden" name="acc_id" value=${acc.acc_id} />
                </form>
            </c:forEach> 
                
        


    </body>
</html>
