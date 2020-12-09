<%-- 
    Document   : doThemTruyen
    Created on : Dec 7, 2020, 12:32:28 PM
    Author     : Admin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Book book = (Book) session.getAttribute("fullBook");
    ArrayList<Book> listBookChosen = (ArrayList<Book>) session.getAttribute("listBookChosen");
    listBookChosen.add(book);
    session.setAttribute("listBookChosen", listBookChosen);
    response.sendRedirect("/PTTK_HTTT/gdTimTruyenThem.jsp");
%>
