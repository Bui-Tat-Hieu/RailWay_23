package com.vti.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "`Group`")
public class Group implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "group_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short groupId;
	
	@Column(name = "group_name", length = 50, nullable = false, unique = true)
	private String groupName;
	
	
	@ManyToOne
	@JoinColumn(name = "creator_id", nullable = false)
	@JsonIgnoreProperties("groupList")
	private Account creatorId;
	
//	@OneToMany(mappedBy = "group")
//	@JsonIgnoreProperties("groupAccountList")
//	private List<GroupAccount> groupAccountList;
	
	
	@Column(name = "create_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	public Group(String groupName) {
		this.groupName = groupName;
		
	}

	public Group() {
		super();
	}
	
	
	
	
}
