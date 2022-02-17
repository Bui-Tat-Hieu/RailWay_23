package com.vti.frontend;

import com.vti.backend.datelayer.PositionRepository;
import com.vti.enity.Position;
import com.vti.enity.enums.PositionName;

public class ProgramPosition {
	
	public static void main(String[] args) {
		
		
		PositionRepository positionRepository = new PositionRepository();
		
//		System.out.println("Danh sách position");
//		List<Position> lists = positionRepository.getAllPosition();
//		for (Position position : lists) {
//			System.out.println(position);
//		}
		
		
//		System.out.println("Create position");
//		Position position = new Position();
//		position.setPositionName(PositionName.POSITION_PM);
//		positionRepository.createPosition(position);
		
		
		System.out.println("Delete position");
		positionRepository.deletePosition((short) 3);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	


}
