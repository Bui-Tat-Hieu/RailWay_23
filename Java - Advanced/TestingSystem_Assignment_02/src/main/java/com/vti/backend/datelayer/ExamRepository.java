package com.vti.backend.datelayer;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.vti.enity.Exam;
import com.vti.utils.HibernateUtils;

public class ExamRepository {
	
	private HibernateUtils hibernateUtils;
	
	public ExamRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}
	
	// danh sách exam
	@SuppressWarnings("unchecked")
	public List<Exam> getAllExam() {
		
		Session session = null;
		List<Exam> lists = new ArrayList<Exam>();
		
		try {
			
			session = hibernateUtils.openSession();
			session.beginTransaction();
			
			lists = (List<Exam>) session.createQuery("FROM Exam").list();
			
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
	
	
	// create exam
	public void createExam(Exam exam) {
		
		Session session = null;
		
		try {
			
			session = hibernateUtils.openSession();
			session.beginTransaction();
			
			session.save(exam);
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
