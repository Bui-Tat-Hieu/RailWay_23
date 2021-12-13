package com.vti.backend;

import com.vti.entiny.Configs;
import com.vti.entiny.HinhChuNhat;
import com.vti.entiny.HinhHoc;
import com.vti.entiny.HinhTron;
import com.vti.entiny.MyMath;
import com.vti.entiny.PrimaryStudent;
import com.vti.entiny.ScannerUtils;
import com.vti.entiny.SecondaryStudent;
import com.vti.entiny.Student;

public class Exercise1_Static {
	

	Student student1 = new Student("Nguyễn Văn A");
	Student student2 = new Student("Nguyễn Văn B");
	Student student3 = new Student("Nguyễn Văn C");
	Student student4 = new Student("Nguyễn Văn D");
	Student[] studentArr = new Student[] {student1, student2,student3, student4};
	

	
	public void question1() {
	
		for (Student students : studentArr) {
			System.out.println(students);
		}
		System.out.println();
		Student.thayDoiCollege();
		for (Student student : studentArr) {
			System.out.println(student);
		}
	}
	
	public void question2() {
		
		System.out.println("Thông Tin Sinh Viên");
		Student.setCollege("Đại Học Bách Khoa");
		for (Student students : studentArr) {
			System.out.println(students);
		}
		System.out.println("==========================================================");
		System.out.println("B1: Các Student sẽ nộp quỹ, mỗi Student 100k");
		System.out.println("Tổng quỹ hiện tại: " + Student.getMoneyGroup());
		
		System.out.println("==========================================================");
		System.out.println(student1.getName() + " lấy 50k đi mua bim bim, kẹo về liên hoan");
		Student.layTien(50);
		System.out.println("Tổng quỹ hiện tại: " + Student.getMoneyGroup());
		
		System.out.println("==========================================================");
		System.out.println(student2.getName() + " lấy 20k đi mua bánh mì");
		Student.layTien(20);
		System.out.println("Tổng quỹ hiện tại: " + Student.getMoneyGroup());
		
		System.out.println("==========================================================");
		System.out.println(student3.getName() + " lấy 150k đi mua đồ dùng học tập cho nhóm");
		Student.layTien(150);
		System.out.println("Tổng quỹ hiện tại: " + Student.getMoneyGroup());
		
		System.out.println("==========================================================");
		System.out.println("B5: Cả nhóm mỗi người lại đóng quỹ mỗi người 50k");
		Student.nopTien(50 * studentArr.length);
		System.out.println("Tổng quỹ hiện tại: " + Student.getMoneyGroup());
	}
	
//	Question 3: static method
//	a) Viết class MyMath để thay thế cho class Math của java.
//	b) Viết thêm method min(), sum vào class MyMath
	
	public void question3() {

		System.out.print("Nhập Vào Số Thứ 1: ");
		int a = ScannerUtils.inputInt("Nhập sai! Vui lòng nhập dạng số, nhập lại.");
		System.out.print("Nhập Vào Số Thứ 2: ");
		int b = ScannerUtils.inputInt("Nhập sai! Vui lòng nhập dạng số, nhập lại.");
		System.out.println("Max: " + MyMath.max(a, b));
		System.out.println("Min: " + MyMath.min(a, b));
		System.out.println("Sum: " + MyMath.sum(a, b));

	}
	
	
//	Question 4: tiếp tục Question 1 Trong class Student
//	a) Viết method cho phép thay đổi college
//	b) Viết method cho phép lấy giá trị của college

	public void question4() {
		
		Student.setCollege("Đại Học Bách Khoa");
		for (Student students : studentArr) {
			System.out.println(students);
		}
		System.out.println();
		
		Student.setCollege("Đại Học Quôc Gia");
		for (Student students : studentArr) {
			System.out.println(students);
		}
		System.out.println("College đã thay đổi : " + Student.getCollege());
		
	}

//	Question 5: Hãy viết chương trình đếm số Student được sinh ra (tham khảo code trên google)
	
	public void question5() {
		System.out.println("==========================================================");
		System.out.println("Số Sinh Viên được khởi tạo: " + Student.getCountStudent());
	}
	
//	Question 6: tiếp tục Question 5
//	Tạo class PrimaryStudent, SecondaryStudent, 
//	hãy viết chương trình đếm số lượng PrimaryStudent được sinh ra, SecondaryStudent được sinh ra.
//	Viết chương trình demo.
//	Khởi tạo 6 Student, trong đó có 2 PrimaryStudent và 4 SecondaryStudent,
//	sau đó in ra số lượng Student, PrimaryStudent, SecondaryStudent được sinh ra.
	
	public void question6() {
		
// Khởi tạo 2 PrimaryStudent
		Student primaryStudent1 = new PrimaryStudent();
		Student primaryStudent2 = new PrimaryStudent();
		
// Khởi tạo 4 SecondaryStudent
		Student secondaryStudent1 = new SecondaryStudent();
		Student secondaryStudent2 = new SecondaryStudent();
		Student secondaryStudent3 = new SecondaryStudent();
		Student secondaryStudent4 = new SecondaryStudent();
		
		System.out.println("Student: " + Student.getCountStudent());
		System.out.println("PrimaryStudent: " + PrimaryStudent.getPrimaryCount());
		System.out.println("SecondaryStudent: " + SecondaryStudent.getSecondaryCount());
		
	}
	
//	Question 7: tiếp tục Question 6
//	Chỉ cho phép user tạo được tối đa 7 học sinh
	
	public void question7() {
		
		question6();
		
		if (Student.getCountStudent() > 7) {
			System.out.println("Đã quá 7 Sinh Viên");
		}
		
	}
	
//	Question 8: Tạo class Configs có các static property
//	SO_LUONG_HINH_TOI_DA = 5;
//	Tạo class HinhHoc, và class HinhTron, HinhChuNhat
//	sẽ kế thừa từ class HinhHoc, implement method tính chu vi, diện tính
//	Viết chương trình chỉ cho phép khởi tạo được tối đa 5 hình,
//	nếu người dùng khởi tạo tới hình thứ 6 thì sẽ throw ra 1 custom Exception có tên là
//	HinhHocException có message là: "Số lượng hình tối đa là: " + Configs. SO_LUONG_HINH_TOI_DA
	
	public void question8() throws Exception {
		
		HinhHoc hinhTron1 = new HinhTron();
		HinhHoc hinhTron2 = new HinhTron();
		HinhHoc hinhTron3 = new HinhTron();
		
		HinhHoc hinhChuNhat1 = new HinhChuNhat();
		HinhHoc hinhChuNhat2 = new HinhChuNhat();
		HinhHoc hinhChuNhat3 = new HinhChuNhat();
		
		if (HinhHoc.getCount() > Configs.SO_LUONG_HINH_TOI_DA) {
			throw new Exception("Số lượng hình tối đa là: " + Configs.SO_LUONG_HINH_TOI_DA);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
