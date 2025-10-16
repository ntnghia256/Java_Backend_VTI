package com.vti.ProductManagement.frontend;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.vti.ProductManagement.backend.business_layer.ProductService;
import com.vti.ProductManagement.backend.entity.Manufacturer;
import com.vti.ProductManagement.backend.entity.Product;
import com.vti.ProductManagement.backend.presentation_layer.ManufacturerController;
import com.vti.ProductManagement.backend.presentation_layer.ProductController;

public class Function {
	private ManufacturerController manufacturerController;
	private ProductController productController;

	public Function() {
		manufacturerController = new ManufacturerController();
		productController = new ProductController();
	}

	Scanner scanner = new Scanner(System.in);

	public void findManufacturer() throws ClassNotFoundException, SQLException {
		while (true) {
			System.out.println("Moi ban nhap id cua manufacturer: ");
			int id = scanner.nextInt();

			Manufacturer m = manufacturerController.getManufacturerById(id);

			if (m != null) {
				System.out.println(m);
			} else {
				System.out.println("Khong co hang nao trung khop voi id");
			}

			System.out.print("Bạn có muốn tiếp tục tìm sản phẩm khác? (y/n): ");
			String choice = scanner.nextLine();
			if (!choice.equalsIgnoreCase("y")) {
				break;
			}
		}
	}

	public void getAllProducts() throws ClassNotFoundException, SQLException {
		List<Product> products = productController.getAllProducts();

		if (products != null && !products.isEmpty()) {
			for (Product p : products) {
				System.out.println(p);
			}
		} else {
			System.out.println("Không có sản phẩm nào trong hệ thống.");
		}
	}

	public void deleteProduct() throws ClassNotFoundException, SQLException {
		while (true) {
			System.out.println("Moi ban nhap id cua product can xoa: ");
			int id = scanner.nextInt();

			boolean isDeleted = productController.deleteProductById(id);

			if (isDeleted) {
				System.out.println("Delete product by id successfully");
			} else {
				System.out.println("Can't not delete");
			}
			System.out.print("Bạn có muốn tiếp tục xóa sản phẩm khác? (y/n): ");
			String choice = scanner.nextLine();
			if (!choice.equalsIgnoreCase("y")) {
				break;
			}
		}

	}

	public void updateProduct() throws ClassNotFoundException, SQLException {
		while (true) {
			System.out.print("Mời bạn nhập id của product cần sửa: ");
			int id = scanner.nextInt();
			scanner.nextLine(); // Xóa bỏ ký tự xuống dòng thừa

			System.out.print("Mời bạn nhập tên mới của product: ");
			String newName = scanner.nextLine();

			boolean isUpdated = productController.updateProductById(id, newName);

			if (isUpdated) {
				System.out.println("Cập nhật sản phẩm thành công!");
			} else {
				System.out.println("Không thể cập nhật sản phẩm!");
			}

			System.out.print("Bạn có muốn tiếp tục cập nhật sản phẩm khác? (y/n): ");
			String choice = scanner.nextLine();
			if (!choice.equalsIgnoreCase("y")) {
				break;
			}
		}

	}

	public void addProduct() throws ClassNotFoundException, SQLException {
		while (true) {
			Product product = new Product();

			// Nhập tên sản phẩm (NOT NULL, UNIQUE)
			System.out.print("Nhập tên sản phẩm: ");
			String productName;
			do {
				productName = scanner.nextLine().trim();
				if (productName.isEmpty()) {
					System.out.println("Tên sản phẩm không được để trống!");
				}
			} while (productName.isEmpty());
			product.setProductName(productName);

			// Nhập giá sản phẩm (VARCHAR -> lưu chuỗi, có thể kèm đơn vị)
			System.out.print("Nhập giá sản phẩm: ");
			String productPrice;
			do {
				productPrice = scanner.nextLine().trim();
				if (productPrice.isEmpty()) {
					System.out.println("Giá sản phẩm không được để trống!");
				}
			} while (productPrice.isEmpty());
			product.setProductPrice(productPrice);

			// Nhập thông tin sản phẩm (NOT NULL)
			System.out.print("Nhập thông tin sản phẩm: ");
			String productInfo;
			do {
				productInfo = scanner.nextLine().trim();
				if (productInfo.isEmpty()) {
					System.out.println("Thông tin sản phẩm không được để trống!");
				}
			} while (productInfo.isEmpty());
			product.setProductInfo(productInfo);

			// Nhập mô tả chi tiết (có thể bỏ trống)
			System.out.print("Nhập mô tả chi tiết: ");
			product.setProductDetail(scanner.nextLine().trim());

			// Nhập số sao (1-5) hoặc bỏ trống
			System.out.print("Nhập số sao đánh giá (1-5, bỏ trống nếu chưa có): ");
			String ratingInput = scanner.nextLine().trim();
			if (!ratingInput.isEmpty()) {
				try {
					int rating = Integer.parseInt(ratingInput);
					if (rating < 1 || rating > 5) {
						System.out.println("Số sao không hợp lệ! Mặc định = 1");
						rating = 1;
					}
					product.setRatingStar(rating);
				} catch (NumberFormatException e) {
					System.out.println("Số sao không hợp lệ! Mặc định = 1");
					product.setRatingStar(1);
				}
			}

			// Nhập Product Image Name (NOT NULL)
			System.out.print("Nhập Product Image Name: ");
			String imageName;
			do {
				imageName = scanner.nextLine().trim();
				if (imageName.isEmpty()) {
					System.out.println("Tên ảnh không được để trống!");
				}
			} while (imageName.isEmpty());
			product.setProductImageName(imageName);

			// Nhập ManufacturerId (bắt buộc)
			System.out.print("Nhập Manufacturer ID: ");
			int manuId = readIntRequired("Manufacturer ID");
			product.setManufactureId(manuId);

			// Nhập CategoryId (bắt buộc)
			System.out.print("Nhập Category ID: ");
			int catId = readIntRequired("Category ID");
			product.setCategoryId(catId);

			// Gọi Controller để thêm sản phẩm
			if (productController.addProductController(product)) {
				System.out.println("Thêm sản phẩm thành công!");
			} else {
				System.out.println("Không thể thêm sản phẩm! - Có thể trùng tên hoặc dữ liệu sai.");
			}

			// Hỏi người dùng có muốn tiếp tục hay không
			System.out.print("Bạn có muốn tiếp tục thêm sản phẩm khác? (y/n): ");
			String choice = scanner.nextLine().trim();
			if (!choice.equalsIgnoreCase("y")) {
				break;
			}
		}
	}

	// Hàm nhập số nguyên bắt buộc
	private int readIntRequired(String fieldName) {
		while (true) {
			String input = scanner.nextLine().trim();
			try {
				return Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.out.print(fieldName + " không hợp lệ! Vui lòng nhập lại: ");
			}
		}
	}

}
