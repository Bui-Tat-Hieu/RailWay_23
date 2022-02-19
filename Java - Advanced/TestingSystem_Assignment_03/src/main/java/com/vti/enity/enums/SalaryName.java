package com.vti.enity.enums;

public enum SalaryName {
	
	DEV("600"), 
	TEST("700"),
	SCRUM_MASTER("1500"),
	PM("2000");
	
	
	private String salaryName;

	private SalaryName(String salaryName) {
		this.salaryName = salaryName;
	}

	public String getSalaryName() {
		return salaryName;
	}

	public static SalaryName toEnum(String sqlSalaryName) {
		for (SalaryName item : SalaryName.values()) {
			if (item.getSalaryName().equals(sqlSalaryName)) {
				return item;
			}
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
