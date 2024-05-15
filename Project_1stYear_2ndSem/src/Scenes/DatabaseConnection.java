package Scenes;

import java.sql.*;

public class DatabaseConnection {
	Connection con;
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/payrollsystemdb";
	String username = "root";
	String password = "";
	
	public Connection getConnection() throws SQLException {
		
		// This will check if the connection is already initialized, if there are connection, it will just reuse it to avoid creating multiple connections
		if(con== null) {
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con = DriverManager.getConnection(url, username, password);
		}
		return con;
	}
}
