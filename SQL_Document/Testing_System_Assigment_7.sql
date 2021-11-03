-- Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo trước 1 năm trước

DROP TRIGGER IF EXISTS trigger_khong_cho_phep_group_mot_nam_truoc;
DELIMITER //
CREATE TRIGGER trigger_khong_cho_phep_group_mot_nam_truoc
BEFORE INSERT ON `group`
	FOR EACH ROW
BEGIN
	DECLARE group_one_year DATE; -- tao bien 1 nam truoc
    (SELECT DATE_SUB(CURDATE(), INTERVAL 1 YEAR)) INTO group_one_year;
        IF NEW.create_date < group_one_year -- khong cho new.create_date 1 nam truoc 
    THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'khong duoc phep them group';
	END IF;
END//
DELIMITER ;

INSERT INTO `group` (group_name, creator_id, create_date)
VALUES 				('group_11', 	1, 		'2020-10-17');


-- Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào department "Sale" nữa,
-- khi thêm thì hiện ra thông báo "Department "Sale" cannot add more user"

DROP TRIGGER IF EXISTS trigger_khong_cho_phep_them_user_vao_department;
DELIMITER //
CREATE TRIGGER trigger_khong_cho_phep_them_user_vao_department
BEFORE INSERT ON `account`
	FOR EACH ROW
BEGIN
	DECLARE department_sale VARCHAR(30) CHAR SET utf8mb4; -- tao bien phong ban sale
    (SELECT department_id INTO department_sale
    FROM department
    WHERE department_name = 'sale');
        IF NEW.department_id = department_sale -- khong cho them user vao department sale
    THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'Department Sale cannot add more user';
	END IF;
END//
DELIMITER ;

INSERT INTO `account`(email,					 user_name,		 full_name, gender, department_id, position_id, 	create_date)
VALUES 				('them.user@gmail.com',		 'them.user', 	'them.user', 'M',		2,				 1,			 '2010-12-21');
					
SELECT * FROM `account`;

-- Question 3: Cấu hình 1 group có nhiều nhất là 5 user

DROP TRIGGER IF EXISTS trigger_group_max_user;
DELIMITER //
CREATE TRIGGER trigger_group_max_user
BEFORE INSERT ON group_account
	FOR EACH ROW
BEGIN
	DECLARE max_user TINYINT;
    (SELECT COUNT(account_id) INTO max_user
    FROM group_account
    WHERE group_id = NEW.group_id
    GROUP BY group_id);

        IF max_user >= 5 -- khong cho them user vao department sale
    THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'group khong duoc nhieu hon 5 user';
	END IF;
END//
DELIMITER ;

INSERT INTO group_account(group_id, account_id, join_date)
VALUES 						(2,		 1,			 '2021-10-10');

-- Question 4: Cấu hình 1 bài thi có nhiều nhất là 10 Question

DROP TRIGGER IF EXISTS trigger_exam_max_question;
DELIMITER //
CREATE TRIGGER trigger_exam_max_question
BEFORE INSERT ON exam_question
	FOR EACH ROW
BEGIN
	DECLARE exam_max_question TINYINT;
    (SELECT COUNT(question_id) INTO exam_max_question
    FROM exam_question
    WHERE exam_id = NEW.exam_id
    GROUP BY exam_id);
        IF exam_max_question >= 10 -- khong cho them user vao department sale
    THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'exam khong duoc nhieu hon 10 question';
	END IF;
END//
DELIMITER ;

INSERT INTO exam_question(exam_id, question_id)
VALUES 						(2,		 11);

SELECT * FROM exam_question;

-- Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là admin@gmail.com (đây là tài khoản admin, không cho phép user xóa),
-- còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông tin liên quan tới user đó

DROP TRIGGER IF EXISTS trigger_khong_cho_phep_xoa_email;
DELIMITER //
CREATE TRIGGER trigger_khong_cho_phep_xoa_email
BEFORE DELETE ON `account`
	FOR EACH ROW
BEGIN
	IF OLD.email = 'admin@gmail.com'
    THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'khong duoc phep xoa';
    END IF;
END//
DELIMITER ;

DELETE
FROM `account`
WHERE email = 'admin@gmail.com';

-- Question 6: Không sử dụng cấu hình default cho field DepartmentID của table Account, 
-- hãy tạo trigger cho phép người dùng khi tạo account không điền vào departmentID thì sẽ được phân vào phòng ban "waiting Department"

DROP TRIGGER IF EXISTS trigger_chuyen_account_sang_waitingromm;
DELIMITER //
CREATE TRIGGER trigger_chuyen_account_sang_waitingromm
BEFORE INSERT ON `account`
	FOR EACH ROW
BEGIN
	IF NEW.department_id IS NULL
    THEN
		SET NEW.department_id = (SELECT department_id FROM department WHERE department_name = 'waiting room');
    END IF;
END//
DELIMITER ;

INSERT INTO `account`(email, 	user_name, 	full_name,	  position_id, 			create_date)
VALUES 	('mot@gmail.com',		 'mot', 	'mot',			1, 				'2010-12-21');
		
SELECT * FROM `account`;
-- Question 7: Cấu hình 1 bài thi (question) chỉ cho phép user tạo tối đa 4 answers cho mỗi question, trong đó có tối đa 2 đáp án đúng.
-- đáp án đúng: 1
-- đáp án sai: 0
USE testing_system;

DROP TRIGGER IF EXISTS trigger_khong_cho_phep_them_answer;
DELIMITER //
CREATE TRIGGER trigger_khong_cho_phep_them_answer
BEFORE INSERT ON answer
FOR EACH ROW
BEGIN
	DECLARE cntanswer TINYINT;
    DECLARE cnttruecorrect TINYINT;
    -- lay so dap an question nhap vao
		SELECT COUNT(answer_id) INTO cntanswer
        FROM answer
        WHERE question_id = NEW.question_id; -- question nhap vao
        
        -- lay so. dap an dung cua question nhap vao
        SELECT COUNT(is_correct) INTO cnttruecorrect
        FROM answer
        WHERE question_id = NEW.question_id AND is_correct =1;
        
	IF cntanswer >= 4 OR (cnttruecorrect >= 2 AND NEW.is_correct =1) THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'khong duoc them question and answer';
    END IF;
END//
DELIMITER ;

INSERT INTO answer(content, question_id, is_correct)
VALUES 				('= 30', 	1,			 1);

-- Question 8: Viết trigger sửa lại dữ liệu cho đúng:
-- Nếu người dùng nhập vào gender của account là nam, nữ, chưa xác định Thì sẽ đổi lại thành M, F, U cho giống với cấu hình ở database

DROP TRIGGER IF EXISTS trigger_check_gender;
DELIMITER //
CREATE TRIGGER trigger_check_gender
BEFORE INSERT ON `account`
	FOR EACH ROW
BEGIN
	IF NEW.gender = 'nam' THEN
		SET NEW.gender = 'M';
	END IF;
    IF NEW.gender = 'nữ' THEN
		SET NEW.gender = 'N';
	END IF;
    IF NEW.gender = 'chưa xác định' THEN
		SET NEW.gender = 'U';
	END IF;
END//
DELIMITER ;

INSERT INTO `account`(email,					 user_name,			 full_name, 	gender, 	department_id, position_id, create_date)
VALUES 				('gender_nu@gmail.com',	 		'user_nu', 			'nu',			 'nữ',				3,		 1,			 '2010-12-21'),
					('gender_nam@gmail.com',	 	'user_nam', 		'nam',			 'nam',				3,		 1,			 '2010-12-21'),
					('chua_xac_dinh@gmail.com',	 'chua_xac_dinh', 	'chua_xac_dinh', 'chưa xác định',		3,		 1,			 '2010-12-21');
					
SELECT * FROM `account`;

-- Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày 

DROP TRIGGER IF EXISTS trigger_khong_cho_phep_xoa_exam;
DELIMITER //
CREATE TRIGGER trigger_khong_cho_phep_xoa_exam
BEFORE DELETE ON exam
	FOR EACH ROW
BEGIN
		DECLARE exam_new_twoday DATE; -- biến chứa 2 ngày trước
        SELECT DATE_SUB(CURDATE(), INTERVAL 2 DAY) INTO exam_new_twoday;
        IF OLD.create_date > exam_new_twoday THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'không được phép xóa bài thi mới tạo được 2 ngày';
		END IF;
END//
DELIMITER ;

DELETE FROM exam WHERE exam_id = 11 ;

SELECT * FROM exam;

-- Question 10: Viết trigger chỉ cho phép người dùng chỉ được update, delete các question 
-- khi question đó chưa nằm trong exam nào

-- delete question
DROP TRIGGER IF EXISTS trigger_xoa_question_khong_chua_exam;
DELIMITER //
CREATE TRIGGER trigger_xoa_question_khong_chua_exam
BEFORE DELETE ON question
	FOR EACH ROW
BEGIN
	DECLARE exam_count TINYINT;
	SELECT COUNT(question_id) INTO exam_count
    FROM exam_question
    WHERE question_id = OLD.question_id;
    IF exam_count <> 0 THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'không được phép xóa question đã có exam';
		END IF;
END//
DELIMITER ;

DELETE FROM question WHERE question_id = 9 ;

SELECT * FROM exam_question;
SELECT * FROM question;

-- Question 10: Viết trigger chỉ cho phép người dùng chỉ được update, delete các question 
-- khi question đó chưa nằm trong exam nào
-- update question
DROP TRIGGER IF EXISTS trigger_update_question_khong_chua_exam;
DELIMITER //
CREATE TRIGGER trigger_update_question_khong_chua_exam
BEFORE UPDATE ON question
	FOR EACH ROW
BEGIN
	DECLARE exam_count TINYINT;
	SELECT COUNT(question_id) INTO exam_count
    FROM exam_question
    WHERE question_id = OLD.question_id;
    IF exam_count <> 0 THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'không được phép update question đã có exam';
		END IF;
END//
DELIMITER ;

UPDATE question
SET question_id = 30
WHERE question_id = 8;

SELECT * FROM exam_question;
SELECT * FROM question;

-- Question 12: Lấy ra thông tin exam trong đó:
-- Duration <= 30 thì sẽ đổi thành giá trị "Short time"
-- 30 < Duration <= 60 thì sẽ đổi thành giá trị "Medium time" 
-- Duration > 60 thì sẽ đổi thành giá trị "Long time

SELECT exam_id, `code`, title, duration, CASE WHEN duration <= 30 THEN 'Short time'
											WHEN duration <= 60 THEN 'Medium time'
											ELSE 'Long time' END AS 'time'
FROM exam;

-- Question 13: Thống kê số account trong mỗi group và in ra thêm 1 column nữa có tên là the_number_user_amount và mang giá trị được quy định như sau:
-- Nếu số lượng user trong group =< 5 thì sẽ có giá trị là few
-- Nếu số lượng user trong group <= 20 và > 5 thì sẽ có giá trị là normal 
-- Nếu số lượng user trong group > 20 thì sẽ có giá trị là higher

SELECT g.group_name, COUNT(ga.account_id) AS 'account_count', CASE WHEN COUNT(account_id) <= 5 THEN 'few'
																WHEN COUNT(account_id) <= 20 AND COUNT(account_id) > 5 THEN 'normal' 
																WHEN COUNT(account_id) > 20 THEN 'higher' END AS 'the_number_user_amount'
FROM `group` g
				LEFT JOIN group_account ga ON g.group_id = ga.group_id
GROUP BY g.group_name;

-- Question 14: Thống kê số mỗi phòng ban có bao nhiêu user, nếu phòng ban nào không có user thì sẽ thay đổi giá trị 0 thành "Không có User"

SELECT d.department_name, CASE WHEN COUNT(a.account_id) = 0  THEN 'Không có User'
								ELSE COUNT(a.account_id)
								END AS 'Không có User'
FROM department d
				LEFT JOIN `account` a ON d.department_id = a.department_id
GROUP BY d.department_name;






