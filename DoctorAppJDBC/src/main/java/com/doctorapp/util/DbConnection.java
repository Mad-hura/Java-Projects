package com.doctorapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;





public class DbConnection {
	static Connection connection;

	public static Connection openConnection() {
		String url = "jdbc:mysql://localhost:3306/mysql";
		String user = "root";
		String password = "admin@123";

		try {
			connection = DriverManager.getConnection(url, user, password);
			Statement statement = connection.createStatement();
			statement.execute(Queries.CREATEQUERY);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void closeConnection() {
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}


