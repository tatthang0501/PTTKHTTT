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
        <link rel="stylesheet" href="styles.css">
    </head>


    <body>
        <% String msg = (String) request.getAttribute("registerMsg");%>
        <p> ${msg}</p>
        <% session.removeAttribute("registerMsg"); %>
        <div class="container">
          <form class="loginForm" action="doDangKiThanhVien.jsp" method="post">
            <table>
              <tr>
                  <td><p>Email</p></td>  
                <td><input type="text" name="email" value="" placeholder="Nhập email"></td>
              </tr>
              <tr>
                  <td><p>Nhập lại email</p></td>
                <td><input type="text" name="cfEmail" value="" placeholder="Nhập lại email"></td>
              </tr>
              <tr>
                  <td><p>Nhập mật khẩu</p></td>
                <td><input type="password" name="password" value="" placeholder="Nhập mật khẩu"></td>
              </tr>
              <tr>
                  <td><p>Nhập lại mật khẩu</p></td>
                <td><input type="password" name="cfPassword" value="" placeholder="Nhập lại mật khẩu"></td>
              </tr>
              <tr>
                  <td><p>Nhập họ</p></td>
                <td><input type="text" name="firstName" value="" placeholder="Nhập họ"></td>
              </tr>
              <tr>
                  <td><p>Nhập đệm</p></td>
                <td><input type="text" name="middleName" value="" placeholder="Nhập đệm"></td>
              </tr>
              <tr>
                  <td><p>Nhập tên</p></td>
                <td><input type="text" name="lastName" value="" placeholder="Nhập tên"></td>
              </tr>
              <tr>
                  <td><p>Nhập giới tính</p></td>
                <td><input type="number" name="sex" value="" placeholder="1: Nam/ 2: Nữ"></td>
              </tr>
              <tr>
                  <td><p>Nhập số nhà</p></td>
                <td><input type="text" name="houseNumber" value="" placeholder="Nhập số nhà"></td>
              </tr>
              <tr>
                  <td><p>Nhập ngõ</p></td>
                <td><input type="text" name="alley" value="" placeholder="Ngõ"></td>
              </tr>
              <tr>
                  <td><p>Nhập đường</p></td>
                <td><input type="text" name="road" value="" placeholder="Đường"></td>
              </tr>
              <tr>
                  <td><p>Nhập quận</p></td>
                <td><input type="text" name="district" value="" placeholder="Quận"></td>
              </tr>
              <tr>
                  <td><p>Nhập thành phố</p></td>
                <td><input type="text" name="city" value="" placeholder="Thành phố"></td>
              </tr>
              <tr>
                  <td><p>Nhập ngày sinh</p></td>
                <td><input type="Date" name="DOB" value=""></td>
              </tr>
              <tr>
                  <td><p>Nhập số điện thoại</p></td>
                <td><input type="text" name="phoneNumber" value="" placeholder="Số điện thoại"></td>
              </tr>
            </table>
              <input type="submit" name="Register" value="Đăng kí">
              <input type="reset" name="Reset" value="Xóa tất cả">
          </form>
        </div>
    </body>
</html>
