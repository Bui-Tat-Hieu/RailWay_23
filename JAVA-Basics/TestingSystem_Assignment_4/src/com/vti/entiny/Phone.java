package com.vti.entiny;

public abstract class Phone {

	protected Contact[] contactArr;
	
	public Phone() {
		Contact contact1 = new Contact("Tat Hieu", "0227421297");
		contactArr = new Contact[] {contact1};
	}
	
	
// a
	public abstract void insertContact(String name, String phone);
	
// b
	public abstract void removeContact(String name);
	
// c
	public abstract void updateContact(String name, String newPhone);
	
// d
	public abstract void searchContact(String name);

	
	public Contact[] getContacts() {
		return contactArr;
	}

	public void setContacts(Contact[] contacts) {
		this.contactArr = contacts;
	}
	
}
