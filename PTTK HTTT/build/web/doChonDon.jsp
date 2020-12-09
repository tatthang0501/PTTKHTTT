<%-- 
    Document   : doChonDon
    Created on : Dec 8, 2020, 12:40:44 AM
    Author     : Admin
--%>

<%@page import="model.RentingBill"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String billId = request.getParameter("billId");
    ArrayList<RentingBill> listRentingBill = (ArrayList<RentingBill>) session.getAttribute("listRentingBill");
    RentingBill rentingBill = new RentingBill();
    for(RentingBill r: listRentingBill){
        if(r.getId() == Integer.parseInt(billId)){
            rentingBill = r;
            break;
        }
    }
    System.out.println(rentingBill.getId());
    session.setAttribute("rentingBill", rentingBill);
    response.sendRedirect("/PTTK_HTTT/gdChiTietDonThue.jsp");
%>
