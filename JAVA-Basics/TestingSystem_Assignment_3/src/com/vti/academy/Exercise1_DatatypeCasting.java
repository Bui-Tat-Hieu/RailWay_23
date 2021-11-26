package com.vti.academy;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import com.vti.academy.enums.PositionName;

public class Exercise1_DatatypeCasting {

	public static void main(String[] args) {
		
		// create department
		Department department1 = new Department();
		department1.departmentId = 1;
		department1.departmentName = "Sale";

		Department department2 = new Department();
		department2.departmentId = 2;
		department2.departmentName = "Marketing";

		Department department3 = new Department();
		department3.departmentId = 3;
		department3.departmentName = "Master";

		// create position
		Position position1 = new Position();
		position1.positionId = 1;
		position1.positionName = PositionName.POSITION_DEV.getPositionName();

		Position position2 = new Position();
		position2.positionId = 2;
		position2.positionName = PositionName.POSITION_TEST.getPositionName();

		Position position3 = new Position();
		position3.positionId = 3;
		position3.positionName = PositionName.POSITION_SCRUM_MASTER.getPositionName();

		// create account
		Account account1 = new Account();
		account1.accountId = 1;
		account1.email = "hieu.buitat@gmail.com";
		account1.userName = "hieu.buitat";
		account1.fullName = "Bùi Tất Hiếu";
		account1.department = department1;
		account1.position = position1;
		account1.salary = 5240.5;
		account1.createDate = new Date();

		Account account2 = new Account();
		account2.accountId = 2;
		account2.email = "binh.nguyenquy@gmail.com";
		account2.userName = "binh.nguyenquy";
		account2.fullName = "Nguyễn Quý Bình";
		account2.department = department1;
		account2.position = position2;
		account2.salary = 10970.055;
		account2.createDate = new Date();

		Account account3 = new Account();
		account3.accountId = 3;
		account3.email = "hieu.dinhvan@gmail.com";
		account3.userName = "hieu.dinhvan";
		account3.fullName = "Đinh Văn Hiếu";
		account3.department = department3;
		account3.position = position3;
		account3.createDate = new Date();
		
//Question 1:	
		
//	question1(account2);	
		
//Question 2:	
		
	question2();		
		
//Question 3:
		
	//question3();	
		
//Question 4:
		
//	question4();	

	}
	
//Question 1:
//	Khai báo 2 số lương có kiểu dữ liệu là float.
//	Khởi tạo Lương của Account 1 là 5240.5 $
//	Khởi tạo Lương của Account 2 là 10970.055$
//	Khai báo 1 số int để làm tròn Lương của Account 1 và in số int đó ra 
//	Khai báo 1 số int để làm tròn Lương của Account 2 và in số int đó ra
	
	public static void question1(Account account) {
		double a = account.salary;
		int i = 100;
		 	i = (int) a;
		
		System.out.println(i);
	}
	
//Question 2:
//	Lấy ngẫu nhiên 1 số có 5 chữ số (những số dưới 5 chữ số thì sẽ thêm có số 0 ở đầu cho đủ 5 chữ số)
	
	public static void question2() {
		System.out.println("\tQuestion 2:");
	
	}
//Question 3:
//	Lấy 2 số cuối của số ở Question 2 và in ra. Gợi ý:
//	Cách 1: convert số có 5 chữ số ra String, sau đó lấy 2 số cuối
//	Cách 2: chia lấy dư số đó cho 100
//Question 4:
//	Viết 1 method nhập vào 2 số nguyên a và b và trả về thương của chúng
	
	public static void question4() {
	Scanner scanner = new Scanner(System.in);
	System.out.print("nhập số nguyên a: ");
	int a = scanner.nextInt();
	System.out.print("nhập số nguyên b: ");
	int b = scanner.nextInt();
	int c = a/b;
	System.out.println("Thương của chúng là: " + c);
	scanner.close();
	}

}
