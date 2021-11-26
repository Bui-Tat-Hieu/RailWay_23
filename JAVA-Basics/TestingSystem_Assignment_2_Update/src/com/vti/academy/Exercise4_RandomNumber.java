package com.vti.academy;

import java.time.LocalDate;
import java.util.Random;

public class Exercise4_RandomNumber {

	public static void main(String[] args) {

//Question 1:
//	In ngẫu nhiên ra 1 số nguyên
		
//		question1();
		
//Question 2:
//	In ngẫu nhiên ra 1 số thực
		
//		question2();
		
//Question 3:
//	Khai báo 1 array bao gồm các tên của các bạn trong lớp, sau đó in ngẫu nhiên ra tên của 1 bạn
		
//		question3();
		
//Question 4:
//	Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 24-07-1995 tới ngày 20-12- 1995
		
//		question4();
		
//Question 5:
//	Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 1 năm trở lại đây
		
//		question5();
		
//Question 6:
//	Lấy ngẫu nhiên 1 ngày trong quá khứ
		
//		question6();
		
//Question 7:
//	Lấy ngẫu nhiên 1 số có 3 chữ số
		
//		question7();
		
		

	}
	
//	Question 1:
//	In ngẫu nhiên ra 1 số nguyên
	
	public static void question1() {
		System.out.println("Question 1:");
		Random ramdom = new Random();
		int x = ramdom.nextInt();
		System.out.println("Số nguyên ngẫu nhiên là: " + x);
		System.out.println();
	}
	
//	Question 2:
//	In ngẫu nhiên ra 1 số thực
		
	public static void question2() {
		System.out.println("Question 2:");
		Random ramdom = new Random();
		double y = ramdom.nextDouble();
		System.out.println("Số thực ngẫu nhiên là: " + y);
		System.out.println();
	}
	
	//Question 3:
//	Khai báo 1 array bao gồm các tên của các bạn trong lớp, sau đó in ngẫu nhiên ra tên của 1 bạn
		
	public static void question3() {
		System.out.println("Question 3:");
		String[] nemberArr = {"hoang", "hieu", "tam", "binh", "truong", "dung"};
		Random ramdom = new Random();
		int z = ramdom.nextInt(nemberArr.length);
		System.out.println("In ngau nhien ten 1 ban: " + nemberArr[z]); // 0=>5
		System.out.println();
	}	
	
	//Question 4:
//	Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 24-07-1995 tới ngày 20-12- 1995
		
	public static void question4() {
		System.out.println("Question 4:");
		Random ramdom = new Random();
		
		int minDay = (int) LocalDate.of(1995, 07, 24).toEpochDay();
		int maxDay = (int) LocalDate.of(1995, 12, 20).toEpochDay();
		
		long ramdomInt = minDay + ramdom.nextInt(maxDay - minDay + 1);
		LocalDate ramdomDay = LocalDate.ofEpochDay(ramdomInt);
		
		System.out.println("Ngày ngẫu nhiên là: " + ramdomDay);
		System.out.println();
	}

	//Question 5:
//	Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 1 năm trở lại đây
		
	public static void question5() {
		System.out.println("Question 5:");
		Random ramdom = new Random();
		
		int now = (int) LocalDate.now().toEpochDay();
		int ramdomDay = now - ramdom.nextInt(365);
		
		LocalDate resultRamdomDay = LocalDate.ofEpochDay(ramdomDay);
		
		System.out.println("ngẫu nhiên trong 1 năm trở lại đây: " + resultRamdomDay);
		System.out.println();
	}

//	Question 6:
//	Lấy ngẫu nhiên 1 ngày trong quá khứ	
	
	public static void question6() {
		System.out.println("Question 6:");
		Random ramdom = new Random();
		
		int maxDay = (int) LocalDate.now().toEpochDay();
		int minDay = (int) LocalDate.MIN.toEpochDay();
		int ramdomDay = minDay + ramdom.nextInt(maxDay - minDay);
		
		LocalDate result = LocalDate.ofEpochDay(ramdomDay);
		System.out.println("ngẫu nhiên trong quá khứ: " + result);
		System.out.println();
		
	}
	
	//Question 7:
//	Lấy ngẫu nhiên 1 số có 3 chữ số	
	
	public static void question7() {
		System.out.println("Question 7:");
		
		Random ramdom = new Random();
		int result = ramdom.nextInt(999-100+1) + 100;
		System.out.println("ngẫu nhiên số có 3 chữ số: " + result);
		System.out.println();
		
		
	}
	
	

}
