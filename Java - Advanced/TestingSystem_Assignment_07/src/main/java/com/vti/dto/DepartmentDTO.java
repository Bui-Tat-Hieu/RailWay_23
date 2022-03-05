package com.vti.dto;

import com.vti.entity.Department;

import lombok.Data;

@Data
public class DepartmentDTO {


	private String departmentName;

	

	public Department toEntity() {
		return new Department(departmentName);
	}



	public DepartmentDTO() {
		super();
	}
	
	
	
}
