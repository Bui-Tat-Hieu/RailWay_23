package com.vti.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
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
	
	@OneToMany(mappedBy = "address")
	@JsonIgnoreProperties("address")
	private List<DetailDepartment> detailDepartmentList;

	
	public Address(String addressName) {
		this.addressName = addressName;
	}

	public Address() {
		super();
	}
	
	
	
}
