package com.vti.backend.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.entity.Address;

public interface IAddressRepository extends JpaRepository<Address, Short> {

	Address findByAddressName(String addresName);
	
	boolean existsByAddressName(String addresName);
	
}
