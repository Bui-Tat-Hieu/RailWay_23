package com.vti.academy;

import java.util.Scanner;

public class Exercise5_ObjectMethod {

	public static void main(String[] args) {
//		Accounting 
//		Boss of director 
//		Marketing
//		Sale
//		Waiting room
		
		// create department
		Department department1 = new Department();
		department1.departmentId = 1;
		department1.departmentName = "Accounting";

		Department department2 = new Department();
		department2.departmentId = 2;
		department2.departmentName = "Marketing";

		Department department3 = new Department();
		department3.departmentId = 3;
		department3.departmentName = "Boss of director";
		
		Department department4 = new Department();
		department4.departmentId = 4;
		department4.departmentName = "Waiting room";
		
		Department department5 = new Department();
		department5.departmentId = 5;
		department5.departmentName = "Sale";
		
		Department[] departmentArr = new Department[] {department1, department2, department3, department4, department5}; 
		
//Question 1:
	
//		question1(department1);
		
//Question 2:
		
//		question2(departmentArr);
		
//Question 3:
		
//		question3(department1);
		
//Question 4:
		
//		question4(department1);
//		question44(department1);
		
//Question 5:
		
//		question5(department1, department2);
		
//Question 6:
		
		question6(departmentArr);
		
//Question 7:
		
		question7(departmentArr);

}

//	Question 1:
//	In ra thông tin của phòng ban thứ 1 (sử dụng toString())

	public static void question1(Department department) {
		System.out.println("\tQuestion 1:");
		System.out.println("Thông tin của phòng ban thứ 1:");
		System.out.println(department);
	}
	
//	Question 2:
//	In ra thông tin của tất cả phòng ban (sử dụng toString())
	
	public static void question2(Department[] departmentArr) {
		System.out.println("\tQuestion 2:");
		System.out.println("Thông tin của tất cả phòng ban:");
		for (Department department : departmentArr) {
			System.out.println(department.toString());
		} 
	}
	
//	Question 3:
//	In ra địa chỉ của phòng ban thứ 1
	
	public static void question3(Department departmentArr) {
		System.out.println("\tQuestion 3:");
		System.out.println("địa chỉ của phòng ban thứ 1: " + departmentArr.hashCode());
	}
	
//	Question 4:
//	Kiểm tra xem phòng ban thứ 1 có tên là "Phòng A" không? 
	
	public static void question4(Department departmentArr) {
		System.out.println("\tQuestion 4:");
		if (departmentArr.departmentName.equals("Phòng A")) {
			System.out.println("Phòng ban tên là Phòng A");
		} else {
			System.out.println("Phòng ban không phải tên Phòng A");
		}
	}
	
	public static void question44(Department departmentArr) {
		System.out.println("\tQuestion 4:");
		System.out.println(departmentArr.departmentName.equals("Phòng A")
							? "Phòng ban tên là Phòng A"
							: "Phòng ban không phải tên Phòng A");
	}
	
//	Question 5: So sánh 2 phòng ban thứ 1 và phòng ban thứ 2 xem có bằng nhau không 
//	(bằng nhau khi tên của 2 phòng ban đó bằng nhau)
	
	public static void question5(Department department1, Department department2) {
		System.out.println("\tQuestion 5:");
		System.out.println(department1.equals(department2)
							? "Tên của 2 phòng ban bằng nhau"
							: "Tên của 2 phòng ban không bằng nhau");
	}
	
//	Question 6: 
//	Khởi tạo 1 array phòng ban gồm 5 phòng ban, sau đó in ra danh sách phòng ban theo thứ tự tăng dần theo tên (sắp xếp theo vần ABCD)
//	VD:
//	Accounting 
//	Boss of director 
//	Marketing
//	Sale
//	Waiting room
	
	public static void question6(Department[] departmentArr) {
		System.out.println("\tQuestion7:");
		for (int i = 0; i < departmentArr.length; i++ ) {
			for (int j = i + 1; j < departmentArr.length; j++) {
				if (departmentArr[i].departmentName == null) {
					departmentArr[i].departmentName = "";
				}
				if (departmentArr[j].departmentName == null) {
					departmentArr[j].departmentName = "";
				}
				if(departmentArr[i].departmentName.compareToIgnoreCase(departmentArr[j].departmentName) > 0) {
					Department temp = departmentArr[i];
					departmentArr[i] = departmentArr[j];
					departmentArr[j] = temp;
				}
			}
		}
		for (int i = 0; i < departmentArr.length; i++) {
			System.out.println(departmentArr[i]);
			
		}
	}
	
// *1 - 7,8,5,3,2 => 8,7,5,3,2 => 8,5,7,3,2 => 8,5,3,7,2 => 8,5,3,2,7
// *2 - 8,5,3,2,7 => 5,8,3,2,7 => 5,3,8,2,7 => 5,3,2,8,7 => 5,3,2,7,8	
// *3 - 5,3,2,7,8 => 3,5,2,7,8 => 3,2,5,7,8	
// *4 - 3,2,5,7,8 => 2,3,5,7,8	
	
//	Question 7:
//	Khởi tạo 1 array học sinh gồm 5 Phòng ban, sau đó in ra danh sách phòng ban được sắp xếp theo tên
//	VD:
//	Accounting
//	Boss of director
//	Marketing 
//	waiting room 
//	Sale
	
	public static void question7(Department[] departmentArr) {
		System.out.println("\tQuestion6:");
		for (int i = 0; i < departmentArr.length; i++ ) {
			for (int j = i + 1; j < departmentArr.length; j++) {
				if (departmentArr[i].departmentName == null) {
					departmentArr[i].departmentName = "";
				}
				if (departmentArr[j].departmentName == null) {
					departmentArr[j].departmentName = "";
				}
				String[] stringArr1 = departmentArr[i].departmentName.split(" ");
				String[] stringArr2 = departmentArr[j].departmentName.split(" ");
				if(stringArr1[stringArr1.length - 1].compareToIgnoreCase(stringArr2[stringArr2.length - 1]) > 0) {
					Department temp = departmentArr[i];
					departmentArr[i] = departmentArr[j];
					departmentArr[j] = temp;
				}
			}
		}
		for (int i = 0; i < departmentArr.length; i++) {
			System.out.println(departmentArr[i]);
			
		}
	}

}
