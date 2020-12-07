<%--
    Document   : gdTimTruyen
    Created on : Dec 6, 2020, 12:36:40 AM
    Author     : Admin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% ArrayList <Book> listBookFound = (ArrayList<Book>) session.getAttribute("listBookFound");
    ArrayList <Book> listBookChosen = (ArrayList<Book>) session.getAttribute("listBookChosen");
    String bookName = (String) session.getAttribute("bookName");
    if(bookName == null) bookName ="";%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tìm truyện</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <div class="container stuFo">
      <form class=" inputStudentName" action="/PTTK_HTTT/doTimTruyen.jsp" method="post">
        <h1 class = "addSV">Tìm truyện</h1>
        <table>
          <tr>
            <td><p>Nhập tên truyện: </p></td>
            <td><input type="text" name="bookName" value="<%=bookName %>" placeholder="Nhập tên truyện cần tìm"></td>
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
            <th>Năm xb</th>
            <th>Giá</th>
            <th>Mô tả</th>
            <th>Chọn</th>
          </tr>
          <% if(listBookFound!=null)
              for(int i = 0; i < listBookFound.size(); i++){%>
              <tr>
                <td><%=(i+1) %></td>
                <td><%=listBookFound.get(i).getName() %></td>
                <td><%=listBookFound.get(i).getYear() %></td>
                <td><%=listBookFound.get(i).getPrice() %></td>
                <td><%=listBookFound.get(i).getDescription() %></td>
                <td><a href="doChonTruyen.jsp?bookId=<%=listBookFound.get(i).getId()%>">Chọn</a></td>
              </tr>
              <% }%>
        </table>
      </form>
        <hr class = "horule">
        <p>Danh sách đã chọn</p>
      <form class="stuFoundForm" action="doChonTruyen.jsp" method="post">
          <table id="stuFound">
          <tr>
            <th>Thứ tự</th>
            <th>Tên</th>
            <th>Năm xb</th>
            <th>Giá</th>
            <th>Mô tả</th>
            <th>Xóa</th>
          </tr>
          <% if(listBookFound!=null)
              for(int i = 0; i < listBookChosen.size(); i++){%>
              <tr>
                <td><%=(i+1) %></td>
                <td><%=listBookChosen.get(i).getName() %></td>
                <td><%=listBookChosen.get(i).getYear() %></td>
                <td><%=listBookChosen.get(i).getPrice() %></td>
                <td><%=listBookChosen.get(i).getDescription() %></td>
                <td><a href="doXoaTruyen.jsp?bookId=<%=listBookChosen.get(i).getId()%>">Xóa</a></td>
              </tr>
              <% }%>
        </table>
        <a href="doXacNhanThueTruyen.jsp"><input type="button" name="goBack" value="Xác nhận thuê truyện"></a>
      </form>
        
    </div>
    </body>
</html>
