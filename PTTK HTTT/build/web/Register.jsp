<%--
    Document   : Register
    Created on : Dec 4, 2020, 2:23:09 AM
    Author     : tatth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đăng kí thành viên</title>
    </head>


    <body>
        <% String msg = (String) request.getAttribute("msg");%>
        <form action="addRegisterUser" method="post">
            <input type="text" name="email" value="" placeholder="Nhập email">
              <input type="text" name="cfEmail" value="Nhập lại email">
              <input type="password" name="cfEmail" value="" placeholder="Nhập lại email">
              <input type="password" name="password" value="" placeholder="Nhập mật khẩu">
              <input type="submit" name="Register" value="">
        </form>
    </body>
</html>
