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
    VALUES	(1,	N'marketing'),
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
	department_id		TINYINT,
	position_id			TINYINT,
	create_date			DATE,
    FOREIGN KEY(department_id) REFERENCES department(department_id),
    FOREIGN KEY(position_id) REFERENCES `position`(position_id)
);
-- create table group
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group`(
	group_id			TINYINT AUTO_INCREMENT PRIMARY KEY,
	group_name			VARCHAR(50) CHAR SET utf8mb4 UNIQUE KEY NOT NULL,
	creator_id			TINYINT,
	create_date			DATE,
    FOREIGN KEY(creator_id) REFERENCES `account`(account_id)
);
-- create table groupaccount
DROP TABLE IF EXISTS group_account;
CREATE TABLE group_account(
	group_id			TINYINT AUTO_INCREMENT PRIMARY KEY,
	account_id			TINYINT,
	join_date			DATE,
    FOREIGN KEY(group_id) REFERENCES `group`(group_id),
    FOREIGN KEY(account_id) REFERENCES `account`(account_id)
);
-- creata TypeQuestion
DROP TABLE IF EXISTS type_question;
CREATE TABLE type_question(
	type_id				TINYINT AUTO_INCREMENT PRIMARY KEY,
	type_name			ENUM('Essay', 'Multiple-Choice')
);
-- creta table categoryquestion
DROP TABLE IF EXISTS category_question;
CREATE TABLE category_question(
	category_id			TINYINT AUTO_INCREMENT PRIMARY KEY,
	category_name		VARCHAR(50) CHAR SET utf8mb4 UNIQUE KEY NOT NULL
);
-- create table question
DROP TABLE IF EXISTS question;
CREATE TABLE question(
	question_id		TINYINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	content				VARCHAR(1000) CHAR SET utf8mb4 NOT NULL,
	category_id			TINYINT,
	type_id				TINYINT,
	creator_id			TINYINT,
	create_date			DATE,
	FOREIGN KEY(creator_id) REFERENCES `account`(account_id),
    FOREIGN KEY(type_id) REFERENCES type_question(type_id),
    FOREIGN KEY(category_id) REFERENCES category_question(category_id)
);
-- create table anwer
DROP TABLE IF EXISTS anwer;
CREATE TABLE answer(
	answer_id 			TINYINT AUTO_INCREMENT PRIMARY KEY,
	content				VARCHAR(1000) NOT NULL,
	question_id		TINYINT,
	is_correct			BOOLEAN, -- có giá trị 1 - 0 (1 = yes 0 = no)
    FOREIGN KEY(question_id) REFERENCES question(question_id)
);
-- create table exam
DROP TABLE IF EXISTS exam;
CREATE TABLE exam(
	exam_id				TINYINT AUTO_INCREMENT PRIMARY KEY,
	`code`				TINYINT UNSIGNED UNIQUE NOT NULL,
	title				VARCHAR(50) CHAR SET utf8mb4 NOT NULL,
	category_id			TINYINT,
	duration			VARCHAR(50) CHAR SET utf8mb4,
	creator_id			TINYINT,
	create_date			DATE,
    FOREIGN KEY(category_id) REFERENCES category_question(category_id),
    FOREIGN KEY(creator_id) REFERENCES `account`(account_id)
);
-- create table examquestion
DROP TABLE IF EXISTS ExamQuestion;			
CREATE TABLE exam_question(
	exam_id 			TINYINT AUTO_INCREMENT PRIMARY KEY,
	question_id			TINYINT,
    FOREIGN KEY(exam_id) REFERENCES exam(exam_id),
    FOREIGN KEY(question_id) REFERENCES question(question_id)
);

 