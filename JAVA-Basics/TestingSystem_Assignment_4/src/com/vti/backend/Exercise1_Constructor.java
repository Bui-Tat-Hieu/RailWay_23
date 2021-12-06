package com.vti.backend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.vti.entiny.Account;
import com.vti.entiny.Department;
import com.vti.entiny.Group;
import com.vti.entiny.Position;
import com.vti.entiny.enums.PositionName;

public class Exercise1_Constructor {
	
	//Question 1:
//	Tạo constructor cho department:
//	a) không có parameters
//	b) Có 1 parameter là nameDepartment và default id của
//	Department = 0
//	Khởi tạo 1 Object với mỗi constructor ở trên
		
	public static void question1() {
		
		System.out.println("a) không có parameters");
		Department department1 = new Department();
		department1.setDepartmentId((byte) 1);
		department1.setDepartmentName("Sale");
		
		System.out.println("departmentId: " + department1.getDepartmentId());
		System.out.println("departmentName: " + department1.getDepartmentName());
		System.out.println();
		
		System.out.println("b) Có 1 parameter là nameDepartment");
		Department department2 = new Department("Marketing");
		
		System.out.println("departmentId: " + department2.getDepartmentId());
		System.out.println("departmentName: " + department2.getDepartmentName());
		System.out.println();
	}
	
	//Question 2:
//	Tạo constructor cho Account:
//	a) Không có parameters
//	b) Có các parameter là id, Email, Username, FirstName,
//	LastName (với FullName = FirstName + LastName)
//	c) Có các parameter là id, Email, Username, FirstName,
//	LastName (với FullName = FirstName + LastName) và
//	Position của User, default createDate = now
//	d) Có các parameter là id, Email, Username, FirstName,
//	LastName (với FullName = FirstName + LastName) và
//	Position của User, createDate
//	Khởi tạo 1 Object với mỗi constructor ở trên
	
	public static void question2() throws ParseException {
//		a) Không có parameters
		
		Position position1 = new Position();
		position1.setPositionId(1);
		position1.setPositionName(PositionName.POSITION_DEV.getPositionName());
		
		Account account1 = new Account();
		account1.setAccountId(1);
		account1.setEmail("hieu.buitat@gmail.com");
		account1.setUserName("hieu.buitat");
		account1.setFullName("");
		account1.setPosition(position1);
		account1.setCreateDate(new Date());
		
		System.out.println("a) Không có parameters");
		System.out.println(account1);
		System.out.println();
		
//		b) Có các parameter là id, Email, Username, FirstName,
//		LastName (với FullName = FirstName + LastName)		
		
//		System.out.println("b) Có các parameter");
//		Account account2 = new Account(2, "binh.nguyenquy@gmail.com", "binh.nguyenquy", "Nguyễn Quý", "Bình");
//		System.out.println(account2);
//		System.out.println();
	
//		c) Có các parameter là id, Email, Username, FirstName,
//		LastName (với FullName = FirstName + LastName) và
//		Position của User, default createDate = now	
		
		// create position

		Position position2 = new Position();
		position2.setPositionId(2);
		position2.setPositionName(PositionName.POSITION_TEST.getPositionName());
		
		System.out.println("c) Có các parameter");
		Account account3 = new Account(3, "hieu.dinhvan@gmail.com", "hieu.dinhvan", "Đinh Văn", "Hiếu", position1);
		System.out.println(account3);
		System.out.println();
		
		
//		d) Có các parameter là id, Email, Username, FirstName,
//		LastName (với FullName = FirstName + LastName) và
//		Position của User, createDate
//		Khởi tạo 1 Object với mỗi constructor ở trên
		
		String date_string = "20-11-1992";
		// Instantiating the SimpleDateFormat class
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		// Parsing the given String to Date object
		Date date = formatter.parse(date_string);
	
		System.out.println("d) Có các parameter");
		Account account4 = new Account(4, "binh.nguyenquy@gmail.com", "binh.nguyenquy", "Nguyễn Quý", "Bình", position2, date);
		System.out.println(account4);
		System.out.println();
		
	}
	
	
	//Question 3:
//	Tạo constructor cho Group:
//	a) không có parameters
//	b) Có các parameter là GroupName, Creator, array Account[]
//	accounts, CreateDate
//	c) Có các parameter là GroupName, Creator, array String[]
//	usernames , CreateDate
//	Với mỗi username thì sẽ khởi tạo 1 Account (chỉ có thông tin username, các thông tin còn lại = null).
//	Khởi tạo 1 Object với mỗi constructor ở trên
	
	public static void question3() throws ParseException {
	
		Account account1 = new Account();
		account1.setAccountId(1);
		account1.setEmail("hieu.buitat@gmail.com");
		account1.setUserName("hieu.buitat");
		account1.setFullName("");
		account1.setDepartment(null);
		account1.setPosition(null);
		account1.setCreateDate(new Date());	

		String dateString = "20-11-1992";
		// Instantiating the SimpleDateFormat class
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		// Parsing the given String to Date object
		Date createDate = formatter.parse(dateString);
		
		Account account2 = new Account(2, "binh.nguyenquy@gmail.com", "binh.nguyenquy", "Nguyễn Quý", "Bình");

		Account[] accountArr = new Account[] {account1, account2};
		
//		a) không có parameters
		
		Group group1 = new Group();
		group1.setGroupId((byte) 1);
		group1.setGroupName("group sale");
		group1.setCreator(account2);
		group1.setCreateDate(createDate);
		group1.setAccounts(accountArr);
		
		System.out.println("a) không có parameters");
		System.out.println(group1);
		System.out.println("danh sach nhan vien");
		for (Account acc : group1.getAccounts()) {
			System.out.println(acc);	
		}
		System.out.println();
//	
//		b) Có các parameter là GroupName, Creator, array Account[]
//		accounts, CreateDate
		
		Group group2 = new Group("group 2 ", account2, createDate, accountArr);
		System.out.println("b) Có các parameter");
		System.out.println(group1);
		System.out.println("danh sach nhan vien");
		for (Account acc : group2.getAccounts()) {
			System.out.println(acc);	
		}
		System.out.println();
		
//		c) Có các parameter là GroupName, Creator, array String[]
//		usernames , CreateDate
//		Với mỗi username thì sẽ khởi tạo 1 Account (chỉ có thông tin username, các thông tin còn lại = null).
//		Khởi tạo 1 Object với mỗi constructor ở trên	
		
		String[] userNames = new String[] {"vand", "vane"};
		Group group3 = new Group("group 3", account2, userNames, createDate );
		
		System.out.println("c) Có các parameter");
		System.out.println(group3);
		System.out.println("danh sach nhan vien");
		for (Account acc : group3.getAccounts()) {
			System.out.println(acc);	
		}
		
		
		
		
		
		
	}
	

}
