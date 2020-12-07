/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Name;

/**
 *
 * @author Admin
 */
public class NameDAO extends DAO {

    public NameDAO() {
        super();
    }

    
    public boolean saveName(Name name) throws SQLException{
        boolean rs = false;
        try{
            st = con.createStatement();
            String sql = "INSERT INTO tblName(firstName, middleName, lastName) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name.getFirstName());
            ps.setString(2, name.getMiddleName());
            ps.setString(3, name.getLastName());
            int i = -1;
            i = ps.executeUpdate();
            if(i != -1){
                rs = true;
            }
        }
        catch(SQLException e){
            System.out.println("Error!");
            this.con.rollback();
        }
        return rs;
    }
}
