package com.vti.backend.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.entity.Account;

public interface IAccountRepository extends JpaRepository<Account, Short> {

	Account findByFullName(String fullName);
	
	boolean existsByFullName(String fullName);
	
}
