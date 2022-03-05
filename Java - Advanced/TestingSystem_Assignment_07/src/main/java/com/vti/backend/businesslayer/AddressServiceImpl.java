package com.vti.backend.businesslayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vti.backend.datalayer.IAddressRepository;
import com.vti.entity.Address;

@Service
public class AddressServiceImpl implements IAddressService {

	@Autowired
	private IAddressRepository repository;
	
	@Override
	public Page<Address> getAllAddress(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Address getAddressById(short id) {
		return repository.findById(id).get();
	}

	@Override
	public Address getAddressByName(String addressName) {
		return repository.findByAddressName(addressName);
	}

	@Override
	public void createAddress(Address address) {
		repository.save(address);
	}

	@Override
	public void updateAddress(Address address) {
		repository.save(address);
	}

	@Override
	public void deleteAddress(short id) {
		repository.deleteById(id);
	}

	@Override
	public boolean isAddresExistsById(short id) {
		return repository.existsById(id);
	}

	@Override
	public boolean isAddressExistsByName(String addressName) {
		return repository.existsByAddressName(addressName);
	}

}
