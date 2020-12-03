/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AccountDAO;
import DAO.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author tatth
 */
public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException{
        String email = request.getParameter("emailAddress");
        Account account = new Account(email);
        AccountDAO aDAO = new AccountDAO();
        String msg = "";
        if(aDAO.checkRegisterAccount(account) == true){
            msg = "Email đã được đăng kí thành viên, hãy chọn email khác!";
        }
        else{
            msg = "Email hợp lệ";
        }
        HttpSession session = request.getSession();
        session.setAttribute("msg", msg);
        
        String url = "/Register.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
