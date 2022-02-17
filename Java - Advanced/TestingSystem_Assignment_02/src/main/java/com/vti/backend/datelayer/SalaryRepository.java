package com.vti.backend.datelayer;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.vti.enity.Salary;
import com.vti.utils.HibernateUtils;

public class SalaryRepository {
	
	private HibernateUtils hibernateUtils;
	
	public SalaryRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}
	
	// danh sách salary
	@SuppressWarnings("unchecked")
	public List<Salary> getAllSalary(){
		
		Session session = null;
		List<Salary> lists = new ArrayList<Salary>();
		
		try {
			
			session = hibernateUtils.openSession();
			session.beginTransaction();
			
			lists = (List<Salary>) session.createQuery("FROM Salary").list();
				
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
	
	
	// tạo salary
	public void createSalary(Salary salary) {
		
		Session session = null;
		
		try {
			
			session = hibernateUtils.openSession();
			session.beginTransaction();
			
			session.save(salary);
			session.getTransaction().commit();
			
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
		
	}
	
	// delete salary
	public void deleteSalary(short id) {
		
		Session session = null;
		
		try {
			
			session = hibernateUtils.openSession();
			session.beginTransaction();
			
			Salary salary = (Salary) session.load(Salary.class, id);
			
			session.delete(salary);
			session.getTransaction().commit();
			
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
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
