package com.vti.entiny;

public class SecondaryStudent extends Student {

	private static int secondaryCount;
	
	public SecondaryStudent() {
		super();
		secondaryCount++;
//		setSecondaryCount(getSecondaryCount() + 1);
	}

	public static int getSecondaryCount() {
		return secondaryCount;
	}

	public static void setSecondaryCount(int secondaryCount1) {
		SecondaryStudent.secondaryCount = secondaryCount1;
	}


}
