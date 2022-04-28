package com.tcs.studentcrud.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

	public static Connection getJDBCConnection() {
		Connection con = null;
		try {

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}

		return con;

	}

}
