package com.vti.backend.presentationlayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.backend.businesslayer.IDepartmentService;
import com.vti.dto.DepartmentDTO;
import com.vti.entity.Department;

@RestController
@RequestMapping(value = "api/v1/departments7")
public class DepartmentController {

	@Autowired
	private IDepartmentService service;
	

	
	@GetMapping()
	public Page<Department> getAllDepartments(Pageable pageable){
		return service.getAllDepartments(pageable);
	}
	
	@GetMapping(value = "/{id}")
	public Department getDepartmentById(@PathVariable(name = "id") short id) {
		return service.getDepartmentById(id);
	}
	
	@GetMapping(value = "/departmentName/{departmentName}")
	public Department getDepartmentByDepartmentName(@PathVariable(name = "departmentName") String departmentName) {
		return service.getDepartmentByName(departmentName);
	}
	
	@PostMapping()
	public void createDepartment (@RequestBody DepartmentDTO departmentDTO) { 
		service.createDepartment(departmentDTO.toEntity());
	}
	
	@PutMapping(value = "/{id}")
	public void updateDepartment(@PathVariable(name = "id") short id, @RequestBody DepartmentDTO departmentDTO) {
		Department department = departmentDTO.toEntity();
		department.setDepartmentId(id);
		service.updateDepartment(department);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteDepartment(@PathVariable(name = "id") short id) {
		service.deleteDepartment(id);
	}
	
	@GetMapping(value = "/is/{id}")
	public boolean isDepartmentExistsById(@PathVariable(name = "id") short id) {
		return service.isDepartmentExistsById(id);
		
	}
	
	@GetMapping(value = "/isName/{departmentName}")
	public boolean isDepartmentExistsByName(@PathVariable(name = "departmentName") String departmentName) {
		return service.isDepartmentExistsByName(departmentName);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
