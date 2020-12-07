<%-- 
    Document   : doDangNhap
    Created on : Dec 5, 2020, 1:21:12 PM
    Author     : Admin
--%>

<%@page import="DAO.UserDAO"%>
<%@page import="model.User"%>
<%@page import="DAO.AccountDAO"%>
<%@page import="model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String email = (String) request.getParameter("email");
    String password = (String) request.getParameter("password");
    Account account = new Account(email, password);
    User user = new User();
    user.setAcc(account);
    AccountDAO aDAO = new AccountDAO();
    UserDAO uDAO = new UserDAO();
    boolean rs = uDAO.checkLogin(user);
    String msg;
    if(rs == true && user.getRole() == 1){
        session.setAttribute("client", user);
        msg = "Đăng nhập thành công, xin chào khách hàng ";
        session.setAttribute("msg", msg);
        response.sendRedirect("/PTTK_HTTT/gdChinhKhachHang.jsp");
    }
    else if(rs == true && user.getRole() == 2){
        session.setAttribute("cashier", user);
        msg = "Đăng nhập thành công, xin chào NV Thu ngân ";
        session.setAttribute("msg", msg);
        response.sendRedirect("/PTTK_HTTT/gdChinhNVThuNgan.jsp");
    }
    else{
        response.sendRedirect("/PTTK_HTTT/gdDangNhap.jsp?err=fail");
        msg = "Đăng nhập thất bại";
        session.setAttribute("msg", msg);
    }
%>
