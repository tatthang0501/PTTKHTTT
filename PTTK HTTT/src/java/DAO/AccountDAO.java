/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Account;

/**
 *
 * @author tatth
 */
public class AccountDAO{

    Connection con = null;
    Statement st = null;
    ResultSet rset = null;
    String url = "jdbc:mysql://localhost:3306/pttktestdb";
    String user = "root";
    String password = "@Thangnguyen5";
    
    public AccountDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public boolean checkRegisterAccount(Account account){
        boolean rs = false;
        try{
            st = con.createStatement();
            String sql = "SELECT * FROM tblAccount WHERE email = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,account.getEmail());
            rset = ps.executeQuery();
            while(rset.next()){
                rs = true;
            }
        }
        catch(SQLException e){
            rs = false;
            System.out.println("Error");
        }
        return rs;
    }
}
