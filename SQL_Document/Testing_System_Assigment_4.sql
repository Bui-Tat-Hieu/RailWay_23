-- Exercise 1: Join

-- SELECT   t1.column,  t2.column
-- FROM   table1 t1
-- JOIN     table2 t2  ON t1.column = t2.column
-- Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ 
SELECT * FROM testing_system.department;
SELECT * FROM testing_system.`account`;
SELECT a.full_name, d.department_name
FROM `account` a
JOIN department d ON a.department_id = d.department_id;

-- Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 13/10/2021
SELECT * FROM testing_system.`account`;
SELECT *
FROM `account`
WHERE create_date >= '2021-10-13';
-- Question 3: Viết lệnh để lấy ra tất cả các developer
SELECT p.position_name, a.full_name
FROM `account` a
JOIN `position` p ON a.position_id = p.position_id
WHERE position_name LIKE 'dev';
-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên 
SELECT * FROM testing_system.department;
SELECT * FROM testing_system.`account`;
SELECT d.department_name, COUNT(a.department_id) AS 'số lượng'
FROM `account` a
JOIN department d ON a.department_id = d.department_id
GROUP BY a.department_id 
HAVING COUNT(a.department_id) > 3;

-- Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
-- SELECT   t1.column,  t2.column
-- FROM   table1 t1
-- JOIN     table2 t2  ON t1.column = t2.column


-- Question 6: Thông kê mỗi category Question được sử dụng trong bao nhiêu Question 
SELECT * FROM category_question;
SELECT * FROM question;
SELECT cq.category_name, COUNT(q.category_id) AS 'cau hoi'
FROM category_question cq
JOIN question q ON cq.category_id = q.category_id
GROUP BY q.category_id;
 
-- Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam
-- SELECT   t1.column,  t2.column
-- FROM   table1 t1
-- JOIN     table2 t2  ON t1.column = t2.column

SELECT q.content, COUNT(eq.question_id) AS 'de thi'
FROM question q
LEFT JOIN exam_question eq ON eq.question_id = q.question_id
GROUP BY q.question_id;
-- Question 8: Lấy ra Question có nhiều câu trả lời nhất 


-- Question 9: Thống kê số lượng account trong mỗi group
-- Question 10: Tìm chức vụ có ít người nhất
SELECT * FROM `position`;
SELECT * FROM `account`;

-- Question 11: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM 
SELECT d.department_id, d.department_name, p.position_name, COUNT(p.position_id) AS 'so luong'
FROM `account` a
JOIN department d ON a.department_id = d.department_id
JOIN `position` p ON a.position_id = p.position_id
GROUP BY d.department_id, p.position_id;
-- Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của 
-- question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, ... 
-- Question 13: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm 
-- Question 14:Lấy ra group không có account nào

-- Question 15: Lấy ra group không có account nào

-- Question 16: Lấy ra question không có answer nào
-- Exercise 2: Union
-- Question 17:
-- 				a) Lấy các account thuộc nhóm thứ 1
-- 				b) Lấy các account thuộc nhóm thứ 2
-- 				c) Ghép 2 kết quả từ câu a) và câu b) sao cho không có record nào trùng nhau
SELECT * FROM `group`;
SELECT a.account_id, a.full_name, ga.group_id
FROM `account` a	
JOIN group_account ga ON a.account_id = ga.account_id
WHERE ga.group_id = 1
UNION
SELECT a.account_id, a.full_name, ga.group_id
FROM `account` a	
JOIN group_account ga ON a.account_id = ga.account_id
WHERE ga.group_id = 2;
-- Question 18:
-- 				a) Lấy các group có lớn hơn 5 thành viên
-- 				b) Lấy các group có nhỏ hơn 7 thành viên
-- 				c) Ghép 2 kết quả từ câu a) và câu b)


