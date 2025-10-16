package com.vti.ProductManagement.backend.entity;

public class Product {
	private int productId;
	private String productName;
	private String productPrice;
	private String productInfo;
	private String productDetail;
	private int ratingStar;
	private String productImageName;
	private int manufactureId;
	private int categoryId;
	private ManufacturerName manufacturerName; 

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int productId, String productName, String productPrice, String productInfo, String productDetail,
			int ratingStar, String productImageName, int manufactureId, int categoryId) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productInfo = productInfo;
		this.productDetail = productDetail;
		this.ratingStar = ratingStar;
		this.productImageName = productImageName;
		this.manufactureId = manufactureId;
		this.categoryId = categoryId;
	}
	
	public Product(int productId, String productName, String productPrice, String productDetail,
			int ratingStar, ManufacturerName manufacturerName) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDetail = productDetail;
		this.ratingStar = ratingStar;
		this.manufacturerName = manufacturerName;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}

	public String getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}

	public int getRatingStar() {
		return ratingStar;
	}

	public void setRatingStar(int ratingStar) {
		this.ratingStar = ratingStar;
	}

	public String getProductImageName() {
		return productImageName;
	}

	public void setProductImageName(String productImageName) {
		this.productImageName = productImageName;
	}

	public int getManufactureId() {
		return manufactureId;
	}

	public void setManufactureId(int manufactureId) {
		this.manufactureId = manufactureId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productInfo=" + productInfo + ", productDetail=" + productDetail + ", ratingStar=" + ratingStar
				+ ", productImageName=" + productImageName + ", manufactureId=" + manufactureId + ", categoryId="
				+ categoryId + "]";
	}

}
