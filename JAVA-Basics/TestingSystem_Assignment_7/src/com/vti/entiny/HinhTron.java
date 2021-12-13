package com.vti.entiny;

public class HinhTron extends HinhHoc {
	
	public HinhTron(float banKinh) {
		super(banKinh);
	}
	
	public HinhTron() {
	}

	public float tinhChuVi(float banKinh) {
		return banKinh * 2 * (Configs.PI);
	}
	
	public float tinhDienTich(float banKinh) {
		return banKinh * banKinh * (Configs.PI);
	}

}
