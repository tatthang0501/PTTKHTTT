<%--
    Document   : gdDangNhap
    Created on : Dec 5, 2020, 12:57:34 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đăng nhập hệ thống</title>
    </head>
    <% String registerMsg = (String) session.getAttribute("registerMsg");%>
    <body>
        <div class="container">
            <p>${registerMsg}</p>
            <% session.removeAttribute("registerMsg"); 
            registerMsg = "";%>
          <form class="loginForm" action="doDangNhap.jsp" method="post">
            <h1 class = >Đăng nhập vào hệ thống</h1>
            <table>
              <tr>
                <td>Nhập email: </td>
                <td><input type="text" name="email" value="" placeholder="Email"></td>
              </tr>
              <tr>
                <td>Nhập mật khẩu: </td>
                <td><input type="password" name="password" value="" placeholder="Mật khẩu"></td>
              </tr>
            </table>
            <input type="submit" name="" value="Đăng nhập">
            <a href="gdDangKiThanhVien.jsp">Đăng kí thành viên</a>
            <% String msg = (String) session.getAttribute("msg");%>
            <p>${msg}</p>
            <%  msg = "";
                session.removeAttribute("msg"); %>
          </form>
        </div>
    </body>
</html>
