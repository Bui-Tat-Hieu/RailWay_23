package com.vti.backend.businesslayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vti.backend.datalayer.IDetailDepartmentRepository;
import com.vti.entity.DetailDepartment;

@Service
public class DetailDepartmentImpl implements IDetailDepartmentService {

	@Autowired
	private IDetailDepartmentRepository repository;
	
	@Override
	public Page<DetailDepartment> getAllDetailDepartment(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public void createDetailDepartment(DetailDepartment detailDepartment) {
		repository.save(detailDepartment);
	}

	@Override
	public void updateDetailDepartment(DetailDepartment detailDepartment) {
		repository.save(detailDepartment);
	}

	@Override
	public void deleteDetailDepartment(short departmentId) {
		repository.deleteById(departmentId);
	}

}
