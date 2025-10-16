DROP DATABASE IF EXISTS ProductManagement;
CREATE DATABASE ProductManagement;
USE ProductManagement;

DROP TABLE IF EXISTS Manufacturer;
CREATE TABLE Manufacturer(
    ManufacturerId     SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    ManufacturerName   ENUM('SAMSUNG', 'APPLE', 'XIAOMI', 'OPPO') NOT NULL UNIQUE KEY
);

DROP TABLE IF EXISTS Category;
CREATE TABLE Category(
    CategoryId    SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    CategoryName  VARCHAR(30) NOT NULL UNIQUE KEY
);

DROP TABLE IF EXISTS Product;
CREATE TABLE Product(
    ProductId        SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    ProductName      VARCHAR(50) NOT NULL UNIQUE KEY,
	ProductPrice     VARCHAR(50) NOT NULL,
	ProductInfo      VARCHAR(200) NOT NULL,
    ProductDetail    VARCHAR(500),
    RatingStar       TINYINT UNSIGNED, 
	ProductImageName VARCHAR(50) NOT NULL,
    ManufacturerId   SMALLINT UNSIGNED NOT NULL,
    CategoryId       SMALLINT UNSIGNED NOT NULL,

    FOREIGN KEY (ManufacturerId) REFERENCES Manufacturer(ManufacturerId),
    FOREIGN KEY (CategoryId)     REFERENCES Category(CategoryId)
);

DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account`(
    AccountID            SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Email                VARCHAR(50) NOT NULL UNIQUE KEY,
    Username             VARCHAR(50) NOT NULL UNIQUE KEY,
	FullName             VARCHAR(50) NOT NULL,
	AvatarImageName      VARCHAR(50) UNIQUE KEY,
	Mobile               VARCHAR(50) UNIQUE KEY NOT NULL,
	Address              VARCHAR(50) UNIQUE KEY NOT NULL,
    CreateDate           DATETIME DEFAULT NOW(),
    `Password`           VARCHAR(100) NOT NULL,
	`Status`             TINYINT UNSIGNED DEFAULT 0  -- 0: Not Active, 1: Active
);
                  
/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/
-- Add data Manufacturer
INSERT INTO Manufacturer	(ManufacturerName	) 
VALUES 					   ('SAMSUNG'	        ),
						   ('APPLE'		        ),
					       ('XIAOMI'        	),
						   ('OPPO'		        ); 
                           
-- Add data Category
INSERT INTO Category(CategoryName) 
VALUES
						('Điện thoại'),
						('Tablet'	),
						('Laptop'	);      
                        
-- Add data Product
INSERT INTO Product (ProductName, 					ProductPrice,		 ProductInfo,																 ProductDetail, 	RatingStar,  ProductImageName, ManufacturerId, CategoryId)			
VALUES 				('Samsung Galaxy S22 Ultra 5G', '30.990.000₫',	'6.9 inches, Chip MediaTek Helio G85 (12nm) mạnh mẽ, Ram 4G, Pin 7000 mAh ',	'ProductDetail1',        5,	       'ImgMobile1.png',         '1',       '1'),			
				    ('Samsung Galaxy A52s 5G',      '9.000.000 ₫',	'Hiệu năng ưu việt, đa nhiệm- Chip xử lí Snapdragon 778G 5G và RAM 8GB',	    'ProductDetail2',        4,	       'ImgMobile2.png',         '1',       '1'),
                    ('Samsung Galaxy A72',         '10.100.000 ₫',	'Màn hình Super AMOLED tần số quét 90Hz, độ sáng cao 800 nit.',	                'ProductDetail3',        3,	       'ImgMobile3.png',         '1',       '1'),
					('iPhone 11 64GB I Chính hãng','11.690.000 ₫',	'Hiệu năng mượt mà, ổn định - Chip A13, RAM 4GB',	                            'ProductDetail4',        4,	       'ImgMobile4.png',         '2',       '1'),
                    ('iPhone 13 Pro Max 128GB',    '29.690.000 ₫',	'Hiệu năng vượt trội - Chip Apple A15 Bionic mạnh mẽ, hỗ trợ mạng 5G',	        'ProductDetail5',        5,	       'ImgMobile5.png',         '2',       '1'),
                    ('Apple iPad Pro 11 2021',     '19.990.000 ₫',	'Đỉnh cao công nghệ màn hình - Màn hình Liquid Retina, tần số quét 120Hz',	    'ProductDetail6',        4,	       'ImgMobile6.png',         '2',       '2'),
                    ('Xiaomi Pad 5',               '8.990.000 ₫',	'Thiết kế mỏng nhẹ, tinh tế - Thiết kế vuông vức, chỉ dày khoảng 7mm',	        'ProductDetail7',        5,	       'ImgMobile7.png',         '3',       '2'),
                    ('Apple MacBook Pro 13',       '30.300.000 ₫',	'Xử lý đồ hoạ mượt mà - Chip M1',	                                            'ProductDetail8',        5,	       'ImgMobile8.png',         '2',       '3'),
                    ('Apple Mac mini M1 256GB',    '17.500.000 ₫',	'Đa nhiệm tốt - Ram 8GB cho phép mở cùng lúc nhiều ứng dụng',	                'ProductDetail9',        4,	       'ImgMobile1.png',         '2',       '3');		


-- Add data Account
INSERT INTO `Account`(Email							, Username			, FullName				, AvatarImageName	     , Mobile	           , Address	       , CreateDate  				,`password`												,`status`)			
VALUES 				                                                                                                 
					('admin@gmail.com'				, 'admin'		    ,'admin'				    ,'admin.jpg'	    ,'0336030999'	,'Nam Từ Liêm - Hà Nội'		,'2022-05-19' ,			'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi' 	,	1	),	
					('Email1@gmail.com'				, 'Username1'		,'Fullname1'				,'Avatar1.jpg'	 	,'0336984888'   ,'Bắc Từ Liêm - Hà Nội'		,'2021-03-05' ,			'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi' 	,	1	),			
					('Email2@gmail.com'				, 'Username2'		,'Fullname2'				, 'Avatar2.jpg'	 	,'0988888888'	,'Cầu Giấy - Hà Nội'		,'2020-06-05' ,			'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	1	),			
                    ('Email3@gmail.com'				, 'Username3'		,'Fullname3'				, 'Avatar3.jpg'	 	,'0945555666'	,'Nam Trực - Nam Định'		,'2019-06-07' ,			'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	0	),			
                    ('Email4@gmail.com'				, 'Username4'		,'Fullname4'				, 'Avatar4.jpg'	 	,'0922222222'	,'Quận 1 - TP.HCM'		    ,'2018-03-04' ,			'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	0	),			
                    ('Email5@gmail.com'				, 'Username5'		,'Fullname5'				, 'Avatar5.jpg'	 	,'0943456789'	,'Quảng Nam - Đà Nẵng'	    ,'2020-02-10' ,		    '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	0	),			
                    ('Email6@gmail.com'				, 'Username6'		,'Fullname6'				, 'Avatar6.jpg'	 	,'0988818188'	,'Quy Nhơn - Bình Định'	    ,'2017-02-11' ,		    '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	0	);
                    
-- Get all data
SELECT * FROM Manufacturer;
SELECT * FROM Category;
SELECT * FROM Product;
SELECT * FROM `Account`;

SELECT COUNT(*) FROM Product WHERE ProductName = "nhuc cai dau";

SELECT * FROM Manufacturer WHERE ManufacturerId = 1;

SELECT p.ProductId, p.ProductName, p.ProductPrice, p.ProductDetail, p.RatingStar, p.ProductInfo, m.ManufacturerName FROM Product p JOIN Manufacturer m ON p.ManufacturerId = m.ManufacturerId