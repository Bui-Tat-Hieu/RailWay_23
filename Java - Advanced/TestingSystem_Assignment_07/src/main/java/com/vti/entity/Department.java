package com.vti.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "department")
public class Department implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "department_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short departmentId;
	
	
	@Column(name = "department_name", length = 30, nullable = false, unique = true)
	private String departmentName;

	@OneToOne(mappedBy = "department")
	@JsonIgnoreProperties("department")
	private DetailDepartment detailDepartment;
	
	@OneToMany(mappedBy = "departmentId")
	@JsonIgnoreProperties("departmentId")
	private List<Account> accountList;
	
	
	public Department(String departmentName) {
		this.departmentName = departmentName;
	}



	public Department() {
		super();
	}
	
	
	
}
