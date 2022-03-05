package com.vti.backend.businesslayer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.entity.Department;

public interface IDepartmentService {
	
	
	public Department getDepartmentById(short id);
	
	public Department getDepartmentByName(String departmentName);
	
	public void createDepartment(Department department);
	
	public void updateDepartment(Department department);
	
	public void deleteDepartment(short id);
	
	public boolean isDepartmentExistsById(short id);
	
	public boolean isDepartmentExistsByName(String departmentName);
	
	public Page<Department> getAllDepartments(Pageable pagable);

}
