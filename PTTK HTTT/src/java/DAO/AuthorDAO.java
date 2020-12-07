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
import model.BookAuthor;

/**
 *
 * @author Admin
 */
public class AuthorDAO extends DAO{
    public AuthorDAO(){
        super();
    }
    
    public Author getAuthor(BookAuthor bookAuthor){
        Author author = new Author();
        String sql = "SELECT * FROM tblAuthor WHERE id = ?";
        try{
            st = con.createStatement();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, bookAuthor.getAuthor().getId());
            ResultSet rsett = ps.executeQuery();
            if(rsett.next()){
                author.setId(rsett.getInt("id"));
                author.setName(rsett.getString("tblNameid"));
                author.setDescription(rsett.getString("description"));
                bookAuthor.setAuthor(author);
            }
        }
        catch(SQLException e){
            System.out.println("Error");
        }
        return author;
    }
}
