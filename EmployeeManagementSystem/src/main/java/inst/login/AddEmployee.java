package inst.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import inst.connection.Conn;
import inst.login_main.login_main;

public class AddEmployee extends JFrame implements ActionListener {

	Random ran = new Random();
	int number = ran.nextInt(999999);

	JTextField tname;
	JTextField tfname;
	JTextField taddress;
	JTextField tphone;
	JTextField taadhar;
	JTextField temail;

	JTextField tsalary;
	JTextField tdesignation;
	JLabel Employeeid;
	JTextField tEID;

	JDateChooser tdob;
	JComboBox tedu;
	JButton Add;
	JButton back;

	public AddEmployee() {

		getContentPane().setBackground(new Color(163, 255, 188));

		JLabel heading = new JLabel("Add Employee Details");
		heading.setBounds(320, 30, 500, 50);
		heading.setFont(new Font("serif", Font.BOLD, 25));
		add(heading);

		JLabel name = new JLabel("Name");
		name.setBounds(50, 150, 150, 30);
		name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		add(name);

	tname = new JTextField();
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

		tdob = new JDateChooser();
		tdob.setBounds(200, 200, 150, 30);
		tdob.setBackground(new Color(177, 252, 197));
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

		String items[] = { "BBA", "B.Tech", "BCA", "BA", "BSC", "B.Com", "MBA", "MCA", "MA", "M.Tech", "MSC", "PHD" };

		tedu = new JComboBox(items);
		tedu.setBackground(new Color(177, 252, 197));
		tedu.setBounds(600, 300, 150, 30);
		add(tedu);

		JLabel Aadhar = new JLabel("Aadhar Card No.");
		Aadhar.setBounds(400, 350, 150, 30);
		Aadhar.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		add(Aadhar);

		 taadhar = new JTextField();
		taadhar.setBounds(600, 350, 150, 30);
		taadhar.setBackground(new Color(177, 252, 197));
		add(taadhar);

		JLabel Employeeid = new JLabel("Employee ID ");
		Employeeid.setBounds(50, 400, 150, 30);
		Employeeid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		add(Employeeid);

		tEID = new JTextField("" + number);
		tEID.setBounds(200, 400, 150, 30);
		tEID.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		tEID.setForeground(Color.red);
		add(tEID);

		JLabel Designation = new JLabel("Designation");
		Designation.setBounds(50, 350, 150, 30);
		Designation.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		add(Designation);

		 tdesignation = new JTextField();
		tdesignation.setBounds(200, 350, 150, 30);
		tdesignation.setBackground(new Color(177, 252, 197));
		add(tdesignation);

		Add = new JButton("Add");
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
			String name = tname.getText();
			String fname = tfname.getText();
			String dob = ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
			String Salary = tsalary.getText();
			String address = taddress.getText();
			String phoneNo = tphone.getText();
			String Email = temail.getText();
			String Education = (String) tedu.getSelectedItem();
			String Designation = tdesignation.getText();
			String empID = tEID.getText();
			String AdharNo = taadhar.getText();

			try {
				Conn c = new Conn();

				String query = "INSERT INTO employee  VALUES('" + name + "' , '" + fname + "' , '" + dob + "' , '"
						+ Salary + "'  ,'" + address + "' , '" + Email + "' , '" + phoneNo + "' , '" + Education
						+ "' , '" + Designation + "' , '" + AdharNo + "' , '" + empID + "'   )";
			
				c.statement.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Details added successfully");
				setVisible(false);

				new login_main();
			} catch (Exception e2) {
e2.printStackTrace();
			}
		}
		else {
			setVisible(false);
			new login_main();
			
		}

	}

	public static void main(String[] args) {
		new AddEmployee();
	}

}
