package com.vti.entiny;

public class Staff <K, V> extends MyMap <K, V> {

	public Staff(K key, V value) {
		super(key, value);
		
	}

	public K getId() {
		return super.getKey();
	}
	
	public String getName() {
		return (String) super.getValue();
	}
	
	
	
}
