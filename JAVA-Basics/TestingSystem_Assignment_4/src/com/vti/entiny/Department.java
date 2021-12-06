package com.vti.entiny;

public class Department {
	
	private byte departmentId;
	private String departmentName;
	
// a
	public Department() {
		super();
	}
	
// b
	public Department(String departmentName) {
		super();
		this.departmentId = 0;
		this.departmentName = departmentName;
	}


	@Override
	public String toString() {
		return "Department [departmentId=" + getDepartmentId() + ", departmentName=" + getDepartmentName() + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		String objName = ((Department) obj).getDepartmentName();
		return this.getDepartmentName().equals(objName);
	}

	public byte getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int i) {
		this.departmentId =  (byte) i;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	
	
	
	
	

}

	
