package com.vti.entiny;

import java.util.Scanner;

public class Department {
	
//	public static int COUNT;
	private byte departmentId;
	private String departmentName;
	
	Scanner scanner = new Scanner(System.in);
	ScannerUtils scannerUtils = new ScannerUtils(scanner);
	
	public Department() {
		
		System.out.println("Nhập ID cho department");
		this.departmentId = (byte) scannerUtils.inputInt("Nhập sai! Vui lòng nhập ID dưới dạng số, nhập lại.");
		
		System.out.println("Nhập tên cho department");
		this.departmentName = scannerUtils.inputString();

	}

	public Department(byte departmentId, String departmentName) {
		super();
//		COUNT++;
		this.departmentId = departmentId; // (byte) COUNT
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "Department [departmentId= " + departmentId 
				+ ", departmentName= " + departmentName + "]";
	}
	
	

}
