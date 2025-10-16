package com.vti.ProductManagement.frontend;

import java.sql.SQLException;
import java.util.Scanner;

public class Program {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		register();
	}

	public static void register() throws ClassNotFoundException, SQLException {
		Function function = new Function();
		int choice;

		System.out.println("+-----------------------------------------+");
		System.out.println("|         MỜI BẠN CHỌN CHỨC NĂNG           |");
		System.out.println("+-----------------------------------------+");
		System.out.println("| 1. Tìm kiếm nhà sản xuất theo ID        |");
		System.out.println("| 2. Xem danh sách thông tin sản phẩm     |");
		System.out.println("|    trên hệ thống                        |");
		System.out.println("| 3. Xóa sản phẩm theo ID                 |");
		System.out.println("| 4. Cập nhật tên của sản phẩm đang có    |");
		System.out.println("| 5. Thêm mới sản phẩm                    |");
		System.out.println("| 6. Chức năng kiểm tra Email             |");
		System.out.println("| 7. Exit                                 |");
		System.out.println("+-----------------------------------------+");
		System.out.print("Mời bạn chọn: ");
		choice = sc.nextInt();

		switch (choice) {
		case 1:
//			System.out.println(">> Tìm kiếm nhà sản xuất theo ID");
			function.findManufacturer();
			break;
		case 2:
//			System.out.println(">> Xem danh sách sản phẩm");
			function.getAllProducts();
			break;
		case 3:
			System.out.println(">> Xóa sản phẩm theo ID");
			function.deleteProduct();
			break;
		case 4:
			System.out.println(">> Cập nhật tên sản phẩm");
			function.updateProduct();
			break;
		case 5:
			System.out.println(">> Thêm mới sản phẩm");
			function.addProduct();
			break;
		case 6:
			System.out.println(">> Kiểm tra Email");
			break;
		case 7:
			System.out.println(">> Thoát chương trình");
			break;
		default:
			System.out.println("Lựa chọn không hợp lệ!");
		}
		System.out.println();

		sc.close();
	}

}
