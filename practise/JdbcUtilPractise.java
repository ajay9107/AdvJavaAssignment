package practice_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtilPractise {
	public static Connection buildConnection() throws SQLException {
		
		
		String connectionurl = "jdbc:mysql://localhost:3306/cdac";
		String userName = "root";
		String password = "password";
		
		Connection	dbConnection = DriverManager.getConnection(connectionurl, userName, password);
		
		return dbConnection;
	}
}
