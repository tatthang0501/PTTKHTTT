<%-- 
    Document   : doXoaTruyen
    Created on : Dec 7, 2020, 12:41:48 PM
    Author     : Admin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String bookId = request.getParameter("bookId");
    ArrayList<Book> list = (ArrayList<Book>) session.getAttribute("listBookChosen");
    ArrayList<Book> listFound = (ArrayList<Book>) session.getAttribute("listBookFound");
    for(Book b: list){
        if(b.getId()== Integer.parseInt(bookId)){
            list.remove(b);
            listFound.add(b);
            break;
        }
    }
    session.setAttribute("listBookChosen", list);
    session.setAttribute("listBookFound", listFound);
    response.sendRedirect("/PTTK_HTTT/gdTimTruyenThem.jsp");
%>
