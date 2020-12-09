<%-- 
    Document   : doChonKH
    Created on : Dec 7, 2020, 11:12:48 PM
    Author     : Admin
--%>

<%@page import="model.RentingBill"%>
<%@page import="DAO.RentingBillDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String id = request.getParameter("clientId");
    ArrayList<User> listClientFound = (ArrayList<User>) session.getAttribute("listClientFound");
    User user = new User();
    for(User u: listClientFound){
        if(u.getId().equals(id)){
            user = u;
            break;
        }
    }
    System.out.println(user.getId());
    session.setAttribute("clientChosen", user);
    RentingBillDAO rbDAO = new RentingBillDAO();
    ArrayList<RentingBill> listRentingBill = rbDAO.getListRentingBill(user);
    session.setAttribute("listRentingBill", listRentingBill);
    response.sendRedirect("/PTTK_HTTT/gdDonThueKhachHang.jsp");
%>
