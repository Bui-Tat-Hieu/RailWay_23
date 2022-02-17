package com.vti.frontend;

import java.util.List;

import com.vti.backend.datelayer.SalaryRepository;
import com.vti.enity.Salary;
import com.vti.enity.enums.SalaryName;

public class ProgramSalary {
	
	public static void main(String[] args) {
		
		SalaryRepository salaryRepository = new SalaryRepository();
		
//		System.out.println("Danh sách Salaty");
//		List<Salary> lists = salaryRepository.getAllSalary();
//		for (Salary salary : lists) {
//			System.out.println(salary);
//		}
		
		
//		System.out.println("Create Salaty");
//		Salary salary = new Salary();
//		salary.setSalaryName(SalaryName.PM);
//		salaryRepository.createSalary(salary);
		
		
		System.out.println("Delete Salaty");
		salaryRepository.deleteSalary((short) 3);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
