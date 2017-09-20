-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 15, 2017 at 06:48 AM
-- Server version: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `quanlynhanvien`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_getDonXinNghi`(in tuNgay Date )
begin
	select *from donxinnghi where THOIGIANBATDAU>= tuNgay;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_getNgayLamViec`(in Ngay Date , in MANVa int(4))
begin
	select *from ngaylamviec where NgayLamViec=Ngay and MANV = MANVa;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_insertDonXinNghi`(in lyDo varchar(200),in thoiGianLap datetime, in thoiGianBatDau Date,in thoiGianKetThuc Date, in MANV int(4))
begin
	select @madon= max(MADON)+1 from donxinnghi;
	insert into donxinnghi(MADON,LYDO,THOIGIANLAP,THOIGIANBATDAU,THOIGIANKETTHUC,MANV) values(@madon,lyDo,thoiGianLap,thoiGianBatDau,thoiGianKetThuc,MANV);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_insertNhanVien`(in MANV INT(4),in TenNhanVien varchar(40),in GioiTinh int(1),in SDT int(11),in DiaChi varchar(100), in TaiKhoan varchar(40),in MAHD int(4))
begin
insert into nhanvien(MANV,TENNV,GIOITINH,SDT,DIACHI,TAIKHOAN,MAHD) values(MANV,TenNhanVien,GioiTinh,SDT,DiaChi,TaiKhoan,MAHD);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_updateNhanVien`(in ma int , in ten varchar(40),in gioi int(1),
										in SD INT(11),in Dia varchar(100),in Tai char(40),in mah int(4))
begin
	update nhanvien set TENNV=ten,GIOITINH = gioi,SDT =SD,DIACHI=Dia,TAIKHOAN=Tai,MAHD=mah where MANV=ma;
end$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `chamluongnhanvien`
--

CREATE TABLE IF NOT EXISTS `chamluongnhanvien` (
`MACL` int(4) NOT NULL,
  `MANV` int(4) NOT NULL,
  `TUNGAY` date NOT NULL,
  `DENNGAY` date NOT NULL,
  `TONGLUONG` float DEFAULT '0'
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=16 ;

--
-- Dumping data for table `chamluongnhanvien`
--

INSERT INTO `chamluongnhanvien` (`MACL`, `MANV`, `TUNGAY`, `DENNGAY`, `TONGLUONG`) VALUES
(1, 1, '2017-06-07', '2017-06-06', 0),
(3, 2, '2017-06-07', '2017-06-14', 0),
(4, 3, '2017-06-07', '2017-06-06', 0),
(5, 4, '2017-06-08', '2017-06-09', 0),
(6, 1, '2017-06-07', '2017-06-15', 200000000),
(7, 2, '2017-06-15', '2017-06-15', 40000000),
(8, 3, '2017-06-07', '2017-06-15', 0),
(9, 4, '2017-06-10', '2017-06-15', 0),
(10, 35, '2017-06-15', '2017-06-15', 0),
(11, 1, '2017-06-16', '2017-06-16', 200060000),
(12, 2, '2017-06-16', '2017-06-16', 0),
(13, 3, '2017-06-16', '2017-06-16', 0),
(14, 4, '2017-06-16', '2017-06-16', 0),
(15, 35, '2017-06-16', '2017-06-16', 0);

-- --------------------------------------------------------

--
-- Table structure for table `chucvu`
--

CREATE TABLE IF NOT EXISTS `chucvu` (
`MACV` int(4) NOT NULL,
  `TENCV` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `MAPB` int(4) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=8 ;

--
-- Dumping data for table `chucvu`
--

INSERT INTO `chucvu` (`MACV`, `TENCV`, `MAPB`) VALUES
(1, 'Nhân viên hành chính', 1),
(2, 'Nhân viên lễ tân', 2),
(3, 'Bảo Vệ Chính', 3),
(4, 'Bảo vệ cổng', 3),
(5, 'Bảo vệ hành lang', 3),
(6, 'Bảo vệ trưởng', 3),
(7, 'trưởng phòng', 5);

-- --------------------------------------------------------

--
-- Table structure for table `ctdk_themgio`
--

CREATE TABLE IF NOT EXISTS `ctdk_themgio` (
  `MANV` int(4) NOT NULL,
  `MADKTHEMGIO` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `ctdk_themgio`
--

INSERT INTO `ctdk_themgio` (`MANV`, `MADKTHEMGIO`) VALUES
(1, 7);

-- --------------------------------------------------------

--
-- Table structure for table `dangkythemgio`
--

CREATE TABLE IF NOT EXISTS `dangkythemgio` (
`MADKTHEMGIO` int(4) NOT NULL,
  `TENDK` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SOGIODK` int(11) DEFAULT NULL,
  `HESOLUONG_1GIO` int(11) DEFAULT NULL,
  `NGAY` datetime NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=8 ;

--
-- Dumping data for table `dangkythemgio`
--

INSERT INTO `dangkythemgio` (`MADKTHEMGIO`, `TENDK`, `SOGIODK`, `HESOLUONG_1GIO`, `NGAY`) VALUES
(1, 'Làm ngoài giờ', 3, 100000, '2017-05-21 00:00:00'),
(2, 'Làm ngoài giờ', 3, 100000, '2017-05-22 00:00:00'),
(5, 'Làm thêm giờ', 3, 20000, '2017-06-15 00:00:00'),
(7, 'thêm giờ', 3, 20000, '2017-06-16 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `donxinnghi`
--

CREATE TABLE IF NOT EXISTS `donxinnghi` (
`MADON` int(4) NOT NULL,
  `LYDO` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `THOIGIANLAP` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `THOIGIANBATDAU` date NOT NULL,
  `THOIGIANKETTHUC` date NOT NULL,
  `MANV` int(4) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=6 ;

--
-- Dumping data for table `donxinnghi`
--

INSERT INTO `donxinnghi` (`MADON`, `LYDO`, `THOIGIANLAP`, `THOIGIANBATDAU`, `THOIGIANKETTHUC`, `MANV`) VALUES
(1, 'Đau Đẻ', '2017-05-01 18:14:33', '2017-05-01', '2017-05-02', 1),
(4, 'Đi chêt', '2017-05-06 20:20:19', '2017-05-06', '2017-05-07', 1),
(5, 'ốm', '2017-06-15 11:15:55', '2017-06-16', '2017-06-16', 1);

-- --------------------------------------------------------

--
-- Table structure for table `hopdong`
--

CREATE TABLE IF NOT EXISTS `hopdong` (
`MAHD` int(4) NOT NULL,
  `MACV` int(4) NOT NULL,
  `NGAYBATDAU` date DEFAULT NULL,
  `NGAYHETHAN` date DEFAULT NULL,
  `TIENLUONG` float NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=11 ;

--
-- Dumping data for table `hopdong`
--

INSERT INTO `hopdong` (`MAHD`, `MACV`, `NGAYBATDAU`, `NGAYHETHAN`, `TIENLUONG`) VALUES
(2, 2, '2017-04-04', '2017-04-20', 200000000),
(3, 1, '2017-04-02', '2017-05-18', 300000),
(4, 4, '2017-04-05', '2017-04-22', 220000),
(5, 3, '2017-04-20', '2017-04-06', 9930930),
(6, 2, '2017-04-04', '2017-04-21', 4444440),
(7, 4, '2017-04-29', '2017-04-29', 40000000),
(8, 5, '2017-06-14', '2017-06-14', 100000),
(9, 6, '2017-06-14', '2018-06-14', 100000),
(10, 2, '2017-06-15', '2018-04-21', 100000);

-- --------------------------------------------------------

--
-- Table structure for table `ngaylamviec`
--

CREATE TABLE IF NOT EXISTS `ngaylamviec` (
  `NgayLamViec` date NOT NULL DEFAULT '0000-00-00',
  `MANV` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `ngaylamviec`
--

INSERT INTO `ngaylamviec` (`NgayLamViec`, `MANV`) VALUES
('2017-06-15', 1),
('2017-06-16', 1),
('2017-06-15', 2);

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE IF NOT EXISTS `nhanvien` (
`MANV` int(4) NOT NULL,
  `TENNV` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `GIOITINH` int(1) NOT NULL,
  `SDT` int(11) DEFAULT NULL,
  `DIACHI` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TAIKHOAN` char(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `MAHD` int(4) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=36 ;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`MANV`, `TENNV`, `GIOITINH`, `SDT`, `DIACHI`, `TAIKHOAN`, `MAHD`) VALUES
(1, 'Chất', 1, 114, 'Khu ổ chuột', 'admin', 2),
(2, 'Nam', 1, 114, 'Khu ổ chuột', 'nhanvien1', 7),
(3, 'Sang', 1, 14, 'Khu ổ chuột', 'nhanvien2', 6),
(4, 'Minh', 1, 222, 'HCM', 'nhanvien3', 9),
(35, 'Nguyễn văn A', 1, 33333, 'hanoi', 'nhanvien33', 3);

-- --------------------------------------------------------

--
-- Table structure for table `phongban`
--

CREATE TABLE IF NOT EXISTS `phongban` (
`MAPB` int(4) NOT NULL,
  `TENPB` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `DIACHI` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=6 ;

--
-- Dumping data for table `phongban`
--

INSERT INTO `phongban` (`MAPB`, `TENPB`, `DIACHI`) VALUES
(1, 'Hành chính', NULL),
(2, 'Lễ Tân', NULL),
(3, 'Bảo Vệ', 'GGG'),
(4, 'Lao công', 'tầng 2'),
(5, 'Phòng ban', 'tang 4');

-- --------------------------------------------------------

--
-- Table structure for table `taikhoan`
--

CREATE TABLE IF NOT EXISTS `taikhoan` (
  `TAIKHOAN` char(20) COLLATE utf8_unicode_ci NOT NULL,
  `MATKHAU` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `LV` int(3) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `taikhoan`
--

INSERT INTO `taikhoan` (`TAIKHOAN`, `MATKHAU`, `LV`) VALUES
('admin', '123456', 0),
('nhanvien1', '1', 2),
('nhanvien2', '1', 2),
('nhanvien3', '1', 2),
('nhanvien33', '1', 1),
('nv1', '1', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chamluongnhanvien`
--
ALTER TABLE `chamluongnhanvien`
 ADD PRIMARY KEY (`MACL`), ADD KEY `MANV` (`MANV`);

--
-- Indexes for table `chucvu`
--
ALTER TABLE `chucvu`
 ADD PRIMARY KEY (`MACV`);

--
-- Indexes for table `ctdk_themgio`
--
ALTER TABLE `ctdk_themgio`
 ADD PRIMARY KEY (`MANV`,`MADKTHEMGIO`), ADD KEY `MADKTHEMGIO` (`MADKTHEMGIO`);

--
-- Indexes for table `dangkythemgio`
--
ALTER TABLE `dangkythemgio`
 ADD PRIMARY KEY (`MADKTHEMGIO`);

--
-- Indexes for table `donxinnghi`
--
ALTER TABLE `donxinnghi`
 ADD PRIMARY KEY (`MADON`), ADD KEY `MANV` (`MANV`);

--
-- Indexes for table `hopdong`
--
ALTER TABLE `hopdong`
 ADD PRIMARY KEY (`MAHD`), ADD KEY `MALOAI` (`TIENLUONG`);

--
-- Indexes for table `ngaylamviec`
--
ALTER TABLE `ngaylamviec`
 ADD PRIMARY KEY (`NgayLamViec`,`MANV`), ADD KEY `MANV` (`MANV`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
 ADD PRIMARY KEY (`MANV`), ADD KEY `MAHD` (`MAHD`), ADD KEY `nv_tk` (`TAIKHOAN`);

--
-- Indexes for table `phongban`
--
ALTER TABLE `phongban`
 ADD PRIMARY KEY (`MAPB`);

--
-- Indexes for table `taikhoan`
--
ALTER TABLE `taikhoan`
 ADD PRIMARY KEY (`TAIKHOAN`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `chamluongnhanvien`
--
ALTER TABLE `chamluongnhanvien`
MODIFY `MACL` int(4) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `chucvu`
--
ALTER TABLE `chucvu`
MODIFY `MACV` int(4) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `dangkythemgio`
--
ALTER TABLE `dangkythemgio`
MODIFY `MADKTHEMGIO` int(4) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `donxinnghi`
--
ALTER TABLE `donxinnghi`
MODIFY `MADON` int(4) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `hopdong`
--
ALTER TABLE `hopdong`
MODIFY `MAHD` int(4) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `nhanvien`
--
ALTER TABLE `nhanvien`
MODIFY `MANV` int(4) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=36;
--
-- AUTO_INCREMENT for table `phongban`
--
ALTER TABLE `phongban`
MODIFY `MAPB` int(4) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `chamluongnhanvien`
--
ALTER TABLE `chamluongnhanvien`
ADD CONSTRAINT `chamluongnhanvien_ibfk_1` FOREIGN KEY (`MANV`) REFERENCES `nhanvien` (`MANV`);

--
-- Constraints for table `ctdk_themgio`
--
ALTER TABLE `ctdk_themgio`
ADD CONSTRAINT `ctdk_themgio_ibfk_1` FOREIGN KEY (`MANV`) REFERENCES `nhanvien` (`MANV`),
ADD CONSTRAINT `ctdk_themgio_ibfk_2` FOREIGN KEY (`MADKTHEMGIO`) REFERENCES `dangkythemgio` (`MADKTHEMGIO`);

--
-- Constraints for table `donxinnghi`
--
ALTER TABLE `donxinnghi`
ADD CONSTRAINT `donxinnghi_ibfk_1` FOREIGN KEY (`MANV`) REFERENCES `nhanvien` (`MANV`);

--
-- Constraints for table `ngaylamviec`
--
ALTER TABLE `ngaylamviec`
ADD CONSTRAINT `ngaylamviec_ibfk_1` FOREIGN KEY (`MANV`) REFERENCES `nhanvien` (`MANV`);

--
-- Constraints for table `nhanvien`
--
ALTER TABLE `nhanvien`
ADD CONSTRAINT `nhanvien_ibfk_3` FOREIGN KEY (`MAHD`) REFERENCES `hopdong` (`MAHD`),
ADD CONSTRAINT `nv_tk` FOREIGN KEY (`TAIKHOAN`) REFERENCES `taikhoan` (`TAIKHOAN`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
