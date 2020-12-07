/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.RentedBook;
import model.RentingBill;

/**
 *
 * @author Admin
 */
public class RentedBookDAO extends DAO {

    public RentedBookDAO() {
        super();
    }

    public boolean saveRentedBook(ArrayList<RentedBook> rentedBook, RentingBill rentingBill) throws SQLException {
        boolean rs = false;
        String sql = "INSERT INTO tblRentedBook(price, tblBookid, tblRentingBillid) VALUES(?,?,?)";
        try {
            int count = 0;
            for (RentedBook rb : rentedBook) {
                st = con.createStatement();
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setFloat(1, rb.getPrice());
                ps.setInt(2, rb.getBook().getId());
                ps.setInt(3, rentingBill.getId());
                count += ps.executeUpdate();
            }
            if(count == rentedBook.size()){
                rs = true;
            }
        } catch (SQLException e) {
            System.out.println("Error saving rented book");
            rs = false;
        }
        return rs;
    }
}
