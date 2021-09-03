package dao;

import java.sql.*;
import java.util.ResourceBundle;

public class ConnectionFactory {
	
	
	private static Connection connection = null;
	
	private ConnectionFactory() {}
	
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		if(connection == null) {
			String url = "jdbc:mysql://localhost:3306/project_1";
			String username = "root";
			String password= "66241927S3cr3t?";
			
			connection = DriverManager.getConnection(url, username, password);
		}
		return connection;
	}
}