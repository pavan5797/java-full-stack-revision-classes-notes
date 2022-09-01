package com.ecommerce.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ecommerce.dao.DBConnection;
import com.ecommerce.dao.userDao;
import com.ecommerce.model.user;

public class UserDaoImpl implements userDao {

	private Connection con;

	public UserDaoImpl() {
		con = DBConnection.getConnection();
	}

	@Override
	public boolean register(user u) {
		try {
			String query = "insert into user (name,email,password) values (?,?,?)";

			PreparedStatement ps;
			ps = con.prepareStatement(query);

			ps.setString(1, u.getName());
			ps.setString(3, u.getPassword());
			ps.setString(2, u.getEmail());

			int n = ps.executeUpdate();
			if (n > 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean userLogin(String email, String password) {
		try {
			String query = "select * from user where email=? and password = ?";

			PreparedStatement ps;
			ps = con.prepareStatement(query);

			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			boolean s = rs.next();
			return s;
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}

}
