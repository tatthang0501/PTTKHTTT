/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.User;
import model.Account;
import model.Address;
import model.Name;

/**
 *
 * @author tatth
 */
public class UserDAO extends DAO {

    public UserDAO() {
        super();
    }

    public boolean saveRegisterUser(User user, Address address) throws SQLException {
        boolean rs = false;
        try {
            st = con.createStatement();
            String sql1 = "INSERT INTO tblAccount(email,password) VALUES (?,?)";
            PreparedStatement ps1 = con.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
            ps1.setString(1, user.getAcc().getEmail());
            ps1.setString(2, user.getAcc().getPassword());
            ps1.executeUpdate();
            ResultSet rset1 = ps1.getGeneratedKeys();
            int accID = 1;
            if (rset1.next()) {
                accID = rset1.getInt(1);
            }
            rset1.close();

            String sql2 = "INSERT INTO tblName(firstName, middleName, lastName) VALUES(?,?,?)";
            PreparedStatement ps2 = con.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
            ps2.setString(1, user.getName().getFirstName());
            ps2.setString(2, user.getName().getMiddleName());
            ps2.setString(3, user.getName().getLastName());
            ps2.executeUpdate();
            ResultSet rset2 = ps2.getGeneratedKeys();
            int nameID = 1;
            if (rset2.next()) {
                nameID = rset2.getInt(1);
            }
            rset2.close();

            String sql = "INSERT INTO tblUser(sex, role, phone, tblAccountid, tblNameid) VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            ps.setString(1, user.getDOB().toString());
            ps.setInt(1, user.getSex());
            ps.setInt(2, user.getRole());
            ps.setString(3, user.getPhone());
            ps.setInt(4, accID);
            ps.setInt(5, nameID);

            ps.executeUpdate();
            ResultSet rset = ps.getGeneratedKeys();
            int i = 1;
            if (rset.next()) {
                i = rset.getInt(1);
                AddressDAO aDAO = new AddressDAO();
                Address add = address;
                if (aDAO.saveAddress(add, i) == true) {
                    rs = true;
                }

            }
        } catch (SQLException e) {
            con.rollback();
            System.out.println("Lỗi rồi");
        }
        return rs;
    }

    public boolean checkLogin(User user) {
        boolean rs = false;
        AccountDAO aDAO = new AccountDAO();
        if (aDAO.checkExistAccount(user.getAcc()) == true) {
//            String sql = "{call getUser(?)}";
            String sql = "SELECT * FROM tblUser WHERE tblAccountid = ?";
            try {
//                CallableStatement cs = con.prepareCall(sql);
                PreparedStatement cs = con.prepareStatement(sql);
                cs.setInt(1, user.getAcc().getId());
                ResultSet rsett = cs.executeQuery();
                if (rsett.next()) {
                    user.setId(rsett.getString("id"));
                    user.setPhone(rsett.getString("phone"));
                    user.setRole(rsett.getInt("role"));
                    user.setSex(rsett.getInt("sex"));
                    rs = true;
                }
            } catch (SQLException e) {
                System.out.println("Error");
                rs = false;
            }
        }
        return rs;
    }

    public ArrayList<User> getUsers(String userName) {
        ArrayList<User> listUserFound = new ArrayList<>();
        String sql = "SELECT * from tblUser where tblNameid = ? AND role = 1";
        NameDAO nDAO = new NameDAO();
        ArrayList<Name> listName = nDAO.getName(userName);
        for (Name n : listName) {
            try {
                st = con.createStatement();
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, n.getId());
                ResultSet rsett = ps.executeQuery();
                if (rsett.next()) {
                    User user = new User();
                    user.setId(Integer.toString(rsett.getInt("id")));
                    user.setName(n);
                    user.setPhone(rsett.getString("phone"));
                    user.setRole(rsett.getInt("role"));
                    user.setSex(rsett.getInt("sex"));
                    listUserFound.add(user);
                }
            } catch (SQLException e) {
                System.out.println("Error getting User");
            }
        }
        
        AddressDAO aDAO = new AddressDAO();
        AccountDAO accDAO = new AccountDAO();
        for(User user: listUserFound){
            ArrayList<Address> listAddress = aDAO.getAddress(user);
            user.setAddrs(listAddress);
            Account account = accDAO.getAccount(user);
            user.setAcc(account);
        }
        
        return listUserFound;
    }
    
//    public User getOneUser(int id){
//        User user = new User();
//        String sql = "SELECT * FROM tblUser WHERE id =?";
//        try{
//            st = con.createStatement();
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, id);
//            ResultSet rsett = ps.executeQuery();
//            if(rsett.next()){
//                user.setId(Integer.toString(rsett.getInt("id")));
//                user.setPhone(rsett.getString("phone"));
//                user.setRole(rsett.getInt("role"));
//                user.setSex(rsett.getInt("sex"));
//            }
//        }
//        catch(SQLException e){
//            System.out.println("Error");
//        }
//        return user;
//    }
}
