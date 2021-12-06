package com.vti.entiny;

public class Contact {
	
	private String name;
	private String number;
	
	
	public Contact(String name, String number) {
		super();
		this.name = name;
		this.number = number;
		
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Contact [name=" + name + ", number=" + number + "]";
	}
	
	

}
