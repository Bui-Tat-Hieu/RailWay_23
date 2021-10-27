USE testing_system;
-- Exercise 1: Tiếp tục với Database Testing System
-- (Sử dụng subquery hoặc CTE)
-- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale

DROP VIEW IF EXISTS nhan_vien_sale ;
CREATE VIEW nhan_vien_sale AS
SELECT a.full_name, d.department_name, d.department_id
FROM `account` a, department d
WHERE a.department_id = d.department_id
AND d.department_id = (	SELECT department_id
							FROM department
							WHERE department_name = 'sale');
                            
SELECT * FROM nhan_vien_sale;

-- Question 2: Tạo view có chứa tim thông tin các account tham gia vào nhiều group nhất 
DROP VIEW IF EXISTS account_max_group;
CREATE VIEW account_max_group AS
WITH
account_max_group AS
(SELECT a.full_name, COUNT(ga.account_id) AS 'group_count'
FROM group_account ga
					JOIN `account` a ON ga.account_id = a.account_id
GROUP BY a.account_id)
SELECT *
FROM account_max_group
WHERE group_count = (SELECT MAX(group_count)
					 FROM account_max_group);
                     
SELECT * FROM account_max_group;

-- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ được coi là quá dài) và xóa nó đi
DROP VIEW IF EXISTS content_max_300_word;
CREATE VIEW content_max_300_word AS
SELECT content
FROM question
WHERE LENGTH(content) > 300;

SELECT * FROM content_max_300_word;
DELETE FROM content_max_300_word;

-- Question 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất 
DROP VIEW IF EXISTS department_max_account;
CREATE VIEW department_max_account AS
WITH
so_luong_account AS 
(SELECT d.department_name, COUNT(a.account_id) AS 'account_count'
FROM `account` a
				JOIN department d ON a.department_id = d.department_id
GROUP BY d.department_id)
SELECT *
FROM so_luong_account
WHERE account_count = (SELECT MAX(account_count)
						FROM so_luong_account);

SELECT * FROM department_max_account;

-- Question 5: Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo
DROP VIEW IF EXISTS question_creator;
CREATE VIEW question_creator AS
SELECT a.account_id, q.content, a.full_name
FROM question q, `account` a
WHERE q.creator_id = a.account_id
AND a.account_id IN
						(SELECT account_id
						FROM `account`
						WHERE full_name LIKE 'Nguyen%');

SELECT * FROM question_creator;
