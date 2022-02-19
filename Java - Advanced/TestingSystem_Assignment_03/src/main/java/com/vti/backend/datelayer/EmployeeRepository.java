package com.vti.backend.datelayer;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.vti.enity.Employee;
import com.vti.utils.HibernateUtils;

public class EmployeeRepository {

	private HibernateUtils hibernateUtils;
	
	public EmployeeRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}
	
	// danh sách account
	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployee() {
		
		Session session = null;
		List<Employee> lists = new ArrayList<Employee>();
		
		try {
			
			session = hibernateUtils.openSession();
			session.beginTransaction();
			
			lists = (List<Employee>) session.createQuery("FROM Employee").list();
			
		} catch (Exception e) {
			e.printStackTrace();
			if(session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return lists;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
