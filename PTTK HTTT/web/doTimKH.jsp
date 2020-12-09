<%-- 
    Document   : doTimKH
    Created on : Dec 7, 2020, 10:03:04 PM
    Author     : Admin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.User"%>
<%@page import="DAO.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String clientName = request.getParameter("clientName");
    UserDAO uDAO = new UserDAO();
    ArrayList<User> listClientFound = uDAO.getUsers(clientName);
    session.setAttribute("listClientFound", listClientFound);
    session.setAttribute("clientName", clientName);
    response.sendRedirect("/PTTK_HTTT/gdTimKH.jsp");
%>
