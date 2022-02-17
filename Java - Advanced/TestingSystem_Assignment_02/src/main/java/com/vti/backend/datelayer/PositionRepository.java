package com.vti.backend.datelayer;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.vti.enity.Position;
import com.vti.utils.HibernateUtils;

public class PositionRepository {
	
	private HibernateUtils hibernateUtils;
	
	public PositionRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}
	
	
	// danh sách position
	@SuppressWarnings("unchecked")
	public List<Position> getAllPosition() {
		
		Session session = null;
		List<Position> lists = new ArrayList<Position>();
		
		try {
			
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			
			// create hql query
			lists = (List<Position>) session.createQuery("FROM Position").list();
			
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
	
	// tạo position
	public void createPosition(Position position) {
		 
		Session session = null;
		
		try {
			
			session = hibernateUtils.openSession();
			session.beginTransaction();
			
			session.save(position);
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
	
	
	// delete posiiton
	public void deletePosition(short id) {
		
		Session session = null;
		
		try {
			
			session = hibernateUtils.openSession();
			session.beginTransaction();
			
			Position position = (Position) session.load(Position.class, id);
			
			session.delete(position);
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
