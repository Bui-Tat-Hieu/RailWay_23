package com.vti.backend.businesslayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vti.backend.datalayer.IGroupRepository;
import com.vti.entity.Group;

@Service
public class GroupServiceImpl implements IGroupService {

	@Autowired
	private IGroupRepository repository;
	
	@Override
	public Page<Group> getAllGroups(Pageable pagable) {
		return repository.findAll(pagable);
	}

	@Override
	public Group getGroupById(short id) {
		return repository.findById(id).get();
	}

	@Override
	public Group getGroupByName(String groupName) {
		return repository.findByGroupName(groupName);
	}

	@Override
	public void createGroup(Group group) {
		repository.save(group);
	}

	@Override
	public void updateGroup(Group group) {
		repository.save(group);
	}

	@Override
	public void deleteGroup(short id) {
		repository.deleteById(id);
	}

	@Override
	public boolean isGroupExistsById(short id) {
		return repository.existsById(id);
	}

	@Override
	public boolean isGroupExistsByName(String groupName) {
		return repository.existsByGroupName(groupName);
	}

}
