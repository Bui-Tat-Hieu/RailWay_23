package com.vti.enity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Manager implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account accountID;
	
	@Column(name = "management_number_of_year")
	private short managementgNumberOfYear;

	public Manager() {
		super();
	}

	public Account getAccountId() {
		return accountID;
	}

	public void setAccountId(Account accountId) {
		this.accountID = accountId;
	}

	public short getManagementgNumberOfYear() {
		return managementgNumberOfYear;
	}

	public void setManagementgNumberOfYear(short managementgNumberOfYear) {
		this.managementgNumberOfYear = managementgNumberOfYear;
	}

	@Override
	public String toString() {
		return "Manager [accountId=" + accountID.getFullName() + ", managementgNumberOfYear=" + managementgNumberOfYear + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
