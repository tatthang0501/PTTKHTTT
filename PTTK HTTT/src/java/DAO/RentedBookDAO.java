/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.Book;
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
        String sql = "INSERT INTO tblRentedBook(price, rentDate, tblBookid, tblRentingBillid) VALUES(?,?,?,?)";
        try {
            int count = 0;
            for (RentedBook rb : rentedBook) {
                st = con.createStatement();
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setFloat(1, rb.getPrice());
                LocalDate date = LocalDate.now();
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                ps.setString(2, dtf.format(date));
                ps.setInt(3, rb.getBook().getId());
                ps.setInt(4, rentingBill.getId());
                count += ps.executeUpdate();
            }
            if (count == rentedBook.size()) {
                rs = true;
            }
        } catch (SQLException e) {
            System.out.println("Error saving rented book");
            rs = false;
        }
        return rs;
    }

    public ArrayList<RentedBook> getRentedBook(RentingBill rentingBill) {
        ArrayList<RentedBook> listRentedBook = new ArrayList<RentedBook>();
        String sql = "SELECT * FROM tblRentedBook WHERE tblRentingBillid = ?";
        try {
            st = con.createStatement();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, rentingBill.getId());
            ResultSet rsett = ps.executeQuery();
            while (rsett.next()) {
                RentedBook rentedBook = new RentedBook();
                rentedBook.setId(rsett.getInt("id"));
                rentedBook.setPrice(rsett.getFloat("price"));
                rentedBook.setRentDate(rsett.getDate("rentDate"));
                rentedBook.setReturnDate(rsett.getDate("returnDate"));
                Book b = new Book();
                b.setId(rsett.getInt("tblBookId"));
                rentedBook.setBook(b);
                BookDAO bDAO = new BookDAO();
                Book book = bDAO.getBook(rentedBook);
                rentedBook.setBook(book);
                listRentedBook.add(rentedBook);
            }
        } catch (SQLException e) {
            System.out.println("Error getting rented book");
        }
        return listRentedBook;
    }

    public void deleteRentedBook(RentedBook rentedBook) {
        String sql = "DELETE FROM tblRentedBook WHERE id = ?";
        try {
            st = con.createStatement();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, rentedBook.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deleting rented book");
        }
    }
}
