package com.vti.academy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import com.vti.academy.enums.PositionName;

public class Exercise5_InputFromConsole {
	static Random random = new Random();
	public static void main(String[] args) throws ParseException {

		
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
		
		// add groupArray
		Group[] groupArr = new Group[] {group1, group2, group3, group4};
		
		Scanner scanner = new Scanner(System.in);
		
//		Question 1:
		
//		question1(scanner);
		
//	Question 2:
		
//		question2(scanner);
	
//	Question 3:
		
//		question3(scanner);
			
//	Question 4:
		
//		question4(scanner);
	
//	Question 5:
		
		question5(scanner);
		
//	Question 6:
		
//		question6(scanner);
		
//	Question 7:
		
//		question7(scanner);	
		
//	Question 8:
	
//		question8(scanner);
		
//	Question 9:

//		question9(accountArr, groupArr, scanner);
		
//	Question 10:
	
//		question10(accountArr, groupArr, scanner);
		
//	Question 11:		
		
//		question11(accountArr, groupArr, scanner);
		
		
		scanner.close();
		
	}
	

//	  Question 1: Viết lệnh cho phép người dùng nhập 3 số nguyên vào chương trình

	public static void question1(Scanner scanner) {
		System.out.println("Mời bạn nhập một số nguyên: ");
		int a = scanner.nextInt();
		System.out.println("Mời bạn nhập một số nguyên: ");
		int b = scanner.nextInt();
		System.out.println("Mời bạn nhập một số nguyên: ");
		int c = scanner.nextInt();
		System.out.println("Số vừa nhập là: " + a + ", " + b + ", " + c);
	}
	

//	  Question 2: Viết lệnh cho phép người dùng nhập 2 số thực vào chương trình

	public static void question2(Scanner scanner) {
		System.out.println("Mời bạn nhập một số thực: ");
		float a = scanner.nextFloat();
		System.out.println("Mời bạn nhập một số thực: ");
		float b = scanner.nextFloat();
		System.out.println("Số vừa nhập là: " + a + ", " + b);
	}	

//	  Question 3: Viết lệnh cho phép người dùng nhập họ và tên

	public static void question3(Scanner scanner) {
		System.out.println("Mời bạn nhập họ và tên: ");
		String hoten = scanner.nextLine();
		System.out.println("Họ và tên là: " + hoten);
	}
	
//	  Question 4: Viết lệnh cho phép người dùng nhập vào ngày sinh nhật của họ

	public static void question4(Scanner scanner) throws ParseException {
		System.out.println("Mời bạn nhập ngày sinh theo định dạng day-month-year: ");
		String dateInput = scanner.next();

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = dateFormat.parse(dateInput);
		System.out.println("ngày sinh là: " + date);
	}
	
//	 *Question 5: Viết lệnh cho phép người dùng tạo account (viết thành method) Đối
//	 với property Position, Người dùng nhập vào 1 2 3 4 5 và vào chương trình sẽ
//	 chuyển thành Position.Dev, Position.Test, Position.ScrumMaster, Position.PM
 
	public static void question5(Scanner scanner) {
		System.out.println("Tạo account");
		Account newAccount = new Account();
		System.out.println("Nhập id");
		int id = scanner.nextInt();
		
		System.out.println("Nhập email");
		String email = scanner.next();
		
		scanner.nextLine();
		System.out.println("Nhập userName");
		String userName = scanner.nextLine();
		
		System.out.println("Nhập fullName");
		String fullName = scanner.nextLine();
		
		System.out.println("Nhập departmentName");
		String departmentName = scanner.nextLine();
		
		System.out.println("Mời bạn nhập mã vị trí (số bất kì từ 1 đến 4): ");
		int num = scanner.nextInt();
		String positionName = "";
		switch (num) {
		case 1:
			positionName = PositionName.POSITION_DEV.getPositionName();
			break;
		case 2:
			positionName = PositionName.POSITION_PM.getPositionName();
			break;
		case 3:
			positionName = PositionName.POSITION_PM.getPositionName();
			break;
		case 4:
			positionName = PositionName.POSITION_SCRUM_MASTER.getPositionName();
			break;
		default:
			positionName = String.valueOf(num);
			break;
			}
		// tạo đối tượng
		Department department1 = new Department();
		department1.departmentId = 1;
		department1.departmentName = departmentName;
		
		Position position1 = new Position();
		position1.positionId = 1;
		position1.positionName = positionName;
		
		// Tạo account
		newAccount.accountId = id;
		newAccount.email = email;
		newAccount.userName = userName;
		newAccount.fullName = fullName;
		newAccount.department = department1;
		newAccount.position = position1;
		
			System.out.println("Account của bạn đã được tạo:"
								+ "\nid: " + newAccount.accountId
								+ "\nemail: " + newAccount.email
								+ "\nusername: " + newAccount.userName
								+ "\nfullname: " + newAccount.fullName
								+ "\ndepartmentName: " + newAccount.department.departmentName
								+ "\npositionName: " + newAccount.position.positionName);
	
	}
	

//	  Question 6: Viết lệnh cho phép người dùng tạo department(viết thành method)

	public static void question6(Scanner scanner) {
		System.out.println("Tạo department");
		System.out.println("Mời bạn nhập id: ");
		byte departmentId = scanner.nextByte();

		scanner.nextLine();
		System.out.println("Mời bạn nhập tên phòng: ");
		String departmentName = scanner.nextLine();
		
		// tao doi tuong
		Department department = new Department();
		department.departmentId = departmentId;
		department.departmentName = departmentName;

		System.out.println("Phòng ban của bạn: ");
		System.out.println("departmentId: " + department.departmentId);
		System.out.println("departmentName: " + department.departmentName);
	}
	
//	 Question 7: Nhập số chẵn từ console

	public static void question7(Scanner scanner) {
		System.out.println("Mời bạn nhập 1 số chẵn: ");
		int num = scanner.nextInt();

		if (num % 2 != 0) {
			System.out.println("số bạn vừa nhập là số lẻ");
		} else {
			System.out.println("số bạn vừa nhập là số chẵn");
		}
	}
	
//	 *Question 8: Viết chương trình thực hiện theo flow sau:
//	Bước 1: Chương trình in ra text "mời bạn nhập vào chức năng muốn sử dụng"
//	Bước 2: Nếu người dùng nhập vào 1 thì sẽ thực hiện tạo account(question5)
//	Nếu người dùng nhập vào 2 thì sẽ thực  hiện chức năng tạo department (question6)
//	Nếu người dùng nhập vào số khác thì in ra text "Mời bạn nhập lại" và quay trở lại bước 1

	public static void question8(Scanner scanner) {
		boolean isOk = false;
		while (isOk == false) {
			System.out.println("mời bạn nhập vào chức năng muốn sử dụng: ");
			int num = scanner.nextInt();

			if (num == 1) {
				question5(scanner); // tạo account
				isOk = true;
			} else if (num == 2) {
				question6(scanner); // tạo department
				isOk = true;
			} else {
				System.out.println("Mời bạn nhập lại: ");
			}
		}
	}
	
//	  Question 9: Viết method cho phép người dùng thêm group vào account theo flow sau: 
//	  Bước 1: In ra tên các usernames của user cho người dùng xem 
//	  Bước 2: Yêu cầu người dùng nhập vào username của account 
//	  Bước 3: In ra tên các group cho người dùng xem 
//	  Bước 4: Yêu cầu người dùng nhập vào tên của group 
//	  Bước 5: Dựa vào username và tên của group người dùng vừa chọn, hãy thêm account vào group đó .

	public static void question9(Account[] accountArr, Group[] groupArr, Scanner scanner) {
		
		boolean isCheckGroup = false;
		boolean isCheckAccount = false;
		for (Account account : accountArr) {
			System.out.println("Tên các username: " + account.userName);
		}

		System.out.println("mời bạn nhập vào username của account: ");
		String userName = scanner.next();

		for (Group group : groupArr) {
			System.out.println("Tên các group: " + group.groupName);
		}
		scanner.nextLine();
		System.out.println("mời bạn nhập vào tên của Group: ");
		String groupName = scanner.nextLine();

		Group groupAdd = null;
		for (Group group : groupArr) {
			if (groupName.equals(group.groupName)) {
				groupAdd = group;
				isCheckGroup = true;
			}
		}
		for (Account account : accountArr) {
			if (userName.equals(account.userName)) {
				
				account.groups = Arrays.copyOf(account.groups, account.groups.length + 1);
				account.groups[account.groups.length - 1] = groupAdd;
				System.out.println("account " + account.userName
									+ " đã thêm vào group " + groupAdd.groupName);
				System.out.println("kết quả: account " + account.userName 
									+ "có mặt trong những group: ");
				for (Group group : account.groups) {
					System.out.println("\t" + group.groupName);
				}

			}
		}
		if(!isCheckGroup) {
			System.out.println("Group bạn nhập không tồn tại trên hệ thống");
		}
		if(!isCheckAccount) {
			System.out.println("Account bạn nhập không tồn tại trên hệ thống");
		}
	}
	
//	  *Question 10:
//	Tiếp tục Question 8 và Question 9 Bổ sung thêm vào bước 2 của Question 8 như sau: 
//	Nếu người dùng nhập vào 3 thì sẽ thực hiện chức năng thêm group vào account
//	Bổ sung thêm Bước 3 của Question 8 như sau:
//	Sau khi người dùng thực hiện xong chức năng ở bước 2 thì in ra dòng text để hỏi người dùng
//	"Bạn có muốn thực hiện chức năng khác không?".
//	Nếu người dùng chọn "Có" thì
//	quay lại bước 1, nếu người dùng chọn "Không" thì kết thúc chương trình (sử
//	dụng lệnh return để kết thúc chương trình)

	public static void question10(Account[] accountArr, Group[] groupArr, Scanner scanner) {
		
		boolean isOk = false;
		while (isOk == false) {
			System.out.println("mời bạn nhập vào chức năng muốn sử dụng: ");
			int num = scanner.nextInt();
			if (num == 1) {
				question5(scanner); // tạo account
				isOk = true;
			} else if (num == 2) {
				question6(scanner); // tạo department
				isOk = true;
			} else if (num == 3) {
				question9(accountArr, groupArr, scanner); // add group vào account
				isOk = true;
			} else {
				System.out.println("Mời bạn nhập lại: ");
			}

			if (isOk == true) {
				System.out.println("Bạn có muốn thực hiện chức năng khác không? Có: nhập 1, Không: nhập 0");
				int yN = scanner.nextInt();
				if (yN == 1) {
					isOk = false;
				} else {
					System.out.println("Kết thúc!");
					return;
				}
				
			}
		}
	}
	
//	 *Question 11: Tiếp tục Question 10 Bổ sung thêm vào bước 2 của Question 8 như
//	sau: Nếu người dùng nhập vào 4 thì sẽ thực hiện chức năng thêm account vào 1
//	nhóm ngẫu nhiên, chức năng sẽ được cài đặt như sau:
//	Bước 1: In ra tên các usernames của user cho người dùng xem
//	Bước 2: Yêu cầu người dùng nhập vào username của account
//	Bước 3: Sau đó chương trình sẽ chọn ngẫu nhiên 1 group
//	Bước 4: Thêm account vào group chương trình vừa chọn ngẫu nhiên

	public static void question11(Account[] accArr, Group[] grArr, Scanner scanner) {

		boolean isOk = false;
		while (!isOk) {
			System.out.println("mời bạn nhập vào chức năng muốn sử dụng: ");
			int num = scanner.nextInt();
			if (num == 1) {
				question5(scanner);// tạo account
				isOk = true;
			} else if (num == 2) {
				question6(scanner);// tạo department
				isOk = true;
			} else if (num == 3) {
				question9(accArr, grArr, scanner);// add group vào account
				isOk = true;
			} else if (num == 4) {
				for (Account acc : accArr) {
					System.out.println("Tên các username: " + acc.userName);
				}

				System.out.println("mời bạn nhập vào username của account: ");
				String userName = scanner.next();	
				int i = random.nextInt(grArr.length);
				Group groupAdd = grArr[i];
				boolean isCheckAcc = false; // biến check account có tồn tại trong hệ thống không
				for (Account acc : accArr) {
					if (userName.equals(acc.userName)) {
						groupAdd.accounts = Arrays.copyOf(groupAdd.accounts, groupAdd.accounts.length + 1);
						groupAdd.accounts[groupAdd.accounts.length - 1] = acc;
						System.out.println("account " + acc.userName + " đã thêm vào group " + groupAdd.groupName);
						System.out.println("kết quả: group " + groupAdd.groupName + "có những account: ");
						for (Account acc1 : groupAdd.accounts) {
							System.out.println("\t" + acc1.userName);
						}
						isCheckAcc = true; // nếu có tồn tại acc thì biến check = true
					}
				}
				if(isCheckAcc == false) {
					System.out.println("không có account trong hệ thống");
				}

				isOk = true;
			}else {
				System.out.println("Mời bạn nhập lại: ");
				isOk = false;
			}

			if (isOk) {
				System.out.println("Bạn có muốn thực hiện chức năng khác không? Có: nhập 1, Không: nhập 0");
				int yN = scanner.nextInt();
				if (yN == 1) {
					isOk = false;
				} else {
					System.out.println("Kết thúc!");
					return;
				}
			}
		}
	}

	
	
	
	
	
	
	
}