
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Godzuuu
 */
public class DAO {
    public static Connection con;
    
    public DAO(){
        if(con == null){
            String dbUrl = "jdbc:mysql://localhost:3309/hoteltest1?autoReconnect=true&useSSL=false";
            String dbClass = "com.mysql.jdbc.Driver";
            
            try{
                Class.forName(dbClass);
                con = DriverManager.getConnection(dbUrl,"root","@Thangnguyen5");
            }catch(Exception ex){
                JOptionPane.showMessageDialog(new JFrame(),"Đéo kết nối được bạn ạ");
            }
        }
    }
}
