package com.ecommerce.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ecommerce.dao.AdminDao;
import com.ecommerce.dao.DBConnection;

public class AdminDaoImpl implements AdminDao {

	private Connection con;

	public AdminDaoImpl() {
		con = DBConnection.getConnection();
	}

	@Override
	public boolean adminLogin(String a, String b) {
		String query = "select * from admin where email=? and password = ?";
		try {
			PreparedStatement ps;
			ps = con.prepareStatement(query);

			ps.setString(1, a);
			ps.setString(2, b);

			ResultSet rs = ps.executeQuery();

			boolean s = rs.next();

			return s;
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}
}