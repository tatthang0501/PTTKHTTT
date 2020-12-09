<%-- 
    Document   : doXacNhanTraTruyen
    Created on : Dec 8, 2020, 1:59:24 AM
    Author     : Admin
--%>

<%@page import="DAO.RentingBillDAO"%>
<%@page import="model.User"%>
<%@page import="model.Cashier"%>
<%@page import="model.RentingBill"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    RentingBill rentingBill = (RentingBill) session.getAttribute("rentingBill");
    System.out.println("id day " + rentingBill.getId());
    User user = (User) session.getAttribute("cashier");
//    User user = (User) session.getAttribute("client");
//    
    Cashier cashier = new Cashier();
    cashier.setId(user.getId());
    rentingBill.setCashier(cashier);
    rentingBill.setStatus(2);
    RentingBillDAO rbDAO = new RentingBillDAO();
    boolean rs = rbDAO.updateRentingBill(rentingBill);
    if(rs = true){
       response.sendRedirect("/PTTK_HTTT/gdChinhNVThuNgan.jsp");
       String billMsg = "Cập nhật hóa đơn thành công";
       session.setAttribute("billMsg", billMsg);
    }
    if(rs  == false){
        response.sendRedirect("/PTTK_HTTT/gdChiTietDonThue.jsp?err=fail");
//        String billMsg = "Cập nhật hóa đơn không thành công";
//       session.setAttribute("billMsg", billMsg);
    }
    session.removeAttribute("rentingBill");
    session.removeAttribute("listbookChosen");
    session.removeAttribute("listBookFound");
%>
