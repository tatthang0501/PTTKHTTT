/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author tatth
 */
public class DAO {
    Connection con = null;
    Statement st = null;
    ResultSet rset = null;
    String url = "dbc:mysql://localhost:3306/pttktestdb";
    String user = "root";
    String password = "@Thangnguyen5";
}
