package com.vti.entiny.enums;

public enum Gender {
	
	GENDER_NAM("Nam"),
	GENDER_NU("Nữ"),
	GENDER_UNKOWN("Unkown");
	
	private String gender;

	Gender(String gender) {
		this.gender = gender;
	}
	
	public String getGender() {
		return gender;
	}

}
