<%-- 
    Document   : gdChiTietTruyen
    Created on : Dec 7, 2020, 12:35:11 AM
    Author     : Admin
--%>

<%@page import="model.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    Book book = (Book) session.getAttribute("fullBook");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chi Tiết Truyện</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <div class="container stuFo">
      

      <form class="stuFoundForm" action="" method="post">
        <table id="stuFound">
          <tr>
            <th>Tên</th>
            <th>Năm xb</th>
            <th>Tác giả</th>
            <th>Thể loại</th>
            <th>Giá</th>
            <th>Mô tả</th>
            <th>Thêm</th>
          </tr>
          <% if(book!=null)%>
              <tr>
                <td><%= book.getName()%></td>
                <td><%= book.getYear() %></td>
                <td><%= book.getAuthor().get(0).getAuthor().getName() %></td>
                <td><%= book.getCate().get(0).getCate().getName() %></td>
                <td><%= book.getPrice() %></td>
                <td><%= book.getDescription() %></td>
                <td><a href="doThemTruyenThem.jsp?bookId=<%=book.getId()%>">Thêm</a></td>
              </tr>
              <a href="gdTimTruyenThem.jsp">Quay lại</a>
        </table>
    </div>
    </body>
</html>
