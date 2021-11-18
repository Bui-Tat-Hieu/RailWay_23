package com.vti.academy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Exercise3_DateFormat {

	public static void main(String[] args) {
	
//	Question 1:
//	In ra thông tin Exam thứ 1 và property create date sẽ được format theo định dạng vietnamese
		
		// create exam
		Exam exam1 = new Exam();
		exam1.examId = 1;
		exam1.code = "S001";
		exam1.title = "SQL basics";
		exam1.duration = "120 phút";
		Locale locale = new Locale("vi", "VN");
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
		String date = dateFormat.format(new Date());
		exam1.createDate = date;
		
		System.out.println("Question 1:");
		System.out.println(" ExamId: " + exam1.examId
							+ "\n Code: " + exam1.code
							+ "\n Title: " + exam1.title
							+ "\n Duration: " + exam1.duration
							+ "\n CreateDate: " + exam1.createDate);
		System.out.println();
//	Question 2:
//	In ra thông tin: Exam đã tạo ngày nào theo định dạng Năm – tháng – ngày – giờ – phút – giây
		
		// create exam
			Exam exam2 = new Exam();
			exam2.examId = 1;
			exam2.code = "S001";
			exam2.title = "SQL basics";
			exam2.duration = "120 phút";
			String pattern = "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			String date1 = simpleDateFormat.format(new Date());
			exam2.createDate = date1;
		
			System.out.println("Question 2:");
			System.out.println(" ExamId: " + exam2.examId
					+ "\n Code: " + exam2.code
					+ "\n Title: " + exam2.title
					+ "\n Duration: " + exam2.duration
					+ "\n CreateDate: " + exam2.createDate);
			System.out.println();
			
//	Question 3:
//	Chỉ in ra năm của create date property trong Question 2
//	Question 4:
//	Chỉ in ra tháng và năm của create date property trong Question 2
//	Question 5:
//	Chỉ in ra "MM-DD" của create date trong Question 2
//		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
