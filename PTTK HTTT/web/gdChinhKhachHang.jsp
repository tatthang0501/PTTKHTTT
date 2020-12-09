<%--
    Document   : gdChinhKhachHang
    Created on : Dec 5, 2020, 3:16:45 PM
    Author     : Admin
--%>

<%@page import="model.User"%>
<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Xin chào khách hàng</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
      <%String msg = (String) session.getAttribute("loginMsg");%>
      <%String rentingMsg = (String) session.getAttribute("rentingMsg");%>
        <h1>${msg}</h1>
        <p>${rentingMsg}</p>
        <a href="gdTimTruyen.jsp">Chọn truyện thuê trực tuyến</a>
        <a href="doDangXuat.jsp">Đăng xuất</a>
    </body>
</html>
