package com.vti.testing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Vidu2_CallProcedure {

	
	public static void main(String[] args) {
		
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream("src/main/resource/database.properties.sql"));
			
			final String DB_URL = properties.getProperty("url");
			final String USER_NAME = properties.getProperty("userName");
			final String PASSWORD = properties.getProperty("password");
			
			// Bước 1 Đăng ký Driver Class với DriveManger
			Class.forName("com.mysql.cj.jdbc.Driver"); //driver class cho SQL
			
			
			// Bước 2 lấy một Connection đến Database
			Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			
			System.out.println("kết nối thành công");
			
			// Bước 3 viết câu lệnh gọi Store procedure
			
			String sql = "call sp_update_user_by_id(?, ?, ?)";
			
			// Bước 4 tạo đối tượng CallableStatement
			CallableStatement callableStatement = connection.prepareCall(sql);
			
			String username = "lan123";
			String email = "lan123@gmail.com";
			int id = 3;
			
			// Truyền các tham số cần thiết
			callableStatement.setString(1, username);
			callableStatement.setString(2, email);
			callableStatement.setInt(3, id);
			
			// Gọi thủ tục
			int effectedRecordNumber = callableStatement.executeUpdate();
			
			System.out.println("số bản ghi bị ảnh hưởng: " + effectedRecordNumber);

			// Bước 5: đóng kết nối
			
			connection.close();
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Lỗi Đăng Ký Driver");
			e.printStackTrace();
		}catch (SQLException e) {
			System.out.println("Lỗi Kết Nối SQL");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
}
