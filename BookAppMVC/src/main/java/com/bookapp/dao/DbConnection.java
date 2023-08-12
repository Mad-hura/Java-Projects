package com.bookapp.dao;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
	import com.bookapp.util.Queries;

	public class DbConnection {
		static Connection connection;

		public static Connection openConnection() {
			String url = "jdbc:mysql://localhost:3306/mysql";
			String user = "root";
			String password = "admin@123";

			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(url, user, password);
				PreparedStatement statement = connection.prepareStatement(Queries.CREATEQUERY);
				statement.execute();

			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
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