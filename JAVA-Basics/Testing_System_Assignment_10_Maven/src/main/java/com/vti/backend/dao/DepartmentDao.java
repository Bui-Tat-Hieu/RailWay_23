package com.vti.backend.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vti.entiny.Department;
import com.vti.utils.JdbcUtils;

public class DepartmentDao {
	
//	Question 1
//	Tạo method để lấy ra danh sách tất cả các Department
	public List<Department> getListDepartments() throws SQLException, ClassNotFoundException {
		try {
			List<Department> listDepartment = new ArrayList<Department>();
			
			// thực hiện truy vấn SQL
			String sql = "SELECT * FROM department";

			ResultSet resultSet = JdbcUtils.executeQuery(sql);
			
			// xử lý Result set
			while (resultSet.next()) {
				listDepartment.add(new Department((byte) resultSet.getByte(1), resultSet.getString(2)));
			}
			return listDepartment;
		
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
	}

//	Question 2 - 3
//	Tạo method để lấy ra Department có id = ?
	public Department getDepartmentById(byte id) throws SQLException, ClassNotFoundException, Exception {
		try {
			// thực hiện truy vấn SQL
			String sql = "SELECT * FROM department WHERE department_id = " + id + ";";
			 ResultSet resultSet = JdbcUtils.executeQuery(sql);
			 if (resultSet.next()) {
				 Department department = new Department((byte) resultSet.getInt(1), resultSet.getString(2)); 
				 return department;
			 } else {
				 throw new Exception("Không thể tìm thấy phòng ban có id = " + id);
			 }
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
	}

//	Question 5
//	Tạo method để check department name có tồn tại hay không?
	public boolean isDepartmentNameExists(String name) throws ClassNotFoundException, SQLException {
		try {
			String sql = "SELECT * FROM department WHERE department_name = ?;";
			PreparedStatement preparedStatement = JdbcUtils.getPreparedStatement(sql);
			preparedStatement.setString(1, name);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
	}
	
//	Tạo method để check department id có tồn tại hay không?
	public boolean isDepartmentIdExists(byte id) throws ClassNotFoundException, SQLException {
		try {
			String sql = "SELECT * FROM department WHERE department_id = ?;";
			PreparedStatement preparedStatement = JdbcUtils.getPreparedStatement(sql);
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
	}
	
//	Tạo method để người dùng có thể tạo được department	
	public void createDepartment(String name) throws SQLException, ClassNotFoundException, Exception {
		try {
			boolean isCheckNameExists = isDepartmentNameExists(name);
			if (isCheckNameExists) {
				throw new Exception("Tên phòng ban đã tồn tại!");
			}
			String sql = "INSERT INTO department (department_name) VALUES (?);";
			
			PreparedStatement preparedStatement = JdbcUtils.getPreparedStatement(sql);
			preparedStatement.setString(1, name);
			
			int effectedRecordAmount = preparedStatement.executeUpdate();
			System.out.println("Đã thêm " + effectedRecordAmount + " dòng");
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
	}
	
//	Question 6
//	Tạo method để người dùng có thể update được department name	
	public void updateDepartment(int id, String newName) throws SQLException, ClassNotFoundException, Exception {
		try {
		// check id
			boolean isCheckIdExixts = isDepartmentIdExists((byte) id);
			if (isCheckIdExixts == false) {
				throw new Exception("Không thể tìm thấy phòng ban có id = " + id);
			}
			
		// check name
			boolean isCheckNameExixts = isDepartmentNameExists(newName);
			if (isCheckNameExixts == true) {
				throw new Exception("Tên phòng ban đã tồn tại!");
			}
			
			String sql = "UPDATE department SET department_name = ? WHERE department_id = ?;";
		
			PreparedStatement preparedStatement = JdbcUtils.getPreparedStatement(sql);
			preparedStatement.setString(1, newName);
			preparedStatement.setInt(2, id);
			
			int effectedRecordAmount = preparedStatement.executeUpdate();
			System.out.println("Đã thêm " + effectedRecordAmount + " dòng");
			
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
		
	}
	
//	Question 7:
//	Tạo method để người dùng có thể xóa được department theo id mà user nhập vào	
	
	public void deleteDepartment(int id) throws SQLException, ClassNotFoundException, Exception {
		try {
		// check id
			boolean isCheckIdExixts = isDepartmentIdExists((byte) id);
			if (isCheckIdExixts == false) {
				throw new Exception("Không thể tìm thấy phòng ban có id = " + id);
			}
			
			String sql = "DELETE FROM department WHERE department_id = ?;";
			
			PreparedStatement preparedStatement = JdbcUtils.getPreparedStatement(sql);
			preparedStatement.setInt(1, id);
			
			int effectedRecordAmount = preparedStatement.executeUpdate();
			System.out.println("Đã xoá " + effectedRecordAmount + " dòng");
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
