package com.vti.entiny;

import java.util.Scanner;

import com.vti.entiny.enums.PositionName;

public class Position {
	
	private byte positionId;
	private PositionName positionName;
	
	Scanner scanner = new Scanner(System.in);
	ScannerUtils scannerUtils = new ScannerUtils(scanner);
	
	public Position() {
		
		System.out.println("Nhập ID cho Position");
		this.positionId = (byte) scannerUtils.inputInt("Nhập sai! Vui lòng nhập ID dưới dạng số, nhập lại.");
		
		
		System.out.println("Nhập tên cho Position có số từ 1 => 4");
		System.out.println("1.Dev(Mặc Định), 2.Test, 3.Scrum Maste, 4.PM");
		int index = scannerUtils.inputInt("Nhập sai! Vui lòng nhập số từ 1 => 4, nhập lại.");
		PositionName[] positionNames = PositionName.values();
		for (PositionName positionName : positionNames) {
			System.out.println(positionName.getPositionName());
		}
		this.positionName = index >= 1 && index <=4 ? PositionName.values()[index - 1] : PositionName.DEV;

	}

	@Override
	public String toString() {
		return "Position [positionId= " + positionId 
				+ ", positionName= " + positionName + "]";
	}


}
