package com.vti.utils;

import java.util.Scanner;

public class ScannerUtils {
	
	private static Scanner scanner;
	
	// khởi tạo scanner
	public static void initScannerUtils() {
		if (scanner == null) {
			scanner = new Scanner(System.in);
		}
	}
	
	// nhập số kiểu int(Số nguyên)
	public static int inputInt(String errorMessage) {
		initScannerUtils();
		int output = 0;
		boolean isOk = false;
		while (isOk == false) {
			try {
				isOk = true;
				String input = scanner.nextLine();
				output = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				isOk = false;
				System.out.println(errorMessage);
			}
		}
		return output;
	}
	
	// nhập số kiểu float(số thực)
	public static float inputFloat(String errorMessage) {
		initScannerUtils();
		float output = 0;
		boolean isOk = false;
		while (isOk == false) {
			try {
				isOk = true;
				String input = scanner.nextLine();
				output = Float.parseFloat(input);
			} catch (NumberFormatException e) {
				isOk = false;
				System.out.println(errorMessage);
			}
		}
		return output;
	}
	
	// nhập số kiểu double (số thực)
	public static double inputDouble(String errorMessage) {
		initScannerUtils();
		double output = 0;
		boolean isOk = false;
		while (isOk == false) {
			try {
				isOk = true;
				String input = scanner.nextLine();
				output = Double.parseDouble(input);
			} catch (NumberFormatException e) {
				isOk = false;
				System.out.println(errorMessage);
			}
		}
		return output;
	}

	// nhập string(ký tự)
	public static String inputString() {
		initScannerUtils();
		return scanner.nextLine();
	}
	
	// đóng scanner
	public static void close() {
		if(scanner!=null) {
			scanner.close();
		}
	}
	

}
