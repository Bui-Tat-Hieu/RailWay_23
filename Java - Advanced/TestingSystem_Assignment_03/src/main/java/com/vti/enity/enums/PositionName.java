package com.vti.enity.enums;

public enum PositionName {
	
	POSITION_DEV("Dev"), 
	POSITION_TEST("Test"),
	POSITION_SCRUM_MASTER("ScrumMaster"),
	POSITION_PM("PM");
//
//	private String positionName;
//
//	PositionName(String positionName) {
//		this.positionName = positionName;
//	}
//
//	public String getPositionName() {
//		return positionName;
//	}
	
	
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
