<%-- 
    Document   : doDangXuat
    Created on : Dec 8, 2020, 11:06:23 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  session.removeAttribute("client");
  session.removeAttribute("cashier");
  response.sendRedirect("/PTTK_HTTT/");
%>

