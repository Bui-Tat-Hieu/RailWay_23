package com.vti.enity;

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

import com.vti.enity.enums.PositionName;
import com.vti.enity.enums.PositionNameConverter;

@Entity
@Table(name = "`position`")
public class Position  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "position_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;
	
	@Column(name = "`position_name`", nullable = false, unique = true)
	@Convert(converter = PositionNameConverter.class)
	private PositionName positionName;

	@OneToMany(mappedBy = "positionId")
	private List<Account> accountsList;
	
	
	public List<Account> getAccountsList() {
		return accountsList;
	}

	public void setAccountsList(List<Account> accountsList) {
		this.accountsList = accountsList;
	}

	public Position() {
		super();
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public PositionName getPositionName() {
		return positionName;
	}

	public void setPositionName(PositionName positionName) {
		this.positionName = positionName;
	}

	@Override
	public String toString() {
		return "Position [id=" + id + ", positionName=" + positionName + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
