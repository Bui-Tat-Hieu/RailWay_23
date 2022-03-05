package com.vti.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vti.entity.enums.SalaryName;
import com.vti.entity.enums.SalaryNameConverter;

import lombok.Data;

@Data
@Entity
@Table(name = "`salary`")
public class Salary  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "salary_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short salaryId;
	
	@Column(name = "salary_name" , nullable = false, unique = true)
	@Convert(converter = SalaryNameConverter.class)
	private SalaryName salaryName;
	
	@OneToMany(mappedBy = "salaryId")
	@JsonIgnoreProperties("salaryId")
	private List<Account> accountsList;
}
