<%-- 
    Document   : doXoaTruyenThem
    Created on : Dec 8, 2020, 1:38:10 AM
    Author     : Admin
--%>

<%@page import="DAO.RentedBookDAO"%>
<%@page import="model.Book"%>
<%@page import="model.RentedBook"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.RentingBill"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String bookId = request.getParameter("bookId");
    RentingBill rentingBill = (RentingBill) session.getAttribute("rentingBill");
    ArrayList<RentedBook> rentedBook = rentingBill.getRentedBook();
    for(RentedBook rb: rentedBook){
        System.out.println(rb.getBook().getId());
    }
    for (RentedBook b : rentedBook) {
        if (b.getBook().getId() == Integer.parseInt(bookId)) {
            System.out.println(b.getBook().getId());
            rentedBook.remove(b);
            float rentFee = rentingBill.getRentFee() - b.getPrice();
            float deposit = rentingBill.getDeposit() - b.getBook().getPrice()*80/100;
            rentingBill.setRentFee(rentFee);
            rentingBill.setDeposit(deposit);
            RentedBookDAO rbDAO = new RentedBookDAO();
            rbDAO.deleteRentedBook(b);
            break;
        }
    }
    rentingBill.setRentedBook(rentedBook);
    session.setAttribute("rentingBill", rentingBill);
    response.sendRedirect("/PTTK_HTTT/gdChiTietDonThue.jsp");
%>
