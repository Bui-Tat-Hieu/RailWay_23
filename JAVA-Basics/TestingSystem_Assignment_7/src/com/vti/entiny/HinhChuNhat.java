package com.vti.entiny;

public class HinhChuNhat extends HinhHoc {
	
	public HinhChuNhat(float chieuRong, float chieuDai) {
		super(chieuRong, chieuDai);
	}
	
	public HinhChuNhat() {
	}

	public float tinhChuVi(float chieuRong, float chieuDai) {
		return (chieuRong + chieuDai) * 2;
	}
	
	public float tinhDienTich(float chieuRong, float chieuDai) {
		return chieuRong * chieuDai;
	}

}
