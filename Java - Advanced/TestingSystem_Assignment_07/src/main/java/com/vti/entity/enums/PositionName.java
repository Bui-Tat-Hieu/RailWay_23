package com.vti.entity.enums;

public enum PositionName {
	
	DEV("Dev"), 
	TEST("Test"),
	SCRUM_MASTER("ScrumMaster"),
	PM("PM");
	
	
	private String positionName;

	private PositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getPositionName() {
		return positionName;
	}

	public static PositionName toEnum(String sqlPositionName) {
		for (PositionName item : PositionName.values()) {
			if (item.getPositionName().equals(sqlPositionName)) {
				return item;
			}
		}
		return null;
	}
	
	
}
