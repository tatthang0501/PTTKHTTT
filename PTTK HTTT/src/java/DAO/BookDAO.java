/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Book;

/**
 *
 * @author Admin
 */
public class BookDAO extends DAO{
    public BookDAO(){
        super();
    }
    
    public ArrayList searchBook(String bookName){
        ArrayList<Book> listBookFound = new ArrayList<Book>();
        String sql = "SELECT * FROM tblBook  WHERE (NOT EXISTS(SELECT id FROM tblRentedBook WHERE tblBookid = tblBook.id ) AND tblBook.name LIKE ? )\n" +
"                            	OR EXISTS(SELECT * FROM tblRentedBook\n" +
"                                WHERE tblRentedBook.tblBookid = tblBook.id\n" +
"                            	AND (tblBook.name LIKE ? )\n" +
"                                AND date(tblRentedBook.returnDate) < date(now()))";
        try{
            st = con.createStatement();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + bookName + "%");
            ps.setString(2, "%" + bookName + "%");
            ResultSet rsett = ps.executeQuery();
//            if(rsett.next()){
                while(rsett.next()){
                    int id = rsett.getInt("id");
                    String name = rsett.getString("name");
                    String year = rsett.getString("year");
                    float price = rsett.getFloat("price");
                    String description = rsett.getString("description");
                    Book book = new Book();
                    book.setId(id);
                    book.setName(name);
                    book.setYear(Integer.parseInt(year));
                    book.setPrice(price);
                    book.setDescription(description);
                    listBookFound.add(book);
                }
//            }
        }
        catch(SQLException e){
            System.out.println("Error!!!!!");
        }
        return listBookFound;
    }
    
    public Book getFullBook(Book book){
        BookAuthorDAO baDAO = new BookAuthorDAO();
        baDAO.getBookAuthor(book);
        BookCateDAO bcDAO = new BookCateDAO();
        bcDAO.getBookCate(book);
        return book;
    }
    
}
