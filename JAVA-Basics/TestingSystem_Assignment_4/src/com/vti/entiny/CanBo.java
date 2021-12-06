package com.vti.entiny;

public class CanBo {

	
	private String name;
	private byte age;
	private String gender;
	private String homeTown;
	
	public CanBo(String name, byte age, String gender, String homeTown) {
		super();
		this.setName(name);
		this.setAge(age);
		this.setSex(gender);
		this.setHomeTown(homeTown);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public String getgender() {
		return gender;
	}

	public void setSex(String gender) {
		this.gender = gender;
	}

	public String getHomeTown() {
		return homeTown;
	}

	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}

	@Override
	public String toString() {
		return "CanBo [name=" + name 
				+ ", age=" + age 
				+ ", gender=" + gender
				+ ", homeTown=" + homeTown + "]";
	}
	
	
	
	
	
}
