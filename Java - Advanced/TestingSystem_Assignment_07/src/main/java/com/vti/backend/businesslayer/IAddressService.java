package com.vti.backend.businesslayer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.entity.Address;

public interface IAddressService {

	
	public Page<Address> getAllAddress(Pageable pageable);
	
	public Address getAddressById(short id);
	
	public Address getAddressByName(String addressName);
	
	public void createAddress(Address address);
	
	public void updateAddress(Address address);
	
	public void deleteAddress(short id);
	
	public boolean isAddresExistsById(short id);
	
	public boolean isAddressExistsByName(String addressName);
	
	
}
