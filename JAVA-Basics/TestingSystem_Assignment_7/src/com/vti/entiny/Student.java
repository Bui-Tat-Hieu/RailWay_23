package com.vti.entiny;


public class Student {
	
	private int id;
	private String name;
	private static float moneyGroup;
	private static String college;
	private static int countStudent;

	
	public Student() {
		super();
		countStudent++;
	}
	
	public Student(String name) {
		super();
		this.id = countStudent;
		this.name = name;
		Student.moneyGroup += 100;
		Student.countStudent ++;
	}
	
	public static void nopTien(float amount) {
		Student.moneyGroup += amount;
	}
	
	public static void layTien(float amount) {
		Student.moneyGroup -= amount;
	}
	

	@Override
	public String toString() {
		return "Student [id= " + id 
				+ ", name= " + name 
				+ ", college= " + college + "]";
	}
	
	public static void thayDoiCollege() {
		college = "Đại học công nghệ";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static float getMoneyGroup() {
		return moneyGroup;
	}

	public static void setMoneyGroup(float moneyGroup) {
		Student.moneyGroup = moneyGroup;
	}
 
	public static String getCollege() {
		return college;
	}

	public static void setCollege(String newCollege) {
		Student.college = newCollege;
	}

	public static int getCountStudent() {
		return countStudent;
	}

	public static void setCountStudent(int countStudent1) {
		countStudent = countStudent1;
	}
	

}
