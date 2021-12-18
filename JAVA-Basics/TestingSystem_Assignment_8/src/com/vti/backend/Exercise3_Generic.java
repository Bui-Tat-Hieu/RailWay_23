package com.vti.backend;

import java.util.ArrayList;
import java.util.List;

import com.vti.entiny.Employee;
import com.vti.entiny.MyMap;
import com.vti.entiny.Phone;
import com.vti.entiny.Staff;
import com.vti.entiny.StudentGeneric;

public class Exercise3_Generic {
	
//	Question 1: T generic (class)
//	Tạo class student có property id, name (trong đó id của student có thể là int, long, float)
//	a) Tạo đối tượng student có id là int
//	b) Tạo đối tượng student có id là float
//	c) Tạo đối tượng student có id là double

	public void question1_2() {
		
		System.out.println("a) Tạo đối tượng student có id là int");
		StudentGeneric student1 = new StudentGeneric <Integer> (1, "Hiếu");
		StudentGeneric student2 = new StudentGeneric <Float> ((float) 2, "Bình");
		StudentGeneric student3 = new StudentGeneric <Double> ((double) 3, "Dũng");
		
		List<StudentGeneric> list = new ArrayList<StudentGeneric>();
		list.add(student1);
		list.add(student2);
		list.add(student3);

		System.out.println(list);
		print(student1);
		print(4);
		print(4f);
	}
	
//	Question 2: T generic (method)
//	Tạo method để in ra thông tin nhập vào (parameter) (parameter có thể là họ và tên, hoặc student, hoặc int)
//	Gợi ý: tạo method print(T a) và cài đặt system out (a) ra
//	Demo chương trình với print(student), print(4), print(4.0)
	
	public <T> void print(T a) {
		System.out.println(a);
	}
	
//	Question 4: E generic
//	Tạo 1 array int, 1 array float, 1 array long, 1 array double
//	Tạo 1 method có parameter là array và in ra các số trong array đó
	
	public void question4() {
		Integer[] intArr= {1, 2, 3};
		Float[] floatArr= {4f, 5f, 6f};
		Double[] doubleArr= {7d, 8d, 9d};
		Long[] longArr= {10l, 11l, 12l};
		
		printArr(intArr);
		printArr(floatArr);
		printArr(doubleArr);
		printArr(longArr);
	}
	
	public <T> void printArr(T[] a) {
		for (T t : a) {
			System.out.println(t);
		}
	}
	
//	Question 5: E generic
//	Viết method trong Employee để in ra thông tin của Employee bao gồm id, name, salaris.
//	Viết method trong Employee để in ra thông tin tháng lương cuối cùng của Employee
//	a) Hãy tạo chương trình demo với Employee có salaries là datatype int
//	b) Hãy tạo chương trình demo với Employee có salaries là datatype float
//	c) Hãy tạo chương trình demo với Employee có salaries là datatype double
	
	public void question5() {
		Integer[] salaryInt= {1000, 2000, 3000};
		Float[] salaryFloat= {(float)4000, (float)5000, (float)6000};
		Double[] salaryDouble= {(double)7000, (double)8000, (double)9000};
		
		Employee<Integer> employee1 = new Employee<Integer>(1, "Hiếu", salaryInt);
		Employee<Float> employee2 = new Employee<Float>((float) 2, "Bình", salaryFloat);
		Employee<Double> employee3 = new Employee<Double>((double) 3, "Dũng", salaryDouble);
		
		System.out.println(employee1);
		System.out.println(employee2);
		System.out.println(employee3);
		System.out.println(employee1.getLastSalary());
		System.out.println(employee2.getLastSalary());
		System.out.println(employee3.getLastSalary());
		
	}
	
//	Question 6: K & V generic
//	Tạo 1 class có tên là MyMap, lưu dữ liệu theo dạng key, value 
//	Tạo các method
//	a) GetValue()
//	b) getKey ()
//	Viết chương trình demo: tạo 1 object Student có key là Mã sinh viên và value là tên của sinh viên đó
	
	public void question6() {
		
		MyMap<Integer, String> student = new MyMap<Integer, String>(1, "Hiếu");
		System.out.println(student);
		
	}
	
//	Question 7: K & V generic
//	Tạo 1 class có tên là Phone, lưu dữ liệu theo dạng key, value (extends MyMap)
//	Với key là email hoặc là số thứ tự hoặc là tên người sử dụng Với value là số điện thoại
//	Tạo các method
//	a) GetPhoneNumber() 
//	b) getKey ()
//	Viết chương trình demo với
//	a) key là email
//	b) key là số thứ tự
//	c) key là tên của người sử dụng
	
	public void question7() {
		
//		a) key là email
		Phone<String, String> email = new Phone<String, String>("hieubuitat@gmail.com", "0123456789");
		System.out.println(email.getKey() + " " + email.getPhoneNumber());
		
//		b) key là số thứ tự
		Phone<Integer, String> num = new Phone<Integer, String>(1, "0123456789");
		System.out.println(num.getKey() + " " + num.getPhoneNumber());
		
//		c) key là tên của người sử dụng
		Phone<String, String> name = new Phone<String, String>("Hiếu", "0123456789");
		System.out.println(name.getKey() + " " + name.getPhoneNumber());
		
	}
	
//	Question 8: K & V generic
//	Tạo 1 class có tên là Staff, lưu dữ liệu theo dạng key, value (extends MyMap)
//	Với key là id của Staff (ID có thể là int, long) Với value là tên của Staff
//	Tạo các method
//	a) GetId ()
//	b) getName ()
//	Viết chương trình demo	
	
	
	public void question8() {
		
	Staff<Integer, String> idInt = new Staff<Integer, String>((int) 1, "Hiếu");
	System.out.println(idInt.getId() + " " + idInt.getName());
	
	Staff<Long, String> idLong = new Staff<Long, String>((long) 2, "Bình");
	System.out.println(idLong.getId() + " " + idLong.getName());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
