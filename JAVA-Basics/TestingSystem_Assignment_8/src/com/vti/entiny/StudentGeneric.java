package com.vti.entiny;

public class StudentGeneric <T> {
	
	private T id;
	private String name;
	
	
	public StudentGeneric() {
		super();
	}

	public StudentGeneric(T id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "StudentT [id=" + id + ", name=" + name + "]";
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
	

	
	
	

}
