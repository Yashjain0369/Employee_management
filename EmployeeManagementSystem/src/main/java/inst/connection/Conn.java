package inst.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Conn {

	Connection connection ;
		public Statement statement;
			
			
			public Conn() {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems" , "root" , "Anshjain9002@");
					statement = connection.createStatement();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}


			public PreparedStatement prepareStatement(String query) {
				try {
		            return connection.prepareStatement(query);
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		        return null;  // In case of an error
		    }
		
				
			}
	

