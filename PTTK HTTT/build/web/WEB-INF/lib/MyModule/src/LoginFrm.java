
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Godzuuu
 */
public class LoginFrm extends JFrame implements ActionListener{
    private JTextField userName;
    private JPasswordField password;
    private JButton btnLogin;

    public LoginFrm() {
        super("Login");
        this.setTitle("Đăng nhập vào hệ thống quản lý khách sạn");
        userName = new JTextField(15);
        password = new JPasswordField(15);
        password.setEchoChar('*');
        btnLogin = new JButton("Login");
        
        JPanel pnMain = new JPanel();
        pnMain.setSize(this.getSize().width-5, this.getSize().height-20);
        pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.PAGE_AXIS));
        pnMain.add(Box.createRigidArea(new Dimension(0, 10)));
        
        JLabel lblHome = new JLabel("Login");
        lblHome.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblHome.setFont(lblHome.getFont().deriveFont(20.0f));
        pnMain.add(lblHome);
        pnMain.add(Box.createRigidArea(new Dimension(0, 20)));
        
        JPanel pnUsername = new JPanel();
        pnUsername.setLayout(new FlowLayout());
        pnUsername.add(new JLabel("Username:"));
        pnUsername.add(userName);
        pnMain.add(pnUsername);
        
        JPanel pnPass = new JPanel();
        pnPass.setLayout(new FlowLayout());
        pnPass.add(new JLabel("Password:"));
        pnPass.add(password);
        pnMain.add(pnPass);
        
        pnMain.add(btnLogin);
        pnMain.add(Box.createRigidArea(new Dimension(0, 10)));
        btnLogin.addActionListener(this);
        
        this.setSize(600, 200);
        this.setLocationRelativeTo(null);
        this.setContentPane(pnMain);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if((e.getSource()instanceof JButton)&&(((JButton)e.getSource()).equals(btnLogin))){
            User user = new User();
            user.setUserName(userName.getText());
            user.setPassword(password.getText());
            User
        }
    }
}
