package com.vti.backend.presentationlayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.backend.businesslayer.IGroupAccountService;
import com.vti.entity.GroupAccount;

@RestController
@RequestMapping(value = "api/v1/groupAccounts7")
public class GroupAccountController {

	@Autowired
	private IGroupAccountService service;
	

	
	@GetMapping()
	public Page<GroupAccount> getAllGroupAccounts(Pageable pageable){
		return service.getAllGroupAccounts(pageable);
	}
	
}
