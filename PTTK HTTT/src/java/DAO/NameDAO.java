/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    
    public ArrayList<Name> getName(String Name){
        ArrayList<Name> listName = new ArrayList<>();
        String sql = "select * from tblName WHERE firstName LIKE ? OR middleName LIKE ? OR lastName LIKE ?";
        try{
            st = con.createStatement();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,"%"+Name+"%");
            ps.setString(2,"%"+Name+"%");
            ps.setString(3,"%"+Name+"%");
            
            ResultSet rsett = ps.executeQuery();
            while(rsett.next()){
                int id = rsett.getInt("id");
                String firstName = rsett.getString("firstName");
                String middleName = rsett.getString("middleName");
                String lastName = rsett.getString("lastName");
                Name name = new Name(id, firstName, middleName, lastName);
                listName.add(name);
            }
        }
        catch(SQLException e){
            System.out.println("Error getting names");
        }
        return listName;
    }
}
