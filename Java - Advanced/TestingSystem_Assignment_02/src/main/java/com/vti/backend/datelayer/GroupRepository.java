package com.vti.backend.datelayer;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.enity.Group;
import com.vti.utils.HibernateUtils;

public class GroupRepository {
	
	private HibernateUtils hibernateUtils;
	
	public GroupRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}
	
	// danh sách group
	
	@SuppressWarnings("unchecked")
	public List<Group> getAllGroup(){
		
		Session session = null;
		List<Group> lists = new ArrayList<Group>();
		
		try {
			
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			
			// create hql query
			lists = (List<Group>) session.createQuery("FROM Group").list();
			
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
	
	// tạo group
	public void createGroup(Group group) {
		
		Session session = null;
		
		try {
			
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			
			// cretae
			session.save(group);
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
	
	// update group
	public void updateGroup(short id, String newName) {
		
		Session session = null;
		
		try {
			
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			
			// get group
			Group group = (Group) session.load(Group.class, id);
			
			// update
			group.setGroupName(newName);
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
	

	// delete group
	public void deleteGroup(short id) {
		
		Session session = null;
		
		try {
			
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			
			// get group
			Group group = (Group) session.load(Group.class, id);
			
			// delete
			session.delete(group);
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
	
	
	// lấy group theo id
	public Group getGroupById(short id) {
		
		Session session = null;
		Group group = null;
		
		try {
			
			session = hibernateUtils.openSession();
			session.beginTransaction();
			
			group = session.get(Group.class, id);
			
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
		return group;
		
	}
	
	// lấy gropu theo tên
	@SuppressWarnings("unchecked")
	public Group getGroupByName(String groupName) {
		
		Session session = null;
		Group group = null;
		
		try {
			
			session = hibernateUtils.openSession();
			session.beginTransaction();
			
			// create hql query
			Query<Group> query = session.createQuery("From Group WHERE groupName = :groupNameParameter");
			
			// set paramater
			query.setParameter("groupNameParameter", groupName);
			
			// get result
			group = query.uniqueResult();
			
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
		
		return group;
		
	}
	
	
	// kiểm tra group có tồn tại không theo id
	public boolean isGroupExistsById(short id) {
		
		Group group = getGroupById(id);
		
		if (group == null) {
			System.err.println("Không có group nào!");
			return false;
			
		}
		System.out.println(group);
		return true;
		
	}
	
	
	// kiểm tra group có tồn tại không theo groupName
	public boolean isGroupExistsByName(String groupName) {
		
		Group group = getGroupByName(groupName);
		
		if (group == null) {
			System.err.println("Không có group nào!");
			return false;
			
		}
		System.out.println(group);
		return true;
		
	}
	
	
	
	
	
	
	
	
	

}
