package com.vti.backend.businesslayer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.entity.GroupAccount;

public interface IGroupAccountService {

	public Page<GroupAccount> getAllGroupAccounts(Pageable pagable);

	public void createGroupAccount(GroupAccount groupAccount);
	
	public void updateGroupAccount(GroupAccount groupAccount);
	
	public void deleteGroupAccount(short id);
	
}
