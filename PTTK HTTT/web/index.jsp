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
        <title>Quản lý cửa hàng cho thuê truyện</title>
        <link rel="stylesheet" href="styles.css">
    </head>

    <body>
        <% String msg = (String) request.getAttribute("msg");%>
        <p>${msg}</p>
        <a href="gdDangKiThanhVien.jsp">Đăng kí thành viên</a>
        <a href="gdDangNhap.jsp">Đăng nhập</a>
    </body>
</html>
