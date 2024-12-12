package inst.login_main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import inst.login.AddEmployee;
import inst.login.RemoveEmployee;
import inst.login.ViewEmployee;

public class login_main  extends JFrame{
public login_main() {
		
	
	ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("inst/icons/home.jpg"));
	Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
	ImageIcon i3 = new ImageIcon(i2);
	
	JLabel img = new JLabel(i3);
	img.setBounds(0, 0, 1120, 630);
	add(img);
	
	JLabel heading = new JLabel("Employee Management System");
	heading.setBounds(340,155 ,400 ,40 );
	heading.setFont(new Font("Raleway"  , Font.BOLD, 25));
	img.add(heading);
	
	
	JButton Add = new JButton("ADD Employee");
	Add.setBounds(335,270 ,150 ,40 );
	Add.setForeground(Color.white);
	Add.setBackground(Color.black);
	Add.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new AddEmployee();
			setVisible(false);
			
		}
	});
	img.add(Add);
	
	JButton View = new JButton("View Employee");
	View.setBounds(565,270 ,150 ,40 );
	View.setForeground(Color.white);
	View.setBackground(Color.black);
	View.addActionListener( new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new ViewEmployee();
			setVisible(false);
			
		}
	});
	img.add(View);
	
	JButton Remove = new JButton("Remove Employee");
	Remove.setBounds(440,370 ,150 ,40 );
	Remove.setForeground(Color.white);
	Remove.setBackground(Color.black);
	Remove.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new RemoveEmployee();
			
		}
	});
	img.add(Remove);
	
	setSize(1120, 630);
	setLocation(250, 100);
	setLayout(null);
	setVisible(true);
}	
}
