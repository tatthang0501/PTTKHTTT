<%-- 
    Document   : gdChinhNVThuNgan
    Created on : Dec 5, 2020, 3:17:00 PM
    Author     : Admin
--%>

<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Xin chào nhân viên thu ngân</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <h1>${loginMsg}</h1>
        <p>${billMsg}</p>
        <a href="gdTimKH.jsp">Trả truyện cho khách hàng</a>
        <a href="doDangXuat.jsp">Đăng xuất</a>
    </body>
</html>
