package com.ecommerce.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ecommerce.dao.DBConnection;
import com.ecommerce.dao.ProductDao;
import com.ecommerce.model.Product;

public class ProductDaoImpl implements ProductDao {

	private Connection con;

	public ProductDaoImpl() {
		con = DBConnection.getConnection();
	}

	@Override
	public boolean addProduct(Product pr) {
		try {
			String query = "insert into product (name,description,price) values (?,?,?)";

			PreparedStatement ps;
			ps = con.prepareStatement(query);

			ps.setString(1, pr.getName());
			ps.setString(2, pr.getDesc());
			ps.setFloat(3, pr.getPrice());

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
	public boolean removeProduct(int id) {
		try {
			String query = "delete from product where id = ?";
			PreparedStatement ps;
			ps = con.prepareStatement(query);

			ps.setInt(1, id);

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
	public boolean updateProduct(Product pr) {
		try {
			String query = "update product set name=?,description=?,price=? where id = ?";
			PreparedStatement ps;
			ps = con.prepareStatement(query);

			ps.setString(1, pr.getName());
			ps.setString(2, pr.getDesc());
			ps.setFloat(3, pr.getPrice());
			ps.setInt(4, pr.getId());

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
	public Product searchProductById(int id) {
		try {
			String query = "select * from product where id = ?";

			PreparedStatement ps;
			ps = con.prepareStatement(query);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next() == true) {

				int a = rs.getInt(1);
				String b = rs.getString(2);
				String c = rs.getString(3);
				float d = rs.getFloat(4);
				Product p = new Product(a, b, d, c);
				return p;
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public ArrayList<Product> getAllProducts() {
		try {
			ArrayList<Product> lst = new ArrayList<>();

			String query = "select * from product";

			PreparedStatement ps;
			ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next() == true) {

				int a = rs.getInt(1);
				String b = rs.getString(2);
				String c = rs.getString(3);
				float d = rs.getFloat(4);
				Product p = new Product(a, b, d, c);
				lst.add(p);

			}
			return lst;

		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}

}
