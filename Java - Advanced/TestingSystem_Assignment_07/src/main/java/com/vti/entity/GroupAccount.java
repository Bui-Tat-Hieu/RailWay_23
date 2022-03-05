package com.vti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "`group_account`")
public class GroupAccount implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private GroupAccountPK id;
	
	@ManyToOne
	@MapsId("group_id")
	@JoinColumn(name = "group_id")
	@JsonIgnoreProperties("groupAccountList")
	private Group group;
	
	@ManyToOne
	@MapsId("account_id")
	@JoinColumn(name = "account_id")
	@JsonIgnoreProperties("account")
	private Account account;
	
	@Column(name = "join_date")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date joinDate;
	
	
	
	@Embeddable
	@Data
	public static class GroupAccountPK implements Serializable {
		
		private static final long serialVersionUID = 1L;
		
		@Column(name = "group_id", nullable = false)
		private short groupId;
		
		@Column(name = "account_id", nullable = false)
		private short accountId;


		
		
	}
	
	
	
	
	
	
	
	
	
	
}
