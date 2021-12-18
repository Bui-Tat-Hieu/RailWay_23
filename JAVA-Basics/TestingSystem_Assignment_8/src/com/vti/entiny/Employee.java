package com.vti.entiny;

import java.util.Arrays;

public class Employee <T> {

	private T id;
	private String name;
	private T[] salaris;
	
	public Employee(T id, String name, T[] salaris) {
		super();
		this.id = id;
		this.name = name;
		this.salaris = salaris;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salaris=" + Arrays.toString(salaris) + "]";
	}
	
	public String getLastSalary() {
		return "Employee [id=" + id 
				+ ", name=" + name 
				+ ", salaris=" + salaris[salaris.length - 1] + "]";
	}

	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public T[] getSalaris() {
		return salaris;
	}

	public void setSalaris(T[] salaris) {
		this.salaris = salaris;
	}


	
	
	
}
