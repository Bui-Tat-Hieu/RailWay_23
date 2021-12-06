package com.vti.backend;

import com.vti.entiny.Student;

public class Exercise4_Encapsulation {

	public static void question1() {
//	Question 1:
	
	Student student1 = new Student("Bùi Tất Hiếu", "Hà Nội");
	student1.plusScore(2f);
	
	Student student2 = new Student("Nguyễn Quý Bình", "Hà Nội");
	student2.plusScore(4f);
	
	Student student3 = new Student("Đinh Văn Hiếu", "Hà Nội");
	student3.plusScore(7f);
	
	Student student4 = new Student("Nguyễn Quý Trường", "Hà Nội");
	student4.plusScore(9f);
	
	System.out.println(student1);
	System.out.println(student2);
	System.out.println(student3);
	System.out.println(student4);
	
	
	
	}	
}
