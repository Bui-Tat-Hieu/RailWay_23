package com.vti.entiny;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

import org.apache.commons.lang3.ArrayUtils;

public class Group {
	
	private byte groupId;
	private String groupName;
	private Account creator;
	private Date createDate;
	private Account[] accounts;
	
	Scanner scanner = new Scanner(System.in);
	ScannerUtils scannerUtils = new ScannerUtils(scanner);
	
	public Group() {
		
		System.out.println("Nhập ID cho Group");
		this.groupId = (byte) scannerUtils.inputInt("Nhập sai! Vui lòng nhập ID dưới dạng số, nhập lại.");

		System.out.println("Nhập tên cho Group");
		this.groupName = scannerUtils.inputString();
		
		System.out.println("Nhập username người tạo nhóm");
		this.creator = new Account(0, null, scannerUtils.inputString(), null, null, null);
		this.createDate = new Date();
		
		this.accounts = new Account[] {};
		boolean isOk = false;
		while (isOk == false) {
			System.out.println("Bạn có muốn thêm account không ?" + "\nNhập 1: Có" + "\nNhập 2: Không");
			int select = scannerUtils.inputInt("Nhập sai! Vui lòng nhập ID dưới dạng số, nhập lại.");
			if (select != 1) {
				isOk = true;
				System.out.println("BYE");
			} else {
				System.out.println("Nhập username của account");
				Account newAccount = new Account(0, null, scannerUtils.inputString(), null, null, null);
				this.accounts = ArrayUtils.add(this.accounts , newAccount);
				System.out.println("Nhập thành công \n" + newAccount.getUserName());
			}
		}
	}
			
	
	
	@Override
	public String toString() {
		return "Group [groupId= " + groupId 
				+ ", groupName= " + groupName 
				+ "\ncreator= " + creator 
				+ "\ncreateDate= " + createDate
				+ "\naccounts= " + Arrays.toString(accounts) + "]";
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
