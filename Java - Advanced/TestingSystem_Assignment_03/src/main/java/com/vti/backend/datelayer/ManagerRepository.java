package com.vti.backend.datelayer;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.vti.enity.Manager;
import com.vti.utils.HibernateUtils;

public class ManagerRepository {

	private HibernateUtils hibernateUtils;
	
	public ManagerRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}
	
	// danh sách account
	@SuppressWarnings("unchecked")
	public List<Manager> getAllManager() {
		
		Session session = null;
		List<Manager> lists = new ArrayList<Manager>();
		
		try {
			
			session = hibernateUtils.openSession();
			session.beginTransaction();
			
			lists = (List<Manager>) session.createQuery("FROM Manager").list();
			
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
