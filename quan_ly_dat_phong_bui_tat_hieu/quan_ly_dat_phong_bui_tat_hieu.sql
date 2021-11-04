

DROP DATABASE IF EXISTS quan_ly_dat_phong_bui_tat_hieu;
CREATE DATABASE quan_ly_dat_phong_bui_tat_hieu;
USE quan_ly_dat_phong_bui_tat_hieu;

ALTER DATABASE quan_ly_dat_phong_bui_tat_hieu CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- 1. Tạo Bảng và thêm tối thiểu 5 bản ghi cho mỗi Bảng

DROP TABLE IF EXISTS KHACH_HANG;
CREATE TABLE KHACH_HANG(
	MaKH 		SMALLINT AUTO_INCREMENT PRIMARY KEY ,
	TenKH		VARCHAR(40) CHARACTER SET utf8mb4 NOT NULL,
	DiaChi		VARCHAR(50) CHARACTER SET utf8mb4 NOT NULL,
	SoDT		CHAR(13)
);
INSERT INTO KHACH_HANG(TenKH, 				DiaChi,	 		SoDT)
VALUES 				('Nguyễn Khánh Linh', 	'cầu giấy', 	0963852741),
					('B', 					'đống đa',		0374185296),
					('C', 					'xuân thuỷ',	0974185236),
					('D', 					'duy tân',		0932165487),
					('E', 					'mỹ đình',		0914725836);

DROP TABLE IF EXISTS PHONG;
CREATE TABLE PHONG(
	MaPhong			TINYINT AUTO_INCREMENT PRIMARY KEY,
	LoaiPhong		VARCHAR(10) CHARACTER SET utf8mb4 NOT NULL,
	SoKhachToiDa	TINYINT(5) NOT NULL,
	GiaPhong		DECIMAL(8,0) NOT NULL,
	MoTa			VARCHAR(50) CHARACTER SET utf8mb4 NOT NULL
);
INSERT INTO PHONG(LoaiPhong, 	SoKhachToiDa,	GiaPhong,	 	MoTa)
VALUES 				('loại 1',		50,			5000000,		'không có'),
					('loại 2',		40,			4000000,		'không có'),
					('loại 3',		30,			3000000,		'không có'),
					('loại 4',		20,			2000000,		'không có'),
					('loại 5',		10,			1000000,		'không có');
					
DROP TABLE IF EXISTS DAT_PHONG;
CREATE TABLE DAT_PHONG(
	MaDatPhong			SMALLINT AUTO_INCREMENT PRIMARY KEY,
	MaPhong				TINYINT NOT NULL,
	MaKH				SMALLINT NOT NULL,
	NgayDat				DATE NOT NULL,
	TienDatCoc			DECIMAL(8,0) NOT NULL,
	GhiChu				VARCHAR(50) CHARACTER SET utf8mb4 NOT NULL,
	TrangThaiDat		ENUM('đã đặt', 'đã huỷ'),
    FOREIGN KEY(MaPhong) REFERENCES PHONG(MaPhong) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(MaKH) REFERENCES KHACH_HANG(MaKH) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO DAT_PHONG(MaPhong, 	MaKH,	NgayDat,	 	TienDatCoc, GhiChu, 	TrangThaiDat)
VALUES 				(1,			1,		'2021-11-04',	2000000,     'đã đặt',		'đã đặt'),
					(2,			1,		'2020-10-04',	2000000,     'đã đặt',		'đã đặt'),
					(3,			4,		'2021-11-04',	2000000,     'đã huỷ',		'đã huỷ'),
					(4,			2,		'2020-05-04',	2000000,     'đã đặt',		'đã đặt'),
					(5,			2,		'2020-11-03',	2000000,     'đã đặt',		'đã đặt'),
					(1,			3,		'2021-06-03',	2000000,     'đã đặt',		'đã đặt'),
					(1,			5,		'2020-04-03',	2000000,     'đã đặt',		'đã đặt');
		
DROP TABLE IF EXISTS DICH_VU_DI_KEM;
CREATE TABLE DICH_VU_DI_KEM(
	MaDV			TINYINT AUTO_INCREMENT PRIMARY KEY,
	TenDV			VARCHAR(50) CHARACTER SET utf8mb4 NOT NULL,
	DonViTinh		VARCHAR(50) CHARACTER SET utf8mb4 NOT NULL,
	DonGia			DECIMAL(7,0) NOT NULL
);
INSERT INTO DICH_VU_DI_KEM(TenDV, 			DonViTinh,		DonGia)
VALUES 				 		('Bia',				'Lon',		25000),
							('Nước ngọt',		'Lon',		10000),
							('Trái cây',		'Đĩa',		200000),
							('Khăn ướt',		'Cái',		10000),
							('Đồ Khô',			'Gói',		50000);
	
DROP TABLE IF EXISTS CHI_TIET_SU_DUNG_DV;
CREATE TABLE CHI_TIET_SU_DUNG_DV(
	MaDatPhong		SMALLINT NOT NULL,
	MaDV			TINYINT NOT NULL,
	SoLuong			CHAR(10),
    PRIMARY KEY (MaDatPhong, MaDV),
    FOREIGN KEY(MaDatPhong) REFERENCES DAT_PHONG(MaDatPhong) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(MaDV) REFERENCES DICH_VU_DI_KEM(MaDV) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO CHI_TIET_SU_DUNG_DV(MaDatPhong, 	MaDV,	SoLuong)
VALUES 				 			(1,				1,			24),
								(1,				2,			24),
								(3,				3,			2),
								(4,				4,			10),
								(5,				5,			10);
								
-- 2. Hiển thị loại phòng đã thuê, tên dịch vụ đã sử dụng của khách hàng có tên là “Nguyễn Khánh Linh”

-- 3. Viết Function để trả về Số điện thoại của Khách hàng thuê nhiều phòng nhất trong năm 2020


SET GLOBAL log_bin_trust_function_creators = 1;
DROP FUNCTION IF EXISTS f_khach_hang_max ;
DELIMITER //
CREATE FUNCTION f_khach_hang_max() RETURNS CHAR(13)
BEGIN
	DECLARE out_sdt CHAR(13);
    SELECT kh.SoDT INTO out_sdt
    FROM KHACH_HANG kh
						JOIN DAT_PHONG dp ON kh.MaKH = dp.MaKH
	WHERE NgayDat < DATE_SUB(CURDATE(), INTERVAL 1 YEAR)
    GROUP BY kh.MaKH
    HAVING COUNT(dp.MaPhong) = 
								(SELECT MAX(so_phong_da_dat)
								FROM
									(SELECT kh.MaKH, COUNT(dp.MaPhong) AS 'so_phong_da_dat'
									FROM KHACH_HANG kh
													JOIN DAT_PHONG dp ON kh.MaKH = dp.MaKH
									WHERE NgayDat < DATE_SUB(CURDATE(), INTERVAL 1 YEAR)
									GROUP BY kh.MaKH) AS KH);
	RETURN out_sdt;
END//
DELIMITER ;

SELECT f_khach_hang_max();

-- 4. Viết thủ tục tăng giá phòng thêm 10,000 VNĐ so với giá phòng hiện tại cho những phòng có số khách tối đa lớn hơn 5.

-- 5. Viết thủ tục thống kê khách hàng và số lần thuê phòng tương ứng của từng khách hàng trong năm nay.

DROP PROCEDURE IF EXISTS sp_khach_hang_dat_phong;
DELIMITER //
CREATE PROCEDURE sp_khach_hang_dat_phong()
BEGIN
	SELECT kh.MaKH, kh.TenKH, COUNT(dp.MaDatPhong) AS 'so_lan_dat_phong'
    FROM KHACH_HANG kh
						LEFT JOIN DAT_PHONG dp ON kh.MaKH = dp.MaKH
	WHERE YEAR(NgayDat) = YEAR(CURDATE()) AND TrangThaiDat = 'đã đặt'
    GROUP BY kh.MaKH;

END//
DELIMITER ;

CALL sp_khach_hang_dat_phong();

-- 6. Viết thủ tục hiển thị 5 đơn đặt phòng gần nhất bao gồm có các thông tin: Mã đặt phòng, tên khách hàng, loại phòng, giá phòng.

DROP PROCEDURE IF EXISTS sp_phong_dat_gan_nhat;
DELIMITER //
CREATE PROCEDURE sp_phong_dat_gan_nhat()
BEGIN
	SELECT dp.MaDatPhong, kh.MaKH, kh.TenKH, p.LoaiPhong, GiaPhong
    FROM DAT_PHONG dp
					JOIN KHACH_HANG kh ON dp.MaKH = kh.MaKH
                    JOIN PHONg p ON dp.MaPhong = p.MaPhong
	WHERE TrangThaiDat = 'đã đặt'
	GROUP BY dp.MaDatPhong, kh.TenKH
    ORDER BY NgayDat DESC
    LIMIT 5;
END//
DELIMITER ;

CALL sp_phong_dat_gan_nhat();

-- 7. Viết Trigger kiểm tra khi thêm phòng mới có Số khách tối đa vượt quá 10 người thì không cho thêm mới và hiển thị thông báo “Vượt quá số người cho phép”.



