package com.vti.enity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Formula;

@Entity
@Table(name = "`account`")
public class Account implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "account_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short accountId;
	
	@Column(name = "email", length = 50, nullable = false, unique = true)
	private String email;
	
	@Column(name = "username", length = 50, nullable = false, unique = true)
	private String userName;
	
	@Column(name = "last_name", length = 50, nullable = false, unique = true)
	private String lastName;
	
	@Column(name = "first_name", length = 50, nullable = false, unique = true)
	private String firstName;
	
	@Formula(value = "concat(last_name , ' ',first_name)")
	private String fullName;
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department departmentId;
	
	@ManyToOne
	@JoinColumn(name = "position_id")
	private Position positionId;
	
	@ManyToOne
	@JoinColumn(name = "salary_id")
	private Salary salaryId;
	
	@OneToMany(mappedBy = "accountsId", fetch = FetchType.EAGER)
	private List<Employee> employeesList;
	
//	@OneToMany(mappedBy = "accountID", fetch = FetchType.EAGER)
//	private List<Manager> managersList;
	
	
	
//	public List<Manager> getManagersList() {
//		return managersList;
//	}
//
//	public void setManagersList(List<Manager> managersList) {
//		this.managersList = managersList;
//	}

	public List<Employee> getEmployeesList() {
		return employeesList;
	}

	public void setEmployeesList(List<Employee> employeesList) {
		this.employeesList = employeesList;
	}

	public Department getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Department departmentId) {
		this.departmentId = departmentId;
	}

	public Position getPositionId() {
		return positionId;
	}

	public void setPositionId(Position positionId) {
		this.positionId = positionId;
	}

	public Salary getSalaryId() {
		return salaryId;
	}

	public void setSalaryId(Salary salaryId) {
		this.salaryId = salaryId;
	}

	@Column(name = "create_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	public Account() {
		super();
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(short accountId) {
		this.accountId = accountId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Account [accountId= " + accountId 
				+ ", email= " + email 
				+ ", userName= " + userName
				+ ", fullName= " + fullName 
				+ ", departmentId= " + departmentId.getDepartmentName()
				+ ", positionId= " + positionId.getPositionName() 
				+ ", salaryId= " + salaryId.getSalaryName() 
				+ ", createDate= " + createDate + "]";
	}


	

	
}
