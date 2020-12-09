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
import model.Address;
import model.User;

/**
 *
 * @author Admin
 */
public class AddressDAO extends DAO {

    AddressDAO() {
        super();
    }
    
    public boolean saveAddress(Address address,int userID){
        boolean rs = false;
        try{
            st = con.createStatement();
            String sql = "INSERT INTO tblAddress(houseNumber, alley, road, ward, district, city, tblUserId) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, address.getHouseNumber());
            ps.setString(2, address.getAlley());
            ps.setString(3, address.getRoad());
            ps.setString(4, address.getWard());
            ps.setString(5, address.getDistrict());
            ps.setString(6, address.getCity());
            ps.setInt(7, userID);
            
            if(ps.execute() == true){
                rs = true;
            }
        }
        catch(SQLException e){
            System.out.println("Error");
        }
        return rs;
    }
    
    public ArrayList<Address> getAddress(User user){
        ArrayList<Address> listAddress = new ArrayList<Address>();
        String sql = "SELECT * FROM tblAddress WHERE tblUserid = ?";
        try{
            st = con.createStatement();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(user.getId()));
            ResultSet rsett = ps.executeQuery();
            while(rsett.next()){
                Address address = new Address();
                address.setId(rsett.getInt("id"));
                address.setHouseNumber(rsett.getString("houseNumber"));
                address.setRoad(rsett.getString("road"));
                address.setWard(rsett.getString("ward"));
                address.setAlley(rsett.getString("alley"));
                address.setCity(rsett.getString("city"));
                address.setDistrict(rsett.getString("district"));
                listAddress.add(address);
            }
        }
        catch(SQLException e){
            System.out.println("Error getting Address");
        }
        return listAddress;
    }
}
