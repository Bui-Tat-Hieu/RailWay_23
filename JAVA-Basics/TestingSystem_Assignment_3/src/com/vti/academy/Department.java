package com.vti.academy;

public class Department {
	byte departmentId;
	String departmentName;
	
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		String objName = ((Department) obj).departmentName;
		return this.departmentName.equals(objName);
	}
	
	
	
	
	
	

}

	
