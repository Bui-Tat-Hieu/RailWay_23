package com.vti.enity.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class SalaryNameConverter implements AttributeConverter<SalaryName, String>{

	@Override
	public String convertToDatabaseColumn(SalaryName salaryName) {
		if (salaryName == null) {
			return null;
		}
		return salaryName.getSalaryName();
	}

	@Override
	public SalaryName convertToEntityAttribute(String sqlSalaryName) {
		if (sqlSalaryName == null) {
			return null;
		}
		return SalaryName.toEnum(sqlSalaryName);
	}
	
	
	
	
	
	
	
	
	
	
	

}
