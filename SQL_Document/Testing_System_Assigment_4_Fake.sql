-- Exercise 1: Join

-- SELECT   t1.column,  t2.column
-- FROM   table1 t1
-- JOIN     table2 t2  ON t1.column = t2.column
-- Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ 
SELECT * FROM testing_system.department;
SELECT * FROM testing_system.`account`;

SELECT a.full_name, d.*
FROM `account` a
JOIN department d ON a.department_id = d.department_id;


-- Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010
SELECT * FROM testing_system.`account`;

SELECT *
FROM `account`
WHERE create_date > '2010-12-20';

-- Question 3: Viết lệnh để lấy ra tất cả các developer
SELECT * FROM testing_system.`position`;
SELECT * FROM testing_system.`account`;

SELECT a.full_name
FROM `account` a
JOIN `position` p ON a.position_id = p.position_id
WHERE p.position_name = 'dev';

-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên 
SELECT * FROM testing_system.department;
SELECT * FROM testing_system.`account`;

SELECT d.department_name
FROM `account` a
JOIN department d ON a.department_id = d.department_id
GROUP BY a.department_id 
HAVING COUNT(a.account_id) > 3;

-- Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
SELECT * FROM testing_system.question;
SELECT q.content, COUNT(eq.exam_id) AS 'so_bai_thi'
FROM question q
JOIN exam_question eq ON q.question_id = eq.question_id
GROUP BY q.question_id
HAVING COUNT(eq.exam_id) = (
SELECT MAX(exam_count)
FROM 
		(SELECT COUNT(eq.exam_id) AS exam_count
        FROM question q
        JOIN exam_question eq ON q.question_id = eq.question_id
        GROUP BY q.question_id) AS t1
        );
-- Question 6: Thông kê mỗi category Question được sử dụng trong bao nhiêu Question 
SELECT * FROM category_question;
SELECT * FROM question;

SELECT cq.category_name, COUNT(q.question_id) AS 'so_luong'
FROM category_question cq
LEFT JOIN question q ON cq.category_id = q.category_id
GROUP BY q.category_id, cq.category_name;
 
-- Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam
SELECT * FROM exam;
SELECT * FROM question;

SELECT q.content, COUNT(eq.question_id) AS 'de thi'
FROM question q
LEFT JOIN exam_question eq ON eq.question_id = q.question_id
GROUP BY q.question_id;
-- Question 8: Lấy ra Question có nhiều câu trả lời nhất 
SELECT * FROM answer;
SELECT * FROM question;

SELECT q.content, COUNT(an.answer_id) AS 'so_cau_tra_loi'
FROM question q
JOIN answer an ON q.question_id = an.question_id
GROUP BY q.question_id
HAVING COUNT(an.answer_id) = 
(SELECT MAX(answer_count) AS 'so_cau_tra_loi'
FROM
	(SELECT question_id, COUNT(answer_id) AS 'answer_count'
	 FROM answer 
	GROUP BY question_id ) AS Q2
);

-- Question 9: Thống kê số lượng account trong mỗi group 
SELECT * FROM `group`;
SELECT * FROM group_account;

SELECT g.group_name, COUNT(ga.account_id) AS 'so_luong_account'
FROM group_account ga
RIGHT JOIN `group` g ON g.group_id = ga.group_id
GROUP BY g.group_id, g.group_name;




-- Question 10: Tìm chức vụ có ít người nhất
SELECT * FROM `position`;
SELECT * FROM `account`;
SELECT p.position_name, COUNT(a.account_id) AS 'so_luong_nguoi'
FROM `position` p LEFT JOIN `account` a ON p.position_id = a.position_id
GROUP BY p.position_id
HAVING COUNT(a.account_id) = 
(SELECT MIN(account_count)
	FROM (SELECT p.position_id, COUNT(a.account_id) AS account_count
		FROM `account` a RIGHT JOIN `position` p ON a.position_id = p.position_id
			GROUP BY p.position_id) AS q2);






-- Question 11: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM 

SELECT d.department_id, d.department_name, p.position_name, COUNT(p.position_id) AS 'so luong'
FROM `account` a
RIGHT JOIN department d ON a.department_id = d.department_id
RIGHT JOIN `position` p ON a.position_id = p.position_id
GROUP BY d.department_id, p.position_id;

SELECT d.department_id, d.department_name, p.position_name, COUNT(p.position_id) AS 'so luong'
FROM department d
LEFT JOIN `account` a ON d.department_id = a.department_id
LEFT JOIN `position` p ON a.position_id = p.position_id
GROUP BY p.position_id, d.department_id;




-- Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của 
-- question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, ... 
SELECT * FROM question;
SELECT * FROM `account`;
SELECT * FROM answer;
SELECT  q.question_id, q.content , tq.type_id,
		a.full_name , an.content , cq.category_id 
FROM question q
				LEFT JOIN type_question tq ON q.type_id = tq.type_id
				LEFT JOIN `account` a ON q.creator_id = a.account_id
				LEFT JOIN answer an ON q.question_id = an.question_id
				LEFT JOIN category_question cq ON q.category_id = cq.category_id;



-- Question 13: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm 
SELECT * FROM testing_system.type_question;
SELECT tq.type_name, COUNT(tq.type_name) AS 'sô lượng câu hỏi'
FROM question q JOIN type_question tq ON q.type_id = tq.type_id
GROUP BY tq.type_name;






-- Question 14:Lấy ra group không có account nào

-- Question 15: Lấy ra group không có account nào
SELECT * FROM `group`;
SELECT * FROM group_account;
SELECT g.group_id, g.group_name
FROM `group` g
LEFT JOIN group_account ga ON g.group_id = ga.group_id
WHERE ga.account_id IS NULL;

-- Question 16: Lấy ra question không có answer nào
SELECT * FROM question;
SELECT * FROM answer;
SELECT q.question_id, q.content
FROM answer a
RIGHT JOIN question q ON a.question_id = q.question_id
WHERE a.question_id IS NULL;
-- Exercise 2: Union
-- Question 17:
-- 				a) Lấy các account thuộc nhóm thứ 1

SELECT a.account_id, a.full_name, ga.group_id
FROM `account` a JOIN group_account ga ON a.account_id = ga.account_id
WHERE ga.group_id = 1;

-- 				b) Lấy các account thuộc nhóm thứ 2

SELECT a.account_id, a.full_name, ga.group_id
FROM `account` a JOIN group_account ga ON a.account_id = ga.account_id
WHERE ga.group_id = 2;
-- 				c) Ghép 2 kết quả từ câu a) và câu b) sao cho không có record nào trùng nhau

SELECT * FROM `group`;
SELECT a.account_id, a.full_name, ga.group_id
FROM `account` a LEFT JOIN group_account ga ON a.account_id = ga.account_id
WHERE ga.group_id = 1
	UNION
SELECT a.account_id, a.full_name, ga.group_id
FROM `account` a LEFT JOIN group_account ga ON a.account_id = ga.account_id
WHERE ga.group_id = 2;

-- Question 18:
-- 		a) Lấy các group có lớn hơn 5 thành viên
SELECT * FROM `group`;
SELECT * FROM `account`;
SELECT g.group_id, COUNT(ga.account_id) AS 'số thành viên trong nhóm' 
FROM `group` g JOIN group_account ga ON g.group_id = ga.group_id
GROUP BY g.group_id
HAVING COUNT(ga.account_id) > 5;

-- 		b) Lấy các group có nhỏ hơn 7 thành viên

SELECT g.group_id, COUNT(ga.account_id) AS 'số thành viên trong nhóm' 
FROM `group` g LEFT JOIN group_account ga ON g.group_id = ga.group_id
GROUP BY g.group_id
HAVING COUNT(ga.account_id) < 7;

-- 		c) Ghép 2 kết quả từ câu a) và câu b)

SELECT g.group_id, COUNT(ga.account_id) AS 'số thành viên trong nhóm' 
FROM `group` g JOIN group_account ga ON g.group_id = ga.group_id
GROUP BY g.group_id
HAVING COUNT(ga.account_id) > 5
	UNION ALL
SELECT g.group_id, COUNT(ga.account_id) AS 'số thành viên trong nhóm' 
FROM `group` g LEFT JOIN group_account ga ON g.group_id = ga.group_id
GROUP BY g.group_id
HAVING COUNT(ga.account_id) < 7;






