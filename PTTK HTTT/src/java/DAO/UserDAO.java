/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.User;
import model.Account;
/**
 *
 * @author tatth
 */
public class UserDAO extends DAO{
    public UserDAO(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
//            rset = st.executeQuery("SELECT VERSION()");
//            if (rset.next()) {
//                System.out.println(rset.getString(1));
//            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public boolean saveRegisterUser(User user) throws SQLException{
        boolean rs = false;
        try{
            st = con.createStatement();
            String sql = "INSERT INTO tblUser(dob, sex, role, phone, tblAccountid, tblNameid, tblStoreid) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getDOB().toString());
            ps.setInt(2, user.getSex());
            ps.setInt(3, user.getRole());
            ps.setString(4, user.getPhone());
            ps.setInt(5,user.getAcc().getId());
            ps.setInt(6, user.getName().getId());
            ps.setInt(7, user.getStore().getId());
            
            ps.execute();
        }
        catch(SQLException e){
            con.rollback();
            System.out.println("Error");
        }
        return rs;
    }
    
}
