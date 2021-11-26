package com.vti.academy;

import java.util.Date;

import com.vti.academy.enums.PositionName;

public class Exercise1_FlowControl {



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
		group4.groupName = "group master";
		group4.createDate = new Date();
		
		// create account
		Account account1 = new Account();
		account1.accountId = 1;
		account1.email = "NguyenVanA@gmail.com";
		account1.userName = "anguyenvan";
		account1.fullName = "Nguyễn Văn A";
		account1.department = department1;
		account1.position = position1;
		account1.createDate = new Date();
		account1.groups = new Group[] {group1};

		Account account2 = new Account();
		account2.accountId = 2;
		account2.email = "NguyenVanB@gmail.com";
		account2.userName = "bnguyenvan";
		account2.fullName = "Nguyễn Văn B";
		account2.department = department2;
		account2.position = position2;
		account2.createDate = new Date();
		account2.groups = new Group[] {group1, group2, group3, group4};

		Account account3 = new Account();
		account3.accountId = 3;
		account3.email = "hieudinhvan@gmail.com";
		account3.userName = "hieudinhvan";
		account3.fullName = "Đinh Văn Hiếu";
		account3.department = department3;
		account3.position = position2;
		account3.createDate = new Date();
		account3.groups = new Group[] {group1, group2};

		Account account4 = new Account();
		account4.accountId = 4;
		account4.email = "hieubuitat@gmail.com";
		account4.userName = "hieubuitat";
		account4.fullName = "Bùi Tất Hiếu";
		account4.department = department2;
		account4.position = position3;
		account4.createDate = new Date();
		
		// add groupaccount
		group1.accounts = new Account[] {account1, account2, account3};
		group2.accounts = new Account[] {account1, account2};
		
		// add accountarr
		Account[] accountArray = new Account[] {account1, account2, account3, account4};
		
		// add departmentarr
		Department[] departmentArray = new Department[] {department1, department2, department3};
		
//	IF
//	Question 1:
//	Kiểm tra account thứ 2
//	Nếu không có phòng ban (tức là department == null) thì sẽ in ra text "Nhân viên này chưa có phòng ban"
//	Nếu không thì sẽ in ra text "Phòng ban của nhân viên này là ..."

		//question1(account2);

//	Question 2:
//	Kiểm tra account thứ 2
//	Nếu không có group thì sẽ in ra text "Nhân viên này chưa có group"
//	Nếu có mặt trong 1 hoặc 2 group thì sẽ in ra text "Group của nhân viên này là Java Fresher, C# Fresher"
//	Nếu có mặt trong 3 Group thì sẽ in ra text "Nhân viên này là người quan trọng, tham gia nhiều group"
//	Nếu có mặt trong 4 group trở lên thì sẽ in ra text "Nhân viên này là người hóng chuyện, tham gia tất cả các group"

		//question2(account2);

//	Question 3:
//	Sử dụng toán tử ternary để làm Question 1

		//question3(account2);

//	Question 4:
//	Sử dụng toán tử ternary để làm yêu cầu sau:
//	Kiểm tra Position của account thứ 1
//	Nếu Position = Dev thì in ra text "Đây là Developer"
//	Nếu không phải thì in ra text "Người này không phải là Developer"

		//question4(account1);

//	SWITCH CASE 
//	Question 5:
//	Lấy ra số lượng account trong nhóm thứ 1 và in ra theo format sau:
//	Nếu số lượng account = 1 thì in ra "Nhóm có một thành viên" 
//	Nếu số lượng account = 2 thì in ra "Nhóm có hai thành viên"
//	Nếu số lượng account = 3 thì in ra "Nhóm có ba thành viên" 
//	Còn lại in ra "Nhóm có nhiều thành viên"
		
		//question5(group1);

//	Question 6:
//	Sử dụng switch case để làm lại Question 2

		//question6(account2);

//	Question 7:
//	Sử dụng switch case để làm lại Question 4
		
		//question7(account1);

//	FOREACH 
//	Question 8:
//	In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ
		
		//question8(accountArray);
			
//	Question 9:
//	In ra thông tin các phòng ban bao gồm: id và name
		
		//question9(departmentArray);
	
//	FOR
//	Question 10:
//	In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ theo định dạng như sau:
//	Thông tin account thứ 1 là: 
//	Email: NguyenVanA@gmail.com 
//	Full name: Nguyễn Văn A
//	Phòng ban: Sale
//	Thông tin account thứ 2 là: 
//	Email: NguyenVanB@gmail.com 
//	Full name: Nguyễn Văn B
//	Phòng ban: Marketting
		
		//question10(accountArray);
		
//	Question 11:
//	In ra thông tin các phòng ban bao gồm: id và name theo định dạng sau:
//	Thông tin department thứ 1 là:
//	Id: 1
//	Name: Sale
//	Thông tin department thứ 2 là:
//	Id: 2
//	Name: Marketing
		
		//question11(departmentArray);
		
//	Question 12:
//	Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 10
		
		//question12(departmentArray);
		
//	Question 13:
//	In ra thông tin tất cả các account ngoại trừ account thứ 2
		
	//	question13(accountArray);
	
//	Question 14:
//	In ra thông tin tất cả các account có id < 4

		//question14(accountArray);
		
//	Question 15:
//	In ra các số chẵn nhỏ hơn hoặc bằng 20
		
		//question15();
		
//	WHILE
//	Question 16:
//	Làm lại các Question ở phần FOR bằng cách sử dụng WHILE kết hợp với lệnh break, continue
//	Question 16 - 10:
//	In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ theo định dạng như sau:
//	Thông tin account thứ 1 là: 
//	Email: NguyenVanA@gmail.com 
//	Full name: Nguyễn Văn A
//	Phòng ban: Sale
//	Thông tin account thứ 2 là: 
//	Email: NguyenVanB@gmail.com 
//	Full name: Nguyễn Văn B
//	Phòng ban: Marketting

//		question16_10(accountArray);
		
//	Question 16 - 11:
//	In ra thông tin các phòng ban bao gồm: id và name theo định dạng sau:
//	Thông tin department thứ 1 là:
//	Id: 1
//	Name: Sale
//	Thông tin department thứ 2 là:
//	Id: 2
//	Name: Marketing
		
//		question16_11(departmentArray);
		
//	Question 16 - 12:
//	Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 10

//		question16_12(departmentArray);
		
//	Question 16 - 13:
//	In ra thông tin tất cả các account ngoại trừ account thứ 2
		
//		question16_13(accountArray);
		
//	Question 16 - 14:
//	In ra thông tin tất cả các account có id < 4
		
//		question16_14(accountArray);
		
//	Question 16 - 15:
//	In ra các số chẵn nhỏ hơn hoặc bằng 20
		
//		question16_15();
		
//	DO-WHILE 
//	Question 17:
//	Làm lại các Question ở phần FOR bằng cách sử dụng DO-WHILE kết hợp với lệnh break, continue
//	Question 17 - 10:
//	In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ theo định dạng như sau:
//	Thông tin account thứ 1 là: 
//	Email: NguyenVanA@gmail.com 
//	Full name: Nguyễn Văn A
//	Phòng ban: Sale
//	Thông tin account thứ 2 là: 
//	Email: NguyenVanB@gmail.com 
//	Full name: Nguyễn Văn B
//	Phòng ban: Marketting
			
//		question17_10(accountArray);
			
//	Question 17 - 11:
//	In ra thông tin các phòng ban bao gồm: id và name theo định dạng sau:
//	Thông tin department thứ 1 là:
//	Id: 1
//	Name: Sale
//	Thông tin department thứ 2 là:
//	Id: 2
//	Name: Marketing		
	
//		question17_11(departmentArray);
			
//	Question 17 - 12:
//	Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 10			
			
//		question17_12(departmentArray);
			
//	Question 17 - 13:
//	In ra thông tin tất cả các account ngoại trừ account thứ 2		

//		question17_13(accountArray);
			
//	Question 17 - 14:
//	In ra thông tin tất cả các account có id < 4		
			
//		question17_14(accountArray);
			
//	Question 17 - 15:
//	In ra các số chẵn nhỏ hơn hoặc bằng 20
			
//		question17_15();
		
		
	}


//	Question 1:
//	Kiểm tra account thứ 2
//	Nếu không có phòng ban (tức là department == null) thì sẽ in ra text "Nhân viên này chưa có phòng ban"
//	Nếu không thì sẽ in ra text "Phòng ban của nhân viên này là ..."
	
	public static void question1(Account accountArray) {
		System.out.println("Question 1:");

		if (accountArray == null) {
			System.out.println("Nhân viên này chưa có phòng ban");
		} else {
			System.out.println("Phòng ban của nhân viên này là " + accountArray.department.departmentName);
		}
	}
	
//	Question 2:
//	Kiểm tra account thứ 2
//	Nếu không có group thì sẽ in ra text "Nhân viên này chưa có group"
//	Nếu có mặt trong 1 hoặc 2 group thì sẽ in ra text "Group của nhân viên này là Java Fresher, C# Fresher"
//	Nếu có mặt trong 3 Group thì sẽ in ra text "Nhân viên này là người quan trọng, tham gia nhiều group"
//	Nếu có mặt trong 4 group trở lên thì sẽ in ra text "Nhân viên này là người hóng chuyện, tham gia tất cả các group"
	
	public static void question2(Account account) {
		
		int accountQ2 = account.groups == null ? 0 : account.groups.length;
		System.out.println("Question 2:");
		if (accountQ2 == 0) {
			System.out.println("Nhân viên này chưa có group");
		} else if (accountQ2 == 1 || accountQ2 == 2) {
			System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
		} else if (accountQ2 == 3) {
			System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
		} else if (accountQ2 == 4) {
			System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
		}	
	}
	
// Question 3:
// Sử dụng toán tử ternary để làm Question 1	
	
	public static void question3(Account account) {
		System.out.println("Question 3:");
		System.out.println(account.department == null ? "Nhân viên này chưa có phòng ban"
				: "Phòng ban của nhân viên này là " + account.department.departmentName);
	
	}

//	Question 4:
//	Sử dụng toán tử ternary để làm yêu cầu sau:
//	Kiểm tra Position của account thứ 1
//	Nếu Position = Dev thì in ra text "Đây là Developer"
//	Nếu không phải thì in ra text "Người này không phải là Developer"
	
	public static void question4(Account account) {
		System.out.println("Question 4:");
		String posName = account.position.positionName.toString();
		System.out.println(posName == "Dev" ? "Đây là Developer" : "Người này không phải là Developer");
	}
	
//	SWITCH CASE 
//	Question 5:
//	Lấy ra số lượng account trong nhóm thứ 1 và in ra theo format sau:
//	Nếu số lượng account = 1 thì in ra "Nhóm có một thành viên" 
//	Nếu số lượng account = 2 thì in ra "Nhóm có hai thành viên"
//	Nếu số lượng account = 3 thì in ra "Nhóm có ba thành viên" 
//	Còn lại in ra "Nhóm có nhiều thành viên"

	public static void question5(Group groupArr) {
		System.out.println("Question 5:");
		int numberAccount = groupArr.accounts.length;
		switch (numberAccount) {
		case 1:
			System.out.println("Nhóm có một thành viên");
			break;
		case 2:
			System.out.println("Nhóm có hai thành viên");
			break;
		case 3:
			System.out.println("Nhóm có ba thành viên");
			break;
		default:
			System.out.println("Nhóm có nhiều thành viên");
		}
	}
	
//	Question 6:
//	Sử dụng switch case để làm lại Question 2
	
	public static void question6(Account account) {
	System.out.println("Question 6:");
	int numberGroup = account.groups == null ? 0 : account.groups.length;
	switch (numberGroup) {
	case 0:
		System.out.println("Nhân viên này chưa có group");
		break;
	case 1:
		System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
		break;
	case 2:
		System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
		break;
	case 3:
		System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
		break;
	default:
		System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
		}
	}
	
//	Question 7:
//	Sử dụng switch case để làm lại Question 4
	
	public static void question7(Account account) {
	System.out.println("Question 7:");
	String positionInAccount = account.position.positionName;
	switch (positionInAccount) {
	case "Dev":
		System.out.println("Đây là Developer");
		break;
	default:
		System.out.println("Người này không phải là Developer");
		}
	}

//	FOREACH 
//	Question 8:
//	In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ
	
	public static void question8(Account[] accountArr) {
	System.out.println("Question 8:");
	for (Account accountobj : accountArr) {
		System.out.println("Email: " + accountobj.email 
							+ ", FullName: " + accountobj.fullName
							+ ", Tên Phòng Ban: " + accountobj.department.departmentName);
		}
	}
	
//	Question 9:
//	In ra thông tin các phòng ban bao gồm: id và name	
	
	public static void question9(Department[] departments) {
	System.out.println("Question 9:");
	for (Department departmentobj : departments) {
		System.out.println("DepartmentId: " + departmentobj.departmentId
							+ ", DepartmentName: " + departmentobj.departmentName);
		}
	}
	
//	FOR
//	Question 10:
//	In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ theo định dạng như sau:
//	Thông tin account thứ 1 là: 
//	Email: NguyenVanA@gmail.com 
//	Full name: Nguyễn Văn A
//	Phòng ban: Sale
//	Thông tin account thứ 2 là: 
//	Email: NguyenVanB@gmail.com 
//	Full name: Nguyễn Văn B
//	Phòng ban: Marketting
		
	public static void question10(Account[] accountArr) {
		System.out.println("Question 10:");
		for (int i = 0; i < accountArr.length; i++) {
			
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Email: " + accountArr[i].email 
								+ "\nFullName: " + accountArr[i].fullName
								+ "\nPhòng ban: " + accountArr[i].department.departmentName);
			
		}
	}	
	
//	Question 11:
//	In ra thông tin các phòng ban bao gồm: id và name theo định dạng sau:
//	Thông tin department thứ 1 là:
//	Id: 1
//	Name: Sale
//	Thông tin department thứ 2 là:
//	Id: 2
//	Name: Marketing
		
	public static void question11(Department[] departmentArr) {
		System.out.println("Question 11:");
		for (int i = 0; i < departmentArr.length; i++) {
			System.out.println("Thông tin department thứ " + (i + 1) + " là:");
			System.out.println("\tId: " + departmentArr[i].departmentId
								+ "\n\tName: " + departmentArr[i].departmentName);
		}
	}
	
//	Question 12:
//	Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 10
		
	public static void question12(Department[] departmentArr) {
		System.out.println("Question 12:");
		for (int i = 0; i < 2; i++) {
			System.out.println("Thông tin department thứ " + (i + 1) + " là:");
			System.out.println(" Id: " + departmentArr[i].departmentId
								+ "\n Name: " + departmentArr[i].departmentName);
		}
	}
	
//	Question 13:
//	In ra thông tin tất cả các account ngoại trừ account thứ 2
		
	public static void question13(Account[] accountArr) {
		System.out.println("Question 13:");
		for (int i = 0; i < accountArr.length; i++)
			if (i != 1) {
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Id: " + accountArr[i].accountId 
								+ "\nEmail: " + accountArr[i].email
								+ "\nUserName: " + accountArr[i].userName
								+ "\nFullName: " + accountArr[i].fullName
								+ "\nDepartment: " + accountArr[i].department.departmentName
								+ "\nPosition: " + accountArr[i].position.positionName);
			System.out.print("groupName: ");
			if (accountArr[i].groups != null) {
			for (Group group : accountArr[i].groups) {
				System.out.print(group.groupName + " \n");

				}
			}
		}	
	}
	
//	Question 14:
//	In ra thông tin tất cả các account có id < 4
		
	public static void question14(Account[] accountArr) {
		System.out.println("Question 14:");
		for (int i = 0; i < accountArr.length; i++) 
			if (accountArr[i].accountId < 4) {
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Id: " + accountArr[i].accountId 
								+ "\nEmail: " + accountArr[i].email
								+ "\nUserName: " + accountArr[i].userName
								+ "\nFullName: " + accountArr[i].fullName
								+ "\ndepartmentName: " + accountArr[i].department.departmentName
								+ "\npositionName: " + accountArr[i].position.positionName);
		}
	}
	
//	Question 15:
//	In ra các số chẵn nhỏ hơn hoặc bằng 20
		
	public static void question15() {
		System.out.println("Question 15:");
		for(int i = 0; i <= 20; i++) {
			if(i%2 != 0) {
				continue;
			}
			System.out.println(i);
		}
	}
	
//	WHILE
//	Question 16:
//	Làm lại các Question ở phần FOR bằng cách sử dụng WHILE kết hợp với lệnh break, continue
//	Question 16 - 10:
//	In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ theo định dạng như sau:
//	Thông tin account thứ 1 là: 
//	Email: NguyenVanA@gmail.com 
//	Full name: Nguyễn Văn A
//	Phòng ban: Sale
//	Thông tin account thứ 2 là: 
//	Email: NguyenVanB@gmail.com 
//	Full name: Nguyễn Văn B
//	Phòng ban: Marketting

	public static void question16_10(Account[] accountWhile10) {
		System.out.println("Question 16 - 10:");
		int i = 0;
		
		while (i < accountWhile10.length ) {
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println(" Email: " + accountWhile10[i].email 
								+ "\n FullName: " + accountWhile10[i].fullName
								+ "\n Phòng ban: " + accountWhile10[i].department.departmentName);
			i++;

		}
	}
	
//	Question 16 - 11:
//	In ra thông tin các phòng ban bao gồm: id và name theo định dạng sau:
//	Thông tin department thứ 1 là:
//	Id: 1
//	Name: Sale
//	Thông tin department thứ 2 là:
//	Id: 2
//	Name: Marketing
		
	public static void question16_11(Department[] departmentWhile11) {
		System.out.println("Question 16 - 11:");
		int d = 0;
		
		while (d < departmentWhile11.length) {
			System.out.println("Thông tin department thứ " + (d + 1) + " là:");
			System.out.println(" Id: " + departmentWhile11[d].departmentId
								+ "\n Name: " + departmentWhile11[d].departmentName);
			d++;

		}
	}
	
//	Question 16 - 12:
//	Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 10
	
	public static void question16_12(Department[] departmentWhile12) {
	System.out.println("Question 16 - 12:");
	int de = 0;
	
	while (de < departmentWhile12.length) {
		if (de != 2) { 
		System.out.println("Thông tin department thứ " + (de + 1) + " là:");
		System.out.println(" Id: " + departmentWhile12[de].departmentId
							+ "\n Name: " + departmentWhile12[de].departmentName);
			}
		de++;
		}
	}	
	
//	Question 16 - 13:
//	In ra thông tin tất cả các account ngoại trừ account thứ 2
	
	public static void question16_13(Account[] accountWhile13) {
	System.out.println("Question 16 - 13:");
	int acc = 0;
	
	while (acc < accountWhile13.length) {
		if (acc != 1) {
		System.out.println("Thông tin account thứ " + (acc + 1) + " là:");
		System.out.println(" Id: " + accountWhile13[acc].accountId 
							+ "\n Email: " + accountWhile13[acc].email
							+ "\n UserName: " + accountWhile13[acc].userName
							+ "\n FullName: " + accountWhile13[acc].fullName
							+ "\n Department: " + accountWhile13[acc].department.departmentName
							+ "\n Position: " + accountWhile13[acc].position.positionName);
			}
		acc++;

		}
	}
	
//	Question 16 - 14:
//	In ra thông tin tất cả các account có id < 4
		
	public static void question16_14(Account[] accountWhile14) {
		System.out.println("Question 16 - 14:");
		int id = 0;
		
		while (id < accountWhile14.length) {
			if (accountWhile14[id].accountId < 4) {
			System.out.println("Thông tin account thứ " + (id + 1) + " là:");
			System.out.println(" Id: " + accountWhile14[id].accountId 
								+ "\n Email: " + accountWhile14[id].email
								+ "\n UserName: " + accountWhile14[id].userName
								+ "\n FullName: " + accountWhile14[id].fullName
								+ "\n Department: " + accountWhile14[id].department.departmentName
								+ "\n Position: " + accountWhile14[id].position.positionName);
			}
			id++;

		}
	}
	
//	Question 16 - 15:
//	In ra các số chẵn nhỏ hơn hoặc bằng 20
		
	public static void question16_15() {
		System.out.println("Question 16 - 15:");
		int i = 0;
		while (i <=20) {
			i++;
			if (i%2 != 0) {
				continue;
			}
		System.out.println(i);
		}
	}
	
//	DO-WHILE 
//	Question 17:
//	Làm lại các Question ở phần FOR bằng cách sử dụng DO-WHILE kết hợp với lệnh break, continue
//	Question 17 - 10:
//	In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ theo định dạng như sau:
//	Thông tin account thứ 1 là: 
//	Email: NguyenVanA@gmail.com 
//	Full name: Nguyễn Văn A
//	Phòng ban: Sale
//	Thông tin account thứ 2 là: 
//	Email: NguyenVanB@gmail.com 
//	Full name: Nguyễn Văn B
//	Phòng ban: Marketting
			
	public static void question17_10(Account[] accountDoWhile10) {
		System.out.println("Question 17 - 10:");
		int adw = 0;
		do {
			if (adw < 2) {
			System.out.println("Thông tin account thứ " + (adw + 1) + " là:");
			System.out.println(" Email: " + accountDoWhile10[adw].email
								+ "\n FullName: "+ accountDoWhile10[adw].fullName
								+ "\n Phòng ban: " + accountDoWhile10[adw].department.departmentName);
				}
			adw++;
		} while (adw < accountDoWhile10.length );	
	}
		
//	Question 17 - 11:
//	In ra thông tin các phòng ban bao gồm: id và name theo định dạng sau:
//	Thông tin department thứ 1 là:
//	Id: 1
//	Name: Sale
//	Thông tin department thứ 2 là:
//	Id: 2
//	Name: Marketing		
	
	public static void question17_11(Department[] departmentDoWhile11) {
	System.out.println("Question 17 - 11:");
	int ddw = 0;
	
	do {
		if (ddw <= 1) {
		System.out.println("Thông tin department thứ " + (ddw + 1) + " là:");
		System.out.println(" Id: " + departmentDoWhile11[ddw].departmentId
							+ "\n Name: " + departmentDoWhile11[ddw].departmentName);
				}
			ddw++;
		} while (ddw < departmentDoWhile11.length);
	}

//	Question 17 - 12:
//	Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 10			
			
	public static void question17_12(Department[] departmentDoWhile12) {
		System.out.println("Question 17 - 12:");
		int ddw12 = 0;
			
		do {
			if (ddw12 < 2) {
			System.out.println("Thông tin department thứ " + (ddw12 + 1) + " là:");
			System.out.println(" Id: " + departmentDoWhile12[ddw12].departmentId
									+ "\n Name: " + departmentDoWhile12[ddw12].departmentName);
				}
			ddw12++;
		} while (ddw12 < departmentDoWhile12.length);
	}
	
//	Question 17 - 13:
//	In ra thông tin tất cả các account ngoại trừ account thứ 2		
			
	public static void question17_13(Account[] accountDoWhile13) {
		System.out.println("Question 17 - 13:");
		int adw13 = 0;
			
		do {
			if (adw13 != 1) {
			System.out.println("Thông tin account thứ " + (adw13 + 1) + " là:");
			System.out.println(" Id: " + accountDoWhile13[adw13].accountId 
								+ "\n Email: " + accountDoWhile13[adw13].email
								+ "\n UserName: " + accountDoWhile13[adw13].userName
								+ "\n FullName: " + accountDoWhile13[adw13].fullName
								+ "\n Department: " + accountDoWhile13[adw13].department.departmentName
								+ "\n Position: " + accountDoWhile13[adw13].position.positionName);
				}
			adw13++;	
		} while (adw13 < accountDoWhile13.length);	
	}
	
//	Question 17 - 14:
//	In ra thông tin tất cả các account có id < 4		
			
	public static void question17_14(Account[] accountDoWhile14) {
		System.out.println("Question 17 - 14:");
		int iddw = 0;
			
		do {
			if (accountDoWhile14[iddw].accountId < 4) {
			System.out.println("Thông tin account thứ " + (iddw + 1) + " là:");
			System.out.println(" Id: " + accountDoWhile14[iddw].accountId 
								+ "\n Email: " + accountDoWhile14[iddw].email
								+ "\n UserName: " + accountDoWhile14[iddw].userName
								+ "\n FullName: " + accountDoWhile14[iddw].fullName
								+ "\n Department: " + accountDoWhile14[iddw].department.departmentName
								+ "\n Position: " + accountDoWhile14[iddw].position.positionName);
				}
			iddw++;

		} while (iddw < accountDoWhile14.length);
	}
	
//	Question 17 - 15:
//	In ra các số chẵn nhỏ hơn hoặc bằng 20
			
	public static void question17_15() {
		System.out.println("Question 17 - 15:");
		int idw = 0;
		do {
			if (idw%2 == 0) {
				System.out.println(idw);
				}
			idw++;
		} while (idw <=20);
	}	
	
	
	
	
	
	
}
	
	
	
	
	
	

