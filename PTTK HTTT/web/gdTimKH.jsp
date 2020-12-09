<%-- 
    Document   : gdTimKH
    Created on : Dec 7, 2020, 8:18:39 PM
    Author     : Admin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.User"%>
<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<% ArrayList<User> listClientFound = (ArrayList<User>) session.getAttribute("listClientFound"); %>
<% String clientName = (String) session.getAttribute("clientName");
if(clientName == null) clientName = "";%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tìm khách hàng</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <div class="container stuFo">
      <form class=" inputStudentName" action="/PTTK_HTTT/doTimKH.jsp" method="post">
        <h1 class = "addSV">Tìm khách hàng</h1>
        <table>
          <tr>
            <td><p>Nhập tên khách hàng: </p></td>
            <td><input type="text" name="clientName" value="<%=clientName%>" placeholder="Nhập tên khách hàng"></td>
          </tr>
        </table>
        <input type="submit" name="findBook" value="Tìm">
      </form>
          <p>Danh sách tìm được</p>
      <form class="stuFoundForm" action="" method="post">
        <table id="stuFound">
          <tr>
            <th>Thứ tự</th>
            <th>Tên</th>
            <th>Giới tính</th>
            <th>Email</th>
            <th>SĐT</th>
            <th>Địa chỉ</th>
            <th>Chọn</th>
          </tr>
          <% if(listClientFound!=null)
              for(int i = 0; i < listClientFound.size(); i++){%>
              <tr>
                <td><%=(i+1) %></td>
                <td><%=listClientFound.get(i).getName().getFirstName() +" "+ listClientFound.get(i).getName().getMiddleName() +" "+ listClientFound.get(i).getName().getLastName()%></td>
                <td><%=listClientFound.get(i).getSex() %></td>
                <td><%=listClientFound.get(i).getAcc().getEmail() %></td>
                <td><%=listClientFound.get(i).getPhone() %></td>
                <td><%=listClientFound.get(i).getAddrs().get(0).getHouseNumber()+" "+listClientFound.get(i).getAddrs().get(0).getRoad()+" "+listClientFound.get(i).getAddrs().get(0).getAlley()+" "+listClientFound.get(i).getAddrs().get(0).getCity()%></td>
                <td><a href="doChonKH.jsp?clientId=<%=listClientFound.get(i).getId()%>">Chọn</a></td>
              </tr>
              <% }%>
        </table>
      </form>
        
    </div>
    </body>
</html>
