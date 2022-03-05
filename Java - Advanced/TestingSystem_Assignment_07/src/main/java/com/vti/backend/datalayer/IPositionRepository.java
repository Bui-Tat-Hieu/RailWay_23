package com.vti.backend.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.entity.Position;
import com.vti.entity.enums.PositionName;

public interface IPositionRepository extends JpaRepository<Position, Short> {

	Position findByPositionName(PositionName positionName);
	
	
	
	
	
	
}
