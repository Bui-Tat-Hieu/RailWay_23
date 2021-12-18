package com.vti.entiny;

import java.util.Scanner;

public class ScannerUtils {
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static int inputInt(String errorMessage) {
		int output = 0;
		boolean isOk = false;
		while (isOk == false) {
			try {
				isOk = true;
				String input = scanner.nextLine();
				output = Integer.parseInt(input);
				
			} catch (Exception e) {
				isOk = false;
				System.out.println(errorMessage);
			}
		}
		return output;
	}
	
	public static float inputFloat(String errorMessage) {
		float output = 0;
		boolean isOk = false;
		while (isOk == false) {
			try {
				isOk = true;
				String input = scanner.nextLine();
				output = Float.parseFloat(input);
				
			} catch (Exception e) {
				isOk = false;
				System.out.println(errorMessage);
			}
		}
		return output;
	}
	
	public static double inputDouble(String errorMessage) {
		double output = 0;
		boolean isOk = false;
		while (isOk == false) {
			try {
				isOk = true;
				String input = scanner.nextLine();
				output = Double.parseDouble(input);
				
			} catch (Exception e) {
				isOk = false;
				System.out.println(errorMessage);
			}
		}
		return output;
	}

	public static String inputString() {
		
		return scanner.nextLine();
	
	}
	

}
