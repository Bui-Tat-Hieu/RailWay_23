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

import com.vti.backend.businesslayer.IDetailDepartmentService;
import com.vti.entity.DetailDepartment;

@RestController
@RequestMapping(value = "api/v1/detailDepartment7")
public class DetailDepartmentController {

	
	@Autowired
	private IDetailDepartmentService service;
	
	@GetMapping()
	public Page<DetailDepartment> getAllDetailDepartment(Pageable pageable) {
		return service.getAllDetailDepartment(pageable);
	}
	
	@PostMapping()
	public void createDetailDepartment(@RequestBody DetailDepartment detailDepartment) {
		detailDepartment = new DetailDepartment();
		
		service.createDetailDepartment(detailDepartment);
	}
	
	
	@PutMapping(value = "/{departmentId}")
	public void updateDetailDepartment(@PathVariable(name = "departmentId") short departmentId, @RequestBody DetailDepartment detailDepartment) {
		detailDepartment = new DetailDepartment();
		detailDepartment.setDepartmentId(departmentId);
		service.updateDetailDepartment(detailDepartment);
	}
	
	@DeleteMapping(value = "/{departmentId}")
	public void deleteDetailDepartment(@PathVariable(name = "departmentId") short departmentId) {
		service.deleteDetailDepartment(departmentId);	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
