package com.vti.backend.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.entity.Group;

public interface IGroupRepository extends JpaRepository<Group, Short> {

	Group findByGroupName(String groupName);
	
	boolean existsByGroupName(String groupName);
	
	
	
	
	
	
	
	
	
	
}
