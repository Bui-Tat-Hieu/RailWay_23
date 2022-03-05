package com.vti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "`employee`")
@PrimaryKeyJoinColumn(name = "account_id")
public class Employee extends Account {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "working_number_of_year")
	private short workingNumberOfYear;

}
