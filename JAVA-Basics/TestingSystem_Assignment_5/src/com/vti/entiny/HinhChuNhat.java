package com.vti.entiny;

public class HinhChuNhat {
	
	private double dai;
	private double rong;
	
	// tạo constructor có tham số
	public HinhChuNhat(double dai, double rong) {
		super();
		this.dai = dai;
		this.rong = rong;
	}
	
	public double tinhDienTich() {
//		test();
		return dai * rong;
	}
	
	public double tinhChuVi() {
//		test();
		return (dai + rong) * 2;
	}
	
	public void test() {
		System.out.println("Tính theo hình chữ nhật");
	}

}
