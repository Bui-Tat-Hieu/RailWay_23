package com.vti.backend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Properties;

import com.vti.utils.JdbcUtils;
import com.vti.utils.ScannerUtils;



public class Exercise1_Basic {

//	Question 1: (Sử dụng Database Testing System đã xây dựng ở SQL)
//	Tạo connection tới database Testing System

	
	public void question1() throws FileNotFoundException, IOException {
		try {
			JdbcUtils.connectedForTesting();
			
//			Properties properties = new Properties();
//			properties.load(new FileInputStream("src/main/resource/database.properties.sql"));
//			
//			final String DB_URL = properties.getProperty("url");
//			final String USER_NAME = properties.getProperty("userName");
//			final String PASSWORD = properties.getProperty("password");
//			
//			// Bước 1: Đăng ký Driver Class với DriveManger
//			Class.forName("com.mysql.cj.jdbc.Driver"); //driver class cho SQL
//
//			// Bước 2: lấy một Connection đến Database
//			Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
//
//			// In ra "Connect success!" khi kết nối thành công.
//			System.out.println("kết nối thành công");

		} catch (ClassNotFoundException e) {
			System.out.println("Lỗi Đăng Ký Driver");
			e.printStackTrace();
		}catch (SQLException e) {
			System.out.println("Lỗi Kết Nối SQL");
			e.printStackTrace();
		}
	}
	
//	Question 2:
//		Tạo method để in ra các thông tin của position gồm có id, name
	
	public void question2() throws FileNotFoundException, IOException {
		
		try {
//			Properties properties = new Properties();
//			properties.load(new FileInputStream("src/main/resource/database.properties.sql"));
//			
//			final String DB_URL = properties.getProperty("url");
//			final String USER_NAME = properties.getProperty("userName");
//			final String PASSWORD = properties.getProperty("password");
//			
//			// Bước 1: Đăng ký Driver Class với DriveManger
//			Class.forName("com.mysql.cj.jdbc.Driver"); //driver class cho SQL
//
//			// Bước 2: lấy một Connection đến Database
//			Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
//			
//
//			System.out.println("kết nối thành công");
//			JdbcUtils.connectedForTesting();
			// Bước 3: tạo một đối tượng Statement
			
//			Statement statenent = connection.createStatement();
		
			// Bước 4: thực hiện truy vấn SQL
			
			String sql = "SELECT * FROM position";
			
			// Bước 5: thực hiện truy vấn SQL
			
			ResultSet resultSet = JdbcUtils.executeQuery(sql);;
			
			// Bước 6: xử lý Result set
			
			System.out.println("Thông tin Position đang có trên hệ thống: ");

			System.out.printf("+-----+-----------------+%n");
			System.out.printf("| %-3s | %-15s |%n", "ID", "PositionName");
			System.out.printf("+-----+-----------------+%n");
			
			while (resultSet.next()) {
				System.out.printf("| %-3s | %-15s |%n", resultSet.getInt("position_id"), resultSet.getString("position_name"));

			}
			System.out.format("+-----+-----------------+%n");
			// Bước 7: đóng kết nối
	
			JdbcUtils.disconnect();

		} catch (ClassNotFoundException e) {
			System.out.println("Lỗi Đăng Ký Driver");
			e.printStackTrace();
		}catch (SQLException e) {
			System.out.println("Lỗi Kết Nối SQL");
			e.printStackTrace();
		}
		
	}
	
//	Question 3: Tạo method để tạo position, user sẽ nhập vào name.
	
	public void question3() throws FileNotFoundException, IOException {
		try {
//			Properties properties = new Properties();
//			properties.load(new FileInputStream("src/main/resource/database.properties.sql"));
//			
//			final String DB_URL = properties.getProperty("url");
//			final String USER_NAME = properties.getProperty("userName");
//			final String PASSWORD = properties.getProperty("password");
//			
//			// Bước 1: Đăng ký Driver Class với DriveManger
//			Class.forName("com.mysql.cj.jdbc.Driver"); //driver class cho SQL
//
//			// Bước 2: lấy một Connection đến Database
//			Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
//
//			System.out.println("kết nối thành công");
			
			String sql = "insert into position (position_name) values(?)";
			
			// Bước 3:  tạo đối tượng preparedStatement
			PreparedStatement preparedStatement = JdbcUtils.getPreparedStatement(sql);

			// Dữ liệu đầu vào (ghi chú: có thể nhập vào từ bàn phím)
			System.out.println("Mời bạn nhập tên chúc vụ");
			String positionName = ScannerUtils.inputString();
		
			//Set parameter (thiết lập tham số)
			preparedStatement.setString(1, positionName);
				
			// Buoc 4: thực hiện câu lệnh
			int effectedRecorAmount = preparedStatement.executeUpdate();
				
			System.out.println("số bản ghi dã bị ảnh hưởng: " + effectedRecorAmount);
				
			// Bước 5: đóng kết nối
			JdbcUtils.disconnect();

		} catch (ClassNotFoundException e) {
			System.out.println("Lỗi Đăng Ký Driver");
			e.printStackTrace();
		}catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("Lỗi trùng giá trị");
		}catch (SQLException e) {
			System.out.println("Lỗi Kết Nối SQL");
			e.printStackTrace();
		}
	}
	
//	Question 4: Tạo method để update tên của position gồm có id = 5 thành "Dev".
	
	public void question4() {
		
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream("src/main/resource/database.properties.sql"));
			
			final String DB_URL = properties.getProperty("url");
			final String USER_NAME = properties.getProperty("userName");
			final String PASSWORD = properties.getProperty("password");
			
			// Bước 1: Đăng ký Driver Class với DriveManger
			Class.forName("com.mysql.cj.jdbc.Driver"); //driver class cho SQL

			// Bước 2: lấy một Connection đến Database
			Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);

			System.out.println("kết nối thành công");
			
			String sql = "update `position` set position_name = ? where position_id = ?";
			
			// Bước 3:  tạo đối tượng preparedStatement
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// Dữ liệu đầu vào (ghi chú: có thể nhập vào từ bàn phím)
				String positionName = "Dev";
				int positionId = 5;
		
			//Set parameter (thiết lập tham số)
				preparedStatement.setString(1, positionName);
				preparedStatement.setInt(2, positionId);
				
			// buoc 4 thực hiện câu lệnh SQL
				int effectedRecorAmount = preparedStatement.executeUpdate();
				
				System.out.println("số bản ghi dã bị ảnh hưởng: " + effectedRecorAmount);
				
			// Bước 5: đóng kết nối
			connection.close();

		} catch (ClassNotFoundException e) {
			System.out.println("Lỗi Đăng Ký Driver");
			e.printStackTrace();
		}catch (SQLException e) {
			System.out.println("Lỗi Kết Nối SQL");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	Question 5: Tạo method để delete của position theo id và user sẽ nhập vào id		
		
	public void question5() throws FileNotFoundException, IOException {
		
		try {
//			Properties properties = new Properties();
//			properties.load(new FileInputStream("src/main/resource/database.properties.sql"));
//			
//			final String DB_URL = properties.getProperty("url");
//			final String USER_NAME = properties.getProperty("userName");
//			final String PASSWORD = properties.getProperty("password");
//			
//			// Bước 1: Đăng ký Driver Class với DriveManger
//			Class.forName("com.mysql.cj.jdbc.Driver"); //driver class cho SQL
//
//			// Bước 2: lấy một Connection đến Database
//			Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
//
//			System.out.println("kết nối thành công");
			
			String sql = "delete from `position` where position_id = ?";
			
			// Bước 3:  tạo đối tượng preparedStatement
			PreparedStatement preparedStatement = JdbcUtils.getPreparedStatement(sql);

			// Dữ liệu đầu vào (ghi chú: có thể nhập vào từ bàn phím)
			System.out.println("Mời bạn nhập ID để xoá chúc vụ");
			int positionId = ScannerUtils.inputInt("Nhập sai! Vui lòng nhập dạng số. Nhập lại!");
		
			//Set parameter (thiết lập tham số)
			preparedStatement.setInt(1, positionId);
				
			// buoc 4 thực hiện truy vấn
			int effectedRecorAmount = preparedStatement.executeUpdate();
				
			System.out.println("số bản ghi dã bị ảnh hưởng: " + effectedRecorAmount);
				
			// Bước 5: đóng kết nối
			JdbcUtils.disconnect();

		} catch (ClassNotFoundException e) {
			System.out.println("Lỗi Đăng Ký Driver");
			e.printStackTrace();
		}catch (SQLException e) {
			System.out.println("Lỗi Kết Nối SQL");
			e.printStackTrace();
		}
	}	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
	
	
	

