<%-- 
    Document   : gdChiTietDonThue
    Created on : Dec 8, 2020, 12:40:06 AM
    Author     : Admin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.RentedBook"%>
<%@page import="model.RentingBill"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    RentingBill rentingBill = (RentingBill) session.getAttribute("rentingBill");
    ArrayList<RentedBook> rentedBook = rentingBill.getRentedBook();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <div class="container stuFo">
            <h1>CHI TIẾT HÓA ĐƠN</h1>
            <form class="stuFoundForm" action="" method="post">
                <table id="stuFound">
                    <tr>
                        <th>ID</th>
                        <th>Ngày thuê</th>
                        <th>Mô tả</th>
                        <th>Tiền cọc</th>
                        <th>Tổng tiền</th>
                    </tr>
                    <% if (rentingBill != null)%>
                    <tr>
                        <td><%= rentingBill.getId() %></td>
                        <td><%= rentingBill.getRentDate()%></td>
                        <td><%= rentingBill.getDescription()%></td>
                        <td><%= rentingBill.getDeposit()%></td>
                        <td><%= rentingBill.getRentFee()%></td>
                    </tr>
                </table>

            </form>
            <hr>

            <h1>CÁC TRUYỆN ĐÃ ĐĂNG KÍ THUÊ TRỰC TUYẾN</h1>
            <form class="stuFoundForm" action="" method="post">
                <table id="stuFound">
                    <tr>
                        <th>Tên</th>
                        <th>Năm xb</th>
                        <th>Tác giả</th>
                        <th>Thể loại</th>
                        <th>Giá</th>
                        <th>Mô tả</th>
                        <th>Xóa</th>
                    </tr>
                    <% for (int i = 0; i < rentedBook.size(); i++) {%>
                    <tr>
                        <td><%= rentedBook.get(i).getBook().getName()%></td>
                        <td><%= rentedBook.get(i).getBook().getYear()%></td>
                        <td><%= rentedBook.get(i).getBook().getAuthor().get(0).getAuthor().getName()%></td>
                        <td><%= rentedBook.get(i).getBook().getCate().get(0).getCate().getName()%></td>
                        <td><%= rentedBook.get(i).getBook().getPrice()%></td>
                        <td><%= rentedBook.get(i).getBook().getDescription()%></td>
                        <td><a href="doXoaTruyenThem.jsp?bookId=<%=rentedBook.get(i).getBook().getId() %>">Xóa</a></td>
                    </tr>
                    <%}%>
                </table> 
            </form>
            <a href="gdDonThueKhachHang.jsp"><input type="button" name="goBack" value="Quay lại"></a>
            <a href="gdTimTruyenThem.jsp"><input type="button" name="goBack" value="Thêm truyện"></a>
            <a href="doXacNhanTraTruyen.jsp"><input type="button" name="goBack" value="Xác nhận trả truyện"></a>
        </div>
    </body>
</html>
