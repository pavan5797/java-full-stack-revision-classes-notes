package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String user = "root";
	private static String pass = "Pavan@5797";
	private static String url = "jdbc:mysql://localhost:3306/ecom";
	private static Connection con = null;

	public static Connection getConnection() {
		try {
			// load driver
			Class.forName(driver);

			// create connection
			con = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException e) {
			System.out.println("driver not found");
		} catch (SQLException e) {
			System.out.println("DB issues " + e);
		}
		return con;
	}
}
