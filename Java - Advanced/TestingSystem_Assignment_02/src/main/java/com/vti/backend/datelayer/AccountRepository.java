package com.vti.backend.datelayer;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.vti.enity.Account;
import com.vti.utils.HibernateUtils;

public class AccountRepository {
	
	private HibernateUtils hibernateUtils;
	
	public AccountRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}
	
	// danh sách account
	@SuppressWarnings("unchecked")
	public List<Account> getAllAccount() {
		
		Session session = null;
		List<Account> lists = new ArrayList<Account>();
		
		try {
			
			session = hibernateUtils.openSession();
			session.beginTransaction();
			
			lists = (List<Account>) session.createQuery("FROM Account").list();
			
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
	
	
	// create account
	public void createAccount(Account account) {
		
		Session session = null;
		
		try {
			
			session = hibernateUtils.openSession();
			session.beginTransaction();
			
			session.save(account);
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
	
	
	// delete account
	public void deleteAccount(short id) {
		
		Session session = null;
		
		try {
			
			session = hibernateUtils.openSession();
			session.beginTransaction();
			
			Account account = (Account) session.load(Account.class, id);
			
			session.delete(account);
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
