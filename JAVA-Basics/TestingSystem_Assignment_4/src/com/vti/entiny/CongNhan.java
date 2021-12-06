package com.vti.entiny;

public class CongNhan extends CanBo {

	

	private byte bac;
	
	public CongNhan(String name, byte age, String gender, String homeTown, byte bac) {
		super(name, age, gender, homeTown);
		this.bac = bac;
		
	}

	@Override
	public String toString() {
		return "CongNhan [Name=" + getName() 
				+ ", Age=" + getAge() 
				+ ", Gender=" + getgender() 
				+ ", HomeTown=" + getHomeTown() 
				+ ", Bậc=" + bac + "]";
	}
	
	
	
	
	
}
