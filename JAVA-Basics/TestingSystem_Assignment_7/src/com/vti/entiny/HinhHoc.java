package com.vti.entiny;

public class HinhHoc {
	
	private static float chieuDai;
	private static float chieuRong;
	private static float banKinh;
	private static int count;
	
	public HinhHoc() {
		count++;
	}

	public HinhHoc(float banKinh) {
		count++;
	}

	public HinhHoc(float chieuRong, float chieuDai) {
		count++;
	}

	public static float getChieuDai() {
		return chieuDai;
	}
	public static void setChieuDai(float chieuDai) {
		HinhHoc.chieuDai = chieuDai;
	}
	public static float getChieuRong() {
		return chieuRong;
	}
	public static void setChieuRong(float chieuRong) {
		HinhHoc.chieuRong = chieuRong;
	}
	public static float getBanKinh() {
		return banKinh;
	}
	public static void setBanKinh(float banKinh) {
		HinhHoc.banKinh = banKinh;
	}
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		HinhHoc.count = count;
	}
	

	

}
