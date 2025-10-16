package com.vti.ProductManagement.backend.presentation_layer;

import java.sql.SQLException;
import java.util.List;

import com.vti.ProductManagement.backend.business_layer.IProductService;
import com.vti.ProductManagement.backend.business_layer.ProductService;
import com.vti.ProductManagement.backend.entity.Product;

public class ProductController {
	private IProductService productService;
	
	public ProductController() {
		productService = new ProductService();
	}
	
	public List<Product> getAllProducts() throws ClassNotFoundException, SQLException {
		return productService.getAllProducts();
	}
	
	public boolean deleteProductById(int productId) throws ClassNotFoundException, SQLException {
		return productService.deleteProductById(productId);
	}
	
	public boolean updateProductById(int productId, String newName) throws ClassNotFoundException, SQLException {
		return productService.updateProductNameById(productId, newName);
	}
	
	public boolean addProductController(Product product) throws ClassNotFoundException, SQLException {
		return productService.addProduct(product);
	}
}
