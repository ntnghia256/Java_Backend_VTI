package com.vti.ProductManagement.backend.business_layer;

import java.sql.SQLException;
import java.util.List;

import com.vti.ProductManagement.backend.data_layer.IProductRepository;
import com.vti.ProductManagement.backend.data_layer.ProductRepository;
import com.vti.ProductManagement.backend.entity.Product;

public class ProductService implements IProductService {
	
private IProductRepository productRepository;
	
	public ProductService() {
		productRepository = new ProductRepository();
	}

	@Override
	public List<Product> getAllProducts() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return productRepository.getAllProducts();
	}

	@Override
	public boolean deleteProductById(int productId) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return productRepository.deleteProductById(productId);
	}

	@Override
	public boolean updateProductNameById(int productId, String newName) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return productRepository.updateProductNameById(productId, newName);
	}

	@Override
	public boolean addProduct(Product product) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return productRepository.addProduct(product);
	}

	@Override
	public boolean isProductNameExists(String productName) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

}
