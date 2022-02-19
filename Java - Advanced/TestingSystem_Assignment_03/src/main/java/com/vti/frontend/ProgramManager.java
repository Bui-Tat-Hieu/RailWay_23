package com.vti.frontend;

import java.util.List;

import com.vti.backend.datelayer.ManagerRepository;
import com.vti.enity.Manager;

public class ProgramManager {

	public static void main(String[] args) {
		
		ManagerRepository managerRepository = new ManagerRepository();
		
		List<Manager> lists = managerRepository.getAllManager();
		
		for (Manager manager : lists) {
			System.out.println(manager);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
