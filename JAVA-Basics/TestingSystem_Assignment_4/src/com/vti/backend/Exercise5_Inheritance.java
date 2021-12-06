package com.vti.backend;

import java.util.Scanner;

import org.apache.commons.lang3.ArrayUtils;

import com.vti.entiny.CanBo;
import com.vti.entiny.CongNhan;
import com.vti.entiny.KySu;
import com.vti.entiny.NhanVien;
import com.vti.entiny.enums.Gender;

import java.util.Arrays;

public class Exercise5_Inheritance {
	
	private static CanBo[] canBoArr;
	private static Scanner scanner;

	public Exercise5_Inheritance() {
		canBoArr = new CanBo[] {};
		scanner = new Scanner(System.in);
	}

	public void question1() { 
		
		while (true) {
			System.out.println("\n\tLựa chọn chức năng bạn muốn sử ");
			System.out.println("\t1.Thêm mới cán bộ.");
			System.out.println("\t2.Tìm kiếm theo họ tên.");
			System.out.println("\t3.Hiện thị thông tin về danh sách các cán bộ.");
			System.out.println("\t4.Nhập vào tên của cán bộ và delete cán bộ đó");
			System.out.println("\t5.Thoát khỏi chương trình.");
			
			int menuChoose = scanner.nextInt();
			switch (menuChoose) {
			case 1 :
				themCanBo();
				break;
			case 2 :
				timTheoTen();
				break;
			case 3 : 
				hienThiDanhSachCanBo();
				break;
			case 4 :
				xoaTheoTen();
				break;
			case 5 :
				return;
			default :
				System.out.println("Lựa chọn số đúng trên menu");
				break;
			}
		}
	}

// them can bo
	private void themCanBo() {
		
		System.out.println("\tLựa chọn chức năng bạn muốn sử ");
		System.out.println("\t1.Thêm Kỹ Sư");
		System.out.println("\t2.Thêm Công Nhân");
		System.out.println("\t3.Thêm Nhân Viên"); 
		
		int choose1 = scanner.nextInt();
		switch (choose1) {
		case 1 :
//			scanner.nextInt();
			System.out.println("\tNhập họ tên kỹ sư");
			scanner.nextLine();
			String tenKySu = scanner.nextLine();
			System.out.println("\tNhập tuổi kỹ sư");
			Byte tuoiKySu = scanner.nextByte();
			
			boolean isOkKySu = false;
			String genderKySu = null;
			while (isOkKySu == false) {
				System.out.println("\tNhập vào giới tính Kỹ Sư 1.Nam, 2.Nữ, 3.Unknown");
				int flagGender = scanner.nextInt();
				
				switch (flagGender) {
				case 1 :
					genderKySu = Gender.GENDER_NAM.getGender();
					isOkKySu = true;
					break;
				case 2 :
					genderKySu = Gender.GENDER_NU.getGender();
					isOkKySu = true;
					break;
				case 3 :
					genderKySu = Gender.GENDER_UNKOWN.getGender();
					isOkKySu = true;
					break;
				default :
					isOkKySu = false;
					break;
				}
			}
//			scanner.nextInt();
			System.out.println("\tNhập địa chỉ Kỹ Sư: ");
			scanner.nextLine();
			String homeTownKySu = scanner.nextLine();
			System.out.println("\tNhập chuyên ngành Kỹ Sư: ");
			String chuyenNganhKySu = scanner.nextLine();
			
			CanBo kySu = new KySu(tenKySu, tuoiKySu, genderKySu, homeTownKySu, chuyenNganhKySu);
			canBoArr = Arrays.copyOf(canBoArr, canBoArr.length + 1);
			canBoArr[canBoArr.length - 1] = kySu;
			System.out.println(kySu);
			break;
		case 2 :
			System.out.println("\tNhập họ tên Công Nhân");
			scanner.nextLine();
			String tenCongNhan = scanner.nextLine();
			System.out.println("\tNhập tuổi Công Nhân");
			byte tuoiCongNhan = scanner.nextByte();
			
			boolean isOkCongNhan = false;
			String genderCongNhan = null;
			while (isOkCongNhan == false) {
				System.out.println("\tNhập vào giới tính Kỹ Sư 1.Nam, 2.Nữ, 3.Unknown");
				int flagGender = scanner.nextInt();
				
				switch (flagGender) {
				case 1 :
					genderCongNhan = Gender.GENDER_NAM.getGender();
					isOkCongNhan = true;
					break;
				case 2 :
					genderCongNhan = Gender.GENDER_NU.getGender();
					isOkCongNhan = true;
					break;
				case 3 :
					genderCongNhan = Gender.GENDER_UNKOWN.getGender();
					isOkCongNhan = true;
					break;
				default :
					isOkCongNhan = false;
					break;
				}
			}
			
			scanner.nextLine();
			System.out.println("\tNhập địa chỉ Công Nhân: ");
			String homeTownCongNhan = scanner.nextLine();
			System.out.println("\tNhập Bậc Công Nhân: ");
			byte bacCongNhan = scanner.nextByte();
			
			CanBo congNhan = new CongNhan(tenCongNhan, tuoiCongNhan, genderCongNhan, homeTownCongNhan, bacCongNhan);
			canBoArr = Arrays.copyOf(canBoArr, canBoArr.length + 1);
			canBoArr[canBoArr.length - 1] = congNhan;
			System.out.println(congNhan);
			break;
		case 3 :
//			scanner.nextInt();
			System.out.println("\tNhập họ tên Nhân Viên");
			scanner.nextLine();
			String tenNhanVien = scanner.nextLine();
			System.out.println("\tNhập tuổi Nhân Viên");
			Byte tuoiNhanVien = scanner.nextByte();
			
			boolean isOkNhanVien = false;
			String genderNhanVien = null;
			while (isOkNhanVien == false) {
				System.out.println("\tNhập vào giới tính Kỹ Sư 1.Nam, 2.Nữ, 3.Unknown");
				int flagGender = scanner.nextInt();
				
				switch (flagGender) {
				case 1 :
					genderNhanVien = Gender.GENDER_NAM.getGender();
					isOkNhanVien = true;
					break;
				case 2 :
					genderCongNhan = Gender.GENDER_NU.getGender();
					isOkNhanVien = true;
					break;
				case 3 :
					genderCongNhan = Gender.GENDER_UNKOWN.getGender();
					isOkNhanVien = true;
					break;
				default :
					isOkNhanVien = false;
					break;
				}
			}
			
//			scanner.nextInt();
			System.out.println("\tNhập địa chỉ Nhân Viên: ");
			scanner.nextLine();
			String homeTownNhanVien = scanner.nextLine();
			System.out.println("\tNhập chuyên ngành Nhân Viên: ");
			String chuyenNganhNhanVien = scanner.nextLine();
			
			CanBo nhanVien = new NhanVien(tenNhanVien, tuoiNhanVien, genderNhanVien, homeTownNhanVien, chuyenNganhNhanVien);
			canBoArr = Arrays.copyOf(canBoArr, canBoArr.length + 1);
			canBoArr[canBoArr.length - 1] = nhanVien;
			System.out.println(nhanVien);
			break;
		
			default :
				break;	
		}
		
	}
	
// b.tìm kiếm họ tên
	private void timTheoTen() {
		
		System.out.println("\tNhập vào họ tên muốn tìm kiếm ");
		scanner.nextLine();
		String hoTen = scanner.nextLine();
		if (canBoArr.length > 0) {
			for (CanBo canBo : canBoArr) {
				if (canBo.getName().equals(hoTen)) {
					System.out.println(canBo);
				}
			}
		}
		
	}
	
// c.Thông tin về danh sách các cán bộ
	private void hienThiDanhSachCanBo() {
		
		String hoTen = scanner.nextLine();
		if (canBoArr.length > 0) {
			for (CanBo canBo : canBoArr) {
				System.out.println("\tThông tin về danh sách các cán bộ(Kỹ Sư, Công Nhân, Nhân Viên)");
				System.out.println(canBo);
			}
		} else {
			System.out.println("\tKhông có cán bộ để hiển thị");
		}
	}
	
// d.xoa theo ten
//	private void xoaTheoTen() {
//		
//		System.out.println("\tNhập vào tên cần xoá thông tin");
//		scanner.nextLine();
//		String hoTen = scanner.nextLine();
//		
//		int index = 0;
//		int[] indexArr = new int[] {};
//		if (canBoArr.length > 0) {
//			for (CanBo canBo : canBoArr) {
//				if (canBo.getName().equals(hoTen));
//					indexArr = ArrayUtils.add(indexArr, index);
//			}
//			index++;
//		}
////		xoa can bo theo indexArr(danh sach index) 
//		if (indexArr.length > 0) {
//			canBoArr = ArrayUtils.removeAll(canBoArr, indexArr);
//		}
//	}
	
	private void xoaTheoTen() {
	
	System.out.println("\tNhập vào tên cần xoá thông tin");
	scanner.nextLine();
	String hoTen = scanner.nextLine();
	
	int[] indexArr = new int[] {};
	
	for (int i = 0; i < canBoArr.length; i++ ) {
		if (hoTen.equals(canBoArr[i].getName())) {
			indexArr = ArrayUtils.add(indexArr, i);
		}
	}
//	xoa can bo theo indexArr(danh sach index) 
	if (indexArr.length > 0) {
		canBoArr = ArrayUtils.removeAll(canBoArr, indexArr);
	}else {
			System.out.println("không có tên nào trùng");
	}
	}
	
}
