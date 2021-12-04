package com.vti.frontend;

import com.vti.entiny.Student;

public class Demo {

	public static void question11() {
		
		Student[] studenArr = new Student[10];
		studenArr[0] = new Student(1, "Nguyễn Văn A", 3);
		studenArr[1] = new Student(2, "Nguyễn Văn B", 3);
		studenArr[2] = new Student(3, "Nguyễn Văn C", 3);
		studenArr[3] = new Student(4, "Nguyễn Văn A1", 1);
		studenArr[4] = new Student(5, "Nguyễn Văn B1", 1);
		studenArr[5] = new Student(6, "Nguyễn Văn C1", 1);
		studenArr[6] = new Student(7, "Nguyễn Văn A2", 2);
		studenArr[7] = new Student(8, "Nguyễn Văn B2", 2);
		studenArr[8] = new Student(9, "Nguyễn Văn C2", 2);
		studenArr[9] = new Student(10, "Nguyễn Văn D", 3);
		
		
		for (Student student : studenArr) {
			student.diemDanh();
		}
		
		for (Student student : studenArr) {
			if (student.getGroup() == 1) {
				student.hocBai();
			}
		}
		
		for (Student student : studenArr) {
			if (student.getGroup() == 2) {
				student.diDonVeSinh();
			}
		}
		
	}
	

}
