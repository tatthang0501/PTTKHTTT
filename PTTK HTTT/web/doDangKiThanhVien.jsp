<%--
    Document   : Register
    Created on : Dec 4, 2020, 2:23:09 AM
    Author     : tatth
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="model.User"%>
<%@page import="model.Address"%>
<%@page import="model.Name"%>
<%@page import="model.Account"%>
<%@page import="DAO.UserDAO"%>
<%@page import="DAO.AccountDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <%
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String middleName = request.getParameter("middleName");
        String lastName = request.getParameter("lastName");
        int sex = Integer.parseInt(request.getParameter("sex"));
        String houseNumber = request.getParameter("houseNumber");
        String alley = request.getParameter("alley");
        String ward = request.getParameter("ward");
        String road = request.getParameter("road");
        String district = request.getParameter("district");
        String city = request.getParameter("city");
        String DOB = request.getParameter("DOB");
        String phone = request.getParameter("phoneNumber");
        int role = 1;
        AccountDAO aDAO = new AccountDAO();
        UserDAO uDAO = new UserDAO();

        Account account = new Account(email, password);

        String msg = "";
        String url = "";
        if (aDAO.checkRegisterAccount(account) == true) {
            msg = "Email đã được đăng kí thành viên, hãy chọn email khác!";
            session.setAttribute("registerMsg", msg);
            response.sendRedirect("/PTTK_HTTT/gdDangKiThanhVien.jsp");
        }
        if (aDAO.checkRegisterAccount(account) == false) {

//            Date date = null;
//            try {
//                date = new SimpleDateFormat("yyyy-MM-dd").parse(DOB);
//                System.out.println(date);
//            } catch (ParseException ex) {
//                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
//            }

            Name name = new Name(firstName, middleName, lastName);
            Address address = new Address(houseNumber, alley, road, ward, district, city);
            User user = new User(sex, role, phone, account, name);
            try {
                uDAO.saveRegisterUser(user,address);
                msg = "Đăng kí thành công, đăng nhập ngay!!";
                session.setAttribute("registerMsg", msg);
                response.sendRedirect("/PTTK_HTTT/gdDangNhap.jsp");
            } catch (SQLException ex) {
                System.out.println("Bị lỗi rồi :( ");
            }
        }
        ;%>
