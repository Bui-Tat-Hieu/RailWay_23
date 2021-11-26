package com.vti.academy;

import java.util.Date;


import com.vti.academy.enums.PositionName;

public class Exercise6_Method {

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

		// create group
		Group group1 = new Group();
		group1.groupId = 1;
		group1.groupName = "group sale";
		group1.createDate = new Date();

		Group group2 = new Group();
		group2.groupId = 2;
		group2.groupName = "group marketing";
		group2.createDate = new Date();

		Group group3 = new Group();
		group3.groupId = 3;
		group3.groupName = "group master";
		group3.createDate = new Date();

		Group group4 = new Group();
		group4.groupId = 4;
		group4.groupName = "group linh tinh";
		group4.createDate = new Date();
		
		// create account
		Account account1 = new Account();
		account1.accountId = 1;
		account1.email = "NguyenVanA@gmail.com";
		account1.userName = "a.nguyenvan";
		account1.fullName = "Nguyễn Văn A";
		account1.department = department1;
		account1.position = position1;
		account1.createDate = new Date();
		account1.groups = new Group[] {group1, group2};

		Account account2 = new Account();
		account2.accountId = 2;
		account2.email = "NguyenVanB@gmail.com";
		account2.userName = "b.nguyenvan";
		account2.fullName = "Nguyễn Văn B";
		account2.department = department2;
		account2.position = position2;
		account2.createDate = new Date();
		account2.groups = new Group[] {group1, group2, group3, group4};

		Account account3 = new Account();
		account3.accountId = 3;
		account3.email = "hieudinhvan@gmail.com";
		account3.userName = "hieu.dinhvan";
		account3.fullName = "Đinh Văn Hiếu";
		account3.department = department3;
		account3.position = position2;
		account3.createDate = new Date();
		account3.groups = new Group[] {};
		
		Account account4 = new Account();
		account4.accountId = 4;
		account4.email = "hieubuitat@gmail.com";
		account4.userName = "hieu.buitat";
		account4.fullName = "Bùi Tất Hiếu";
		account4.department = department2;
		account4.position = position3;
		account4.createDate = new Date();
		account4.groups = new Group[] {};
		
		// add groupaccount
		// thêm creator, acoounts cho group
		group1.creator = account1;
		group1.accounts = new Account[] {account1, account2, account3, account4};
		
		group2.creator = account2;
		group2.accounts = new Account[] {account1, account2};
		
		group3.creator = account3;
		group3.accounts = new Account[] { account3 };
		
		// add accountarr
		Account[] accountArr = new Account[] {account1, account2, account3, account4};
		
//	Question 1:
//	Tạo method để in ra các số chẵn nguyên dương nhỏ hơn 10
		
		question1();
		
//	Question 2:
//	Tạo method để in thông tin các account
		
		question2(accountArr);
		
//	Question 3:
//	Tạo method để in ra các số nguyên dương nhỏ hơn 10
		
		question3();
		

	}
	
//	Question 1:
//	Tạo method để in ra các số chẵn nguyên dương nhỏ hơn 10
	
	public static void question1() {
		System.out.println("Question 1:");
		for(int i = 0; i < 10; i++) {
			if(i%2 != 0) {
				continue;
			}
			System.out.println(i);
		}
	}
	
	
	
	
//	Question 2:
//	Tạo method để in thông tin các account
		public static void question2(Account[] accountArr) {
			for (int i = 0; i < accountArr.length; i++) {
				System.out.println("Thông tin account thứ " + (i + 1) + " là:");
				System.out.println("AccountId: " + accountArr[i].accountId
									+ "\nEmail: " + accountArr[i].email
									+ "\nUserName: " + accountArr[i].userName
									+ "\nFullName: " + accountArr[i].fullName
									+ "\nDepartmentName: " + accountArr[i].department.departmentName
									+ "\nPositionName: " + accountArr[i].position.positionName);
				System.out.print("groupName: \n");
				if (accountArr[i].groups != null) {
				for (Group group : accountArr[i].groups) {
					System.out.print(group.groupName + "\n");	
					}
		
				}	
		
			}
			System.out.println();
		}
	
//	Question 3:
//	Tạo method để in ra các số nguyên dương nhỏ hơn 10	
	
		public static void question3() {
			System.out.println("Question 3:");
			for(int i = 0; i < 10; i++) {
				System.out.println(i);
			}
		}
	
	
	
	
	
	
	
	
	
	
	

}