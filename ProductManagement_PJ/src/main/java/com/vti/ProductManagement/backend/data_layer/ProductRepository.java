package com.vti.ProductManagement.backend.data_layer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vti.ProductManagement.backend.entity.ManufacturerName;
import com.vti.ProductManagement.backend.entity.Product;
import com.vti.ProductManagement.utils.JDBCUtils;

public class ProductRepository implements IProductRepository {

	private JDBCUtils jdbcUtils;

	public ProductRepository() {
		jdbcUtils = new JDBCUtils();
	}

	@Override
	public List<Product> getAllProducts() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		try {
			Connection conn = jdbcUtils.getConnection();

			List<Product> list = new ArrayList<>();
			String sql = "SELECT p.ProductId, p.ProductName, p.ProductPrice, p.ProductDetail, p.RatingStar, p.ProductInfo, m.ManufacturerName FROM Product p JOIN Manufacturer m ON p.ManufacturerId = m.ManufacturerId";

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String manu = rs.getString("ManufacturerName");
				ManufacturerName m = ManufacturerName.valueOf(manu);

				Product p = new Product(rs.getInt("ProductId"), rs.getString("ProductName"),
						rs.getString("ProductPrice"), rs.getString("ProductDetail"), rs.getInt("RatingStar"), m);
				list.add(p);

			}
			return list;
		} finally {
			// TODO: handle finally clause
			jdbcUtils.disconnect();
		}
	}

	@Override
	public boolean deleteProductById(int productId) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM Product WHERE ProductId = ?";
		try (Connection conn = jdbcUtils.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, productId);
			int affected = ps.executeUpdate();
			return affected > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtils.disconnect();
		}
		return false;
	}

	@Override
	public boolean updateProductNameById(int productId, String newName) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		String sql = "UPDATE Product SET ProductName = ? WHERE ProductId = ?";
		try (Connection conn = jdbcUtils.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, newName);
			ps.setInt(2, productId);
			int affected = ps.executeUpdate();
			return affected > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean addProduct(Product product) throws SQLException, ClassNotFoundException {
		if (isProductNameExists(product.getProductName())) {
			System.out.println("Tên sản phẩm đã tồn tại.");
			return false;
		}

		String sql = "INSERT INTO productmanagement.Product (ProductName, ProductPrice, ProductInfo, ProductDetail, RatingStar, ProductImageName, ManufacturerId, CategoryId) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection conn = jdbcUtils.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, product.getProductName());
			ps.setString(2, product.getProductPrice()); // giá nên để double
			ps.setString(3, product.getProductInfo());
			ps.setString(4, product.getProductDetail());
			ps.setInt(5, product.getRatingStar());
			ps.setString(6, product.getProductImageName());
			ps.setInt(7, product.getManufactureId());
			ps.setInt(8, product.getCategoryId());

			return ps.executeUpdate() > 0;
		}
	}

	@Override
	public boolean isProductNameExists(String productName) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		String sql = "SELECT COUNT(*) FROM Product WHERE ProductName = ?";
		try (Connection conn = jdbcUtils.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, productName);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return rs.getInt(1) > 0;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
