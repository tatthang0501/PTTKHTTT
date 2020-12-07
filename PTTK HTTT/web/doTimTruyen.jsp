<%-- 
    Document   : doTimTruyen
    Created on : Dec 6, 2020, 12:37:16 AM
    Author     : Admin
--%>

<%@page import="model.RentingBill"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Book"%>
<%@page import="DAO.BookDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String bookName = request.getParameter("bookName");
    BookDAO bookDAO = new BookDAO();
    ArrayList<Book> listBookFound = bookDAO.searchBook(bookName);
    ArrayList<Book> listBookChosen = new ArrayList<Book>();
    RentingBill rentingBill = new RentingBill();
    session.setAttribute("listBookFound", listBookFound);
    session.setAttribute("listBookChosen", listBookChosen);
    session.setAttribute("bookName", bookName);
    
    session.setAttribute("rentingBill", rentingBill);
    response.sendRedirect("/PTTK_HTTT/gdTimTruyen.jsp");
%>

