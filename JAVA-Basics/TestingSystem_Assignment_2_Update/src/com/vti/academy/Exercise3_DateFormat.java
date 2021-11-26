package com.vti.academy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.vti.academy.enums.PositionName;
import com.vti.academy.enums.TypeName;

public class Exercise3_DateFormat {

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
		exam1.createDate = new Date();

		Exam exam2 = new Exam();
		exam2.examId = 2;
		exam2.code = "J001";
		exam2.title = "java basics";
		exam2.categoryQuestion = categoryquestion2;
		exam2.duration = "60 phút";
		exam2.account = account2;
		exam2.createDate = new Date();

		Exam exam3 = new Exam();
		exam3.examId = 3;
		exam3.code = "P001";
		exam3.title = "python basics";
		exam3.categoryQuestion = categoryquestion3;
		exam3.duration = "90 phút";
		exam3.account = account3;
		exam3.createDate = new Date();
	
		Exam[] examArr = new Exam[] {exam1, exam2, exam3};
//	Question 1:
		
		System.out.println("Question 1:");
		question1(exam1);
		System.out.println();
		
//	Question 2:
		
		System.out.println("Question 2:");
		Date [] dateArr = question2(examArr);
		System.out.println();
		
//	Question 3:
			
		System.out.println("Question 3:");
		question3(dateArr);
		System.out.println();
			
//	Question 4:

		System.out.println("Question 4:");
		question4(dateArr);
		System.out.println();
		
//	Question 5:
		
		System.out.println("Question 5:");
		question5(dateArr);
	
	}
	
//	Question 1:
//	In ra thông tin Exam thứ 1 và property create date sẽ được format theo định dạng vietnamese
	
	public static void question1(Exam exam) {
		Locale locale = new Locale("vi", "VN");
		DateFormat dateformat = DateFormat.getDateInstance(DateFormat.DEFAULT,locale);
		String date = dateformat.format(exam.createDate);
		System.out.println("Title: " + exam.title  + "\ncreateDate: " + date);
	}
//	Question 2:
//	In ra thông tin: Exam đã tạo ngày nào theo định dạng Năm – tháng – ngày – giờ – phút – giây

	public static Date [] question2(Exam[] examArr) {
		Date [] dateArr = new Date[examArr.length];
		for (int i = 0; i < examArr.length; i++) {
		String pattern = "yyyy-MM-dd-HH-mm-ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(examArr[i].createDate);
		date = simpleDateFormat.format(examArr[i].createDate);
		System.out.println("title: " + examArr[i].title + "\ncreateDate: " + date);
		dateArr[i] = examArr[i].createDate;
			}
		return dateArr;
		}

	
//	Question 3:
//	Chỉ in ra năm của create date property trong Question 2
			
	public static void question3(Date [] dateArr) {
			for (Date date : dateArr) {
			String pattern = "yyyy";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			String createYear = simpleDateFormat.format(date);
			System.out.println("createYear: " + createYear);
			}
	}
	
//	Question 4:
//	Chỉ in ra tháng và năm của create date property trong Question 2
	
	public static void question4(Date [] dateArr) {
		for (Date date : dateArr) {
		String pattern = "yyyy-MM";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String createYearMoth = simpleDateFormat.format(date);
		System.out.println("createYearMoth: " + createYearMoth);
		}
	}
	
//	Question 5:
//	Chỉ in ra "MM-DD" của create date trong Question 2
	
	public static void question5(Date [] dateArr) {
		for (Date date : dateArr) {
		String pattern = "MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String createMothDay = simpleDateFormat.format(date);
		System.out.println("createMothDay: " + createMothDay);
		}
	}
	
	


}
