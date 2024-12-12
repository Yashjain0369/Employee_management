package inst.login;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import inst.connection.Conn;
import inst.login_main.login_main;

public class RemoveEmployee extends JFrame implements ActionListener{

	Choice empid;
 JButton delete , back;
 
	
	 public RemoveEmployee() {
		
		
		JLabel label = new JLabel("Employee ID");
		label.setBounds(50,50 ,100,30 );
		label.setFont(new Font("Tahoma" , Font.BOLD , 15));
		add(label);
		
		empid = new Choice();
		empid.setBounds(200,50 ,150 ,30 );
add(empid);

try {
	Conn c = new Conn();
	ResultSet  rs = c.statement.executeQuery("SELECT * FROM employee");
	while(rs.next()) {
		empid.add(rs.getString("EmpID"));
		
	}
	
} catch (Exception e) {
	e.printStackTrace();
}

JLabel labelname = new JLabel("Name");
labelname.setBounds(50,100 ,100,30 );
labelname.setFont(new Font("Tahoma" , Font.BOLD , 15));
add(labelname);
		

 final JLabel textname = new JLabel();
textname.setBounds(200,100 ,100,30 );
add(textname);

JLabel labelphone = new JLabel("Phone No");
labelphone.setBounds(50,150 ,100,30 );
labelphone.setFont(new Font("Tahoma" , Font.BOLD , 15));
add(labelphone );

final   JLabel textphone = new JLabel();
textphone.setBounds(200,150 ,100,30 );
add(textphone);

JLabel labelemail = new JLabel("Email ID");
labelemail.setBounds(50,200 ,100,30 );
labelemail.setFont(new Font("Tahoma" , Font.BOLD , 15));
add(labelemail );

  final JLabel textemail = new JLabel();
textemail.setBounds(200,200 ,100,30 );
add(textemail);

try {
	
	Conn c = new Conn();
	ResultSet rs = c.statement.executeQuery("SELECT * FROM employee where EmpID = '"+empid.getSelectedItem()+"'");
	while(rs.next()) {
		textname.setText(rs.getString("name"));
		textphone.setText(rs.getString("PhoneNo"));
		textemail.setText(rs.getString("Email"));
	
		
	}
} catch (Exception e) {
	e.printStackTrace();
}

empid.addItemListener(new ItemListener() {
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		try {
			
			Conn c = new Conn();
			ResultSet rs = c.statement.executeQuery("SELECT * FROM employee where EmpID = '"+empid.getSelectedItem()+"'");
			while(rs.next()) {
				textname.setText(rs.getString("name"));
				textphone.setText(rs.getString("PhoneNo"));
				textemail.setText(rs.getString("Email"));
			
			}
		}
			
		catch (Exception e2) {
			e2.printStackTrace();
		}
		
	}
});

delete = new JButton("Delete");
delete.setBounds(80,300 ,100 ,30 );
delete.setBackground(Color.black);
delete.setForeground(Color.white);
delete.addActionListener(this);
add(delete);

back = new JButton("Back");
back.setBounds(220,300 ,100 ,30 );
back.setBackground(Color.black);
back.setForeground(Color.white);
back.addActionListener(this);
add(back);

ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("inst/icons/delete.png"));
Image i2 = i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
ImageIcon i3 = new ImageIcon(i2);

JLabel img = new JLabel(i3);
img.setBounds(700, 80, 200, 200);
add(img);

ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("inst/icons/rback.png"));
Image i22 = i11.getImage().getScaledInstance(1120, 630,Image.SCALE_DEFAULT);
ImageIcon i33 = new ImageIcon(i22);

JLabel img1 = new JLabel(i33);
img1.setBounds(0, 0, 1120, 630);
add(img1);




		setSize(1000, 400);
		setLocation(300,150 );
		setLayout(null);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new RemoveEmployee();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
if(e.getSource() == delete) {
	
	try {
		Conn c = new Conn();
		String query = "DELETE FROM employee where EmpID = '"+empid.getSelectedItem()+"'";
		c.statement.executeUpdate(query);
		JOptionPane.showMessageDialog(null, "Employee Details Deleted Successfully ");
		setVisible(false);
		new login_main();
	}
	
	catch (Exception e3) {
		e3.printStackTrace();
	}
	
}
else {
	setVisible(false);
}
		
	}
}
	
