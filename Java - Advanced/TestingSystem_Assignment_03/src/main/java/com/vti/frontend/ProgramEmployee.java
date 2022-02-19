package com.vti.frontend;

import java.util.List;

import com.vti.backend.datelayer.EmployeeRepository;
import com.vti.enity.Employee;

public class ProgramEmployee {

	public static void main(String[] args) {
		
		EmployeeRepository employeeRepository = new EmployeeRepository();
		
		List<Employee> lists = employeeRepository.getAllEmployee();
		
		for (Employee employee : lists) {
			System.out.println(employee);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
