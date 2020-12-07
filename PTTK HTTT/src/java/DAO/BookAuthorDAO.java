/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    public BookAuthor[] getBookAuthor(Book book){
        BookAuthor[] bookAuthorList = {};
        String sql = "SELECT * FROM tblBookAuthor WHERE tblBookid = ?";
        try{
            st = con.createStatement();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, book.getId());
            ResultSet rsett = ps.executeQuery();
            int i = 0;
            while(rsett.next()){
                BookAuthor bookAuthor = new BookAuthor();
                bookAuthor.setId(rsett.getInt("id"));
                Author author = new Author();
                author.setId(rsett.getInt("tblAuthorid"));
                bookAuthor.setAuthor(author);
                AuthorDAO aDAO = new AuthorDAO();
                aDAO.getAuthor(bookAuthor);
                bookAuthorList[i] = bookAuthor;
                i++;
            }
            book.setBookAuthor(bookAuthorList);
        }
        catch(SQLException e){
            System.out.println("Error");
            
        }
        return bookAuthorList;
    }
}
