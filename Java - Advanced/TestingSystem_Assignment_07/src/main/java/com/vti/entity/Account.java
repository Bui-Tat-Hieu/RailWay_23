package com.vti.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Formula;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "`account`")
@Inheritance(strategy = InheritanceType.JOINED)
public class Account implements Serializable {
	
	private static final long serialVersionUID = 1L;
	

	@Column(name = "account_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short accountId;
	
	@Column(name = "email", length = 50, nullable = false, unique = true)
	private String email;
	
	@Column(name = "username", length = 50, nullable = false, unique = true)
	private String userName;
	
	@Column(name = "last_name", length = 50, nullable = false, unique = true)
	private String lastName;
	
	@Column(name = "first_name", length = 50, nullable = false, unique = true)
	private String firstName;
	
	@Formula(value = "concat(last_name , ' ',first_name)")
	private String fullName;
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	@JsonIgnoreProperties("accountList")
	private Department departmentId;
	
	@ManyToOne
	@JoinColumn(name = "position_id")
	@JsonIgnoreProperties("accountsList")
	private Position positionId;
	
	@ManyToOne
	@JoinColumn(name = "salary_id")
	@JsonIgnoreProperties("accountsList")
	private Salary salaryId;
	
	@Column(name = "create_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	@OneToMany(mappedBy = "creatorId")
	@JsonIgnoreProperties("creatorId")
	private List<Group> groupList;

	
//	@OneToMany(mappedBy = "account")
//	@JsonIgnoreProperties("groupAccountList")
//	private List<GroupAccount> groupAccountList;




	public Account() {
		
	}
	
}
