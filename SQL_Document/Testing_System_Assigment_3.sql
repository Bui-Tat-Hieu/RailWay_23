-- Question 1: Thêm ít nhất 10 record vào mỗi table
-- Question 2: lấy ra tất cả các phòng ban

SELECT * FROM testing_systing.department;
SELECT department_name
FROM department;
-- Question 3: lấy ra id của phòng ban "Sale"
SELECT * FROM testing_systing.department;
SELECT department_id
FROM department
WHERE department_name = 'sale';


-- Question 4: lấy ra thông tin account có full name dài nhất
SELECT * FROM testing_systing.`account`;
SELECT *
FROM `account`
WHERE LENGTH(full_name) =
(SELECT MAX(LENGTH(full_name)) FROM `account`);

-- Question 5: Lấy ra thông tin account có full name dài nhất và thuộc phòng ban có id =10
SELECT * FROM testing_systing.`account`;
SELECT *
FROM `account`
WHERE LENGTH(full_name) =
(SELECT MAX(LENGTH(full_name)) FROM `account`) AND department_id = 10;

-- Question 6: Lấy ra tên group đã tham gia trước ngày 15/10/2021
SELECT * FROM testing_systing.group;
SELECT *
FROM `group`
WHERE create_date <= '2021-10-15';

-- Question 7: Lấy ra ID của question có >= 4  có câu trả lời
SELECT * FROM testing_systing.question;
SELECT * FROM testing_systing.answer;
SELECT question_id
FROM answer
GROUP BY question_id
HAVING COUNT(question_id) >=4;


-- Question 8: Lấy ra các mã đề thi có thời gian thi >= 60 phút và được tạo trước ngày 15-10-2021
SELECT * FROM testing_systing.exam;
SELECT `code`
FROM exam
WHERE duration >= 60 AND create_date <= '2021-10-15';

-- Question 9: Lấy ra 5 group được tạo gần đây nhất
SELECT * FROM testing_systing.`group`;
SELECT *
FROM `group`
ORDER BY create_date DESC
LIMIT 5;



-- Question 10: Đếm số nhân viên thuộc department có id = 2
SELECT * FROM testing_systing.`account`;
SELECT COUNT(full_name) AS 'số nhân viên'
FROM `account`
WHERE department_id = 2;

-- Question 11: Lấy ra nhân viên có tên bắt đầu bằng chữ "N" và kết thúc bằng chữ "o" 
SELECT * FROM testing_systing.`account`;
SELECT *
FROM `account`
WHERE full_name LIKE 'n%' OR full_name LIKE '%o';
-- Question 12: Xóa tất cả các exam được tạo trước ngày 12/10/20121
SELECT * FROM testing_systing.exam;
DELETE 
FROM exam
WHERE create_date = '2021-10-15'; -- e bị lỗi chỗ này
-- Question 13: Xóa tất cả các question có nội dung bắt đầu bằng từ "câu hỏi" 
-- Question 14: Update thông tin của account có id = 5 thành tên "Nguyễn Bá Lộc" và email thành loc.nguyenba@vti.com.vn
SELECT * FROM testing_systing.`account`;
UPDATE `account`
SET 	email = 'loc.nguyenba@gmail.com',
		full_name = 'Nguyễn Bá Lộc'
WHERE account_id = 5;




-- Question 15: update account có id = 5 sẽ thuộc group có id = 4