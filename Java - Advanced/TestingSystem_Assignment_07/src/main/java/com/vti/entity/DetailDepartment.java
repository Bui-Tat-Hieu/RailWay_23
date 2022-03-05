package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "detail_department")
public class DetailDepartment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Column(name = "department_id")
	@Id
	private short departmentId;
	
//	@Column(name = "address_id")
//	private short addressID;
	
	@OneToOne
	@JoinColumn(name = "department_id")
	@JsonIgnoreProperties("detailDepartment")
	private Department department;
	
	
	@ManyToOne
	@MapsId("address_id")
	@JoinColumn(name = "address_id")
	@JsonIgnoreProperties("detailDepartmentList")
	private Address address;
	
	
	@Column(name = "emulation_point")
	private short emulationPoint;
}
