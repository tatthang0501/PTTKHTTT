<%-- 
    Document   : gdDonThueKhachHang
    Created on : Dec 7, 2020, 11:21:17 PM
    Author     : Admin
--%>

<%@page import="model.RentingBill"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đơn thuê khách hàng</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <%ArrayList<RentingBill> listRentingBill = (ArrayList<RentingBill>) session.getAttribute("listRentingBill");%>
    <body>
        <div class="container stuFo">
            <p>Danh sách hóa đơn</p>
      <form class="stuFoundForm" action="" method="post">
        <table id="stuFound">
          <tr>
            <th>Thứ tự</th>
            <th>Ngày lên hóa đơn</th>
            <th>Số tiền thuê</th>
            <th>Mô tả</th>
            <th>Trạng thái</th>
            <th>Chọn</th>
          </tr>
          <% if(listRentingBill!=null)
              for(int i = 0; i < listRentingBill.size(); i++){%>
              <tr>
                <td><%=(i+1) %></td>
                <td><%=listRentingBill.get(i).getRentDate() %></td>
                <td><%=listRentingBill.get(i).getRentFee() %></td>
                <td><%=listRentingBill.get(i).getDescription() %></td>
                <td><%=listRentingBill.get(i).getStatus() %></td>
                <td><a href="doChonDon.jsp?billId=<%=listRentingBill.get(i).getId()%>">Chọn</a></td>
              </tr>
              <% }%>
        </table>
      </form>
        
    </div>
    </body>
</html>
