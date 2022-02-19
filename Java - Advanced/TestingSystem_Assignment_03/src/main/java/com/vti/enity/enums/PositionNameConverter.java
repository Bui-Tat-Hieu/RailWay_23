package com.vti.enity.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


@Converter(autoApply = true)
public class PositionNameConverter implements AttributeConverter<PositionName, String>{

	// converter từ java sang SQL
	@Override
	public String convertToDatabaseColumn(PositionName positionName) {
		if (positionName == null) {
			return null;
		}
		return positionName.getPositionName();
	}

	// converter từ SQL sang java
	@Override
	public PositionName convertToEntityAttribute(String sqlPositionName) {
		if (sqlPositionName == null) {
			return null;
		}
		return PositionName.toEnum(sqlPositionName);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
