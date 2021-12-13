package com.vti.entiny;

public class PrimaryStudent extends Student {
	
	private static int primaryCount;
	
	public PrimaryStudent() {
		super();
		primaryCount++;
	}

	public static int getPrimaryCount() {
		return primaryCount;
	}

	public static void setPrimaryCount(int primaryCount1) {
		PrimaryStudent.primaryCount = primaryCount1;
	}



}
