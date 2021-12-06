package com.vti.backend;

import java.util.Scanner;

import com.vti.entiny.VietnamesePhone;

public class Exercise6_Abstraction {
	
	Scanner scanner;
	
	public Exercise6_Abstraction() {
		scanner = new Scanner(System.in);
	}

	public void	question1() {
		VietnamesePhone vnPhone = new VietnamesePhone();
		
		while (true) {
			System.out.println("\n\tLựa chọn chức năng bạn muốn sử ");
			System.out.println("\t1. InsertContact");
			System.out.println("\t2. RemoveContact");
			System.out.println("\t3. UpdateContact");
			System.out.println("\t4. SearchContact");
			System.out.println("\t5. ShowContact");
			System.out.println("\t6. Thoát khỏi chương trình.");
			
			int menuChoose = scanner.nextInt();
			switch (menuChoose) {
			case 1 : {
				System.out.println("\tNhập tên");
				scanner.nextLine();
				String name = scanner.nextLine();
				System.out.println("\tNhập phone");
				String phone = scanner.nextLine();
				vnPhone.insertContact(name, phone);
				break;
			}
			case 2 : {
				System.out.println("\tNhập tên");
				scanner.nextLine();
				String name = scanner.nextLine();
				vnPhone.removeContact(name);
				break;
			}
			case 3 :{
				System.out.println("\tNhập tên");
				scanner.nextLine();
				String name = scanner.nextLine();
				System.out.println("\tNhập phone mới");
				String newPhone = scanner.nextLine();
				vnPhone.updateContact(name, newPhone);
				break;
			}
			case 4 : {
				System.out.println("\tNhập tên");
				scanner.nextLine();
				String name = scanner.nextLine();
				vnPhone.searchContact(name);
				break;
			}
			case 5 : {
				vnPhone.showContact();
				break;
			}
			case 6 : {
				scanner.close();
				return;
			}
			default :
				System.out.println("Nhập đúng số trên menu");
			}

		}
		
	}
	
}
