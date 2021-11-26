package com.vti.academy;

import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Exercise4_String {

	public static void main(String[] args) {
		

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
		group3.groupName = "group Java";
		group3.createDate = new Date();
		
		Group group4 = new Group();
		group4.groupId = 4;
		group4.groupName = "Java";
		group4.createDate = new Date();
		
		Group[] groupArr = new Group[] {group1, group2, group3, group4,};
		
		Scanner scanner = new Scanner(System.in);
		
//Question 1:
		
//		question1(scanner);
		
//Question 2:
		
//		question2(scanner);	
		
//Question 3:
		
//		question3(scanner);
//		question3();
//Question 4:
		
//		question4(scanner);
		
//Question 5:
		
//		question5(scanner);
		
//Question 6:
		
//	question6(scanner);
//	question66(scanner);
	
//Question 7:
		
//		question7(scanner);
		
//Question 8:
		
//		question8(groupArr, scanner);
		
//Question 9:
		
//		question9(groupArr, scanner);
		
//Question 10 (Optional):		
		
//		question0();
		
//Question 11 (Optional):
		
//		question();
		
//Question 12 (Optional):
		
//		question();
		
//Question 13 (Optional):
		
//		question3();
		
//Question 14 (Optional):
		
//		question4();
		
//Question 15 (Optional):
		
//		question5();
		
//Question 16 (Optional):
		
//		question6();
		
		scanner.close();
		
}

//Question 1:
//	Nhập một xâu kí tự, đếm số lượng các từ trong xâu kí tự đó (các từ có thể cách nhau bằng nhiều khoảng trắng );
	
	public static void question1(Scanner scanner) {
		
//		System.out.println("\tQuestion 1:");
//		System.out.print("Mời bạn nhập kí tự: ");
//		String s1 = scanner.nextLine();
//		System.out.println("Số lượng kí tự là: " + s1.length());
		
		System.out.println("\tQuestion 1:");
		String s1;
		System.out.println("Mời bạn nhập kí tự: ");
		s1 = scanner.nextLine().trim();
		if(s1.isEmpty()||s1==null) {
			System.out.println("so tu la: 0");
		}else {
		String[] words = s1.split("\s+");
		System.out.println("Số lượng kí tự trong xau là: " + words.length);
		}
		
	}

//Question 2:
//	Nhập hai xâu kí tự s1, s2 nối xâu kí tự s2 vào sau xâu s1;
	
	public static void question2(Scanner scanner) {
		
		System.out.println("\tQuestion 2:");
		System.out.print("Mời bạn nhập kí tự s1: ");
		String s1 = scanner.nextLine();
		System.out.print("Mời bạn nhập kí tự s2: ");
		String s2 = scanner.nextLine();
		System.out.println("\nXâu kí tự là: " + s1 + " " + s2);
		
	}
	
	
//Question 3:
//	Viết chương trình để người dùng nhập vào tên và kiểm tra, nếu tên chư viết hoa chữ cái đầu thì viết hoa lên

	public static void question3(Scanner scanner) {
		System.out.println("Nhập vào tên");
		String name = scanner.nextLine();
		String firstword = name.substring(0, 1).toUpperCase();
		String lastword = name.substring(1);
		String result = "";
		if (!Pattern.matches("[A-Z]", firstword)) {
			result = firstword.toUpperCase().concat(lastword);
		} else {
			result = firstword.concat(lastword);
		}
		System.out.println("Tên của bạn: " + result);
	}
	

	
	private static void question3() {
		System.out.println("Question 3");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Mời bạn nhập vào tên bạn: ");
		String name = scanner.nextLine();
		String result = "";
		
		for (String ten : name.trim().split("\\s+")) {
			String nameCharAt0 = String.valueOf(ten.charAt(0));
			if (nameCharAt0.equals(nameCharAt0.toLowerCase())) {
				result += nameCharAt0.toUpperCase() + ten.substring(1) + " ";
			} else {
				result += ten + " ";
			}
		}
		
		scanner.close();
		System.out.println("Tên của bạn: " + result);
	}
	
//Question 4:
//	Viết chương trình để người dùng nhập vào tên in từng ký tự trong tên của người dùng ra
//	VD:
//	Người dùng nhập vào "Nam", hệ thống sẽ in ra 
//	"Ký tự thứ 1 là: N"
//	"Ký tự thứ 1 là: A"
//	"Ký tự thứ 1 là: M"
	
	public static void question4(Scanner scanner) {
		
		System.out.println("\tQuestion 4:");
		System.out.println("Mời bạn nhập vào tên: ");
		String s1 = scanner.nextLine();
		 		s1 = s1.toUpperCase().replaceAll("\s+", "");
		 for (int i = 0; i < s1.length(); i++) {
		System.out.println("Ký tự thứ " + (i + 1) + " là: " + s1.charAt(i));
		 }
	}
	
//	Question 5:
//	Viết chương trình để người dùng nhập vào họ, sau đó yêu cầu người dùng nhập vào tên
//	và hệ thống sẽ in ra họ và tên đầy đủ
	
	public static void question5(Scanner scanner) {
		
		System.out.println("\tQuestion 5:");
		System.out.print("Mời bạn nhập họ: ");
		String s1 = scanner.nextLine();
		System.out.print("Mời bạn nhập tên: ");
		String s2 = scanner.nextLine();
		System.out.println("\nHọ và tên đầy đủ là: " + s1 + " " + s2);
		
	}

//Question 6:
//	Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ
//	và sau đó hệ thống sẽ tách ra họ, tên , tên đệm
//	Người dùng nhập vào "Nguyễn Văn Nam" Hệ thống sẽ in ra
//	"Họ là: Nguyễn" "Tên đệm là: Văn" "Tên là: Nam"
	
	public static void question6(Scanner scanner) {
		
		System.out.println("\tQuestion 6:");
		System.out.print("Mời bạn nhập họ và tên: ");
		String s1 = scanner.nextLine();
		String[] word = s1.split(" ");
		String ho = word[0];
		String tendem = word[1];
		String ten = word[2];
		System.out.println("Họ là: " + ho
							+ "\nTên đệm là: " + tendem
							+ "\nTên là: " + ten);
	}
	
	public static void question66(Scanner scanner) {
		
		System.out.println("\tQuestion 6:");
		System.out.print("Mời bạn nhập họ và tên: ");
		String fullname = scanner.nextLine();
		String[] result = fullname.split(" ");
		
		switch (result.length) {
		case 2:
			System.out.println("Họ là: " + result[0]);
			System.out.println("Tên là: " + result[1]);
			break;
		case 3:
			System.out.println("Họ là: " + result[0]);
			System.out.println("Tên đệm là: " + result[1]);
			System.out.println("Họ là: " + result[2]);
			break;
		case 4:
			System.out.println("Họ là: " + result[0]);
			System.out.println("Tên đệm là: " + result[1]);
			System.out.println("Họ là: " + result[2] + " " + result[3]);
			break;
		default:
			System.out.println("Có quá nhiều trường hợp tên không theo quy tắc ");
		}
	}
	

//Question 7:
//	Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và chuẩn hóa họ và tên của họ như sau:
//	a) Xóa dấu cách ở đầu và cuối và giữa của chuỗi người dùng nhập vào
//	VD: Nếu người dùng nhập vào " nguyễn văn nam" thì sẽ chuẩn hóa thành "nguyễn văn nam"
//	b) Viết hoa chữ cái mỗi từ của người dùng
//	VD: Nếu người dùng nhập vào " nguyễn văn nam" thì sẽ chuẩn hóa thành "Nguyễn Văn Nam"
	
	public static void question7(Scanner scanner) {
		System.out.println("\tQuestion 7:");
		System.out.println("Mời bạn nhập vào họ và tên");
		String hovaten = scanner.nextLine().trim();
		
		String[] hotenArr = hovaten.split("\s+");
		String result = "";
		for (String hoten : hotenArr) {
			result += String.valueOf(hoten.charAt(0)).toUpperCase().concat(hoten.substring(2)).concat(" ");
		}
		
		System.out.printf("Họ và tên là: %s %n", result.trim());
		
	}

//Question 8:
//	In ra tất cả các group có chứa chữ "Java"
	
	public static void question8(Group[] groupArr, Scanner scanner) {
		System.out.println("\tQuestion 8:");
		for (Group group : groupArr) {
		if (group.groupName.contains("Java")) {
			System.out.println("groupId: " + group.groupId
								+ "\ngroupName: " + group.groupName);
			}
		}

	}
	
//Question 9:
//	In ra tất cả các group "Java"
	
	public static void question9(Group[] groupArr, Scanner scanner) {
		System.out.println("\tQuestion 9:");
		for (Group group : groupArr) {
		if (group.groupName.equals("Java")) {
			System.out.println("groupId: " + group.groupId
								+ "\ngroupName: " + group.groupName);
			}
		}

	}	
//Question 10 (Optional):
//	Kiểm tra 2 chuỗi có là đảo ngược của nhau hay không. Nếu có xuất ra “OK” ngược lại “KO”.
//	Ví dụ “word” và “drow” là 2 chuỗi đảo ngược nhau.
//Question 11 (Optional):
//	Count special Character Tìm số lần xuất hiện ký tự "a" trong chuỗi
//Question 12 (Optional): 
//	Reverse String Đảo ngược chuỗi sử dụng vòng lặp
//Quetion 13 (Optional):
//	String not contains digit
//	Kiểm tra một chuỗi có chứa chữ số hay không, nếu có in ra false ngược lại true.
//	Ví dụ:
//	"abc" => true
//	"1abc", "abc1", "123", "a1bc", null => false
//Question 14 (Optional):
//	Replace character
//	Cho một chuỗi str, chuyển các ký tự được chỉ định sang một ký tự khác cho trước.
//	Ví dụ:
//	"VTI Academy" chuyển ký tự 'e' sang '*' kết quả " VTI Acad*my"
//Question 15 (Optional):
//	Revert string by word
//	Đảo ngược các ký tự của chuỗi cách nhau bởi dấu cách mà không dùng thư viện.
//	Ví dụ: " I am developer " => "developer am I".
//	Các ký tự bên trong chỉ cách nhau đúng một dấu khoảng cách.
//	Gợi ý: Các bạn cần loại bỏ dấu cách ở đầu và cuối câu, thao tác cắt chuỗi theo dấu cách
//Question 16 (Optional):
//	Cho một chuỗi str và số nguyên n >= 0. Chia chuỗi str ra làm các phần bằng nhau với n ký tự. Nếu chuỗi không chia được thì xuất ra màn hình “KO”.

















}
