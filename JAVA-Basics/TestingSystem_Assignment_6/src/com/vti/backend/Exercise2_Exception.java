package com.vti.backend;

import java.util.Scanner;

import com.vti.entiny.Department;
import com.vti.entiny.Group;
import com.vti.entiny.Position;
import com.vti.entiny.ScannerUtils;

public class Exercise2_Exception {
	
	Scanner scanner = new Scanner(System.in);
	ScannerUtils scannerUtils = new ScannerUtils(scanner);

//	Question 1: try...catch...finally
//	Hãy xử lý exception cho VD trên, khi bị lỗi thì sẽ in ra text "cannot divide 0"

	private float divide(int a, int b) {
		if(b == 0) {
			throw new ArithmeticException();
		}else {
			return (float) a / b;
		}
	}
	
	public void question1() {
		
		try {
			float result = divide(7, 0);
			System.out.println(result);
		} catch (ArithmeticException ari) {
			System.out.println("cannot divide 0");
		}
	}

//	Question 2: tiếp tục Question 1
//	Sau khi thực hiện xong method divide dù có lỗi hay không sẽ in ra text "divide completed!"	
	
	public void question2() {
		try {
			
			float result = divide(7, 2);
			System.out.println(result);
		} catch (ArithmeticException ari) {
			System.out.println("cannot divide 0");
		} finally {
			System.out.println("divide completed!");
		}
	}
	
	
	
//	Question 3:	Hãy xử lý exception cho VD trên và in ra thông tin lỗi.

	public void question3() {
		try {
			int[] numbers = {1, 2, 3};
			
			System.out.println(numbers[10]);
		} catch (ArrayIndexOutOfBoundsException array) {
			System.out.println("phần tử không tồn tại");
		}
		
	}
	
//	Question 4: Tạo 1 array departments gồm 3 phần tử
//	Sau đó viết 1 method getIndex(int index) để lấy thông tin phần tử thứ index trong array departments.
//	Nếu index vượt quá length lấy ra thì sẽ in ra text "Cannot find department."
	
	
	
	public void getIndex(int index) {
		
//		// create department
		Department department1 = new Department((byte)1, "Sale");
		Department department2 = new Department((byte)2, "Marketing");
		Department department3 = new Department((byte)3, "Master");
		Department[] departmentArr = new Department[] {department1, department2, department3};

		try {
			System.out.println(departmentArr[index]);
		} catch (Exception e) {
			System.out.println("Không thể tìm thấy phòng ban");
		}		
	}

	public int question4(int index) {
		getIndex(index);
		return index;
		}
	
//	Question 5:
//		Tạo 1 method inputAge() và trả về 1 số int. Trong method hãy cài đặt như sau:
//		B1: Sau đó dùng scanner để nhập vào 1 số	
//		B2: Check exeption
//		Nếu người dùng nhập vào 1 số thì return về số đó
//		Nếu người dùng không nhập vào 1 số thì sẽ in ra dòng text "wrong inputing! Please input an age as int, input again."
//		Nếu người dùng không nhập vào 1 số < 0 thì sẽ in ra dòng text
//		"Wrong inputing! The age must be greater than 0, please input again."
//		B3: hãy demo trong method main() 
//	Gợi ý:
//		o Tại bước 1 & bước 2: Check exception, ta có thể yêu cầu người dùng nhập vào String (scanner.nextLine()),
//		o Sau đó sử dụng casting datatype để convert String to int
//		o Nếu convert được thì suy ra người dùng nhập vào 1 số
//		int
//		o Nếu không convert được thì suy ra người dùng nhập sai,
//		khi người dùng nhập sai thì sẽ in ra text "wrong inputing! Please input an age as int, input again."
	
	public int inputAge() {
		while (true) {
//			Scanner scanner = new Scanner(System.in);
			System.out.println("===Question 5, Question 6===");
			System.out.println("Vui lòng nhập vào tuổi");
			String input = scanner.nextLine();
			try {
				int inputAge = Integer.parseInt(input);
				if (inputAge > 0) {
					System.out.println("Tuổi của bản là: " + inputAge);
					scanner.close();
					return inputAge;
				} else {
					System.out.println("Nhập sai! Tuổi phải lớn hơn 0, vui lòng nhập lại.");
				}
			} catch (Exception e) {
				System.out.println("Nhập sai! Vui lòng nhập tuổi dưới dạng số, nhập lại.");
			}
		}
	}
	
	public void question5() {
		inputAge();
	}
	
//	Question 7: làm tương tự câu 6
//	Tạo 1 class ScannerUtils, trong class sẽ tạo 1 method inputInt() chuyên để nhập dữ liệu dạng int như age, id, ...
//	Gợi ý: inputInt() sẽ có parameter là String errorMessage để người dùng có thể tự điền được errorMessage vào	
	
	public void question7() {
		
		System.out.println("Nhập vào 1 số nguyên");
		int num = scannerUtils.inputInt("Nhập sai! Vui lòng nhập dạng số nguyên, nhập lại.");
		System.out.println("Số nguyên vừa nhập là: " + num);
	}
	
//	Question 8: làm tương tự câu 7
//	Làm tương tự câu 7 với các method inputFloat(), inputDouble(), inputString()
//	Riêng với inputString() thì không cần phải handling exception
	
	public void question8() {
		
		System.out.println("Nhập vào 1 số thực(float)");
		float num = scannerUtils.inputFloat("Nhập sai! Vui lòng nhập dạng số thực, nhập lại.");
		System.out.println("Số thực vừa nhập là: " + num);
		
		System.out.println("Nhập vào 1 số thực(double)");
		double num1 = scannerUtils.inputDouble("Nhập sai! Vui lòng nhập dạng số thực, nhập lại.");
		System.out.println("Số thực vừa nhập là: " + num1);
		
	}
	
//	Question 9: Sử dụng ScannerUtils vừa tạo để nhập thông tin cho Department, 
//	Position với điều kiện khi khởi tạo object sẽ yêu cầu nhập vào thông tin luôn trong constructor (VD như hình dưới)//	
	
	public void question9() throws Exception {
		System.out.println("=====Tạo Department=====");
		Department department = new Department();
		System.out.println(department);
		
		System.out.println("=====Tạo Position=====");
		Position position = new Position();
		System.out.println(position);
	}
	
//	Question 10: làm giống bài 9
//	Sử dụng ScannerUtils để nhập thông tin cho Group
//	Khi tạo các property array accounts thì hỏi người dùng xem,
//	bạn có muốn thêm accounts hay không, nếu người dùng đồng ý thì sẽ nhập thông tin account
//	(với mỗi thông tin Account nhập vào ta sẽ tạo Object mới)
	
	public void question10() {
		
		System.out.println("=====Tạo Group=====");
		Group group = new Group();
		System.out.println(group);
	}
	
	
	
}
