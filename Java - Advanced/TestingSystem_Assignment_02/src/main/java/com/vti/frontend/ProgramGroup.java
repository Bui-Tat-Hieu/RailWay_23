package com.vti.frontend;

import java.util.Date;
import java.util.List;

import com.vti.backend.datelayer.GroupRepository;
import com.vti.enity.Group;

public class ProgramGroup {
	
	public static void main(String[] args) {
		
		GroupRepository groupRepository = new GroupRepository();
		
		
//		System.out.println("Danh Sách Group");
//		List<Group> lists = groupRepository.getAllGroup();
//		
//		for (Group group : lists) {
//			System.out.println(group);
//		}
		
		
//		System.out.println("Create Group");
//		Group group = new Group();
//		group.setGroupName("Python2");
//		group.setCreateDate(new Date());
//		groupRepository.createGroup(group);
		
		
//		System.out.println("Update Group");
//		groupRepository.updateGroup((short) 5, "Pythhon2222222");
		
		
//		System.out.println("Delete Group");
//		groupRepository.deleteGroup((short) 5);
		
		
//		System.out.println("Lấy group theo id");
//		Group group = groupRepository.getGroupById((short) 3);
//		System.out.println(group);
		
		
//		System.out.println("Lấy group theo groupName");
//		Group group = groupRepository.getGroupByName("Database");
//		System.out.println(group);
		
		
//		System.out.println("kiểm tra group có tồn tại không theo id");
//		System.out.println(groupRepository.isGroupExistsById((short) 6));
		
		
		System.out.println("kiểm tra group có tồn tại không theo groupName");
		System.out.println(groupRepository.isGroupExistsByName("Database"));
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
