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
import com.vti.entity.enums.PositionName;
import com.vti.entity.enums.PositionNameConverter;

import lombok.Data;

@Data
@Entity
@Table(name = "`position`")
public class Position  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "position_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short positonId;
	
	@Column(name = "`position_name`", nullable = false, unique = true)
	@Convert(converter = PositionNameConverter.class)
	private PositionName positionName;

	@OneToMany(mappedBy = "positionId")
	@JsonIgnoreProperties("positionId")
	private List<Account> accountsList;
	
}
