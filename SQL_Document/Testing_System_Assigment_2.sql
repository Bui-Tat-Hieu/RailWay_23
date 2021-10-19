-- create database
DROP DATABASE IF EXISTS testing_systing;
CREATE DATABASE testing_systing;
USE testing_systing;

ALTER DATABASE testing_systing CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

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
	create_date			DATETIME DEFAULT NOW(),
    FOREIGN KEY(department_id) REFERENCES department(department_id),
    FOREIGN KEY(position_id) REFERENCES `position`(position_id)
);
-- add data account
INSERT INTO `account`(email, use_name, full_name, department_id, position_id)
VALUES 	('mot@gmail.com', 'so_mot', 'số một', '1', '1'),
		('hai@gmail.com', 'so_hai', 'số hai', '2', '1'),
        ('ba@gmail.com', 'so_ba', 'số ba', '3', '2'	),
        ('bon@gmail.com', 'so_bon', 'số bốn', '4', '4'),
        ('nam@gmail.com', 'so_nam', 'số năm', '5', '1'),
        ('sau@gmail.com', 'so_sau', 'số sáu', '6', '2'),
        ('bay@gmail.com', 'so_bay', 'số bảy', '7', '3'),
        ('tam@gmail.com', 'so_tam', 'số tám', '8', '3'),
        ('chin@gmail.com', 'so_chin', 'số chín', '9', '4'),
        ('muoi@gmail.com', 'so_muoi', 'sô mười', '10', '2');
-- create table group
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group`(
	group_id			TINYINT AUTO_INCREMENT PRIMARY KEY,
	group_name			VARCHAR(50) CHAR SET utf8mb4 UNIQUE KEY NOT NULL,
	creator_id			TINYINT,
	create_date			DATETIME DEFAULT NOW(),
    FOREIGN KEY(creator_id) REFERENCES `account`(account_id)
);
-- add data group
INSERT INTO `group` (group_name, creator_id)
VALUES 	('group_1', '8'	),
		('group_2', '9'	),
		('group_3', '10'),
        ('group_4', '7'),
		('group_5', '6'	),
		('group_6', '5'	),
        ('group_7', '4'),
        ('group_8', '2'),
        ('group_9', '1'),
        ('group_10', '3');
-- create table groupaccount
DROP TABLE IF EXISTS group_account;
CREATE TABLE group_account(
	group_id			TINYINT AUTO_INCREMENT PRIMARY KEY,
	account_id			TINYINT,
	join_date			DATETIME DEFAULT NOW(),
    FOREIGN KEY(group_id) REFERENCES `group`(group_id),
    FOREIGN KEY(account_id) REFERENCES `account`(account_id)
);
-- add data group_account
INSERT INTO group_account(group_id, account_id)
VALUES ('1', '8'),
('2', '9'),
('3', '10'),
('4', '7'),
('5', '6'),
('6', '5'),
('7', '4'),
('8', '2'),
('9', '1'),
('10', '3');
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
	create_date			DATETIME DEFAULT NOW(),
	FOREIGN KEY(creator_id) REFERENCES `account`(account_id),
    FOREIGN KEY(type_id) REFERENCES type_question(type_id),
    FOREIGN KEY(category_id) REFERENCES category_question(category_id)
);
INSERT INTO question(content,category_id, type_id, creator_id)
VALUES 	('câu hỏi 1','1', '1', '1'),
		('câu hỏi 2','2', '1', '2'),
		('câu hỏi 3','3', '2', '3'),
		('câu hỏi 4','4', '2', '4'),
		('câu hỏi 5','5', '2', '5'),
		('câu hỏi 6','6', '1', '6'),
		('câu hỏi 7','7', '1', '7'),
		('câu hỏi 8','8', '2' ,'8'),
		('câu hỏi 9','9', '2', '9'),
		('câu hỏi 10','10', '1', '10');
-- create table anwer
DROP TABLE IF EXISTS answer;
CREATE TABLE answer(
	answer_id 			TINYINT AUTO_INCREMENT PRIMARY KEY,
	content				VARCHAR(1000) NOT NULL,
	question_id			TINYINT,
	is_correct			BOOLEAN, -- có giá trị 1 - 0 (1 = yes 0 = no)
    FOREIGN KEY(question_id) REFERENCES question(question_id)
);
INSERT INTO answer(content, question_id, is_correct)
VALUES 	('câu trả lời 1', '1','1'),
		('câu trả lời 2', '2', '1'),
		('câu trả lời 3', '3', '0'),
		('câu trả lời 4', '4', '1'),
		('câu trả lời 5', '5', '0'),
		('câu trả lời 6', '6', '0'),
		('câu trả lời 7', '7', '1'),
		('câu trả lời 8', '8', '1'),
		('câu trả lời 9', '9', '1'),
		('câu trả lời 10', '10', '0');
-- create table exam
DROP TABLE IF EXISTS exam;
CREATE TABLE exam(
	exam_id				TINYINT AUTO_INCREMENT PRIMARY KEY,
	`code`				TINYINT UNIQUE KEY,
	title				VARCHAR(50) CHAR SET utf8mb4 NOT NULL,
	category_id			TINYINT,
	duration			VARCHAR(50) CHAR SET utf8mb4 NOT NULL,
	creator_id			TINYINT,
	create_date			DATETIME DEFAULT NOW(),
    FOREIGN KEY(category_id) REFERENCES category_question(category_id),
    FOREIGN KEY(creator_id) REFERENCES `account`(account_id)
);
INSERT INTO exam(`code`, tiTle, category_id, duration, creator_id)
VALUES 	('101', 'tiêu đề 1', '1', '45 phút', '1'),
		('102', 'tiêu đề 2', '2', '45 phút', '2'),
		('103', 'tiêu đề 3', '3', '45 phút', '3'),
		('104', 'tiêu đề 4', '4', '45 phút', '4'),
		('105', 'tiêu đề 5', '5', '45 phút', '5'),
		('106', 'tiêu đề 6', '6', '45 phút', '6'),
		('107', 'tiêu đề 7', '7', '45 phút', '7'),
		('108', 'tiêu đề 8', '8', '45 phút', '8'),
		('109', 'tiêu đề 9', '9', '45 phút', '9'),
		('110', 'tiêu đề 10', '10', '45 phút', '10');
-- create table examquestion
DROP TABLE IF EXISTS exam_question;			
CREATE TABLE exam_question(
	exam_id 			TINYINT AUTO_INCREMENT PRIMARY KEY,
	question_id			TINYINT,
    FOREIGN KEY(exam_id) REFERENCES exam(exam_id),
    FOREIGN KEY(question_id) REFERENCES question(question_id)
);
-- add data exam_question
INSERT INTO exam_question(exam_id, question_id)
VALUES ('1', '1'),
('2', '2'),
('3', '3'),
('4', '4'),
('5', '5'),
('6', '6'),
('7', '7'),
('8', '8'),
('9', '9'),
('10', '10');

 