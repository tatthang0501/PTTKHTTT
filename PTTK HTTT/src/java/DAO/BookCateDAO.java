/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Book;
import model.BookCate;
import model.Category;

/**
 *
 * @author Admin
 */
public class BookCateDAO extends DAO{
    public BookCateDAO(){
        super();
    }
    
    public ArrayList<BookCate> getBookCate(Book book){
        ArrayList<BookCate> listBookCate = new ArrayList<>();
        String sql = "SELECT * FROM tblBookCate WHERE tblBookid = ?";
        try{
            st = con.createStatement();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, book.getId());
            ResultSet rsett = ps.executeQuery();
            while(rsett.next()){
                BookCate bookCateSingle = new BookCate();
                bookCateSingle.setId(rsett.getInt("id"));
                Category cate = new Category();
                cate.setId(rsett.getInt("tblCategoryid"));
                bookCateSingle.setCate(cate);
                CategoryDAO cDAO = new CategoryDAO();
                cDAO.getCate(bookCateSingle);
                listBookCate.add(bookCateSingle);
            }
            book.setCate(listBookCate);
        }
        catch(SQLException e){  
            System.out.println("Error!");
        }
        return listBookCate;
    }
}
