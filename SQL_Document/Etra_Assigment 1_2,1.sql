-- create database data_types
DROP DATABASE IF EXISTS data_types;
CREATE DATABASE data_types;
USE data_types;

-- create table database_types_1
DROP TABLE IF EXISTS data_types_1;
CREATE TABLE data_types_1(
	id				TINYINT AUTO_INCREMENT PRIMARY KEY,
	`name`			VARCHAR(50) NOT NULL,
	`code`			VARCHAR(50) NOT NULL,
	modified_date	DATETIME DEFAULT NOW()
);
-- add data data_types_1
INSERT INTO data_types_1(`name`, `code`)
VALUES ('diamond', '1a2b3');
-- create table data_types_2
DROP TABLE IF EXISTS data_types_2;
CREATE TABLE data_types_2(
	id			TINYINT AUTO_INCREMENT PRIMARY KEY,
	`name`		VARCHAR(50) CHAR SET utf8mb4 NOT NULL,
	birth_date	DATE,
	gender		ENUM('male', 'female', 'unknown')
);
-- add data data_types_2
INSERT INTO data_types_2(`name`, birth_date)
VALUES ('hieu.buitat', '1997/02/21');

		