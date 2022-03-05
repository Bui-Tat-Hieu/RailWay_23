package com.vti.backend.businesslayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vti.backend.datalayer.IAccountRepository;
import com.vti.entity.Account;

@Service
public class AccountServiceImpl implements IAccountService {
 
	@Autowired
	private IAccountRepository repository;
	
	
	@Override
	public Page<Account> getAllAccounts(Pageable pagable) {
		return repository.findAll(pagable);
	}

	@Override
	public Account getAccountById(short id) {
		return repository.findById(id).get();
	}

	@Override
	public Account getAccountByFullName(String fullName) {
		return repository.findByFullName(fullName);
	}

	@Override
	public void createAccount(Account account) {
		repository.save(account);
	}

	@Override
	public void updateAccount(Account account) {
		repository.save(account);
	}

	@Override
	public void deleteAccount(short id) {
		repository.deleteById(id);
	}

	@Override
	public boolean isAccountExistsById(short id) {
		return repository.existsById(id);
	}

	@Override
	public boolean isAccountExistsByFullName(String fullName) {
		return repository.existsByFullName(fullName);
	}

}
