<%-- 
    Document   : doXacNhanThueTruyen
    Created on : Dec 7, 2020, 12:56:05 PM
    Author     : Admin
--%>

<%@page import="DAO.RentedBookDAO"%>
<%@page import="java.util.Collections"%>
<%@page import="model.User"%>
<%@page import="DAO.RentingBillDAO"%>
<%@page import="model.Client"%>
<%@page import="model.RentedBook"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Book"%>
<%@page import="model.RentingBill"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
   RentingBill rentingBill = (RentingBill) session.getAttribute("rentingBill");
   ArrayList<RentedBook> rentedBook = rentingBill.getRentedBook();
   ArrayList <Book> listBookChosen = (ArrayList<Book>) session.getAttribute("listBookChosen");
   ArrayList<RentedBook> listRBNew = new ArrayList<RentedBook>();
   float rentingBillRentFee = rentingBill.getRentFee();
   System.out.println(rentingBillRentFee);
   float rentingBillDeposit = rentingBill.getDeposit();
   System.out.println(rentingBillDeposit);
   for(Book b:listBookChosen){
       RentedBook r = new RentedBook();
       r.setBook(b);
       float rentFee = b.getPrice()*15/100;
       float deposit = b.getPrice() * 80/100;
       r.setPrice(rentFee);
       rentedBook.add(r);
       listRBNew.add(r);
       rentingBillRentFee += rentFee;
       rentingBillDeposit += deposit;
   }
   RentedBookDAO rbDAO = new RentedBookDAO();
   rbDAO.saveRentedBook(listRBNew, rentingBill);
   rentingBill.setRentedBook(rentedBook);
   rentingBill.setDeposit(rentingBillDeposit);
   rentingBill.setRentFee(rentingBillRentFee);
   session.setAttribute("rentingBill", rentingBill);
   response.sendRedirect("/PTTK_HTTT/gdChiTietDonThue.jsp");
//    String rentingMsg = "";
//    boolean rs = rbDAO.saveRentingBill(rentingBill);
//    System.out.println(rentingBill.getId());
//    if(rs){
//        rentingMsg = "Thêm hóa đơn thành công";
//        session.setAttribute("rentingMsg", rentingMsg);
//        response.sendRedirect("/PTTK_HTTT/gdChiTietHoaDon.jsp");
//        System.out.println("done");
//    }
//    if(rs == false){
//        rentingMsg = "Thêm hóa đơn thất bại";
//        session.setAttribute("rentingMsg", rentingMsg);
//        response.sendRedirect("/PTTK_HTTT/gdTimTruyenThem.jsp?err=fail");
//        System.out.println("fail");
//    }
    
%>