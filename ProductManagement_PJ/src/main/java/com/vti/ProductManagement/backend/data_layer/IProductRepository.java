package com.vti.ProductManagement.backend.data_layer;

import java.sql.SQLException;
import java.util.List;

import com.vti.ProductManagement.backend.entity.Product;

public interface IProductRepository {
	/**
	 * 1. Get list product Include: Id, name, price, detail, rate, manufacturer
	 * 
	 * @throws SQLException, ClassNotFoundException
	 */
	List<Product> getAllProducts() throws SQLException, ClassNotFoundException;

	/**
	 * 2. Delete by id
	 * 
	 * @param productId - id
	 * @return true if success, false if fail
	 */
	boolean deleteProductById(int productId) throws SQLException, ClassNotFoundException;

	/**
	 * 3. Update id
	 * 
	 * @param productId - id product
	 * @param newName   -
	 * @return true if success, false if fail
	 */
	boolean updateProductNameById(int productId, String newName) throws SQLException, ClassNotFoundException;

	/**
	 * 4. Add product - Before add new product check if exists
	 * 
	 * @param product - new product info
	 * @return true if success, false if fail
	 */
	boolean addProduct(Product product) throws SQLException, ClassNotFoundException;

	/**
	 * Check product has been already exists yet?
	 * 
	 * @param productName - name need to check
	 * @return true if exists, false if not
	 */
	boolean isProductNameExists(String productName) throws SQLException, ClassNotFoundException;
}
