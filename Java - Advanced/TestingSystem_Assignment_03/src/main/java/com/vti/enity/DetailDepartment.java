package com.vti.enity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "detail_department")
public class DetailDepartment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@ManyToOne()
	@MapsId("department_id")
	@JoinColumn(name = "department_id")
	private Department departmentId;
	
	
	@ManyToOne()
	@MapsId("address_id")
	@JoinColumn(name = "address_id")
	private Address addressId;
	
	@Column(name = "emulation_point")
	private short emulationPoint;

	public DetailDepartment() {
		super();
	}

	public Department getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Department departmentId) {
		this.departmentId = departmentId;
	}

	public Address getAddressId() {
		return addressId;
	}

	public void setAddressId(Address addressId) {
		this.addressId = addressId;
	}

	public short getEmulationPoint() {
		return emulationPoint;
	}

	public void setEmulationPoint(short emulationPoint) {
		this.emulationPoint = emulationPoint;
	}

	@Override
	public String toString() {
		return "DetailDepartment [departmentId=" + departmentId + ", addressId=" + addressId + ", emulationPoint="
				+ emulationPoint + "]";
	}
	
	
	
	
	

}
