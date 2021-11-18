package com.vti.academy;

import java.util.Date;
import java.util.Locale;

import com.vti.academy.enums.PositionName;

public class Exercise2_SystemOutPrintf {

	public static void main(String[] args) {
//	
//	Question 1:
//	Khai báo 1 số nguyên = 5 và sử dụng lệnh System out printf để in ra số nguyên đó
		
		System.out.println("Question 1:");
		System.out.printf("Số Nguyên: %d%n", 5);
		
		System.out.println();
		
//	Question 2:
//	Khai báo 1 số nguyên = 100 000 000 và sử dụng lệnh System out printf để in ra số nguyên đó thành định dạng như sau: 100,000,000
		
		System.out.println("Question 2:");
		System.out.printf(Locale.US, "Số Nguyên: %,d%n", 100000000);
		
		System.out.println();
	
//	Question 3:
//	Khai báo 1 số thực = 5,567098 và sử dụng lệnh System out printf để in ra số thực đó chỉ bao gồm 4 số đằng sau
		
		System.out.println("Question 3:");
		System.out.printf("Số Thực: %5.4f%n", 5.567098);
		
		System.out.println();
		
//	Question 4:
//	Khai báo Họ và tên của 1 học sinh và in ra họ và tên học sinh đó theo định dạng như sau:
//	Họ và tên: "Nguyễn Văn A" thì sẽ in ra trên console như sau:
//	Tên tôi là "Nguyễn Văn A" và tôi đang độc thân.
		
		System.out.println("Question 4:");
		System.out.printf("'%s' %n", "Tên tôi là Nguyễn Văn A và tôi đang độc thân.");
		
		System.out.println();
	
//	Question 5:
//	Lấy thời gian bây giờ và in ra theo định dạng sau: 24/04/2020 11h:16p:20s
		
		
		System.out.println("Question 4:");
		System.out.printf("%1$td/%1$tm/%1$ty %tT %n", new Date());
		
		System.out.println();
			
//	Question 6:
//	In ra thông tin account (như Question 8 phần FOREACH) theo định dạng table (giống trong Database)
		
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
		account1.email = "NguyenVanA@gmail.com";
		account1.userName = "anguyenvan";
		account1.fullName = "Nguyễn Văn A";
		account1.department = department1;
		account1.position = position1;
		account1.createDate = new Date();

		Account account2 = new Account();
		account2.accountId = 2;
		account2.email = "NguyenVanB@gmail.com";
		account2.userName = "bnguyenvan";
		account2.fullName = "Nguyễn Văn B";
		account2.department = department2;
		account2.position = position2;
		account2.createDate = new Date();

		Account account3 = new Account();
		account3.accountId = 3;
		account3.email = "hieudinhvan@gmail.com";
		account3.userName = "hieudinhvan";
		account3.fullName = "Đinh Văn Hiếu";
		account3.department = department3;
		account3.position = position2;
		account3.createDate = new Date();

		Account account4 = new Account();
		account4.accountId = 4;
		account4.email = "hieubuitat@gmail.com";
		account4.userName = "hieubuitat";
		account4.fullName = "Bùi Tất Hiếu";
		account4.department = department2;
		account4.position = position3;
		account4.createDate = new Date();
		
		System.out.println("Question 8:");
		System.out.println("Email			FullName	DepartmentName"
							+ "\n" + account1.email + "\t" + account1.fullName + "\t" +  account1.department.departmentName);
			

	}

}
