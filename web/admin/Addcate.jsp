<%-- 
    Document   : Addcate
    Created on : Apr 16, 2018, 5:43:53 PM
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
        Select category : <select name="cate_id">
            <form action="UpdateServlet">
                Select your Category : <select name="cate_id">
                <c:forEach var="cat" items="${cat_list}">
                    <option value=${cat.cate_id}>
                        ${cat.name}
                    </option>
                    </c:forEach> 
            </select>
                    <input type="submit" value="add" />
            </form>
                
    </body>
</html>
