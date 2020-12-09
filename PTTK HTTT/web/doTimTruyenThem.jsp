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
    session.setAttribute("listBookFound", listBookFound);
    session.setAttribute("listBookChosen", listBookChosen);
    session.setAttribute("bookName", bookName);
    
    response.sendRedirect("/PTTK_HTTT/gdTimTruyenThem.jsp");
%>

