package com.vti.frontend;

import java.util.List;

import com.vti.backend.datelayer.DepartmentRepository;
import com.vti.enity.Address;
import com.vti.enity.Department;
import com.vti.enity.DetailDepartment;

public class ProgramDepartment {
	
	public static void main(String[] args) {
		
		
		DepartmentRepository departmentRepository = new DepartmentRepository();
		
		List<Department> lists = departmentRepository.getAllDepartment();
		
		for (Department department : lists) {
			System.out.println("Department: " + department.getDepartmentName());
			for (DetailDepartment detailDepartment : department.getDetailDepartment()) {
				
				Address address =  detailDepartment.getAddressId();
				System.out.println("Address: " + address.getAddressName());
				System.out.println("emulationPoint: " + detailDepartment.getEmulationPoint());
				
			
			}
			System.out.println("");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
