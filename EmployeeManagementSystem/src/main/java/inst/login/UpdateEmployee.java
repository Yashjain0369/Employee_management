package inst.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import inst.connection.Conn;
import inst.login_main.login_main;

public class UpdateEmployee extends JFrame implements ActionListener {

	JTextField tedu;
	JTextField tfname;
	JTextField taddress;
	JTextField tphone;
	JTextField taadhar;
	JTextField temail;

	JTextField tsalary;
	JTextField tdesignation;
	JLabel Employeeid;

	JButton Add;
	JButton back;
	String number;

	public UpdateEmployee(String number) {

		this.number = number;

		getContentPane().setBackground(new Color(163, 255, 188));

		JLabel heading = new JLabel("Add Employee Details");
		heading.setBounds(320, 30, 500, 50);
		heading.setFont(new Font("serif", Font.BOLD, 25));
		add(heading);

		JLabel name = new JLabel("Name");
		name.setBounds(50, 150, 150, 30);
		name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		add(name);

		JLabel tname = new JLabel();
		tname.setBounds(200, 150, 150, 30);
		tname.setBackground(new Color(177, 252, 197));
		add(tname);

		JLabel fname = new JLabel("Father's Name");
		fname.setBounds(400, 150, 150, 30);
		fname.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		add(fname);

		tfname = new JTextField();
		tfname.setBounds(600, 150, 150, 30);
		tfname.setBackground(new Color(177, 252, 197));
		add(tfname);

		JLabel dob = new JLabel("Date Of Birth");
		dob.setBounds(50, 200, 150, 30);
		dob.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		add(dob);

		JLabel tdob = new JLabel();
		tdob.setBounds(50, 20, 150, 30);
		tdob.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(tdob);

		JLabel Salary = new JLabel("Salary");
		Salary.setBounds(400, 200, 150, 30);
		Salary.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		add(Salary);

		tsalary = new JTextField();
		tsalary.setBounds(600, 200, 150, 30);
		tsalary.setBackground(new Color(177, 252, 197));
		add(tsalary);

		JLabel address = new JLabel("Address");
		address.setBounds(50, 250, 150, 30);
		address.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		add(address);

		taddress = new JTextField();
		taddress.setBounds(200, 250, 150, 30);
		taddress.setBackground(new Color(177, 252, 197));
		add(taddress);

		JLabel phone = new JLabel("Phone No.");
		phone.setBounds(400, 250, 150, 30);
		phone.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		add(phone);

		tphone = new JTextField();
		tphone.setBounds(600, 250, 150, 30);
		tphone.setBackground(new Color(177, 252, 197));
		add(tphone);

		JLabel Email = new JLabel("Email ID");
		Email.setBounds(50, 300, 150, 30);
		Email.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		add(Email);

		temail = new JTextField();
		temail.setBounds(200, 300, 150, 30);
		temail.setBackground(new Color(177, 252, 197));
		add(temail);

		JLabel Education = new JLabel("Education");
		Education.setBounds(400, 300, 150, 30);
		Education.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		add(Education);

		tedu = new JTextField();
		tedu.setBounds(600, 300, 150, 30);
		tedu.setBackground(new Color(177, 252, 197));
		add(tedu);

//		String items[] = { "BBA", "B.Tech", "BCA", "BA", "BSC", "B.Com", "MBA", "MCA", "MA", "M.Tech", "MSC", "PHD" };

//		tedu = new JComboBox(items);
//		tedu.setBackground(new Color(177, 252, 197));
//		tedu.setBounds(600, 300, 150, 30);
//		add(tedu);

		JLabel Aadhar = new JLabel("Aadhar Card No.");
		Aadhar.setBounds(400, 350, 150, 30);
		Aadhar.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		add(Aadhar);

		JLabel taadhar = new JLabel();
		taadhar.setBounds(600, 350, 150, 30);
		taadhar.setBackground(new Color(177, 252, 197));
		add(taadhar);

		JLabel Employeeid = new JLabel("Employee ID ");
		Employeeid.setBounds(50, 400, 150, 30);
		Employeeid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		add(Employeeid);

		JLabel Designation = new JLabel("Designation");
		Designation.setBounds(50, 350, 150, 30);
		Designation.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		add(Designation);

		tdesignation = new JTextField();
		tdesignation.setBounds(200, 350, 150, 30);
		tdesignation.setBackground(new Color(177, 252, 197));
		add(tdesignation);

		try {
			Conn c = new Conn();
			String query = "SELECT * FROM employee where EmpID = '" + number + "'";
			ResultSet rs = c.statement.executeQuery(query);

			while (rs.next()) {
				tname.setText(rs.getString("name"));
				tfname.setText(rs.getString("fname"));
				tdob.setText(rs.getString("DOB"));
				tsalary.setText(rs.getString("Salary"));
				taddress.setText(rs.getString("Address"));
				temail.setText(rs.getString("Email"));
				tphone.setText(rs.getString("PhoneNo"));
				tedu.setText(rs.getString("Education"));
				tdesignation.setText(rs.getString("Designation"));
				taadhar.setText(rs.getString("AdharNo"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Add = new JButton("Update");
		Add.setBounds(450, 550, 150, 40);
		Add.setBackground(Color.black);
		Add.setForeground(Color.white);
		Add.addActionListener(this);
		add(Add);

		back = new JButton("Back");
		back.setBounds(250, 550, 150, 40);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.addActionListener(this);
		add(back);

		setSize(900, 700);
		setLayout(null);
		setLocation(300, 50);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Add) {

			String fname = tfname.getText();
			String salary = tsalary.getText();
			String address = taddress.getText();
			String phoneno = tphone.getText();
			String email = temail.getText();
			String education = tedu.getText();
			String designation = tdesignation.getText();

			try {

				Conn c = new Conn();
				String query = "UPDATE employee set fname = '" + fname + "' , Salary = '" + salary + "'  , Address = '"
						+ address + "' ,  Email = '" + email + "',  PhoneNo = '" + phoneno + "' ,  Education = '"
						+ education + "', Designation = '"+designation+"'   where EmpId = '"+number+"' ";
				
				c.statement.executeUpdate(query);
				JOptionPane.showMessageDialog(null , "Details Updated Successfully");
setVisible(false);
new login_main();

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}else {
			setVisible(false);
			new ViewEmployee();
		}

	}

	public static void main(String[] args) {

		new UpdateEmployee("");

	}

}
