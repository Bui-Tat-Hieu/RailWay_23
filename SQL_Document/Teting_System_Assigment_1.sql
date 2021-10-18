
CREATE DATABASE Vtiacademy;
USE 			Vtiacademy;

CREATE TABLE Department (
	DepartmentID 		INT,
	DepartmentName 		VARCHAR(50)
);
CREATE TABLE `Position` (
	PositionID			INT,
	PositionName		VARCHAR(50)
);
CREATE TABLE `ACCOUNT` (
	AccountID			INT,
	Email				VARCHAR(50),
	UseName				VARCHAR(50),
	FullName			VARCHAR(50),
	DepartmentID		INT,
	PositionID			INT,
	Createdate			DATE			
);
CREATE TABLE `GROUP` (
	GroupID				INT,
	Groupname			VARCHAR(50),
	CreateID			INT,
	CreatDate			DATE 
);
CREATE TABLE GroupAccount (
	GroupID				INT,
	AccountID			INT,
	Joindate			DATE 
);
CREATE TABLE TypeQuestion (
	TypeID				INT,
	TypeName			VARCHAR(50)
);
CREATE TABLE CategoryQuestion (
	CategoryID			INT,
	CategoryName		VARCHAR(50)
);
CREATE TABLE Question (
	QuestionID			INt,
	Content				VARCHAR(1000),
	Category			INT,
	TypeID				INT,
	CreatorID			INT,
	CreateDate			DATE 
);
CREATE TABLE Answer (
	AnswerID 			INT,
	Content				VARCHAR(1000),
	QuestionID			INT,
	isCorrectc			VARCHAR(50)
);
CREATE TABLE Exam (
	ExamID				INT,
	`Code`				INT,
	Title				VARCHAR(50),
	CategoryID			INT,
	Duration			VARCHAR(50),
	CreatorID			INT,
	CreateDate			DATE
);			
CREATE TABLE Examquestion (
	ExamID 				INT,
	QuestionID			INT
);

 