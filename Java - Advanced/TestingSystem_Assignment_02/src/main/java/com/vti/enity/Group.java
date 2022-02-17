package com.vti.enity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "`Group`")
public class Group implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;
	
	@Column(name = "group_name", length = 50, nullable = false, unique = true)
	private String groupName;
	
	@Column(name = "create_date")
	@Temporal(TemporalType.DATE)
	private Date createDate;
	
	public Group() {
		super();
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", groupName=" + groupName + ", createDate=" + createDate + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
