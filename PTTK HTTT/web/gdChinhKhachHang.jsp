<%--
    Document   : gdChinhKhachHang
    Created on : Dec 5, 2020, 3:16:45 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      <%String msg = (String) session.getAttribute("msg");%>
        <h1>${msg}</h1>
        <a href="gdTimTruyen.jsp">Chọn truyện thuê trực tuyến</a>
    </body>
</html>
