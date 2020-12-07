/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author tatth
 */
public class DAO {

    public static Connection con;
    Statement st = null;
    ResultSet rset = null;
    String url = "jdbc:mysql://localhost/pttktestdb?useSSL=false";
    String user = "root";
    String password = "@Thangnguyen5";

    public DAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
