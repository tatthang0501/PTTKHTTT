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
   ArrayList <Book> listBookChosen = (ArrayList<Book>) session.getAttribute("listBookChosen");
   User user = (User) session.getAttribute("client");
   Client client = new Client();
   client.setId(user.getId());
   client.setName(user.getName());
   client.setPhone(user.getPhone());
   client.setRole(user.getRole());
   client.setSex(user.getSex());
   client.setStore(user.getStore());
   client.setAcc(user.getAcc());
   client.setAddrs(user.getAddrs());
   client.setDOB(user.getDOB());
   
   ArrayList<RentedBook> listrb = new ArrayList<RentedBook>();
   float rentingBillRentFee = 0; 
   for(Book b:listBookChosen){
       RentedBook r = new RentedBook();
       r.setBook(b);
       float rentFee = b.getPrice()*15/100;
       r.setPrice(rentFee);
       listrb.add(r);
       rentingBillRentFee += rentFee;
       System.out.println(b.getId());
   }

   rentingBill.setRentedBook(listrb);
   rentingBill.setClient(client);
   rentingBill.setStatus(1);
   rentingBill.setRentFee(rentingBillRentFee);
   RentingBillDAO rbDAO = new RentingBillDAO();
    
    String rentingMsg = "";
    boolean rs = rbDAO.saveRentingBill(rentingBill);
    System.out.println(rentingBill.getId());
    if(rs){
        rentingMsg = "Thêm hóa đơn thành công";
        session.setAttribute("rentingMsg", rentingMsg);
        response.sendRedirect("/PTTK_HTTT/gdChinhKhachHang.jsp");
        System.out.println("done");
    }
    if(rs == false){
        rentingMsg = "Thêm hóa đơn thất bại";
        session.setAttribute("rentingMsg", rentingMsg);
        response.sendRedirect("/PTTK_HTTT/gdTimTruyen.jsp?err=fail");
        System.out.println("fail");
    }
%>