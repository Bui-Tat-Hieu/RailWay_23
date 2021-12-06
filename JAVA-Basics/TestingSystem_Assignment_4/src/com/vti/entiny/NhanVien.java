package com.vti.entiny;

public class NhanVien extends CanBo {

	private String congViec;
	
	public NhanVien(String name, byte age, String sex, String homeTown, String congViec) {
		super(name, age, sex, homeTown);
		this.congViec = congViec;

	}

	@Override
	public String toString() {
		return "NhanVien [Name()=" + getName() 
				+ ", Age()=" + getAge()
				+ ", Gender()=" + getgender()
				+ ", HomeTown()=" + getHomeTown() 
				+ ", Công Việc=" + congViec + "]";
	}
	
	

}
