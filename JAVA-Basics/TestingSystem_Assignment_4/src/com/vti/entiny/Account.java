package com.vti.entiny;

import java.util.Arrays;
import java.util.Date;

public class Account {

	private int accountId;
	private String email;
	private String userName;
	private String fullName;
	private Department department;
	private Position position;
	private Date createDate;
	private Group[] groups;
	
//	a) Không có parameters
	public Account() {
		super();
	}

//	b) Có các parameter là id, Email, Username, FirstName,
//	LastName (với FullName = FirstName + LastName)	
	public Account(int accountId, String email, String userName, String lastName, String firstName) {
		super();
		this.accountId = accountId;
		this.email = email;
		this.userName = userName;
		this.fullName = lastName.concat(" ").concat(firstName);
	}

//	c) Có các parameter là id, Email, Username, FirstName,
//	LastName (với FullName = FirstName + LastName) và
//	Position của User, default createDate = now	
	
	public Account(int accountId, String email, String userName, String lastName, String firstName, Position position) {
		super();
		this.accountId = accountId;
		this.email = email;
		this.userName = userName;
		this.fullName = lastName.concat(" ").concat(firstName);
		this.position = position;
		this.createDate = new Date();
	}
	
//	d) Có các parameter là id, Email, Username, FirstName,
//	LastName (với FullName = FirstName + LastName) và
//	Position của User, createDate
//	Khởi tạo 1 Object với mỗi constructor ở trên

	public Account(int accountId, String email, String userName, String lastName, String firstName, Position position, Date createDate) {
	super();
	this.accountId = accountId;
	this.email = email;
	this.userName = userName;
	this.fullName = lastName.concat(" ").concat(firstName);
	this.position = position;
	this.createDate = createDate;
}


	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", email=" + email + ", userName=" + userName + ", fullName="
				+ fullName + ", department=" + department + ", position=" + position + ", createDate=" + createDate
				+ ", groups=" + Arrays.toString(groups) + "]";
	}

	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
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
	
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	
	
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
	public Group[] getGroups() {
		return groups;
	}
	public void setGroups(Group[] groups) {
		this.groups = groups;
	}
	
	
	

}
