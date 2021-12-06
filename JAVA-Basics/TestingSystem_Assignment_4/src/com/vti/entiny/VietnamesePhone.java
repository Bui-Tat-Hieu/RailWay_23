package com.vti.entiny;

import org.apache.commons.lang3.ArrayUtils;

public class VietnamesePhone extends Phone {
	
//	private Contact[] contactArr;
//	
//	public VietnamesePhone() {
//		contactArr = new Contact[] {};
//	}


	@Override
	public void insertContact(String name, String phone) {
		Contact insertContact = new Contact(name, phone);
		contactArr = ArrayUtils.add(contactArr, insertContact);
	}

//	@Override
//	public void removeContact(String name) {
//
//		int index = 0;
//		int[] indexArr = new int[] {};
//		if (contactArr.length > 0) {
//			for (Contact contact : contactArr) {
//				if (name.equals(contact.getName()));
//				indexArr = ArrayUtils.add(indexArr, index);
//			}
//			index++;
//		}
//		if (indexArr.length > 0) {
//			contactArr = ArrayUtils.removeAll(contactArr, indexArr);
//		} else {
//			System.out.println("không có tên nào trùng");
//		}
//		
//	}

	@Override
	public void removeContact(String name) {
		int[] indexArr = new int[] {};
		for (int i = 0; i < contactArr.length; i++) {
			if(name.equals(contactArr[i].getName())) {
				indexArr = ArrayUtils.add(indexArr, i);
			}
		}
		if (indexArr.length > 0) {
			contactArr = ArrayUtils.removeAll(contactArr, indexArr);
		} else {
			System.out.println("không có tên nào trùng");
		}
	}
	

	@Override
	public void updateContact(String name, String newPhone) {

		for (Contact contact : contactArr) {
			if (name.equals(contact.getName())) {
				contact.setNumber(newPhone);
			}
		}
	}

	@Override
	public void searchContact(String name) {

		for (Contact contact : contactArr) {
			if (name.equals(contact.getName())) {
				System.out.println(contact);
			}
		
		}

	}
	
	public void showContact() {
		for (Contact contact : contactArr) {
			System.out.println(contact);
		}
	}
	
	
}