/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.BookCate;
import model.Category;

/**
 *
 * @author Admin
 */
public class CategoryDAO extends DAO{
    public CategoryDAO(){
        super();
    }
    
    public Category getCate(BookCate bookCate){
        String sql = "SELECT * FROM tblCategory WHERE id = ?";
        Category category = new Category();
        try{
            st = con.createStatement();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, bookCate.getCate().getId());
            ResultSet rsett = ps.executeQuery();
            if(rsett.next()){
                category.setId(rsett.getInt("id"));
                category.setName(rsett.getString("name"));
                category.setDescription(rsett.getString("description"));
                bookCate.setCate(category);
            }
        }
        catch(SQLException e){
            System.out.println("Error!");
        }
        return category;
    }
}
