package com.vti.enity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "department_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short departmentId;
	
	@Column(name = "department_name", length = 30, nullable = false, unique = true)
	private String departmentName;

	@OneToMany(mappedBy = "departmentId", fetch = FetchType.EAGER)
	private List<DetailDepartment> detailDepartment;
	
	@OneToMany(mappedBy = "departmentId")
	private List<Account> accountsList;
	
	public List<Account> getAccountsList() {
		return accountsList;
	}

	public void setAccountsList(List<Account> accountsList) {
		this.accountsList = accountsList;
	}

	public Department() {
		super();
	}

	public short getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(short departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<DetailDepartment> getDetailDepartment() {
		return detailDepartment;
	}

	public void setDetailDepartment(List<DetailDepartment> detailDepartment) {
		this.detailDepartment = detailDepartment;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", detailDepartment="
				+ detailDepartment + "]";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
