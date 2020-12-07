/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AccountDAO;
import DAO.NameDAO;
import DAO.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Address;
import model.Name;
import model.User;

/**
 *
 * @author tatth
 */
public class Register extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
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
            url = "/gdDangKiThanhVien.jsp";
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
                msg = "Email hợp lệ";
                url = "/welcome.jsp";
            } catch (SQLException ex) {
                System.out.println("Bị lỗi rồi :( ");
            }
        }
        HttpSession session = request.getSession();
        session.setAttribute("msg", msg);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
