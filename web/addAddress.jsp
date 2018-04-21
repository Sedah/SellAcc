<%-- 
    Document   : addAddress
    Created on : Apr 21, 2018, 2:58:24 PM
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
        <h1>Please Enter Your Address</h1>
        <form class="form" action="addAddress" method="POST">
            <div class="form-group">

                <div class="form-group">
                    <input class="form-control" id="address" type="text" name="province" placeholder="Province"/>
                </div>
                <div class="form-group">
                    <input class="form-control" id="district" type="text" name="district" placeholder="District"/>
                </div>
                <div class="form-group">
                    <input class="form-control" id="Home" type="text" name="h_num" placeholder="House number"/>
                </div>
                <div class="form-group">
                    <input class="form-control" id="street" type="text" name="street" placeholder="Street"/>
                </div>
                <div class="form-group">
                    <input class="form-control" id="area" type="text" name="area" placeholder="area"/>
                </div>

                <div class="form-group">
                    <input class="form-control" id="ZIP-Code" type="text" name="postcode" placeholder="ZIP-Code"/>
                </div>
                <div class="form-group">
                    <br><button class="btn btn-b btn-round" type="submit">Submit</button> 
                </div>
        </form>
    </body>
</html>
