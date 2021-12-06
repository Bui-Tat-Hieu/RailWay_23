package com.vti.entiny;

public class KySu extends CanBo {

	private String nganhDaoTao;
	
	public KySu(String name, byte age, String sex, String homeTown, String nganhDaoTao) {
		super(name, age, sex, homeTown);
		this.nganhDaoTao = nganhDaoTao;
		
	}

	@Override
	public String toString() {
		return "KySu [Name()=" + getName() 
				+ ", Age()=" + getAge()
				+ ", Gender()=" + getgender() 
				+ ", HomeTown()=" + getHomeTown() 
				+ ", Ngành Đào Tạo=" + nganhDaoTao + "]";
	}
	
}
