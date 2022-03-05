package com.vti.backend.businesslayer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.entity.Account;

public interface IAccountService {

	public Page<Account> getAllAccounts(Pageable pagable);
	
	public Account getAccountById(short id);
	
	public Account getAccountByFullName(String fullName);
	
	public void createAccount(Account account);
	
	public void updateAccount(Account account);
	
	public void deleteAccount(short id);
	
	public boolean isAccountExistsById(short id);
	
	public boolean isAccountExistsByFullName(String fullName);
	
	
}
