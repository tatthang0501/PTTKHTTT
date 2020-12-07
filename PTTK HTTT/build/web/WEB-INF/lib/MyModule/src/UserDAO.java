
import java.sql.PreparedStatement;
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
public class UserDAO {

    public UserDAO() {
        super();
    }
    
    public boolean checkLogin(User user){
        boolean result = false;
        String sql = "SELECT name, address, dateOfBirth, identityNumber, phoneNumber FROM tblUser where userName = ? AND password = ?";
        try{
            PreparedStatement ps = con.preparedStatement
        }catch(Exception e){
            System.out.println("Sai tên tài khoản hoặc mật khẩu");
            JOptionPane.showMessageDialog(new JFrame(), "Sai tên tài khoản hoặc mật khẩu");
        }
    }
}
