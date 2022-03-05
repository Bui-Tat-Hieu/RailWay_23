package com.vti.backend.presentationlayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.backend.businesslayer.IAddressService;
import com.vti.dto.AddressDTO;
import com.vti.entity.Address;

@RestController
@RequestMapping(value = "api/v1/address7")
public class AddressController {

	
	@Autowired
	private IAddressService service;
	
	@GetMapping()
	public Page<Address> getAllAddress(Pageable pageable){
		return service.getAllAddress(pageable);
	}
	
	@GetMapping(value = "/{id}")
	public Address getAddressById(@PathVariable(name = "id") short id) {
		return service.getAddressById(id);
	}
	
	@GetMapping(value = "/addressName/{addressName}")
	public Address getAddressByName(@PathVariable(name = "addressName") String addressName) {
		return service.getAddressByName(addressName);
	}
	
	@PostMapping()
	public void createAddress(@RequestBody AddressDTO addressDTO) {
		service.createAddress(addressDTO.toEntity());
	}
	
	
	@PutMapping(value = "/{id}")
	public void updateAddress(@PathVariable(name = "id") short id, @RequestBody AddressDTO addressDTO) {
		Address address = addressDTO.toEntity();
		address.setAddressId(id);
		service.updateAddress(address);
		
	}
		
	@DeleteMapping(value = "/{id}")
	public void deleteAddress(@PathVariable(name = "id") short id) {
		service.deleteAddress(id);
	}
	
	@GetMapping(value = "/is/{id}")
	public boolean isAddressExistsById(@PathVariable(name = "id") short id) {
		return service.isAddresExistsById(id);
	}
	
	@GetMapping(value = "/isName/{addressName}")
	public boolean isAddressExistsByName(@PathVariable(name = "addressName") String addressName) {
		return service.isAddressExistsByName(addressName);
	}
	
	
	
	
}
