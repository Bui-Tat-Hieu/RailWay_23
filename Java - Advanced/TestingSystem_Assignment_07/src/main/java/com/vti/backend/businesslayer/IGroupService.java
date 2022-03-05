package com.vti.backend.businesslayer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.entity.Group;

public interface IGroupService {

	public Page<Group> getAllGroups(Pageable pagable);

	public Group getGroupById(short id);
	
	public Group getGroupByName(String groupName);
	
	public void createGroup(Group group);
	
	public void updateGroup(Group group);
	
	public void deleteGroup(short id);
	
	public boolean isGroupExistsById(short id);
	
	public boolean isGroupExistsByName(String groupName);
	
	
}
