package com.vti.backend.presentationlayer;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.backend.businesslayer.IGroupService;
import com.vti.entity.Account;
import com.vti.entity.Group;

@RestController
@RequestMapping(value = "api/v1/groups7")
public class GroupControler {

	@Autowired
	private IGroupService service;
	

	
	@GetMapping()
	public Page<Group> getAllGroups(Pageable pageable){
		return service.getAllGroups(pageable);
	}
	
	@GetMapping(value = "/{id}")
	public Group getGroupById(@PathVariable(name = "id") short id) {
		return service.getGroupById(id);
	}
	
	@GetMapping(value = "/groupName/{groupName}")
	public Group getGroupByGroupName(@PathVariable(name = "groupName") String groupName) {
		return service.getGroupByName(groupName);
	}
	
	@PostMapping()
	public void createGroup (@RequestBody Group group) { 
		group.setCreateDate(new Date());
		service.createGroup(group);
	}
	
	@PutMapping(value = "/{id}")
	public void updateGroup(@PathVariable(name = "id") short id, @RequestBody Group group) {
		group.setGroupId(id);
		group.setCreateDate(new Date());
		service.updateGroup(group);
	}
	
	
	@DeleteMapping(value = "/{id}")
	public void deleteGroup(@PathVariable(name = "id") short id) {
		service.deleteGroup(id);
	}
	
	@GetMapping(value = "/is/{id}")
	public boolean isGroupExistsById(@PathVariable(name = "id") short id) {
		return service.isGroupExistsById(id);
		
	}
	
	@GetMapping(value = "/isName/{groupName}")
	public boolean isGroupExistsByName(@PathVariable(name = "groupName") String groupName) {
		return service.isGroupExistsByName(groupName);
	}
	
}
