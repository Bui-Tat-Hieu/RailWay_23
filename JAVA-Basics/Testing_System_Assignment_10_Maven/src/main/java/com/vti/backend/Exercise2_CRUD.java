package com.vti.backend;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.dao.DepartmentDao;
import com.vti.entiny.Department;
import com.vti.utils.ScannerUtils;

public class Exercise2_CRUD {
	
	DepartmentDao departmentDao = new DepartmentDao();
	
//	Question 1: read data – get list departments
//	Tạo method để lấy ra danh sách tất cả các Department
	public void question1() throws ClassNotFoundException, SQLException {
		List<Department> listDepartment = departmentDao.getListDepartments();
		
		System.out.println("Thông tin Department đang có trên hệ thống: ");
		System.out.printf("+-----+-----------------+%n");
		System.out.printf("| %-3s | %-15s |%n", "ID", "Department Name");
		System.out.printf("+-----+-----------------+%n");
		
		for (Department department : listDepartment) {
			System.out.printf("| %-3s | %-15s |%n", department.getDepartmentId(), department.getDepartmentName());
		}
		System.out.format("+-----+-----------------+%n");
	}
	
//	Question 2: read data – get department by id
//	Tạo method để lấy ra Department có id = 5
	public void question2() throws ClassNotFoundException, SQLException, Exception {
		Department department = departmentDao.getDepartmentById((byte) 5);
		
		System.out.println("Thông tin Department đang có trên hệ thống: ");
		System.out.printf("+-----+-----------------+%n");
		System.out.printf("| %-3s | %-15s |%n", "ID", "Department Name");
		System.out.printf("+-----+-----------------+%n");
		
		if (department != null) {
			System.out.printf("| %-3s | %-15s |%n", department.getDepartmentId(), department.getDepartmentName());
		} 
		System.out.format("+-----+-----------------+%n");
	}
	
//	Question 3: Tiếp tục Question 2 (read data – get department by id)
//	Không fix cứng id nữa mà sẽ dùng scanner để yêu cầu người dùng nhập vào id,
//	sau đó trả về thông tin department có id như người dùng nhập vào
	public void question3() throws ClassNotFoundException, SQLException, Exception {
		System.out.println("Mời bạn nhập vào ID muôn tìm kiếm");
		int id = ScannerUtils.inputInt("Nhập sai! Nhập dưới dạng số. Nhập lại!");
		Department department = departmentDao.getDepartmentById((byte) id);
		
		System.out.println("Thông tin Department đang có trên hệ thống: ");
		System.out.printf("+-----+-----------------+%n");
		System.out.printf("| %-3s | %-15s |%n", "ID", "Department Name");
		System.out.printf("+-----+-----------------+%n");
		
		if (department != null) {
			System.out.printf("| %-3s | %-15s |%n", department.getDepartmentId(), department.getDepartmentName());
		} 
		System.out.format("+-----+-----------------+%n");
	}
	
//	Question 4: check data exists – check department name exists
//	Tạo method để check department name có tồn tại hay không?
	
	public void question4() throws ClassNotFoundException, SQLException {
		System.out.println("Mời bạn nhập vào tên phòng ban muốn tìm kiếm");
		String departmentName = ScannerUtils.inputString();
		boolean isDepartment = departmentDao.isDepartmentNameExists(departmentName);
		if (isDepartment) {
			System.out.println("Có phòng ban là " + departmentName);
		} else {
			System.out.println("Không có phòng ban là " + departmentName);
		}	
	}
	
//	Question 5: create data – create department
//	Tạo method để người dùng có thể tạo được department
	
	public void question5() throws ClassNotFoundException, SQLException, Exception {
		System.out.println("Mời bạn nhập vào tên phòng ban muốn thêm");
		String departmentName = ScannerUtils.inputString();
		departmentDao.createDepartment(departmentName);
	}
	
//	Question 6: update data – update department
//	Tạo method để người dùng có thể update được department name
	
	public void question6() throws ClassNotFoundException, SQLException, Exception {
		System.out.println("Mời bạn nhập vào ID");
		int id = ScannerUtils.inputInt("Nhập sai! Nhập dưới dạng số. Nhập lại!");
		
		System.out.println("Mời bạn nhập vào tên phòng ban");
		String departmentName = ScannerUtils.inputString();
		departmentDao.updateDepartment(id, departmentName);
	}
	
//	Question 7:
//	Tạo method để người dùng có thể xóa được department theo id mà user nhập vào
	
	public void question7() throws SQLException, ClassNotFoundException, Exception {
		System.out.println("Mời bạn nhập vào ID muốn xoá");
		int id = ScannerUtils.inputInt("Nhập sai! Nhập dưới dạng số. Nhập lại!");
		departmentDao.deleteDepartment(id);
	}
	
	
	
	
	
	
	
	
}
