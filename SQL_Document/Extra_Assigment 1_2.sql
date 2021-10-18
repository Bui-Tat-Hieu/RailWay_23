-- add database fresher
DROP DATABASE IF EXISTS fresher;
CREATE DATABASE fresher;
USE fresher;
-- add create table traninee
DROP TABLE IF EXISTS trainee;
CREATE TABLE trainee(
trainee_id		TINYINT AUTO_INCREMENT PRIMARY KEY,
full_name		VARCHAR(30) CHAR SET utf8mb4 NOT NULL,
birth_date		DATE,
Gender			ENUM('Male', 'Female', 'Unknown'),
ET_IQ			TINYINT CHECK(0<=ET_IQ AND ET_IQ<=20),
ET_gmath		TINYINT CHECK(0<=ET_gmath AND ET_gmath<=20),
ET_english		TINYINT CHECK(0<=ET_english AND ET_english<=50),
training_class	VARCHAR(20),
evaluation		VARCHAR(255),
vti_account		VARCHAR(50) UNIQUE KEY NOT NULL
);
-- add data trainee
 INSERT INTO trainee(full_name, birth_date, training_class, vti_account)
 VALUES ('bùi tất hiếu', '1997/02/21', 'railway23', 'hieu.buitat@vtiacademy.edu.vn');