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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.RentedBook;
import model.RentingBill;
import model.User;

/**
 *
 * @author Admin
 */
public class RentingBillDAO extends DAO {

    public RentingBillDAO() {
        super();
    }

    public boolean saveRentingBill(RentingBill rentingBill) throws SQLException {
        boolean rs = false;
        String sql = "INSERT INTO tblRentingBill(rentDate, status, deposit, rentFee, tblClientid) VALUES (?,?,?,?,?)";

        try {
            st = con.createStatement();
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            LocalDate date = LocalDate.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            ps.setString(1,dtf.format(date));
            ps.setInt(2, rentingBill.getStatus());
            ps.setFloat(3, rentingBill.getDeposit());
            ps.setFloat(4, rentingBill.getRentFee());
            ps.setInt(5, Integer.parseInt(rentingBill.getClient().getId()));

            ps.executeUpdate();
            ResultSet rsett = ps.getGeneratedKeys();
            if (rsett.next()) {
                int id = rsett.getInt(1);
                rentingBill.setId(id);
                RentedBookDAO rbDAO = new RentedBookDAO();
                if (rbDAO.saveRentedBook(rentingBill.getRentedBook(), rentingBill) == true) {
                    rs = true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error saving renting bill");
            rs = false;
        }
        return rs;
    }

    public ArrayList<RentingBill> getListRentingBill(User user) {
        ArrayList<RentingBill> listRentingBill = new ArrayList<RentingBill>();
        String sql = "SELECT * FROM tblRentingBill WHERE tblClientid = ? AND status = 1";

        try {
            st = con.createStatement();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(user.getId()));
            ResultSet rsett = ps.executeQuery();
            while (rsett.next()) {
                RentingBill rb = new RentingBill();
                rb.setId(rsett.getInt("id"));
                rb.setRentDate(rsett.getDate("rentDate"));
                rb.setRentFee(rsett.getFloat("rentFee"));
                rb.setStatus(rsett.getInt("status"));
                rb.setDescription(rsett.getString("description"));
                rb.setDeposit(rsett.getFloat("deposit"));
                RentedBookDAO rbDAO = new RentedBookDAO();
                ArrayList<RentedBook> listRentedBook = rbDAO.getRentedBook(rb);
                rb.setRentedBook(listRentedBook);
                listRentingBill.add(rb);
            }
        } catch (SQLException e) {
            System.out.println("Error getting Renting Bill");
        }
        return listRentingBill;
    }

    public boolean updateRentingBill(RentingBill rentingBill) {
        boolean rs = true;
        String sql = "UPDATE tblRentingBill SET rentFee = ?, deposit = ?, status = ?, tblCashierid = ? WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setFloat(1, rentingBill.getRentFee());
            ps.setFloat(2, rentingBill.getDeposit());
            ps.setInt(3, 2);
            ps.setInt(4, Integer.parseInt(rentingBill.getCashier().getId()));
            ps.setInt(5, rentingBill.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error updating Renting Bill");
            rs = false;
        }
        return rs;
    }

}
