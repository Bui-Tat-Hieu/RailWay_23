package com.vti.dto;

import com.vti.entity.Address;

import lombok.Data;

@Data
public class AddressDTO {

	private String addressName;
	
	public Address toEntity() {
		return new Address(addressName);
	}

	public AddressDTO() {
		super();
	}
	
	
	
}
