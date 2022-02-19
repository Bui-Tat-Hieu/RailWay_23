package com.vti.enity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "address_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short addressId;
	
	@Column(name = "address_name", length = 100, nullable = false, unique = true)
	private String addressName;
	
	@OneToMany(mappedBy = "addressId", fetch = FetchType.LAZY)
	private List<DetailDepartment> detailDepartment;

	public Address() {
		super();
	}

	public short getAddressId() {
		return addressId;
	}

	public void setAddressId(short addressId) {
		this.addressId = addressId;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public List<DetailDepartment> getDetailDepartment() {
		return detailDepartment;
	}

	public void setDetailDepartment(List<DetailDepartment> detailDepartment) {
		this.detailDepartment = detailDepartment;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", addressName=" + addressName + ", detailDepartment="
				+ detailDepartment + "]";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
