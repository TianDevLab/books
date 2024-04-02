package com.ait.books;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper
{
	private String url;
	private static ConnectionHelper instance;

	private ConnectionHelper()
	{
		try {
			// This is the new driver class for MySQL Connector/J 8.0.x
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Updated JDBC URL for MySQL Connector/J 8.0.x with the new timezone property
			// Change the database name from 'space' to 'books'
			url = "jdbc:mysql://localhost/books?user=root&password=1996Allen&serverTimezone=UTC";
		} catch (ClassNotFoundException e) {
			// Handle the error - typically log it or print it to the console.
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		if (instance == null) {
			instance = new ConnectionHelper();
		}
		try {
			return DriverManager.getConnection(instance.url);
		} catch (SQLException e) {
			throw e;
		}
	}
	
	public static void close(Connection connection)
	{
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
