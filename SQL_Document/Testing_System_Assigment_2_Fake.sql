-- create database
DROP DATABASE IF EXISTS testing_system;
CREATE DATABASE testing_system;
USE testing_system;

ALTER DATABASE testing_system CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- create table Department
DROP TABLE IF EXISTS department;
CREATE TABLE department(
	department_id 		TINYINT AUTO_INCREMENT PRIMARY KEY,
	department_name 	VARCHAR(30) CHAR SET utf8mb4 UNIQUE KEY NOT NULL
    );
    -- add data department
INSERT INTO department(department_id, department_name)
    VALUES	(1,	N'marketing'	),
			(2, N'sale'			),
            (3, N'bảo vệ'		),
            (4, N'nhân sự'		),
            (5, N'kỹ thuật'		),
            (6, N'tài chính'	),
            (7, N'phó giám đốc'	),
            (8, N'giám đốc'		),
            (9, N'thư ký'		),
            (10, N'bản năng'	);
-- creata table position
DROP TABLE IF EXISTS `position`; 
CREATE TABLE `position`(
	position_id			TINYINT AUTO_INCREMENT PRIMARY KEY,
	position_name		ENUM('Dev', 'Test', 'Scrum Master', 'PM')
);
-- add data position
INSERT INTO `position`(position_name)
VALUES 	('dev'			),
		('test'			),
        ('scrum master'	),
        ('pm'			);
-- create table account
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`(
	account_id			TINYINT AUTO_INCREMENT PRIMARY KEY,
	email				VARCHAR(50) NOT NULL UNIQUE KEY,
	use_name			VARCHAR(50) NOT NULL UNIQUE KEY,
	full_name			VARCHAR(50) CHAR SET utf8mb4 NOT NULL,
	department_id		TINYINT NOT NULL,
	position_id			TINYINT NOT NULL,
	create_date			DATE,
    FOREIGN KEY(department_id) REFERENCES department(department_id),
    FOREIGN KEY(position_id) REFERENCES `position`(position_id)
);
-- add data account
INSERT INTO `account`(email, use_name, full_name, department_id, position_id, create_date)
VALUES 	('hieu.buitat@gmail.com',		 'hieu.buitat', 		'Bùi Tất Hiếu',			 2, 1, '2010-12-21'),
		('binh.nguyenquy@gmail.com',	 'binh.nguyenquy',	 	'Nguyễn Quý Bình',		 2, 1, '2010-12-20'),
        ('truong.nguyenquy@gmail.com',	 'truong.nguyenquy', 	'Nguyễn Quý Trường',	 2, 2, '2021-10-12'),
        ('bao.buigia@gmail.com', 		 'bao.buigia', 			'Bùi Gia Bảo',			 4, 4, '2021-10-13'),
        ('hieu.nguyenba@gmail.com', 	'hieu.nguyenba', 		'Nguyễn Bá Hiếu',		 5, 1, '2021-10-14'),
        ('quang.nguyenkhac@gmail.com',	 'quang.nguyenkhac',	'Nguyễn Khắc Quang',	 2, 2, '2021-10-15'),
        ('hien.nguyenthi@gmail.com',	 'hien.nguyenthi',	 	'Nguyễn Thị Thu Hiền',	 3, 3, 	'2021-10-16'),
        ('hue.nguyenthi@gmail.com', 	'hue.nguyenthi', 		'Nguyễn Thị Kim Huệ', 	 2, 4, '2021-10-17'),
        ('hieu.dinhvan@gmail.com', 		'hieu.dinhvan',			'Đinh Văn Hiếu',		 9, 4, '2021-10-18'),
        ('phuong.buithi@gmail.com', 	'phuong.buithi',		'Bùi Thị Phương',		 10, 2, '2021-10-19');
-- create table group
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group`(
	group_id			TINYINT AUTO_INCREMENT,
	group_name			VARCHAR(50) CHAR SET utf8mb4 UNIQUE KEY NOT NULL,
	creator_id			TINYINT,
	create_date			DATE,
    PRIMARY KEY(group_id, creator_id),
    FOREIGN KEY(creator_id) REFERENCES `account`(account_id) ON DELETE CASCADE ON UPDATE CASCADE
);
-- add data group
INSERT INTO `group` (group_name, creator_id, create_date)
VALUES 	('group_1', 1, '2019-10-17'),
		('group_2', 2, '2019-10-18'),
		('group_3', 3, '2019-12-19'),
        ('group_4', 4, '2021-10-13'),
		('group_5', 5, '2021-10-14'),
		('group_6', 6, '2021-10-15'),
        ('group_7', 7, '2021-10-16'),
        ('group_8', 8, '2021-10-17'),
        ('group_9', 9, '2021-10-18'),
        ('group_10', 10, '2021-10-19');
        
-- create table groupaccount
DROP TABLE IF EXISTS group_account;
CREATE TABLE group_account(
	group_id			TINYINT AUTO_INCREMENT,
	account_id			TINYINT,
	join_date			DATE,
	PRIMARY KEY(group_id, account_id),
    FOREIGN KEY(group_id) REFERENCES `group`(group_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(account_id) REFERENCES `account`(account_id) ON DELETE CASCADE ON UPDATE CASCADE
);
-- add data group_account
INSERT INTO group_account(group_id, account_id, join_date)
VALUES 	(1, 1, '2021-10-10'),
		(1, 2, '2021-10-11'),
		(1, 3, '2021-10-12'),
		(1, 4, '2021-10-13'),
		(1, 5, '2021-10-14'),
		(1, 6, '2021-10-15'),
		(7, 7, '2021-10-16'),
		(2, 8, '2021-10-17'),
		(9, 9, '2021-10-18'),
		(10, 10, '2021-10-19');
      
-- creata Type_question
DROP TABLE IF EXISTS type_question;
CREATE TABLE type_question(
	type_id				TINYINT AUTO_INCREMENT PRIMARY KEY,
	type_name			ENUM('Essay', 'Multiple-Choice')
);
-- add data type_question
INSERT INTO type_question(type_name)
VALUES 	('essay'			),
		('multiple-choice'	);
-- creta table category_question
DROP TABLE IF EXISTS category_question;
CREATE TABLE category_question(
	category_id			TINYINT AUTO_INCREMENT PRIMARY KEY,
	category_name		VARCHAR(50) CHAR SET utf8mb4 UNIQUE KEY NOT NULL
);
-- add data category_question
INSERT INTO category_question(category_name)
VALUES 	('chủ đề 1'),
		('chủ đề 2'),
		('chủ đề 3'),
		('chủ để 4'),
		('chủ để 5'),
        ('chủ đề 6'),
        ('chủ đề 7'),
        ('chủ đề 8'),
        ('chủ đề 9'),
        ('chủ đề 10');
-- create table question
DROP TABLE IF EXISTS question;
CREATE TABLE question(
	question_id			TINYINT AUTO_INCREMENT PRIMARY KEY,
	content				VARCHAR(100) CHAR SET utf8mb4 NOT NULL,
	category_id			TINYINT,
	type_id				TINYINT,
	creator_id			TINYINT,
	create_date			DATE,
	FOREIGN KEY(creator_id) REFERENCES `account`(account_id),
    FOREIGN KEY(type_id) REFERENCES type_question(type_id),
    FOREIGN KEY(category_id) REFERENCES category_question(category_id)
);
INSERT INTO question(content,category_id, type_id, creator_id, create_date)
VALUES 	('câu hỏi 1 + 1',	 1, 1, 1,	 '2021-10-10'),
		('câu hỏi 1 + 2',	 1, 1, 1,	 '2021-10-11'),
		('3 + 3',		 	 1, 2, 3,	 '2021-10-12'),
		('4 + 4',			 4, 2, '4',	 '2021-10-13'),
		('5 + 5',			 5, 2, 5,	 '2021-10-14'),
		('6 + 6',			 6, 1, 6,	 '2021-10-15'),
		('7 + 7', 			 7, 1, 7,	 '2021-10-16'),
		('8 + 8',			 8, 2 ,8,	 '2021-10-17'),
		('9 + 9',			 9, 2, 9,	 '2021-10-18'),
		('10 + 10',			 10, 1, 10,	 '2021-10-19'),
        ('10 + 10',			 10, 1, 10,	 '2021-10-19');
-- create table anwer
DROP TABLE IF EXISTS answer;
CREATE TABLE answer(
	answer_id 			TINYINT AUTO_INCREMENT PRIMARY KEY,
	content				VARCHAR(100),
	question_id			TINYINT,
	is_correct			BOOLEAN, -- có giá trị 1 - 0 (1 = yes 0 = no)
    FOREIGN KEY(question_id) REFERENCES question(question_id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO answer(content, question_id, is_correct)
VALUES 	('= 3', 2, 1),
		('= 3', 2, 1),
		('= 3', 2, 0),
		('= 3', 2, 1),
		('= 10', 5, 0),
		('= 12', 6, 0),
		('= 14', 1, 1),
		('= 16', 8, 1),
		('= 18', 9, 1),
		('= 20', 10, 0);
-- create table exam
DROP TABLE IF EXISTS exam;
CREATE TABLE exam(
	exam_id				TINYINT AUTO_INCREMENT PRIMARY KEY,
	`code`				TINYINT UNIQUE KEY,
	title				VARCHAR(50) CHAR SET utf8mb4 NOT NULL,
	category_id			TINYINT,
	duration			TINYINT NOT NULL,
	creator_id			TINYINT,
	create_date			DATE,
    FOREIGN KEY(category_id) REFERENCES category_question(category_id),
    FOREIGN KEY(creator_id) REFERENCES `account`(account_id)
);
INSERT INTO exam(`code`, tiTle, category_id, duration, creator_id, create_date)
VALUES 	('101', 'tiêu đề 1', 1, 60, 1, '2019-10-10'),
		('102', 'tiêu đề 2', 1, 60, 1, '2019-10-11'),
		('103', 'tiêu đề 3', 3, 60, 3, '2019-10-12'),
		('104', 'tiêu đề 4', 4, 60, 4, '2019-10-13'),
		('105', 'tiêu đề 5', 5, 45, 5, '2021-10-14'),
		('106', 'tiêu đề 6', 6, 30, 6, '2021-10-15'),
		('107', 'tiêu đề 7', 7, 15, 7, '2021-10-16'),
		('108', 'tiêu đề 8', 8, 15, 8, '2021-10-17'),
		('109', 'tiêu đề 9', 9, 90, 9, '2019-12-18'),
		('110', 'tiêu đề 10', 10, 120, 10, '2019-12-19');
-- create table examquestion
DROP TABLE IF EXISTS exam_question;			
CREATE TABLE exam_question(
	exam_id 			TINYINT NOT NULL,
	question_id			TINYINT NOT NULL,
    PRIMARY KEY (exam_id, question_id),
    FOREIGN KEY(exam_id) REFERENCES exam(exam_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(question_id) REFERENCES question(question_id) ON DELETE CASCADE ON UPDATE CASCADE
);
-- add data exam_question
INSERT INTO exam_question(exam_id, question_id)
VALUES 	(1, 1),
		(2, 1),
		(3, 1),
		(4, 4),
		(5, 5),
		(6, 6),
		(7, 7),
		(8, 8),
		(9, 10),
		(10, 10);

 