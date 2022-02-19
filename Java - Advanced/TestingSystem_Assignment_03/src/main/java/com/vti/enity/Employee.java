package com.vti.enity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "`employee`")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account accountsId;
	
	@Column(name = "working_number_of_year")
	private short workingNumberOfYear;

	public Employee() {
		super();
	}

	public Account getAccountsId() {
		return accountsId;
	}

	public void setAccountsId(Account accountsId) {
		this.accountsId = accountsId;
	}

	public short getWorkingNumberOfYear() {
		return workingNumberOfYear;
	}

	public void setWorkingNumberOfYear(short workingNumberOfYear) {
		this.workingNumberOfYear = workingNumberOfYear;
	}

	@Override
	public String toString() {
		return "Employee [accountsId= " + accountsId.getFullName() + ", workingNumberOfYear= " + workingNumberOfYear + "]";
	}
	
	
	
	
	
	
	
	
}
