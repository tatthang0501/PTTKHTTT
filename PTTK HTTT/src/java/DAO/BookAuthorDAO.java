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
import model.Author;
import model.Book;
import model.BookAuthor;

/**
 *
 * @author Admin
 */
public class BookAuthorDAO extends DAO{
    public BookAuthorDAO(){
        super();
    }
    
    public ArrayList<BookAuthor> getBookAuthor(Book book){
        ArrayList<BookAuthor> listBookAuthor = new ArrayList<BookAuthor>();
        String sql = "SELECT * FROM tblBookAuthor WHERE tblBookid = ?";
        try{
            st = con.createStatement();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, book.getId());
            ResultSet rsett = ps.executeQuery();
            while(rsett.next()){
                BookAuthor bookAuthor = new BookAuthor();
                bookAuthor.setId(rsett.getInt("id"));
                Author author = new Author();
                author.setId(rsett.getInt("tblAuthorid"));
                bookAuthor.setAuthor(author);
                AuthorDAO aDAO = new AuthorDAO();
                aDAO.getAuthor(bookAuthor);
                listBookAuthor.add(bookAuthor);
            }
            book.setAuthor(listBookAuthor);
        }
        catch(SQLException e){
            System.out.println("Error");
            
        }
        return listBookAuthor;
    }
}
