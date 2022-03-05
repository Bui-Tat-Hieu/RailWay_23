package com.vti.entity.enums;

import javax.persistence.AttributeConverter;

public class SalaryNameConverter  implements AttributeConverter<SalaryName, String>{

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
