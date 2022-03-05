package com.vti.backend.businesslayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vti.backend.datalayer.IGroupAccountRepository;
import com.vti.entity.GroupAccount;

@Service
public class GroupAccountServiceImpl implements IGroupAccountService {

	@Autowired
	private IGroupAccountRepository repository;
	
	
	@Override
	public Page<GroupAccount> getAllGroupAccounts(Pageable pagable) {
		return repository.findAll(pagable);
	}

	@Override
	public void createGroupAccount(GroupAccount groupAccount) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateGroupAccount(GroupAccount groupAccount) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteGroupAccount(short id) {
		// TODO Auto-generated method stub

	}

}
