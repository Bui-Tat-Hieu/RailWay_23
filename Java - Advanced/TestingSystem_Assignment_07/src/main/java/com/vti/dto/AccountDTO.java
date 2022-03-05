package com.vti.dto;

import com.vti.entity.Account;

import lombok.Data;


@Data
public class AccountDTO {
	
	

	private String email;
		
	private String userName;
	
	private String lastName;
	
	private String firstName;
//	
//	private Department department;
//	
//	private Position position;
//	
//	private Salary salary;
//	
//	private Date createDate;

	public AccountDTO() {
		super();
	}
	
//	public Account toAccount() {
//		return new Account(email, userName, lastName, firstName);
//	}


	
	
	
	
}
