package com.vti.enity.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


@Converter(autoApply = true)
public class PositionNameConverter implements AttributeConverter<PositionName, String>{

	@Override
	public String convertToDatabaseColumn(PositionName positionName) {
		if (positionName == null) {
			return null;
		}
		return positionName.getPositionName();
	}

	@Override
	public PositionName convertToEntityAttribute(String sqlPositionName) {
		if (sqlPositionName == null) {
			return null;
		}
		return PositionName.toEnum(sqlPositionName);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
