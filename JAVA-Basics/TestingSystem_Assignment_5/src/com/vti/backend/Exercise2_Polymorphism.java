package com.vti.backend;

import java.util.Scanner;

import com.vti.entiny.HinhVuong;
import com.vti.entiny.MyMath;
import com.vti.entiny.Student;

public class Exercise2_Polymorphism {
	
	private Student[] studenArr; // create mang student
	
	public void question1() {
		createStudentArr();
		caLopDiemDanh();
		diHocBai(1);
		diDonVeSinh(2);
	}
	
	private void createStudentArr() {
		
		studenArr = new Student[10];
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

	}

	private void caLopDiemDanh() {
		for (Student student : studenArr) {
			student.diemDanh();
		}
	}
	
	private void diHocBai(int groupId) {
		for (Student student : studenArr) {
			if (student.getGroup() == groupId) {
				student.hocBai();
			}
		}
	}
	
	private void diDonVeSinh(int groupId) {
		for (Student student : studenArr) {
			if (student.getGroup() == groupId) {
				student.diDonVeSinh();
			}
		}
	}
	
	public void question3() {
	
		HinhVuong hv = new HinhVuong(2);
		System.out.println("chi vi hinh vuong: " + hv.tinhChuVi());
		System.out.println("chi vi dien tich: " + hv.tinhDienTich());
	}
	
	
	public void question4() {
		
		MyMath mymath = new MyMath();
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("nhap diem 1: ");
//		mymath.setDiem1(scanner.nextInt());
//		System.out.println("nhap diem 2: ");
//		mymath.setDiem2(scanner.nextInt());
		System.out.println("Sum MyMath: " + mymath.sum(1, 3));
 	}
	
	
	
	
	
	
	
	
	
	
}