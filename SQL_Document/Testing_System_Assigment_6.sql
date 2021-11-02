USE testing_system;

-- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các account thuộc phòng ban đó
DESCRIBE department;
DESCRIBE `account`;
-- tao thu tuc
DROP PROCEDURE IF EXISTS sp_phong_ban;
DELIMITER //
CREATE PROCEDURE sp_phong_ban(IN in_department_name VARCHAR(30) CHAR SET utf8mb4)
	BEGIN
		SELECT a.full_name
        FROM `account` a
						JOIN department d ON a.department_id = d.department_id
		WHERE d.department_name = in_department_name ;
END//
DELIMITER ;


CALL sp_phong_ban('sale');

-- Question 2: Tạo store để in ra số lượng account trong mỗi group
DESCRIBE `group`;
DESCRIBE `account`;

DROP PROCEDURE IF EXISTS sp_accounr_count;
DELIMITER //
CREATE PROCEDURE sp_accounr_count()
	BEGIN
		SELECT g.group_name, COUNT(ga.account_id) AS 'account_count'
        FROM `group` g
						LEFT JOIN group_account ga ON g.group_id = ga.group_id
		GROUP BY g.group_id, g.group_name;
END//
DELIMITER ;

CALL sp_accounr_count();

-- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo trong tháng hiện tại
DESCRIBE question;
DESCRIBE type_question;

DROP PROCEDURE IF EXISTS sp_thong_ke_question;
DELIMITER //
CREATE PROCEDURE sp_thong_ke_question()
	BEGIN
		SELECT COUNT(q.question_id), tq.type_name
        FROM type_question tq 
						LEFT JOIN question q ON tq.type_id = q.type_id
		WHERE MONTH(q.create_date) = MONTH(curdate()) AND YEAR(q.create_date) = YEAR(curdate()) 
		GROUP BY tq.type_id;
END//
DELIMITER ;

CALL sp_thong_ke_question();

-- Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất 
DESCRIBE question;
DESCRIBE type_question;
USE testing_system;

DROP PROCEDURE IF EXISTS sp_type_question_max;
DELIMITER //
CREATE PROCEDURE sp_type_question_max(OUT out_type_id TINYINT)
BEGIN
	SELECT type_id INTO out_type_id
    FROM question
    GROUP BY type_id
    HAVING COUNT(question_id) = 
								(SELECT MAX(count_question)
                                 FROM (SELECT COUNT(question_id) AS 'count_question'
										FROM question
                                        GROUP BY type_id) AS Q);
END//
DELIMITER ;

SET @out_type_id = 0;
CALL sp_type_question_max(@out_type_id);
SELECT @out_type_id;

-- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question
DESCRIBE question;
DESCRIBE type_question;

DROP PROCEDURE IF EXISTS sp_ten_type_question;
DELIMITER //
CREATE PROCEDURE sp_ten_type_question()
BEGIN
    DECLARE out_type_id TINYINT;
    SET out_type_id = 0;
    CALL sp_type_question_max(out_type_id);
	SELECT type_name
    FROM type_question
    WHERE type_id = out_type_id;
END//
DELIMITER ;

CALL sp_ten_type_question();

-- Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi ky tu và trả về group có tên chứa chuỗi ky tu của người dùng nhập vào 
-- hoặc trả về user có username chứa chuỗi ky tu của người dùng nhập vào
DESCRIBE `group`;
DESCRIBE `account`;

DROP PROCEDURE IF EXISTS sp_thong_tin_account;
DELIMITER //
CREATE PROCEDURE sp_thong_tin_account(IN input VARCHAR(50))
BEGIN
	SELECT g.group_name COLLATE utf8mb4_unicode_ci AS 'group_name'
    FROM `group` g
    WHERE g.group_name LIKE  CONCAT('%', input, '%') COLLATE utf8mb4_unicode_ci
UNION
	SELECT a.user_name COLLATE utf8mb4_unicode_ci AS 'account_name'
    FROM `account` a
    WHERE a.user_name LIKE CONCAT('%', input, '%') COLLATE utf8mb4_unicode_ci;
END//
DELIMITER ;

CALL sp_thong_tin_account('group');

-- Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và trong store sẽ tự động gán:
-- username sẽ giống email nhưng bỏ phần @..mail đi positionID: sẽ có default là developer departmentID: sẽ được cho vào 1 phòng chờ
-- Sau đó in ra kết quả tạo thành công
DROP PROCEDURE IF EXISTS sp_nhap_user;
DELIMITER //
CREATE PROCEDURE sp_nhap_user(IN in_full_name VARCHAR(50)CHAR SET utf8mb4, IN in_email VARCHAR(50))
	BEGIN
		DECLARE userName VARCHAR(50) DEFAULT SUBSTRING_INDEX(in_email, '@', 1);
        DECLARE departmentID TINYINT DEFAULT 11;
        DECLARE positionID TINYINT DEFAULT 1;
        DECLARE createDate DATE DEFAULT curdate();
        INSERT INTO `account` (email, user_name, full_name, department_id, position_id, create_date)
        VALUES (in_email, userName, in_full_name, departmentID, positionID, createDate);
        SELECT * FROM `account` ORDER BY account_id DESC LIMIT 1;
    END//
DELIMITER ;

CALL sp_nhap_user('Bùi Gia Hân', 'han.buigia@gmail.com');
SELECT * FROM `account`;

-- Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice để thống kê câu hỏi 
-- essay hoặc multiple-choice nào có content dài nhất
DESCRIBE question;
DESCRIBE type_question;

DROP PROCEDURE IF EXISTS sp_max_type_question;
DELIMITER //
CREATE PROCEDURE sp_max_type_question (IN in_type_name ENUM ('Essay','Multiple-Choice'))
BEGIN 
	SELECT tq.type_name, q.content, LENGTH(q.content) AS 'length_content'
    FROM question q
					JOIN type_question tq ON q.type_id = tq.type_id
	WHERE LENGTH(q.content) = 
							(SELECT MAX(length_content) AS 'max_length_content'
							FROM
								(SELECT LENGTH(q.content) AS 'length_content'
								FROM type_question tq
													JOIN question q ON tq.type_id = q.type_id
								WHERE tq.type_name = in_type_name) AS tq)
										AND tq.type_name = in_type_name;
END//
DELIMITER ;

CALL sp_max_type_question('Essay');
CALL sp_max_type_question('Multiple-Choice');

-- Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID
DESCRIBE exam;

DROP PROCEDURE IF EXISTS sp_delete_exam;
DELIMITER //
CREATE PROCEDURE sp_delete_exam(IN in_exam_id TINYINT)
BEGIN 
	DELETE
	FROM exam
    WHERE exam_id = in_exam_id;
END//
DELIMITER ;

CALL sp_delete_exam(10);
SELECT * FROM exam;

-- Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử dụng store ở câu 9 để xóa)
-- Sau đó in số lượng record đã remove từ các table liên quan trong khi removing
-- Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng nhập vào tên phòng ban 
-- và các account thuộc phòng ban đó sẽ được chuyển về phòng ban default là phòng ban chờ việc
DROP PROCEDURE IF EXISTS sp_xoa_dp_set_default;
DELIMITER $$
CREATE PROCEDURE sp_xoa_dp_set_default(IN depName VARCHAR(30) CHAR SET utf8mb4)
    BEGIN 
        -- Chuyển nhân viên thuộc phòng ban departmentName sang pphòng chờ
        UPDATE `account`
        -- lay department_id cua phong 'phòng chờ'
        SET department_id = (SELECT department_id
							FROM department
							WHERE department_name = 'phòng chờ')
        -- lay department_id cua phong ban duoc nhap vao
        WHERE department_id = (SELECT department_id
								FROM department
								WHERE department_name = depName);
        -- Xoá phòng ban
        DELETE FROM department
        WHERE department_name = depName;
    END$$
DELIMITER ;

SELECT *
FROM `account` a JOIN department d ON d.department_id = a.department_id;
SELECT * FROM department;
CALL sp_xoa_dp_set_default('sale');
-- Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm nay
DROP PROCEDURE sp_so_cau_hoi_moi_thang_trong_nam_nay;
DELIMITER $$
CREATE PROCEDURE sp_so_cau_hoi_moi_thang_trong_nam_nay()
	BEGIN
		WITH cte_12months AS -- bảng tạm của các tháng
					(SELECT 1 AS 'thang'
					UNION SELECT 2 AS 'thang'
					UNION SELECT 3 AS 'thang'
					UNION SELECT 4 AS 'thang'
					UNION SELECT 5 AS 'thang'
					UNION SELECT 6 AS 'thang'
					UNION SELECT 7 AS 'thang'
					UNION SELECT 8 AS 'thang'
					UNION SELECT 9 AS 'thang'
					UNION SELECT 10 AS 'thang'
					UNION SELECT 11 AS 'thang'
					UNION SELECT 12 AS 'thang'),
                    
            cte_nhung_cau_hoi_cua_nam_hien_tai AS -- bang ảo của question năm hiện tại
				(SELECT * FROM question WHERE YEAR(create_date) = YEAR(CURDATE()))
                
			SELECT c12.thang, count(cq.question_id) AS so_luong
			FROM cte_12months c12 LEFT JOIN cte_nhung_cau_hoi_cua_nam_hien_tai cq
											ON c12.thang = MONTH(cq.create_date)
			GROUP BY c12.thang;
	END $$
DELIMITER ;        
-- gọi thủ tục
call sp_so_cau_hoi_moi_thang_trong_nam_nay();

-- Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6 tháng gần đây nhất
-- (Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong tháng")
DROP PROCEDURE IF EXISTS sp_dem_cau_hoi_6thang_gan_nhat_cach2;
DELIMITER $$
CREATE PROCEDURE sp_dem_cau_hoi_6thang_gan_nhat_cach2()
BEGIN
-- sử dụng CTE
WITH cte_6thang_gan_nhat AS -- tạo bang tạm 6 tháng gần đây
	(SELECT MONTH(DATE_SUB(NOW(), INTERVAL 5 MONTH)) AS 'thang', YEAR(DATE_SUB(NOW(), INTERVAL 5 MONTH)) AS `nam`
	UNION
	SELECT MONTH(DATE_SUB(NOW(), INTERVAL 4 MONTH)) AS 'thang', YEAR(DATE_SUB(NOW(), INTERVAL 4 MONTH)) AS `nam`
	UNION 
    SELECT MONTH(DATE_SUB(NOW(), INTERVAL 3 MONTH)) AS 'thang', YEAR(DATE_SUB(NOW(), INTERVAL 3 MONTH)) AS `nam`
	UNION 
	SELECT MONTH(DATE_SUB(NOW(), INTERVAL 2 MONTH)) AS 'thang', YEAR(DATE_SUB(NOW(), INTERVAL 2 MONTH)) AS `nam`
	UNION
	SELECT MONTH(DATE_SUB(NOW(), INTERVAL 1 MONTH)) AS 'thang', YEAR(DATE_SUB(NOW(), INTERVAL 1 MONTH)) AS `nam`
	UNION
	SELECT MONTH(NOW())AS 'thang', YEAR(NOW()) AS `nam`), 
cte_cau_hoi_trong_nam_nay AS -- tạo bang tạm question >= 6 tháng va <= hien tai
	(SELECT * FROM question where create_date >= DATE_SUB(NOW(), INTERVAL 6 MONTH) AND create_date <= CURDATE())

	SELECT ct6.thang, ct6.nam, 
			CASE WHEN COUNT(question_id) = 0 THEN 'không có câu hỏi nào trong tháng' ELSE COUNT(question_id) END AS so_luong_cau_hoi 
	FROM CTE_6thang_gan_nhat ct6 LEFT JOIN cte_cau_hoi_trong_nam_nay cc ON ct6.thang = MONTH(cc.create_date)
	GROUP BY ct6.thang, ct6.nam
	ORDER BY ct6.thang ASC;
END$$
DELIMITER ;
-- gọi theo cách 2
CALL sp_dem_cau_hoi_6thang_gan_nhat_cach2();

