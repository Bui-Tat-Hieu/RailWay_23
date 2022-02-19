package com.vti.enity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.vti.enity.enums.SalaryName;
import com.vti.enity.enums.SalaryNameConverter;

@Entity
@Table(name = "`salary`")
public class Salary  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "salary_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short salaryId;
	
	@Column(name = "salary_name" , nullable = false, unique = true)
	@Convert(converter = SalaryNameConverter.class)
	private SalaryName salaryName;
	
	@OneToMany(mappedBy = "salaryId")
	private List<Account> accountsList;

	public List<Account> getAccountsList() {
		return accountsList;
	}

	public void setAccountsList(List<Account> accountsList) {
		this.accountsList = accountsList;
	}

	public Salary() {
		super();
	}

	public short getSalaryId() {
		return salaryId;
	}

	public void setSalaryId(short salaryId) {
		this.salaryId = salaryId;
	}

	public SalaryName getSalaryName() {
		return salaryName;
	}

	public void setSalaryName(SalaryName salaryName) {
		this.salaryName = salaryName;
	}

	@Override
	public String toString() {
		return "Salary [salaryId=" + salaryId + ", salaryName=" + salaryName + "]";
	}
	
	
	
	
	
	

}
