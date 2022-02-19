package com.vti.backend.datelayer;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.vti.enity.Department;
import com.vti.utils.HibernateUtils;

public class DepartmentRepository {
	
	private HibernateUtils hibernateUtils;
	
	public DepartmentRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}
	
	
	// danh sách account
	@SuppressWarnings("unchecked")
	public List<Department> getAllDepartment() {
		
		Session session = null;
		List<Department> lists = new ArrayList<Department>();
		
		try {
			
			session = hibernateUtils.openSession();
			session.beginTransaction();
			
			lists = (List<Department>) session.createQuery("FROM Department").list();
			
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
