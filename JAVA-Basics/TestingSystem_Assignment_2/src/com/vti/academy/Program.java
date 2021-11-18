package com.vti.academy;

import java.util.Date;

import com.vti.academy.enums.PositionName;
import com.vti.academy.enums.TypeName;

public class Program {

	public static void main(String[] args) {

		// create department
		Department department1 = new Department();
		department1.departmentId = 1;
		department1.departmentName = "Sale";

		Department department2 = new Department();
		department2.departmentId = 2;
		department2.departmentName = "Marketing";

		Department department3 = new Department();
		department3.departmentId = 3;
		department3.departmentName = "Master";

		// create position
		Position position1 = new Position();
		position1.positionId = 1;
		position1.positionName = PositionName.POSITION_DEV.getPositionName();

		Position position2 = new Position();
		position2.positionId = 2;
		position2.positionName = PositionName.POSITION_TEST.getPositionName();

		Position position3 = new Position();
		position3.positionId = 3;
		position3.positionName = PositionName.POSITION_SCRUM_MASTER.getPositionName();

		// create account
		Account account1 = new Account();
		account1.accountId = 1;
		account1.email = "hieu.buitat@gmail.com";
		account1.userName = "hieu.buitat";
		account1.fullName = "Bùi Tất Hiếu";
		account1.department = department1;
		account1.position = position1;
		account1.createDate = new Date();

		Account account2 = new Account();
		account2.accountId = 2;
		account2.email = "binh.nguyenquy@gmail.com";
		account2.userName = "binh.nguyenquy";
		account2.fullName = "Nguyễn Quý Bình";
		account2.department = department1;
		account2.position = position2;
		account2.createDate = new Date();

		Account account3 = new Account();
		account3.accountId = 3;
		account3.email = "hieu.dinhvan@gmail.com";
		account3.userName = "hieu.dinhvan";
		account3.fullName = "Đinh Văn Hiếu";
		account3.department = department3;
		account3.position = position3;
		account3.createDate = new Date();

		// create group
		Group group1 = new Group();
		group1.groupId = 1;
		group1.groupName = "group sale";
		group1.creator = account1;
		group1.createDate = new Date();

		Group group2 = new Group();
		group2.groupId = 2;
		group2.groupName = "group marketing";
		group2.creator = account2;
		group2.createDate = new Date();

		Group group3 = new Group();
		group3.groupId = 3;
		group3.groupName = "group master";
		group3.creator = account3;
		group3.createDate = new Date();

		// create group account
		GroupAccount groupaccount1 = new GroupAccount();
		groupaccount1.group = group1;
		groupaccount1.account = account1;
		groupaccount1.joinDate = new Date();

		GroupAccount groupaccount2 = new GroupAccount();
		groupaccount2.group = group2;
		groupaccount2.account = account2;
		groupaccount2.joinDate = new Date();

		GroupAccount groupaccount3 = new GroupAccount();
		groupaccount3.group = group2;
		groupaccount3.account = account1;
		groupaccount3.joinDate = new Date();

		// create type question
		TypeQuestion typequestion1 = new TypeQuestion();
		typequestion1.typeId = 1;
		typequestion1.typeName = TypeName.TYPE_NAME_ESSAY.getTypeName();

		TypeQuestion typequestion2 = new TypeQuestion();
		typequestion2.typeId = 2;
		typequestion2.typeName = TypeName.TYPE_NAME_MULTIPLE_CHOICE.getTypeName();

		// create category question
		CategoryQuestion categoryquestion1 = new CategoryQuestion();
		categoryquestion1.categoryId = 1;
		categoryquestion1.categoryName = "SQL";

		CategoryQuestion categoryquestion2 = new CategoryQuestion();
		categoryquestion2.categoryId = 2;
		categoryquestion2.categoryName = "java";

		CategoryQuestion categoryquestion3 = new CategoryQuestion();
		categoryquestion3.categoryId = 3;
		categoryquestion3.categoryName = "python";

		// create question
		Question question1 = new Question();
		question1.questionId = 1;
		question1.content = "SQL là gì";
		question1.categoryQuestion = categoryquestion1;
		question1.typeQuestion = typequestion1;
		question1.account = account1;
		question1.createDate = new Date();

		Question question2 = new Question();
		question2.questionId = 2;
		question2.content = "java là gì";
		question2.categoryQuestion = categoryquestion2;
		question2.typeQuestion = typequestion1;
		question2.account = account2;
		question2.createDate = new Date();

		Question question3 = new Question();
		question3.questionId = 3;
		question3.content = "python là gì";
		question3.categoryQuestion = categoryquestion3;
		question3.typeQuestion = typequestion2;
		question3.account = account3;
		question3.createDate = new Date();

		// create answer
		Answer answer1 = new Answer();
		answer1.answerId = 1;
		answer1.content = "là ngôn ngữ truy vấn có cấu trúc";
		answer1.question = question1;
		answer1.isCorrect = true;

		Answer answer2 = new Answer();
		answer2.answerId = 2;
		answer2.content = "là ngôn ngữ lập trình phổ biến";
		answer2.question = question2;
		answer2.isCorrect = true;

		Answer answer3 = new Answer();
		answer3.answerId = 3;
		answer3.content = "không biết";
		answer3.question = question3;
		answer3.isCorrect = false;

		// create exam
		Exam exam1 = new Exam();
		exam1.examId = 1;
		exam1.code = "S001";
		exam1.title = "SQL basics";
		exam1.categoryQuestion = categoryquestion1;
		exam1.duration = "120 phút";
		exam1.account = account1;
		

		Exam exam2 = new Exam();
		exam2.examId = 2;
		exam2.code = "J001";
		exam2.title = "java basics";
		exam2.categoryQuestion = categoryquestion2;
		exam2.duration = "60 phút";
		exam2.account = account2;
	

		Exam exam3 = new Exam();
		exam3.examId = 3;
		exam3.code = "P001";
		exam3.title = "python basics";
		exam3.categoryQuestion = categoryquestion3;
		exam3.duration = "90 phút";
		exam3.account = account3;
	

		// create exam question
		ExamQuestion examquestion1 = new ExamQuestion();
		examquestion1.exam = exam1;
		examquestion1.question = question1;
		

		ExamQuestion examquestion2 = new ExamQuestion();
		examquestion2.exam = exam2;
		examquestion2.question = question2;

		ExamQuestion examquestion3 = new ExamQuestion();
		examquestion3.exam = exam3;
		examquestion3.question = question3;

		// Question 3: Trong file Program.java, hãy in ít nhất 1 giá trị của mỗi đối
		// tượng ra

		// department
		System.out.println("Thông tin department 1: ");

		System.out.println("Department Name: " + department1.departmentName);
		System.out.println("Department Id: " + department1.departmentId);
		System.out.println("\n");

		// position
		System.out.println("Thông tin position 1: ");

		System.out.println("Position Name: " + position1.positionName);
		System.out.println("Position Id: " + position1.positionId);
		System.out.println("\n");

		// account
		System.out.println("Thông tin account 1: ");

		System.out.println("Account Id: " + account1.accountId);
		System.out.println("Email: " + account1.email);
		System.out.println("UserName: " + account1.userName);
		System.out.println("FullName: " + account1.fullName);
		System.out.println("Department Name: " + account1.department.departmentName);
		System.out.println("Position Name: " + account1.position.positionName);
		System.out.println("CreateDate: " + account1.createDate);
		System.out.println("\n");

		// group
		System.out.println("Thông tin group 1: ");

		System.out.println("Group Id: " + group1.groupId);
		System.out.println("Group Name: " + group1.groupName);
		System.out.println("Creator: " + group1.creator.fullName);
		System.out.println("Create Date: " + group1.createDate);
		System.out.println("\n");

		// group account
		System.out.println("Thông tin group account 1: ");

		System.out.println("Group Name: " + groupaccount1.group.groupName);
		System.out.println("Account User: " + groupaccount1.account.userName);
		System.out.println("Join Date: " + groupaccount1.joinDate);
		System.out.println("\n");

		// type question
		System.out.println("Thông tin type question 1: ");

		System.out.println("Type Id: " + typequestion1.typeId);
		System.out.println("Type Name: " + typequestion1.typeName);
		System.out.println("\n");

		// category question
		System.out.println("Thông tin category question 1: ");

		System.out.println("Category Id: " + categoryquestion1.categoryId);
		System.out.println("Category Name: " + categoryquestion1.categoryName);
		System.out.println("\n");

		// question
		System.out.println("Thông tin question 1: ");

		System.out.println("Question Id: " + question1.questionId);
		System.out.println("Content: " + question1.content);
		System.out.println("Category Name: " + question1.categoryQuestion.categoryName);
		System.out.println("Type Name: " + question1.typeQuestion.typeName);
		System.out.println("Creator: " + question1.account.fullName);
		System.out.println("Create Date: " + question1.createDate);
		System.out.println("\n");

		// answer
		System.out.println("Thông tin answer 1: ");

		System.out.println("Answer Id: " + answer1.answerId);
		System.out.println("Content: " + answer1.content);
		System.out.println("Question Name: " + answer1.question.content);
		System.out.println("Is Correct: " + answer1.isCorrect);
		System.out.println("\n");

		// exam
		System.out.println("Thông tin exam 1: ");

		System.out.println("Exam Id: " + exam1.examId);
		System.out.println("Code: " + exam1.code);
		System.out.println("Title: " + exam1.title);
		System.out.println("Category Name: " + exam1.categoryQuestion.categoryName);
		System.out.println("Duration: " + exam1.duration);
		System.out.println("Creator: " + exam1.account.fullName);
		System.out.println("Create Date: " + exam1.createDate);
		System.out.println("\n");

		// exam question
		System.out.println("Thông tin exam question 1: ");

		System.out.println("Title: " + examquestion1.exam.title);
		System.out.println("Question: " + examquestion1.question.content);
		examquestion1.goToSchool();

	}

}
