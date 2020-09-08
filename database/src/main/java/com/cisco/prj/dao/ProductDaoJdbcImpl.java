package com.cisco.prj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cisco.prj.entity.Product;

public class ProductDaoJdbcImpl implements ProductDao {

	@Override
	public void addProduct(Product p) throws DaoException {
		String SQL = "INSERT INTO products (id, name, price, quantity) VALUES (0, ?, ?, ?)";
		Connection con = null;

		try {
			con = DBUtil.getConn();
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setString(1, p.getName());
			ps.setDouble(2, p.getPrice());
			ps.setInt(3, p.getQuantity());
			ps.executeUpdate(); // INSERT, DeLETE and UPDATE
		} catch (SQLException e) {
			throw new DaoException("unable to add product", e);
		} finally {
			DBUtil.closeConnection(con);
		}

	}

	@Override
	public List<Product> getProducts() throws DaoException {
		
		List<Product> list = new ArrayList<Product>();
		String SQL = "SELECT id, name, price, quantity FROM products";
		Connection con = null;
		
		try {
			con = DBUtil.getConn();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			while(rs.next()) {
				list.add(new Product(rs.getInt("id"), 
						rs.getString("name"), 
						rs.getDouble("price"), 
						rs.getInt("quantity")));
			}
		} catch (SQLException e) {
			throw new DaoException("unable to get products", e);
		} finally {
			DBUtil.closeConnection(con);
		}

		return list;
	}

}
