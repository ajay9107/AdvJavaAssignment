package com.flights.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AutoConnect {
	private static Connection con;
	public static Connection autoConnect() throws SQLException, ClassNotFoundException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/flight_reservation";
		String user="root";
		String pass="password";
		con=DriverManager.getConnection(url, user, pass);
		return con;
		
	}

}
