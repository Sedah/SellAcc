-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: mariadb
-- Generation Time: Apr 28, 2018 at 10:13 AM
-- Server version: 10.2.14-MariaDB-10.2.14+maria~jessie
-- PHP Version: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `webpro_15_prod`
--

-- --------------------------------------------------------

--
-- Table structure for table `accessories`
--

CREATE TABLE `accessories` (
  `acc_id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `description` mediumtext NOT NULL,
  `price` float NOT NULL,
  `image` varchar(100) DEFAULT NULL,
  `cate_cate_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `accessories`
--

INSERT INTO `accessories` (`acc_id`, `name`, `description`, `price`, `image`, `cate_cate_id`) VALUES
(1, 'แหวนไม้ handmade ดอกยิปโซ', 'แหวนไม้ handmade\r\nข้างในเป็นดอกยิปโซ\r\nสื่อถึงความบริสุทธิ์จริงใจ อ่อนหวาน ดอกไม้แห่งรักแรก\r\n\r\nมี 2 สี : สีธรรมชาติ(สีไม้) สีดำ\r\nมี 2 ขนาด \r\n\r\nแหวนปรับขนาดไซด์ได้', 100, 'https://i.imgur.com/c6UHmfR.jpg', 2),
(2, 'สร้อยโหลแก้วจิ๋ว ดาว ดอกไม้ หัวใจ', 'สร้อยโหลแก้วจิ๋ว\r\n\r\nมีสามแบบ\r\n: ดาว : หัวใจ : ดอกไม้\r\n\r\nข้างในเป็นดอกไม้แห้งธรรมชาติ ดอกไม้ไม่เหี่ยว เก๋ไก๋ ใส่ได้กับทุกชุด', 200, 'https://i.imgur.com/A5WoqNx.jpg', 1),
(3, 'เซทกำไลข้อมือไม้ handmade 2 ชิ้น', 'เซทกำไลข้อมือไม้ handmade\r\nกำไลไม้ + กำไลโหลแก้วจิ๋ว\r\nสามารถเลือกดอกไม้ได้', 200, 'https://i.imgur.com/xX5SmvN.jpg', 4),
(4, 'สร้อยคอโหลแก้วจิ๋ว', 'สร้อยคอโหลแก้วจิ๋ว\r\n- ข้างในเป็นขนแกะ สามารถเลือกสีผสมสีเองได้', 120, 'https://i.imgur.com/XHL8tdE.jpg', 1),
(5, 'สร้อยคอโหลแก้วจิ๋ว เซ็ท 2', 'สร้อยคอโหลแก้วจิ๋ว - ข้างในเป็นดอกหญ้าแห้งธรรมชาติ ดอกไม้ไม่เหี่ยว', 120, 'https://i.imgur.com/CiYryCE.jpg', 1),
(6, 'สร้อยไม้ handmade', 'สร้อยไม้ handmade พร้อมส่ง', 150, 'https://i.imgur.com/sp2Ha8k.jpg', 1),
(7, 'กำไลข้อมือไม้ handmade', 'กำไลข้อมือไม้ handmade - ข้างในเป็นดอกไม้ต่างๆ', 150, 'https://i.imgur.com/HUqY5Vk.jpg', 4),
(8, 'สร้อยคอโหลแก้วจิ๋ว ดอกยิปโซ', 'สร้อยคอโหลแก้วจิ๋ว - ข้างในเป็นดอกยิปโซ ความหมาย : สื่อถึงความบริสุทธิ์ จริงใจ อ่อนหวาน เป็นดอกไม้แห่งรักแรก', 120, 'https://i.imgur.com/poUUKZq.jpg', 1),
(9, 'แหวนไม้ handmade', 'แหวนไม้ handmade ข้างในเป็นดอกไม้แห้งธรรมชาติ ไม่เหี่ยว เข้ากับธรรมชาติ มี 2 สี : สีธรรมชาติ(สีไม้) สีดำ', 100, 'https://i.imgur.com/78pdlIv.jpg', 2),
(10, 'เข็มกลัดไม้ Handmade', 'เข็มกลัดไม้ handmade ข้างในเป็นดอกไม้แห้งธรรมชาติ ไม่เหี่ยว เข้ากับธรรมชาติ มี 2 สี : สีธรรมชาติ(สีไม้) สีดำ  น่ารัก เก๋ๆ ติดได้ทั้งเสื้อ กระเป๋า หมวก รีบจับจองกันเลย', 129, 'https://i.imgur.com/OMc0DXZ.jpg', 3);

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `add_id` int(11) NOT NULL,
  `province` varchar(100) NOT NULL,
  `district` varchar(100) NOT NULL,
  `house_num` varchar(100) NOT NULL,
  `street` varchar(100) NOT NULL,
  `area` varchar(100) NOT NULL,
  `postcode` char(5) NOT NULL,
  `member_cus_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `address`
--

INSERT INTO `address` (`add_id`, `province`, `district`, `house_num`, `street`, `area`, `postcode`, `member_cus_id`) VALUES
(1, 'กรุงเทพ', 'บางกะปิ', '102', 'ถนนลาดพร้าว', 'คลองจั่น', '10240', 1),
(2, 'กรุงเทพ', 'บางกะปิ', '506', 'ถนนลาดพร้าว', 'คลองจั่น', '10240', 1),
(3, 'กรุงเทพ', 'มักกะสัน', '405', 'ถนนเพชรบุรีตัดใหม่', 'ราชเทวี', '10400', 3),
(4, 'ปทุมธานี', 'เมืองปทุมธานี', '608', '-', 'บ้านกลาง', '12000', 2),
(5, 'ฉะเชิงเทรา', 'บางปะกง', '51', '-', 'บางปะกง', '24130', 4),
(6, 'กรุงเทพ', 'บางแค', '605/265', 'ถ.เพชรเกษม', 'บางแคเหนือ', '10160', 5),
(7, 'กรุงเทพ', 'บางแค', '621/203', 'ถ.เพชรเกษม', 'บางแคเหนือ', '10160', 5),
(8, 'กรุงเทพ', 'บางหว้า', '203', 'ถ.เพชรเกษม', 'ภาษีเจริญ', '10160', 6),
(9, 'ปทุมธานี ', 'พืชอุดม', '10', '-', 'ลำลูกกา', '12150', 7),
(10, 'บุรีรัมย์', 'สะเดา', '35', '-', 'พลับพลาชัย', '31250', 8);

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `cate_id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`cate_id`, `name`) VALUES
(1, 'สร้อยคอ'),
(2, 'แหวน'),
(3, 'เข็มกลัด'),
(4, 'กำไลข้อมือ');

-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

CREATE TABLE `comment` (
  `com_id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `review` longtext NOT NULL,
  `date` datetime NOT NULL,
  `cus_cus_id` int(11) NOT NULL,
  `acc_acc_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `comment`
--

INSERT INTO `comment` (`com_id`, `name`, `review`, `date`, `cus_cus_id`, `acc_acc_id`) VALUES
(1, 'alice', '                                        สวย', '2018-04-28 16:31:39', 1, 10),
(2, 'Pololy', '                                        สวยมากเลย', '2018-04-28 16:33:42', 21, 2),
(3, 'aki', '                                   แฟนชอบมากๆ     ', '2018-04-28 16:36:27', 3, 4),
(4, 'akiiii', '                                        ติดใจจนต้องซื้ออีก', '2018-04-28 16:37:31', 3, 6),
(5, 'aki125', '                                        ของเขาดีจริง', '2018-04-28 16:37:56', 3, 5),
(6, 'dervie', '                                        ติดใจจนต้องกลับมาซื้ออีก', '2018-04-28 16:53:27', 7, 7),
(7, 'DIeee', '                                        สินค้าดูดี ให้ 3 ผ่าน', '2018-04-28 16:54:19', 7, 7),
(8, 'Kaew', '                     สวยงามมากๆ                   ', '2018-04-28 16:54:42', 7, 7),
(9, 'Aliss', '                             ดีงามเกินราคา      ', '2018-04-28 16:58:27', 23, 8),
(10, 'ABC', '                             ชอบชิ้นนี้มากๆ           ', '2018-04-28 16:58:43', 23, 8);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `cus_id` int(11) NOT NULL,
  `email` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `user_type` enum('mem','non') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`cus_id`, `email`, `name`, `user_type`) VALUES
(1, 'alicia@gmail.com', 'Alice', 'mem'),
(2, 'alyssa@hotmail.com', 'Alyssa', 'mem'),
(3, 'aki123@gmail.com', 'Akira ', 'mem'),
(4, 'bonnie@gmail.com', 'Bonita ', 'mem'),
(5, 'gzchrise@gmail.com', 'Chris', 'mem'),
(6, 'danny@hotmail.com', 'Dan ', 'mem'),
(7, 'derekkk@hotmail.com', 'Derek ', 'mem'),
(8, 'jadey@hotmail.com', 'Jade', 'mem'),
(9, 'johnny@gmail.com', 'John ', 'mem'),
(10, 'jake124@gmail.com', 'Jake', 'mem'),
(11, 'kenttis@hotmail.com', 'Kent', 'non'),
(20, 'clair25@hotmail.com', 'Claris', 'non'),
(21, 'ploycute@hotmail.com', 'ploy', 'non'),
(22, 'ploywince@gmail.com', 'ploy', 'non'),
(23, 'alissa14@gmail.com', 'Alissa', 'non');

-- --------------------------------------------------------

--
-- Table structure for table `deliverie`
--

CREATE TABLE `deliverie` (
  `type` enum('ems','normal','register') NOT NULL,
  `send_date` date NOT NULL,
  `tracking_number` char(13) DEFAULT NULL,
  `order_order_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `deliverie`
--

INSERT INTO `deliverie` (`type`, `send_date`, `tracking_number`, `order_order_id`) VALUES
('ems', '2017-12-31', '1234567890123', 1),
('normal', '2012-12-30', '165161611', 2);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `emp_id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `position` enum('send','order') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`emp_id`, `name`, `username`, `password`, `position`) VALUES
(1, 'Aileen', 'Ail', 'Ail123', 'order'),
(2, 'Alisha ', 'Aisha', 'aisha54', 'order'),
(3, 'Benjamin', 'Benj', 'ben546', 'order'),
(4, 'Chana', 'chan', 'cha145', 'order'),
(5, 'Chandra', 'Moon', 'moon112', 'order'),
(6, 'Davin', 'Dev', 'devvv', 'order'),
(7, 'Finn', 'Fione', 'finn578', 'order'),
(8, 'Gavin', 'grape', 'guine45', 'order'),
(9, 'Harley', 'Haley', 'hi365', 'send'),
(10, 'Ira', 'ira', 'ira310', 'send');

-- --------------------------------------------------------

--
-- Table structure for table `employee_order`
--

CREATE TABLE `employee_order` (
  `date` date NOT NULL,
  `what_do` text NOT NULL,
  `emp_emp_id` int(11) NOT NULL,
  `order_order_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `employee_order`
--

INSERT INTO `employee_order` (`date`, `what_do`, `emp_emp_id`, `order_order_id`) VALUES
('2018-04-28', 'Change order 1 status from verify_pass to send', 1, 1),
('2018-04-28', 'Change order 2 status from wait_verify to send', 1, 2),
('2018-04-28', 'Change order 3 status from wait_verify to verify_pass', 1, 3),
('2018-04-28', 'Change order 4 status from wait_verify to verify_pass', 1, 4),
('2018-04-28', 'Change order 5 status from wait_verify to cancle', 1, 5),
('2018-04-28', 'Change order 6 status from wait_verify to verify_pass', 1, 6),
('2018-04-28', 'Change order 7 status from wait_verify to verify_not_pass', 1, 7),
('2018-04-28', 'Change order 8 status from wait_verify to verify_pass', 1, 8),
('2018-04-28', 'Change order 11 status from wait_verify to wait_verify', 1, 11),
('2018-04-28', 'Change order 1 status from wait_verify to verify_pass', 3, 1),
('2018-04-28', 'Change order 6 status from verify_pass to verify_not_pass', 3, 6),
('2018-04-28', 'Change order 8 status from verify_pass to wait_verify', 3, 8);

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `cus_cus_id` int(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `point` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`cus_cus_id`, `username`, `password`, `point`) VALUES
(1, 'Alicia', 'alice123', 0),
(2, 'alyse', 'lovely12', 50),
(3, 'aki125', 'akiaki1', 79),
(4, 'bonnie', 'rabbit50', 3),
(5, 'chrissi', 'god32', 20),
(6, 'Dannn', 'dannyja55', 55),
(7, 'Derk', 'derv12', 0),
(8, 'jedzzz', 'jedzy1', 2),
(9, 'johnson', 'johnny89', 200),
(10, 'jake', 'cherry23', 7);

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE `order` (
  `order_id` int(11) NOT NULL,
  `buy_date` datetime NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `status_order` enum('wait_verify','verify_pass','verify_not_pass','send','cancle') NOT NULL DEFAULT 'wait_verify',
  `use_point` int(11) DEFAULT NULL,
  `recieve_point` int(11) DEFAULT NULL,
  `total_price` float(8,2) NOT NULL,
  `address` text NOT NULL,
  `cus_cus_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `order`
--

INSERT INTO `order` (`order_id`, `buy_date`, `status_order`, `use_point`, `recieve_point`, `total_price`, `address`, `cus_cus_id`) VALUES
(1, '2018-04-28 09:44:29', 'send', NULL, NULL, 1000.00, '102/103 ถ.เพชรบุรีตัดใหม่ มักกะสัน ราชเทวี กรุงเทพฯ 10400', 20),
(2, '2018-04-28 09:44:35', 'send', NULL, NULL, 840.00, '503 ถนนลาดพร้าว บางกะปิ คลองจั่น กรุงเทพมหานคร 10240', 21),
(3, '2018-04-28 09:44:40', 'verify_pass', NULL, NULL, 940.00, '503 ถนนลาดพร้าว บางกะปิ คลองจั่น  กรุงเทพมหานคร 10240', 22),
(4, '2018-04-28 09:44:44', 'verify_pass', 0, 25, 258.00, '506 ถนนลาดพร้าว คลองจั่น บางกะปิ กรุงเทพ 10240', 1),
(5, '2018-04-28 09:44:53', 'cancle', 0, 84, 840.00, '10 ลำลูกกา พืชอุดม ปทุมธานี 12150', 7),
(6, '2018-04-28 10:11:49', 'verify_not_pass', 1, 10, 99.00, '405 ถนนเพชรบุรีตัดใหม่ ราชเทวี มักกะสัน กรุงเทพ 10400', 3),
(7, '2018-04-28 09:45:07', 'verify_not_pass', 45, 24, 195.00, '405 ถนนเพชรบุรีตัดใหม่ ราชเทวี มักกะสัน กรุงเทพ 10400', 3),
(8, '2018-04-28 10:11:54', 'wait_verify', 4, 39, 386.00, '405 ถนนเพชรบุรีตัดใหม่ ราชเทวี มักกะสัน กรุงเทพ 10400', 3),
(9, '2018-04-21 19:30:41', 'wait_verify', NULL, NULL, 600.00, '412 ถ.เพชรเกษม ภาษีเจริญ บางหว้า กรุงเทพมหานคร 10160', 23),
(10, '2018-04-21 19:31:54', 'wait_verify', 10, 120, 1190.00, '35 - พลับพลาชัย สะเดา บุรีรัมย์ 31250', 8),
(11, '2018-04-27 15:41:39', 'wait_verify', 5, 52, 515.00, '405 ถนนเพชรบุรีตัดใหม่ ราชเทวี มักกะสัน กรุงเทพ 10400', 3),
(27, '2018-04-28 10:13:06', 'verify_pass', 0, 100, 1000.00, '506 ถนนลาดพร้าว คลองจั่น บางกะปิ กรุงเทพ 10240', 1);

-- --------------------------------------------------------

--
-- Table structure for table `order_item`
--

CREATE TABLE `order_item` (
  `price` double NOT NULL,
  `quentity` int(11) NOT NULL,
  `acc_acc_id` int(11) NOT NULL,
  `item_num` int(11) NOT NULL,
  `order_order_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `order_item`
--

INSERT INTO `order_item` (`price`, `quentity`, `acc_acc_id`, `item_num`, `order_order_id`) VALUES
(100, 1, 1, 1, 3),
(100, 1, 1, 1, 6),
(200, 5, 2, 1, 1),
(200, 2, 2, 1, 13),
(200, 2, 2, 1, 14),
(200, 2, 2, 1, 15),
(200, 2, 2, 1, 16),
(200, 2, 2, 1, 17),
(200, 1, 2, 1, 26),
(200, 3, 3, 1, 2),
(200, 2, 3, 1, 11),
(200, 1, 3, 1, 12),
(200, 3, 3, 2, 3),
(200, 2, 3, 2, 27),
(120, 7, 4, 1, 5),
(120, 1, 4, 1, 8),
(120, 5, 4, 1, 18),
(120, 5, 4, 1, 19),
(120, 5, 4, 1, 20),
(120, 5, 4, 1, 21),
(120, 5, 4, 1, 22),
(120, 5, 4, 1, 23),
(120, 5, 4, 1, 24),
(120, 2, 4, 2, 2),
(120, 2, 4, 3, 3),
(120, 1, 5, 2, 8),
(120, 1, 5, 2, 11),
(150, 4, 6, 1, 27),
(150, 1, 6, 3, 8),
(150, 1, 7, 1, 26),
(120, 2, 8, 1, 7),
(120, 5, 8, 1, 9),
(100, 12, 9, 1, 10),
(129, 2, 10, 1, 4),
(129, 4, 10, 1, 25);

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `payment_id` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `amount` float NOT NULL,
  `type` enum('credit','money-trans') NOT NULL,
  `image` varchar(255) NOT NULL,
  `order_order_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`payment_id`, `date`, `amount`, `type`, `image`, `order_order_id`) VALUES
(1, '2018-04-25 00:00:00', 1000, 'money-trans', 'https://i.imgur.com/A5WoqNx.jpg', 1),
(2, '2018-04-25 00:00:00', 840, 'money-trans', 'https://i.imgur.com/A5qwqNx.jpg', 2),
(3, '2018-04-26 00:00:00', 940, 'money-trans', 'https://i.imgur.com/ApoiuhNx.jpg', 3),
(4, '2017-12-31 10:55:00', 258, 'money-trans', 'https://i.imgur.com/Bjofdlx.jpg', 4),
(5, '2018-04-28 10:13:06', 1000, 'credit', ' ', 27);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accessories`
--
ALTER TABLE `accessories`
  ADD PRIMARY KEY (`acc_id`);

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`add_id`,`member_cus_id`),
  ADD KEY `member_cus_id_idx` (`member_cus_id`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`cate_id`),
  ADD UNIQUE KEY `cate_id_UNIQUE` (`cate_id`);

--
-- Indexes for table `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`com_id`),
  ADD KEY `cus_cus_id_idx` (`cus_cus_id`),
  ADD KEY `acc_acc_id_fk_idx` (`acc_acc_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`cus_id`);

--
-- Indexes for table `deliverie`
--
ALTER TABLE `deliverie`
  ADD PRIMARY KEY (`order_order_id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`emp_id`);

--
-- Indexes for table `employee_order`
--
ALTER TABLE `employee_order`
  ADD PRIMARY KEY (`emp_emp_id`,`order_order_id`),
  ADD KEY `employee_order_id_idx` (`order_order_id`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`cus_cus_id`);

--
-- Indexes for table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `order_cus_cus_id_idx` (`cus_cus_id`);

--
-- Indexes for table `order_item`
--
ALTER TABLE `order_item`
  ADD PRIMARY KEY (`acc_acc_id`,`item_num`,`order_order_id`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`payment_id`),
  ADD KEY `payment_order_order_id_idx` (`order_order_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `accessories`
--
ALTER TABLE `accessories`
  MODIFY `acc_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `address`
--
ALTER TABLE `address`
  MODIFY `add_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `cate_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `comment`
--
ALTER TABLE `comment`
  MODIFY `com_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `cus_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `order`
--
ALTER TABLE `order`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `payment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `acc_acc_id_fk` FOREIGN KEY (`acc_acc_id`) REFERENCES `accessories` (`acc_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `cus_cus_id_fk` FOREIGN KEY (`cus_cus_id`) REFERENCES `customer` (`cus_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `deliverie`
--
ALTER TABLE `deliverie`
  ADD CONSTRAINT `deliverie_order_order_id` FOREIGN KEY (`order_order_id`) REFERENCES `order` (`order_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `employee_order`
--
ALTER TABLE `employee_order`
  ADD CONSTRAINT `employee_emp_id` FOREIGN KEY (`emp_emp_id`) REFERENCES `employee` (`emp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `employee_order_id` FOREIGN KEY (`order_order_id`) REFERENCES `order` (`order_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `member`
--
ALTER TABLE `member`
  ADD CONSTRAINT `cus_cus_id` FOREIGN KEY (`cus_cus_id`) REFERENCES `customer` (`cus_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `order_cus_cus_id` FOREIGN KEY (`cus_cus_id`) REFERENCES `customer` (`cus_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `order_item`
--
ALTER TABLE `order_item`
  ADD CONSTRAINT `odi_acc_acc_id_fk` FOREIGN KEY (`acc_acc_id`) REFERENCES `accessories` (`acc_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `payment_order_order_id` FOREIGN KEY (`order_order_id`) REFERENCES `order` (`order_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
