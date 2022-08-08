package com.revature.utils;

import java.sql.Connection; //java.sql is the JDBC package
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	// A singleton design pattern only allows one instance of a Class to exist in
	// memory at a time. Connection here is singleton

	private static Connection connection;

	public static Connection getConnection() throws SQLException {
		if (connection != null && !connection.isClosed()) {
			return connection;
		} else {

			// For many frameworks, or in cases where there are multiple SQL drivers, you
			// will need to register which
			// Driver you are using for the connection interface. The Class.forName method
			// will allow you to do this.
			// This step is often unnecessary for simple projects but is considered best
			// practice.

			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			String url = "jdbc:postgresql://javafs220725.ctl0w09tjsjs.us-east-1.rds.amazonaws.com:5432/demos";
			String username = "postgres"; // It is possible to hide raw credentials by using ENV variables
			String password = "password1234"; // You can access those variables with System.getenv("var-name");

			connection = DriverManager.getConnection(url, username, password);

			return connection;

		}
	}

	public static void main(String[] args) {
		try {
			getConnection();
			System.out.println("Connection Successful");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
