package com.vti.enity.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class SalaryNameConverter implements AttributeConverter<SalaryName, String>{

	// converter từ java sang SQL
	@Override
	public String convertToDatabaseColumn(SalaryName salaryName) {
		if (salaryName == null) {
			return null;
		}
		return salaryName.getSalaryName();
	}

	// converter từ SQL sang java
	@Override
	public SalaryName convertToEntityAttribute(String sqlSalaryName) {
		if (sqlSalaryName == null) {
			return null;
		}
		return SalaryName.toEnum(sqlSalaryName);
	}
	
	
	
	
	
	
	
	
	
	
	

}
