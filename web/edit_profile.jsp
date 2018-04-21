<%-- 
    Document   : edit_profile
    Created on : Apr 21, 2018, 1:25:02 PM
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
        <h1>Edit Profile</h1>
        <form action="editPassword">
            Password <br> <br>
            please enter new password : <input type="password" name="new_pass" value="" /> <br> <br>
            please enter old password : <input type="password" name="old_pass" value="" /> <br> <br>
            <input type="submit" value="Save" />
        </form>
            Address
            <table border="1">
                <thead>
                    <tr>
                        <th>province</th>
                        <th>district</th>
                        <th>house_num</th>
                        <th>street</th>
                        <th>area</th>
                        <th>postcode</th>
                    </tr>
                </thead>
                <tbody>
                <form action="deleteAddress">
                    <c:forEach var="add" items="${addlist}">
                        <tr>
                            <td>${add.province} </td>
                            <td>${add.district} </td>
                            <td>${add.house_num}</td>
                            <td>${add.street} </td>
                            <td>${add.area} </td>
                            <td>${add.postcode}</td>
                        <input type="hidden" name="add_id" value="${add.add_id}" />
                            <td><input type="submit" value="delete" /></td>
                        </tr>
                    </c:forEach>
                </form>
                </tbody>
            </table>
            <a href="addAddress.jsp">Add new address</a>
            <c:if test="${password == 1}">
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script>swal("Password incorrect");</script>  
    </c:if>

    </body>
</html>
