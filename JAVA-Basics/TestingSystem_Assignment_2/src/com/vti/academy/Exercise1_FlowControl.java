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
		
//	IF
//	Question 1:
//	Kiểm tra account thứ 2
//	Nếu không có phòng ban (tức là department == null) thì sẽ in ra text "Nhân viên này chưa có phòng ban"
//	Nếu không thì sẽ in ra text "Phòng ban của nhân viên này là ..."

		System.out.println("Question 1:");
		if (account2.department == null) {
			System.out.println("Nhân viên này chưa có phòng ban");
		} else {
			System.out.println("Phòng ban của nhân viên này là " + account2.department.departmentName);
		}
		System.out.println();

//	Question 2:
//	Kiểm tra account thứ 2
//	Nếu không có group thì sẽ in ra text "Nhân viên này chưa có group"
//	Nếu có mặt trong 1 hoặc 2 group thì sẽ in ra text "Group của nhân viên này là Java Fresher, C# Fresher"
//	Nếu có mặt trong 3 Group thì sẽ in ra text "Nhân viên này là người quan trọng, tham gia nhiều group"
//	Nếu có mặt trong 4 group trở lên thì sẽ in ra text "Nhân viên này là người hóng chuyện, tham gia tất cả các group"

		System.out.println("Question 2:");
		if (account2.groups == null) {
			System.out.println("Nhân viên này chưa có group");
		} else if (account2.groups.length <= 2) {
			System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
		} else if (account2.groups.length == 3) {
			System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
		} else if (account2.groups.length == 4) {
			System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
		}
		System.out.println();

//	Question 3:
//	Sử dụng toán tử ternary để làm Question 1

		System.out.println("Question 3:");
		System.out.println(account2.department == null ? "Nhân viên này chưa có phòng ban"
				: "Phòng ban của nhân viên này là " + account2.department.departmentName);
		System.out.println();

//	Question 4:
//	Sử dụng toán tử ternary để làm yêu cầu sau:
//	Kiểm tra Position của account thứ 1
//	Nếu Position = Dev thì in ra text "Đây là Developer"
//	Nếu không phải thì in ra text "Người này không phải là Developer"

		System.out.println("Question 4:");
		System.out.println(account1.position == position1 ? "Đây là Developer" : "Người này không phải là Developer");
		System.out.println();

//	SWITCH CASE 
//	Question 5:
//	Lấy ra số lượng account trong nhóm thứ 1 và in ra theo format sau:
//	Nếu số lượng account = 1 thì in ra "Nhóm có một thành viên" 
//	Nếu số lượng account = 2 thì in ra "Nhóm có hai thành viên"
//	Nếu số lượng account = 3 thì in ra "Nhóm có ba thành viên" 
//	Còn lại in ra "Nhóm có nhiều thành viên"
		
		

		System.out.println("Question 5:");
		int numberaccount = group1.accounts.length;
		switch (numberaccount) {
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
		System.out.println();

//	Question 6:
//	Sử dụng switch case để làm lại Question 2

		System.out.println("Question 6:");
		int numbergroup = account2.groups.length;
		switch (numbergroup) {
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
		System.out.println();

//	Question 7:
//	Sử dụng switch case để làm lại Question 4
		
		System.out.println("Question 7:");
		String positionInAccount = account1.position.positionName;
		switch (positionInAccount) {
		case "Dev":
			System.out.println("Đây là Developer");
			break;
		default:
			System.out.println("Người này không phải là Developer");
		}
		System.out.println();

//	FOREACH 
//	Question 8:
//	In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ
		
		System.out.println("Question 8:");
		Account[] accounts = new Account [] {account1, account2, account3, account4};
		for (Account accountobj : accounts) {
			System.out.println("Email: " + accountobj.email + ", FullName: " + accountobj.fullName
								+ ", DepartmentName: " + accountobj.department.departmentName);
		}
		System.out.println();
			
//	Question 9:
//	In ra thông tin các phòng ban bao gồm: id và name
		
		System.out.println("Question 9:");
		Department[] departments = new Department[] {department1, department2, department3};
		for (Department departmentobj : departments) {
			System.out.println("DepartmentId: " + departmentobj.departmentId
								+ ", DepartmentName: " + departmentobj.departmentName);
		}
		System.out.println();
	
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
		
		System.out.println("Question 10:");
		Account[] accountfor = new Account[] {account1, account2};
		for (int a = 0; a < accountfor.length; a++) {
			System.out.println("Thông tin account thứ " + (a + 1) + " là:");
			System.out.println(" Email: " + accountfor[a].email + "\n FullName: " + accountfor[a].fullName
								+ "\n Phòng ban: " + accountfor[a].department.departmentName);
		}
		System.out.println();
		
//	Question 11:
//	In ra thông tin các phòng ban bao gồm: id và name theo định dạng sau:
//	Thông tin department thứ 1 là:
//	Id: 1
//	Name: Sale
//	Thông tin department thứ 2 là:
//	Id: 2
//	Name: Marketing
		
		System.out.println("Question 11:");
		Department[] departmentfor = new Department[] {department1, department2};
		for (int d = 0; d < departmentfor.length; d++) {
			System.out.println("Thông tin department thứ " + (d + 1) + " là:");
			System.out.println(" Id: " + departmentfor[d].departmentId
								+ "\n Name: " + departmentfor[d].departmentName);
		}
		System.out.println();	
//	Question 12:
//	Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 10
		
		System.out.println("Question 12:");
		Department[] departmentfor12 = new Department[] {department1, department2, department3};
		for (int d = 0; d < 2; d++) {
			System.out.println("Thông tin department thứ " + (d + 1) + " là:");
			System.out.println(" Id: " + departmentfor12[d].departmentId
								+ "\n Name: " + departmentfor12[d].departmentName);
		}
		System.out.println();
		
//	Question 13:
//	In ra thông tin tất cả các account ngoại trừ account thứ 2
		
		System.out.println("Question 13:");
		Account[] accountfor13 = new Account[] {account1, account2, account3};
		for (int a = 0; a < accountfor13.length; a++)
			if (a != 1) {
			System.out.println("Thông tin account thứ " + (a + 1) + " là:");
			System.out.println(" Id: " + accountfor13[a].accountId 
								+ "\n Email: " + accountfor13[a].email
								+ "\n UserName: " + accountfor13[a].userName
								+ "\n FullName: " + accountfor13[a].fullName
								+ "\n Department: " + accountfor13[a].department.departmentName
								+ "\n Position: " + accountfor13[a].position.positionName);
		}
		System.out.println();
	
//	Question 14:
//	In ra thông tin tất cả các account có id < 4
		
		System.out.println("Question 14:");
		Account[] accountfor14 = new Account[] {account1, account2, account3, account4};
		for (int id = 0; id < accountfor14.length; id++) 
			if (accountfor14[id].accountId < 4) {
			System.out.println("Thông tin account thứ " + (id + 1) + " là:");
			System.out.println(" Id: " + accountfor14[id].accountId 
								+ "\n Email: " + accountfor14[id].email
								+ "\n UserName: " + accountfor14[id].userName
								+ "\n FullName: " + accountfor14[id].fullName
								+ "\n Department: " + accountfor14[id].department.departmentName
								+ "\n Position: " + accountfor14[id].position.positionName);
		}
		System.out.println();
		
//	Question 15:
//	In ra các số chẵn nhỏ hơn hoặc bằng 20
		
		System.out.println("Question 15:");
		for(int i = 0; i <= 20; i++) {
			if(i%2==1) {
				continue;
			}
			System.out.println(i);
		}
		System.out.println();
//		WHILE
//		Question 16:
//		Làm lại các Question ở phần FOR bằng cách sử dụng WHILE kết hợp với lệnh break, continue
//		Question 16 - 10:
//		In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ theo định dạng như sau:
//		Thông tin account thứ 1 là: 
//		Email: NguyenVanA@gmail.com 
//		Full name: Nguyễn Văn A
//		Phòng ban: Sale
//		Thông tin account thứ 2 là: 
//		Email: NguyenVanB@gmail.com 
//		Full name: Nguyễn Văn B
//		Phòng ban: Marketting

		System.out.println("Question 16 - 10:");
		Account[] accountwhile10 = new Account[] {account1, account2, account3, account4};
		int a = 0;
		
		while (a < accountwhile10.length ) {
			System.out.println("Thông tin account thứ " + (a + 1) + " là:");
			System.out.println(" Email: " + accountwhile10[a].email + "\n FullName: " + accountwhile10[a].fullName
								+ "\n Phòng ban: " + accountwhile10[a].department.departmentName);
			a++;
			if (a == 2) {
				break;
			}
		}
		System.out.println();
		
//		Question 16 - 11:
//		In ra thông tin các phòng ban bao gồm: id và name theo định dạng sau:
//		Thông tin department thứ 1 là:
//		Id: 1
//		Name: Sale
//		Thông tin department thứ 2 là:
//		Id: 2
//		Name: Marketing
		
		System.out.println("Question 16 - 11:");
		Department[] departmentwhile11 = new Department[] {department1, department2, department3};
		int d = 0;
		
		while (d < departmentwhile11.length) {
			System.out.println("Thông tin department thứ " + (d + 1) + " là:");
			System.out.println(" Id: " + departmentwhile11[d].departmentId
								+ "\n Name: " + departmentwhile11[d].departmentName);
			d++;
			if (d == 2) {
				break;
			}
		}
		System.out.println();
		
//		Question 16 - 12:
//		Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 10
		
		System.out.println("Question 16 - 12:");
		Department[] departmentwhile12 = new Department[] {department1, department2, department3};
		int de = 0;
		
		while (de < departmentwhile12.length) {
			if (de != 2) { 
			System.out.println("Thông tin department thứ " + (de + 1) + " là:");
			System.out.println(" Id: " + departmentwhile12[de].departmentId
								+ "\n Name: " + departmentwhile12[de].departmentName);
			}
			de++;
		}
		System.out.println();
		
//		Question 16 - 13:
//		In ra thông tin tất cả các account ngoại trừ account thứ 2
		
		System.out.println("Question 16 - 13:");
		Account[] accountwhile13 = new Account[] {account1, account2, account3 };
		int acc = 0;
		
		while (acc < accountwhile13.length) {
			if (acc != 1) {
			System.out.println("Thông tin account thứ " + (acc + 1) + " là:");
			System.out.println(" Id: " + accountwhile13[acc].accountId 
								+ "\n Email: " + accountwhile13[acc].email
								+ "\n UserName: " + accountwhile13[acc].userName
								+ "\n FullName: " + accountwhile13[acc].fullName
								+ "\n Department: " + accountwhile13[acc].department.departmentName
								+ "\n Position: " + accountwhile13[acc].position.positionName);
			}
			acc++;	
		}
		System.out.println();
		
//		Question 16 - 14:
//		In ra thông tin tất cả các account có id < 4
		
		System.out.println("Question 16 - 14:");
		Account[] accountwhile14 = new Account[] {account1, account2, account3, account4};
		int id = 0;
		
		while (id < accountwhile14.length) {
			if (accountwhile14[id].accountId < 4) {
			System.out.println("Thông tin account thứ " + (id + 1) + " là:");
			System.out.println(" Id: " + accountwhile14[id].accountId 
								+ "\n Email: " + accountwhile14[id].email
								+ "\n UserName: " + accountwhile14[id].userName
								+ "\n FullName: " + accountwhile14[id].fullName
								+ "\n Department: " + accountwhile14[id].department.departmentName
								+ "\n Position: " + accountwhile14[id].position.positionName);
			}
			id++;
		}
		System.out.println();
		
//		Question 16 - 15:
//		In ra các số chẵn nhỏ hơn hoặc bằng 20
		
		System.out.println("Question 16 - 15:");
		int i = 0;
		while (i <=20) {
			i++;
			if (i%2 == 1) {
				continue;
			}
			System.out.println(i);
		}
			System.out.println();
		
//		DO-WHILE 
//		Question 17:
//		Làm lại các Question ở phần FOR bằng cách sử dụng DO-WHILE kết hợp với lệnh break, continue
//		Question 17 - 10:
//		In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ theo định dạng như sau:
//		Thông tin account thứ 1 là: 
//		Email: NguyenVanA@gmail.com 
//		Full name: Nguyễn Văn A
//		Phòng ban: Sale
//		Thông tin account thứ 2 là: 
//		Email: NguyenVanB@gmail.com 
//		Full name: Nguyễn Văn B
//		Phòng ban: Marketting
			
			System.out.println("Question 17 - 10:");
			Account[] accountdowhile10 = new Account[] {account1, account2, account3, account4};
			int adw = 0;
			do {
				if (adw < 2) {
				System.out.println("Thông tin account thứ " + (adw + 1) + " là:");
				System.out.println(" Email: " + accountdowhile10[adw].email
									+ "\n FullName: "+ accountdowhile10[adw].fullName
									+ "\n Phòng ban: " + accountdowhile10[adw].department.departmentName);
				}
				adw++;
			} while (adw < accountdowhile10.length );
			
			System.out.println();
			
//		Question 17 - 11:
//		In ra thông tin các phòng ban bao gồm: id và name theo định dạng sau:
//		Thông tin department thứ 1 là:
//		Id: 1
//		Name: Sale
//		Thông tin department thứ 2 là:
//		Id: 2
//		Name: Marketing		
			
			System.out.println("Question 17 - 11:");
			Department[] departmentdowhile11 = new Department[] {department1, department2, department3};
			int ddw = 0;
			
			do {
				if (ddw <= 1) {
				System.out.println("Thông tin department thứ " + (ddw + 1) + " là:");
				System.out.println(" Id: " + departmentdowhile11[ddw].departmentId
									+ "\n Name: " + departmentdowhile11[ddw].departmentName);
				}
				ddw++;
			} while (ddw < departmentwhile11.length);

			System.out.println();	
			
//		Question 17 - 12:
//		Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 10			
			
			System.out.println("Question 17 - 12:");
			Department[] departmentdowhile12 = new Department[] {department1, department2, department3};
			int ddw12 = 0;
			
			do {
				if (ddw12 < 2) {
				System.out.println("Thông tin department thứ " + (ddw12 + 1) + " là:");
				System.out.println(" Id: " + departmentdowhile12[ddw12].departmentId
									+ "\n Name: " + departmentdowhile12[ddw12].departmentName);
				}
				ddw12++;
			} while (ddw12 < departmentwhile12.length);

			System.out.println();
			
//		Question 17 - 13:
//		In ra thông tin tất cả các account ngoại trừ account thứ 2		
			
			System.out.println("Question 17 - 13:");
			Account[] accountdowhile13 = new Account[] {account1, account2, account3 };
			int adw13 = 0;
			
			do {
				if (adw13 != 1) {
				System.out.println("Thông tin account thứ " + (adw13 + 1) + " là:");
				System.out.println(" Id: " + accountwhile13[adw13].accountId 
									+ "\n Email: " + accountdowhile13[adw13].email
									+ "\n UserName: " + accountdowhile13[adw13].userName
									+ "\n FullName: " + accountdowhile13[adw13].fullName
									+ "\n Department: " + accountdowhile13[adw13].department.departmentName
									+ "\n Position: " + accountdowhile13[adw13].position.positionName);
				}
				adw13++;	
			} while (adw13 < accountwhile13.length);
			System.out.println();		
			
//		Question 17 - 14:
//		In ra thông tin tất cả các account có id < 4		
			
			System.out.println("Question 17 - 14:");
			Account[] accountdowhile14 = new Account[] {account1, account2, account3, account4};
			int iddw = 0;
			
			do {
				if (accountdowhile14[iddw].accountId < 4) {
				System.out.println("Thông tin account thứ " + (iddw + 1) + " là:");
				System.out.println(" Id: " + accountdowhile14[iddw].accountId 
									+ "\n Email: " + accountdowhile14[iddw].email
									+ "\n UserName: " + accountdowhile14[iddw].userName
									+ "\n FullName: " + accountdowhile14[iddw].fullName
									+ "\n Department: " + accountdowhile14[iddw].department.departmentName
									+ "\n Position: " + accountdowhile14[iddw].position.positionName);
				}
				iddw++;
			} while (iddw < accountdowhile14.length);
			System.out.println();	
			
//		Question 17 - 15:
//		In ra các số chẵn nhỏ hơn hoặc bằng 20
			
			System.out.println("Question 17 - 15:");
			int idw = 0;
			do {
				if (idw%2 == 0) {
					System.out.println(idw);
				} idw++;
			} while (idw <=20);
					
			
		
	}

}
