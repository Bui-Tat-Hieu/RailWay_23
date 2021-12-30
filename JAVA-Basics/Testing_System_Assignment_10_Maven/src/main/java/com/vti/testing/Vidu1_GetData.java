package com.vti.testing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Vidu1_GetData {

	public static void main(String[] args) {
		
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream("src/main/resource/database.properties.sql"));
			
			final String DB_URL = properties.getProperty("url");
			final String USER_NAME = properties.getProperty("userName");
			final String PASSWORD = properties.getProperty("password");
			
			// bước 1 Đăng ký Driver Class với DriveManger
			Class.forName("com.mysql.cj.jdbc.Driver"); //driver class cho SQL
			
			
			// bước 2 lấy một Connection đến Database
			Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			
			System.out.println("kết nối thành công");
			
			// bước 3  tạo một đối tượng Statement
			
			Statement statenent = connection.createStatement();
			
			// buoc 4 thực hiện truy vấn SQL 
			String sql = "SELECT id, username, email FROM user";
			
			//buoc 5 thực hiện truy vấn SQL
			ResultSet resultSet = statenent.executeQuery(sql);
			
			// buoc 6 xử lý Result set
			while (resultSet.next()) {
				System.out.println(resultSet.getInt("id"));
				System.out.println(resultSet.getString("username"));
				System.out.println(resultSet.getString("email"));
			}
			// buoc 7 đóng kết nối
			
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
