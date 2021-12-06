package com.vti.entiny;

import java.util.Arrays;
import java.util.Date;

public class Group {
	private byte groupId;
	private String groupName;
	private Account creator;
	private Date createDate;
	private Account[] accounts;
	
//	a) không có parameters
	public Group() {
		super();
	}
	
//	b) Có các parameter là GroupName, Creator, array Account[]
//	accounts, CreateDate
	
	public Group(String groupName, Account creator, Date createDate, Account[] accounts) {
		super();
		this.groupName = groupName;
		this.creator = creator;
		this.createDate = createDate;
		this.accounts = accounts;
	}
	
//	c) Có các parameter là GroupName, Creator, array String[]
//	usernames , CreateDate
	
	public Group(String groupName, Account creator, String[] userNames, Date createDate) {
		super();
		this.groupName = groupName;
		this.creator = creator;
		this.createDate = createDate;
		this.accounts = new Account[] {};
		if (userNames.length > 0) {
			for (String uName : userNames) {
				Account account = new Account();
				account.setUserName(uName);
				this.accounts = Arrays.copyOf(this.accounts, this.accounts.length + 1);
				this.accounts[this.accounts.length - 1] = account;
			}
		}
	}




	@Override
	public String toString() {
		return "Group [groupId=" + groupId + ", groupName=" + groupName + ", creator=" + creator + ", createDate="
				+ createDate + ", accounts=" + Arrays.toString(accounts) + "]";
	}

	public byte getGroupId() {
		return groupId;
	}


	public void setGroupId(byte i) {
		this.groupId = i;
	}
	
	
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	
	public Account getCreator() {
		return creator;
	}
	public void setCreator(Account creator) {
		this.creator = creator;
	}
	
	
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
	public Account[] getAccounts() {
		return accounts;
	}
	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}
	
	

}
