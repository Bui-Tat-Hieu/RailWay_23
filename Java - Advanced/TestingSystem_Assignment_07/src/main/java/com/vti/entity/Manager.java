package com.vti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "`manager`")
@PrimaryKeyJoinColumn(name = "account_id")
public class Manager extends Account {

	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "management_number_of_year")
	private short managementgNumberOfYear;

}
