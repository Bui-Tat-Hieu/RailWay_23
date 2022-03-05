package com.vti.backend.businesslayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vti.backend.datalayer.IDepartmentRepository;
import com.vti.entity.Department;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

	@Autowired
	private IDepartmentRepository repository;
	
//	@Override
//	public List<Department> getAllDepartment() {
//		return repository.findAll();
//	}

	@Override
	public Department getDepartmentById(short id) {
		return repository.findById(id).get();
	}

	@Override
	public Department getDepartmentByName(String departmentName) {
		return repository.findByDepartmentName(departmentName);
	}

	@Override
	public void createDepartment(Department department) {
		repository.save(department);
	}

	@Override
	public void updateDepartment(Department department) {
		repository.save(department);
	}

	@Override
	public void deleteDepartment(short id) {
		repository.deleteById(id);
	}

	@Override
	public boolean isDepartmentExistsById(short id) {
		return repository.existsById(id);
	}

	@Override
	public boolean isDepartmentExistsByName(String departmentName) {
		return repository.existsByDepartmentName(departmentName);
	}

	@Override
	public Page<Department> getAllDepartments(Pageable pagable) {
		return repository.findAll(pagable);
	}
	


}
