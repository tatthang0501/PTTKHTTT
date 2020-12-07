<%-- 
    Document   : doChonTruyen
    Created on : Dec 6, 2020, 9:27:37 PM
    Author     : Admin
--%>

<%@page import="DAO.BookDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String bookId = request.getParameter("bookId");
    ArrayList<Book> list = (ArrayList<Book>) session.getAttribute("listBookFound");
    BookDAO bDAO = new BookDAO();
    Book book = new Book();
//    Book fullBook = new Book();
    for (Book b : list) {
        if (b.getId() == Integer.parseInt(bookId)) {
            book = b;
            list.remove(b); 
//            fullBook = bDAO.getFullBook(book);
            break;
        }
    }
    session.setAttribute("listBookFound", list);
    session.setAttribute("fullBook", book);
    response.sendRedirect("/PTTK_HTTT/gdChiTietTruyen.jsp");
%>
