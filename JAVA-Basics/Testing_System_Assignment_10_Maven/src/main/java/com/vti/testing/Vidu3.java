package com.vti.testing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class Vidu3 {

	public static Connection getConnection() {
		Properties properties = new Properties();
		Connection connection = null;
		
		try {
			properties.load(new FileInputStream("src/main/resource/database.properties.sql"));
			
			final String DB_URL = properties.getProperty("url");
			final String USER_NAME = properties.getProperty("userName");
			final String PASSWORD = properties.getProperty("password");
			
			// Bước 1 Đăng ký Driver Class với DriveManger
			Class.forName("com.mysql.cj.jdbc.Driver"); //driver class cho SQL
						
						
			// Bước 2 lấy một Connection đến Database
			connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			
			System.out.println("kết nối thành công");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e ) {
			e.printStackTrace();
		} catch (ClassNotFoundException e ) {
			e.printStackTrace();
		}catch (SQLException e ) {
			e.printStackTrace();
		}
		return connection;
	}
	


		// Tạo Team
		public static void createTeam(Connection connection) throws SQLException {

				String sql = "insert into team (name) values(?)";

				// Bước 3: Tạo một đối tượng PreparedStatement
				PreparedStatement preparedStatement = connection.prepareStatement(sql);

				// Dữ liệu đầu vào(ghi chú: có thể nhập vào từ bàn phím)
				String name = "Team 1";
				// Set parameter(thiết lập tham số)
				preparedStatement.setString(1, name);

				// Bước 4: Thực hiện truy vấn SQL
				int effectedRecordAmount = preparedStatement.executeUpdate();

				System.out.println("Số bản ghi đã bị ảnh hưởng: " + effectedRecordAmount);
				
		}
		
		// Tạo user
		public static void createUser(Connection connection) throws SQLException {
	 
				String sql = "insert into `user`(username,email) values(?, ?)";

				// Bước 3: Tạo một đối tượng PreparedStatement
				PreparedStatement preparedStatement = connection.prepareStatement(sql);

				// Dữ liệu đầu vào(ghi chú: có thể nhập vào từ bàn phím)
				String username = "dang123";
				String email = "dang123@gmail.com";

				// Set parameter(thiết lập tham số)
				preparedStatement.setString(1, username);
				preparedStatement.setString(2, email);

				// Bước 4: Thực hiện truy vấn SQL
				int effectedRecordAmount = preparedStatement.executeUpdate();

				System.out.println("Số bản ghi đã bị ảnh hưởng: " + effectedRecordAmount);
		 
		}
	
		// Thêm User vào Team
		public static void addUserToTeam(Connection connection) throws SQLException {
	 
				String sql = "insert into team_user (team_id, user_id) values(?,?)";

				// Bước 3: Tạo một đối tượng PreparedStatement
				PreparedStatement preparedStatement = connection.prepareStatement(sql);

				// Dữ liệu đầu vào(ghi chú: có thể nhập vào từ bàn phím)
				int teamId = 10;
				int userId = 1;
				// Set parameter(thiết lập tham số)
				preparedStatement.setInt(1, teamId);
				preparedStatement.setInt(2, userId);

				// Bước 4: Thực hiện truy vấn SQL
				int effectedRecordAmount = preparedStatement.executeUpdate();

				System.out.println("Số bản ghi đã bị ảnh hưởng: " + effectedRecordAmount);
			 
		}
	
		public static void main(String[] args) {
			Connection connection = getConnection();
			//turn off auto commit
			try {
				// AutoCommit = false: tắt commit
				connection.setAutoCommit(false);
				//mặc  định AutoCommit = true
				createTeam(connection);
				createUser(connection);
				addUserToTeam(connection);
				
				//commit connection
				connection.commit();
				System.out.println("Transaction commit!"); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				try {
					connection.rollback();
					System.out.println("roll back!"); 
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			try {
				connection.setAutoCommit(true);
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
