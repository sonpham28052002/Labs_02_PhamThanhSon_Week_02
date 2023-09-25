-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th9 24, 2023 lúc 12:45 AM
-- Phiên bản máy phục vụ: 10.4.28-MariaDB
-- Phiên bản PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `mydb2`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customer`
--

CREATE TABLE `customer` (
  `cust_id` bigint(20) NOT NULL,
  `address` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `cust_name` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `customer`
--

INSERT INTO `customer` (`cust_id`, `address`, `email`, `cust_name`, `phone`) VALUES
(1, '566 Nguyễn Thái Sơn, P4, Gò Vấp, TP HCM', 'sonpham28052002@gmail.com', 'Phạm Thanh Sơn', '0346676956'),
(2, '456 Đường ABC, Quận 1, TP HCM', 'customer2@email.com', 'Nguyễn Văn An', '0901234567'),
(3, '789 Đường XYZ, Quận 2, TP HCM', 'customer3@email.com', 'Trần Thị Bình', '0912345678'),
(4, '101 Đường DEF, Quận 3, TP HCM', 'customer4@email.com', 'Lê Văn Cao', '0923456789'),
(5, '202 Đường MNO, Quận 4, TP HCM', 'customer5@email.com', 'Phạm Thị Dương', '0934567890'),
(6, '303 Đường HIJ, Quận 5, TP HCM', 'customer6@email.com', 'Vũ Văn Việt', '0945678901'),
(7, '404 Đường STU, Quận 6, TP HCM', 'customer7@email.com', 'Hồ Thị Phương', '0956789012'),
(8, '505 Đường NOP, Quận 7, TP HCM', 'customer8@email.com', 'Đỗ Văn Giang', '0967890123'),
(9, '606 Đường QWE, Quận 8, TP HCM', 'customer9@email.com', 'Ngô Thị Hương', '0978901234'),
(10, '707 Đường ZXC, Quận 9, TP HCM', 'customer10@email.com', 'Trương Văn In', '0989012345'),
(11, '808 Đường UIO, Quận 10, TP HCM', 'customer11@email.com', 'Hoàng Thị Khánh', '0990123456'),
(12, '909 Đường ASD, Quận 11, TP HCM', 'customer12@email.com', 'Lý Văn Lý', '0911122334'),
(13, '111 Đường JKL, Quận 12, TP HCM', 'customer13@email.com', 'Bùi Thị Minh', '0912233445'),
(14, '222 Đường TYU, Quận Bình Tân, TP HCM', 'customer14@email.com', 'Phan Văn Nhật', '0913344556'),
(15, '333 Đường POU, Quận Bình Thạnh, TP HCM', 'customer15@email.com', 'Mai Thị Ôn', '0914455667'),
(16, '444 Đường RET, Quận Tân Phú, TP HCM', 'customer16@email.com', 'Nguyễn Văn Phương', '0915566778'),
(17, '555 Đường JKH, Quận Tân Bình, TP HCM', 'customer17@email.com', 'Trần Thị Quyên', '0916677889'),
(18, '666 Đường XCV, Quận Phú Nhuận, TP HCM', 'customer18@email.com', 'Lê Thị Rỡ', '0917788990'),
(19, '777 Đường TYR, Quận Thủ Đức, TP HCM', 'customer19@email.com', 'Phạm Văn Sang', '0918899001'),
(20, '888 Đường WER, Quận Gò Vấp, TP HCM', 'customer20@email.com', 'Vũ Thị Tính', '0919900112');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `employee`
--

CREATE TABLE `employee` (
  `emp_id` bigint(20) NOT NULL,
  `address` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `dob` datetime(6) DEFAULT NULL,
  `email` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `fullName` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `status` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `employee`
--

INSERT INTO `employee` (`emp_id`, `address`, `dob`, `email`, `fullName`, `phone`, `status`) VALUES
(1, '1/6 Nguyễn Văn Nghi, P4, Gò Vấp, TP HCM', '2020-09-09 14:52:16.000000', 'leonpham17042002@gmail.com', 'Phạm Thái Bảo', '0346676954', 1),
(2, '123 Đường ABC, Quận 1, TP HCM', '1995-01-15 08:30:00.000000', 'employee2@email.com', 'Nguyễn Văn Anh', '0901234567', 1),
(3, '456 Đường XYZ, Quận 2, TP HCM', '1990-03-20 12:45:00.000000', 'employee3@email.com', 'Trần Thị Biên', '0912345678', 1),
(4, '789 Đường DEF, Quận 3, TP HCM', '1985-07-10 10:15:00.000000', 'employee4@email.com', 'Lê Văn Cừ', '0923456789', 1),
(5, '101 Đường MNO, Quận 4, TP HCM', '1988-05-05 15:20:00.000000', 'employee5@email.com', 'Phạm Thị Diệu', '0934567890', 1),
(6, '202 Đường HIJ, Quận 5, TP HCM', '1992-11-30 09:00:00.000000', 'employee6@email.com', 'Vũ Văn Kiên', '0945678901', 1),
(7, '303 Đường STU, Quận 6, TP HCM', '1986-04-25 14:10:00.000000', 'employee7@email.com', 'Hồ Thị Phúc', '0956789012', 1),
(8, '404 Đường NOP, Quận 7, TP HCM', '1994-08-12 11:30:00.000000', 'employee8@email.com', 'Đỗ Văn Giàu', '0967890123', 1),
(9, '505 Đường QWE, Quận 8, TP HCM', '1983-02-18 13:50:00.000000', 'employee9@email.com', 'Ngô Thị Hoa', '0978901234', 1),
(10, '606 Đường ZXC, Quận 9, TP HCM', '1991-06-06 10:00:00.000000', 'employee10@email.com', 'Trương Văn Iêm', '0989012345', 1),
(11, '707 Đường UIO, Quận 10, TP HCM', '1990-09-22 09:45:00.000000', 'employee11@email.com', 'Hoàng Thị Khoa', '0990123456', 1),
(12, '808 Đường ASD, Quận 11, TP HCM', '1987-03-05 13:15:00.000000', 'employee12@email.com', 'Lý Văn Liêm', '0911122334', 1),
(13, '909 Đường JKL, Quận 12, TP HCM', '1993-12-20 11:20:00.000000', 'employee13@email.com', 'Bùi Thị Nhung', '0912233445', 1),
(14, '111 Đường TYU, Quận Bình Tân, TP HCM', '1989-05-15 08:30:00.000000', 'employee14@email.com', 'Phan Văn Nhiên', '0913344556', 1),
(15, '222 Đường POU, Quận Bình Thạnh, TP HCM', '1996-03-20 12:45:00.000000', 'employee15@email.com', 'Mai Thị Tiền', '0914455667', 1),
(16, '333 Đường RET, Quận Tân Phú, TP HCM', '1998-07-10 10:15:00.000000', 'employee16@email.com', 'Nguyễn Văn Phát', '0915566778', 1),
(17, '444 Đường JKH, Quận Tân Bình, TP HCM', '1997-05-05 15:20:00.000000', 'employee17@email.com', 'Trần Thị Quỳnh', '0916677889', 1),
(18, '555 Đường XCV, Quận Phú Nhuận, TP HCM', '1994-11-30 09:00:00.000000', 'employee18@email.com', 'Lê Thị Hiệu', '0917788990', 1),
(19, '666 Đường TYR, Quận Thủ Đức, TP HCM', '1991-04-25 14:10:00.000000', 'employee19@email.com', 'Phạm Văn Sáng', '0918899001', 1),
(20, '777 Đường WER, Quận Gò Vấp, TP HCM', '1988-08-12 11:30:00.000000', 'employee20@email.com', 'Vũ Thị Thanh', '0919900112', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orders`
--

CREATE TABLE `orders` (
  `order_id` bigint(20) NOT NULL,
  `orderDate` datetime(6) DEFAULT NULL,
  `cus_id` bigint(20) DEFAULT NULL,
  `employee_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `orders`
--

INSERT INTO `orders` (`order_id`, `orderDate`, `cus_id`, `employee_id`) VALUES
(1, '2023-09-05 16:22:10.000000', 1, 1),
(2, '2023-09-06 09:45:20.000000', 2, 2),
(3, '2023-09-07 14:30:15.000000', 3, 3),
(4, '2023-09-08 11:10:30.000000', 4, 4),
(5, '2023-09-09 17:55:45.000000', 5, 5),
(6, '2023-09-10 08:20:40.000000', 6, 6),
(7, '2023-09-11 12:15:25.000000', 7, 7),
(8, '2023-09-12 10:05:50.000000', 8, 8),
(9, '2023-09-13 15:40:55.000000', 9, 9),
(10, '2023-09-14 09:30:10.000000', 10, 10),
(11, '2023-09-15 14:15:05.000000', 11, 11),
(12, '2023-09-16 13:05:20.000000', 12, 12),
(13, '2023-09-17 16:50:15.000000', 13, 13),
(14, '2023-09-18 11:40:30.000000', 14, 14),
(15, '2023-09-19 14:25:25.000000', 15, 15),
(16, '2023-09-20 10:35:40.000000', 16, 16),
(17, '2023-09-21 15:05:35.000000', 17, 17),
(18, '2023-09-22 09:15:50.000000', 18, 18),
(19, '2023-09-23 14:50:45.000000', 19, 19),
(20, '2023-09-24 12:00:10.000000', 20, 20);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `order_detail`
--

CREATE TABLE `order_detail` (
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `price` double DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  `order_id` bigint(20) NOT NULL,
  `product_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `order_detail`
--

INSERT INTO `order_detail` (`note`, `price`, `quantity`, `order_id`, `product_id`) VALUES
(NULL, 3000, 10, 1, 1),
(NULL, 1500000, 1, 1, 9),
(NULL, 300000, 1, 1, 11);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product`
--

CREATE TABLE `product` (
  `product_id` bigint(20) NOT NULL,
  `description` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `manufacturer` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `unit` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `product`
--

INSERT INTO `product` (`product_id`, `description`, `manufacturer`, `name`, `status`, `unit`) VALUES
(1, 'bút bi xanh dành cho học sinh sinh viên', 'Kim Đồng', 'Bút Bi Xanh', 1, 'Cái'),
(2, 'Sách vở lớp 1', 'Nhà Xuất Bản Giáo Dục', 'Sách Vở Lớp 1', 1, 'Cuốn'),
(3, 'Áo thun trắng unisex', 'H&M', 'Áo Thun Trắng', 1, 'Cái'),
(4, 'Máy tính xách tay Dell Inspiron', 'Dell', 'Máy Tính Dell', 1, 'Cái'),
(5, 'Quyển sổ tay ghi chú', 'Artline', 'Sổ Tay Ghi Chú', 1, 'Quyển'),
(6, 'Bút mực đen chất lượng', 'Pilot', 'Bút Mực Đen', 1, 'Cái'),
(7, 'Máy ảnh DSLR Canon EOS', 'Canon', 'Máy Ảnh Canon', 1, 'Cái'),
(8, 'Giày thể thao Nike Air Max', 'Nike', 'Giày Nike Air Max', 1, 'Đôi'),
(9, 'Balo du lịch thời trang', 'Samsonite', 'Balo Du Lịch', 1, 'Cái'),
(10, 'Điện thoại di động iPhone 12', 'Apple', 'iPhone 12', 1, 'Cái'),
(11, 'Chuột máy tính không dây', 'Logitech', 'Chuột Máy Tính', 1, 'Cái'),
(12, 'Loa Bluetooth JBL Flip', 'JBL', 'Loa Bluetooth', 1, 'Cái'),
(13, 'Máy sấy tóc Panasonic', 'Panasonic', 'Máy Sấy Tóc', 1, 'Cái'),
(14, 'Đèn bàn LED đa năng', 'Philips', 'Đèn Bàn LED', 1, 'Cái'),
(15, 'Gương trang điểm đẹp', 'IKEA', 'Gương Trang Điểm', 1, 'Cái'),
(16, 'Thảm trải sàn màu xanh', 'IKEA', 'Thảm Trải Sàn', 1, 'Cái'),
(17, 'Áo khoác phao nam', 'North Face', 'Áo Khoác Phao', 1, 'Cái'),
(18, 'Máy pha cà phê Nespresso', 'Nespresso', 'Máy Pha Cà Phê', 1, 'Cái'),
(19, 'Bàn làm việc gỗ tự nhiên', 'IKEA', 'Bàn Làm Việc', 1, 'Cái'),
(20, 'Ghế xoay văn phòng', 'IKEA', 'Ghế Văn Phòng', 1, 'Cái'),
(21, 'Bình nước thể thao', 'Nike', 'Bình Nước Thể Thao', 1, 'Cái');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product_image`
--

CREATE TABLE `product_image` (
  `image_id` bigint(20) NOT NULL,
  `alternative` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `path` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `product_image`
--

INSERT INTO `product_image` (`image_id`, `alternative`, `path`, `product_id`) VALUES
(1, NULL, '/dataImg/1.png', 1),
(2, NULL, '/dataImg/2.png', 2),
(3, NULL, '/dataImg/3.png', 3),
(4, NULL, '/dataImg/4.png', 4),
(5, NULL, '/dataImg/5.png', 5),
(6, NULL, '/dataImg/6.png', 6),
(7, NULL, '/dataImg/7.png', 7),
(8, NULL, '/dataImg/8.png', 8),
(9, NULL, '/dataImg/9.png', 9),
(10, NULL, '/dataImg/10.png', 10),
(11, NULL, '/dataImg/11.png', 11),
(12, NULL, '/dataImg/12.png', 12),
(13, NULL, '/dataImg/13.png', 13),
(14, NULL, '/dataImg/14.png', 14),
(15, NULL, '/dataImg/15.png', 15),
(16, NULL, '/dataImg/16.png', 16),
(17, NULL, '/dataImg/17.png', 17),
(18, NULL, '/dataImg/18.png', 18),
(19, NULL, '/dataImg/19.png', 19),
(20, NULL, '/dataImg/20.png', 20),
(21, NULL, '/dataImg/21.png', 21);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product_price`
--

CREATE TABLE `product_price` (
  `price_date_time` datetime(6) NOT NULL,
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `price` double NOT NULL,
  `product_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `product_price`
--

INSERT INTO `product_price` (`price_date_time`, `note`, `price`, `product_id`) VALUES
('2023-09-09 16:31:37.000000', 'Khuyễn Mãi 9-9', 3000, 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`cust_id`);

--
-- Chỉ mục cho bảng `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`emp_id`);

--
-- Chỉ mục cho bảng `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `FK5u324hx6p8cu83aycaopvegwf` (`cus_id`),
  ADD KEY `FKog5v9ga2g2ukytypn4ocip6b4` (`employee_id`);

--
-- Chỉ mục cho bảng `order_detail`
--
ALTER TABLE `order_detail`
  ADD PRIMARY KEY (`order_id`,`product_id`),
  ADD KEY `FKb8bg2bkty0oksa3wiq5mp5qnc` (`product_id`);

--
-- Chỉ mục cho bảng `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`product_id`);

--
-- Chỉ mục cho bảng `product_image`
--
ALTER TABLE `product_image`
  ADD PRIMARY KEY (`image_id`),
  ADD KEY `FK6oo0cvcdtb6qmwsga468uuukk` (`product_id`);

--
-- Chỉ mục cho bảng `product_price`
--
ALTER TABLE `product_price`
  ADD PRIMARY KEY (`price_date_time`,`product_id`),
  ADD KEY `FKeupemu63ifqfc4txkskyy1hyi` (`product_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `customer`
--
ALTER TABLE `customer`
  MODIFY `cust_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT cho bảng `employee`
--
ALTER TABLE `employee`
  MODIFY `emp_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT cho bảng `orders`
--
ALTER TABLE `orders`
  MODIFY `order_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT cho bảng `product`
--
ALTER TABLE `product`
  MODIFY `product_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT cho bảng `product_image`
--
ALTER TABLE `product_image`
  MODIFY `image_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `FK5u324hx6p8cu83aycaopvegwf` FOREIGN KEY (`cus_id`) REFERENCES `customer` (`cust_id`),
  ADD CONSTRAINT `FKog5v9ga2g2ukytypn4ocip6b4` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`emp_id`);

--
-- Các ràng buộc cho bảng `order_detail`
--
ALTER TABLE `order_detail`
  ADD CONSTRAINT `FKb8bg2bkty0oksa3wiq5mp5qnc` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  ADD CONSTRAINT `FKrws2q0si6oyd6il8gqe2aennc` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`);

--
-- Các ràng buộc cho bảng `product_image`
--
ALTER TABLE `product_image`
  ADD CONSTRAINT `FK6oo0cvcdtb6qmwsga468uuukk` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`);

--
-- Các ràng buộc cho bảng `product_price`
--
ALTER TABLE `product_price`
  ADD CONSTRAINT `FKeupemu63ifqfc4txkskyy1hyi` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
