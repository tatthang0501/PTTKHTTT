/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.RentedBook;
import model.RentingBill;

/**
 *
 * @author Admin
 */
public class RentingBillDAO extends DAO{
    public RentingBillDAO(){
        super();
    }
    
    public boolean saveRentingBill(RentingBill rentingBill) throws SQLException{
        boolean rs = false;
        String sql = "INSERT INTO tblRentingBill(status,rentFee,tblClientid) VALUES (?,?,?)";
        
        try{
            st = con.createStatement();
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, rentingBill.getStatus());
            ps.setFloat(2, rentingBill.getRentFee());
            ps.setInt(3, Integer.parseInt(rentingBill.getClient().getId()));
            
            ps.executeUpdate();
            ResultSet rsett = ps.getGeneratedKeys();
            if(rsett.next()){
                int id = rsett.getInt(1);
                rentingBill.setId(id);
                RentedBookDAO rbDAO = new RentedBookDAO();
                if(rbDAO.saveRentedBook(rentingBill.getRentedBook(), rentingBill) == true){
                    rs = true;
                }
            }
        }
        catch(SQLException e){
            System.out.println("Error saving renting bill");
            rs = false;
        }
        return rs;
    }
}
