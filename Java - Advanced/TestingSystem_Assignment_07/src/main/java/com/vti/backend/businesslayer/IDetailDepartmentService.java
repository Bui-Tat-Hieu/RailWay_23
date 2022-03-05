package com.vti.backend.businesslayer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.entity.DetailDepartment;

public interface IDetailDepartmentService {

	public Page<DetailDepartment> getAllDetailDepartment(Pageable pageable);
	
	public void createDetailDepartment(DetailDepartment detailDepartment);
	
	public void updateDetailDepartment(DetailDepartment detailDepartment);
	
	public void deleteDetailDepartment(short departmentId);
	
	
	
	
	
	
	
	
	
	
	
}
