package inst.login;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.*;

import inst.connection.Conn;
import inst.login_main.login_main;

public class ViewEmployee extends JFrame implements ActionListener{

	Choice Emp;
	JTable table;
	JButton Search , print , update , back;
	
	public ViewEmployee(){
		getContentPane().setBackground(new Color(255,131,122));
		
		JLabel search = new JLabel("Search By Employee ID");
		search.setBounds(20, 20, 150, 20);
		add(search);
		
		Emp = new Choice();
		Emp.setBounds(180, 20, 150, 20);
		add(Emp);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.statement.executeQuery("SELECT * FROM employee");
		while(rs.next()) {
			Emp.add(rs.getString("EmpID"));
			
		}
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		table = new JTable();
		try {
			Conn c = new Conn();
			ResultSet rs = c.statement.executeQuery("SELECT * FROM employee");
		table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		JScrollPane  js = new JScrollPane(table);
		js.setBounds(0, 100, 900, 600);
		add(js);
		
		Search = new JButton("Search");
		Search.setBounds(20,70 ,80 ,20 );
		Search.addActionListener(this);
		add(Search);
		
		print = new JButton("print");
		print.setBounds(120,70 ,80 ,20 );
		print.addActionListener(this);
		add(print);
		
		update = new JButton("Update");
		update.setBounds(220,70 ,80 ,20 );
		update.addActionListener(this);
		add(update);
		
		back = new JButton("back");
		back.setBounds(320,70 ,80 ,20 );
		back.addActionListener(this);
		add(back);
		
		setSize(900, 700);
		setLayout(null);
	setLocation(300, 100);
	setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()  == Search) {
			String query = "SELECT * FROM employee where EmpID = '"+Emp.getSelectedItem()+"'";
			
			try {
			Conn c = new Conn();
			 ResultSet resultSet =c.statement.executeQuery(query);
			 table.setModel(DbUtils.resultSetToTableModel(resultSet));
			}
			catch (Exception E) {
				E.printStackTrace();
			}
			
		}
		else if(e.getSource()  == print) {
		try {
			table.print();
		}
		catch (Exception E) {
			E.printStackTrace();
		}
		
			
		}
		else if(e.getSource() == update) {
			setVisible(false);
			
			new UpdateEmployee(Emp.getSelectedItem());
		}
		else {
			setVisible(false);
			new login_main();
		}
		
	}
	public static void main(String[] args) {
		
		 new ViewEmployee();
		
	}

	
	
}
