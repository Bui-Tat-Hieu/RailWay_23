package com.vti.backend.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.entity.Salary;
import com.vti.entity.enums.SalaryName;

public interface ISalaryRepository extends JpaRepository<Salary, Short> {

	
	Salary findBySalaryName(SalaryName salaryName);
	
}
