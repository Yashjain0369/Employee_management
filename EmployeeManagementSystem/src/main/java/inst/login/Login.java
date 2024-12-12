//package inst.login;
//import java.awt.Color;
//import java.awt.Image;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPasswordField;
//import javax.swing.JTextField;
//
//import inst.connection.Conn;
//
//
//public class Login extends JFrame implements ActionListener {
//	
//	JTextField tusername;
//	JPasswordField tpassword;
//	JPasswordField tpassword1;
//	JButton login;
//	
//	JButton back;
//	
//	public Login() {
//	
//		JLabel username = new JLabel("Username");
//		username.setBounds(40, 20, 100, 30);
//		add(username);
//		
//	JTextField tusername = new JTextField();
//	tusername.setBounds(150, 20,150 , 30);
//	add(tusername);
//	
//		JLabel password= new JLabel("Password");
//        password.setBounds(40, 70, 150, 30);
//
//     add(password);
//     
//
//     JPasswordField tpassword = new JPasswordField();
//        tpassword.setBounds(150, 70, 150,30);
//
//      add(tpassword);
//      
//      login = new JButton("Login");
//      login.setBounds(150,140,150,30);
//      login.setBackground(Color.black);
//      login.setForeground(Color.white);
//      login.addActionListener(this);
//      add(login);
//      
//      back = new JButton("Back");
//   back.setBounds(150,180,150,30);
//      back.setBackground(Color.black);
//      back.setForeground(Color.white);
//      back.addActionListener(this);
//      add(back);
//      
//      ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("inst/icons/second (1).jpg"));
//      Image i22 = i11.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
//
//            ImageIcon i4 = new ImageIcon(i22);
//            JLabel img1 = new JLabel(i4);
//            img1.setBounds(350, 10, 600, 400);
//            add(img1);
//      
//     JPasswordField tpassword1 = new JPasswordField();
////      tpassword1.setBounds(150, 70, 150,30);
//      add(tpassword1);
//      
//      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("inst/icons/LoginB.jpg"));
//Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
//
//      ImageIcon i3 = new ImageIcon(i2);
//      JLabel img = new JLabel(i3);
//      img.setBounds(0, 0, 600, 300);
//      add(img);
//      
//   
//		setSize(600, 300);
//		setLocation(400, 400);
//			setVisible(true);	
//		setLayout(null);
//
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//	if(e.getSource() == login) {
//		
//		try {
//			String username = tusername.getText();
//			String password = new String(tpassword.getPassword());
//
//			
//			Conn conn = new Conn();
//			
//			String query = "SELECT * FROM login WHERE username = ? AND password = ?";
//			 PreparedStatement pst = conn.prepareStatement(query);
//             pst.setString(1, username);
//             pst.setString(2, password);
//             ResultSet rs = pst.executeQuery();
//			if(rs.next()) {
//				
//				setVisible(false);
//			
//			}
//			else {
//				
//				JOptionPane.showMessageDialog(null, "Invalid Username or Password");
//			}
//			
//			
//			
// 			
//		} catch (Exception e2) {
//			e2.printStackTrace();
//		}
//	}
//	else if (e.getSource() == back) {
//		
//		System.exit(22);
//		
//	}
//		
//	}
//
//}
package inst.login;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;

import inst.connection.Conn;
import inst.login_main.login_main;

public class Login extends JFrame implements ActionListener {
    
    JTextField tusername;
    JPasswordField tpassword;
    JButton login;
    JButton back;

    public Login() {
        JLabel username = new JLabel("Username");
        username.setBounds(40, 20, 100, 30);
        add(username);
        
        tusername = new JTextField();
        tusername.setBounds(150, 20, 150, 30);
        add(tusername);
        
        JLabel password = new JLabel("Password");
        password.setBounds(40, 70, 150, 30);
        add(password);
        
        tpassword = new JPasswordField();
        tpassword.setBounds(150, 70, 150, 30);
        add(tpassword);
        
        login = new JButton("Login");
        login.setBounds(150, 140, 150, 30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        
        back = new JButton("Back");
        back.setBounds(150, 180, 150, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("inst/icons/second (1).jpg"));
        Image i22 = i11.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i4 = new ImageIcon(i22);
        JLabel img1 = new JLabel(i4);
        img1.setBounds(350, 10, 600, 400);
        add(img1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("inst/icons/LoginB.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 600, 300);
        add(img);

        setSize(600, 300);
        setLocation(400, 400);
        setVisible(true);
        setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            try {
                String username = tusername.getText();
                String password = new String(tpassword.getPassword());
                
                Conn conn = new Conn();
                String query = "SELECT * FROM login WHERE username = ? AND password = ?";
                PreparedStatement pst = conn.prepareStatement(query);
                pst.setString(1, username);
                pst.setString(2, password);
                ResultSet rs = pst.executeQuery();
                
                if (rs.next()) {
                    setVisible(false);  // Hide the login screen on successful login
                    // Proceed to the next screen or perform additional actions
                    new login_main();
                  
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                }
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(this, "An error occurred: " + e2.getMessage());
                e2.printStackTrace();
            }
        } else if (e.getSource() == back) {
            dispose();  // Close the current window
        }
    }
}
