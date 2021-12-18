package com.vti.backend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.vti.entiny.ScannerUtils;
import com.vti.entiny.Student;

public class Exercise1_Collection {

	
//	Question 1: List
//	Tạo 1 student có property id, name
//	(trong đó có 3 student có name trùng nhau, id sẽ là auto increment)
	
	public void question1() {
//		Khai báo 1 ArrayList students, sau đó
	
		Student student1 =new Student("Trường");
		Student student2 =new Student("Bình");
		Student student3 =new Student("Dũng");
		Student student4 =new Student("Hiếu");
		Student student5 =new Student("Hiếu");
		Student student6 =new Student("Hiếu");
		
		List<Student> list = new ArrayList<Student>(Arrays.asList(student1, student2, student3, student4, student5 ,student6));

//		a) In ra tổng số phần tử của students
		
		System.out.println("a) Tổng số phần tử của students: " + list.size());
		
//		b) Lấy phần tử thứ 4 của students
		
		System.out.println("b) Phần tử thứ 4 của students: " + list.get(3));
		
//		c) In ra phần tử đầu và phần tử cuối của students
		
		System.out.println("c) Phần tử đầu của students: " + list.get(0));
		System.out.println("c) Phần tử cuối của students: " + list.get(list.size() - 1));
		
//		d) Thêm 1 phần tử vào vị trí đầu của students
		
		list.add(0,student6);
		System.out.println("d) Thêm 1 phần tử vào vị trí đầu của students\n" + list);
		
//		e) Thêm 1 phần tử vào vị trí cuối của students
		
		list.add(list.size(), student1);
		System.out.println("e) Thêm 1 phần tử vào vị trí cuối của students\n" + list);
		
//		f) Đảo ngược vị trí của students
		
		Collections.reverse(list);
		System.out.println("f) Đảo ngược vị trí của students\n" + list);
		
//		g) Tạo 1 method tìm kiếm student theo id
		
//		System.out.println("Nhập vào ID");
//		int id = ScannerUtils.inputInt("Nhập sai! Vui lòng nhập dạng số.");
//		boolean isID = false;
//		for (Student student : list) {
//			if (student.getId() == id) {
//				isID = true;
//				System.out.println(student);
//			}
//		}
//		if (!isID) {
//			System.out.println("Không tìm thấy Sinh Viên");
//		}
		
//		h) Tạo 1 method tìm kiếm student theo name
		
//		System.out.println("Nhập vào tên");
//		String name = ScannerUtils.inputString();
//		boolean isName = false;
//		for (Student student : list) {
//			if (student.getName().equals(name)) {
//				isName = true;
//				System.out.println(student);
//			}
//		}
//		if (!isName) {
//			System.out.println("Không tìm thấy Sinh Viên");
//		}
		
//		i) Tạo 1 method để in ra các student có trùng tên
		
//		System.out.println("Method để in ra các student có trùng tên");
//		Set<Integer> set = new HashSet<Integer>();
//		for (int i = 0; i < list.size() - 1; i++) {
//			String nameI = list.get(i).getName();
//			for (int j = i + 1; j < list.size(); j++) {
//				String nameJ = list.get(j).getName();
//				if (nameI.equals(nameJ)) {
//					set.add(i);
//					set.add(j);
//				}
//			}
//		}
//		for (Integer integer : set) {
//			System.out.println(list.get(integer));
//		}

//		j) Xóa name của student có id = 2;
		System.out.println("Xóa name của student có id = 2");
		for (Student student : list) {
			if (student.getId() == 2) {
				student.setName(null);
			}
		}
		System.out.println(list);
//		k) Delete student có id = 5;
		System.out.println("Delete student có id = 5");
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == 5) {
				list.remove(i);
			}
		}
		System.out.println(list);
//		l) Tạo 1 ArrayList tên là studentCopies và add tất cả students vào
//		studentCopies
		
		List<Student> studentCopies = list;
		System.out.println("ArrayList tên là studentCopies\n" + studentCopies);
	}
	


}
