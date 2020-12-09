/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Account;
import model.User;

/**
 *
 * @author tatth
 */
public class AccountDAO extends DAO {

    public AccountDAO() {
        super();
    }

    public boolean checkRegisterAccount(Account account) {
        boolean rs = false;
        try {
            st = con.createStatement();
            String sql = "SELECT * FROM tblAccount WHERE email = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, account.getEmail());
            rset = ps.executeQuery();
            if (rset.next()) {
                rs = true;
            }
        } catch (SQLException e) {
            System.out.println("Error");
        }
        return rs;
    }

    public int saveAccount(Account account) {
        boolean rs = false;
        int i = -1;
        try {
            st = con.createStatement();
            String sql = "INSERT INTO tblAccount(email,password) VALUES (?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, account.getEmail());
            ps.setString(2, account.getPassword());
            i = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error!");
        }
        return i;
    }

    public boolean checkExistAccount(Account account) {
        boolean rs = false;
//        if (account.getEmail().contains("true") || account.getEmail().contains("=")
//                || account.getPassword().contains("true") || account.getPassword().contains("=")) {
//            return false;
//        }
//        String sql = "{call checkLogin(?,?)}";
            String sql = "SELECT * FROM tblAccount WHERE email = ? AND password = ?";
        try {
//            CallableStatement cs = con.prepareCall(sql);
            PreparedStatement cs = con.prepareStatement(sql);
            cs.setString(1, account.getEmail());
            cs.setString(2, account.getPassword());
            ResultSet rsett = cs.executeQuery();
            if(rsett.next()){
                account.setId(rsett.getInt("id"));
                account.setEmail(rsett.getString("email"));
                account.setPassword(rsett.getString("password"));
                rs = true;
            }
        } catch (SQLException e) {
            System.out.println("Error account!");
        }
        return rs;
    }
    
    public Account getAccount(User user){
        Account account = new Account();
        String sql = "SELECT * FROM tblAccount WHERE id = ?";
        try{
            st = con.createStatement();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(user.getId()));
            ResultSet rsett = ps.executeQuery();
            if(rsett.next()){
                account.setId(rsett.getInt("id"));
                account.setEmail(rsett.getString("email"));
                account.setPassword(rsett.getString("password"));
            }
        }
        catch(SQLException e){
            System.out.println("Error getting Account");
        }
        return account;
    }
}
