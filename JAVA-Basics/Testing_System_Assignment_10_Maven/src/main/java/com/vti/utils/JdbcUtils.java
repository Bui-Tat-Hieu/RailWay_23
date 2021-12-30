package com.vti.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils {
	
	private static Connection connection = null; 
	
	public static void connectedForTesting() throws ClassNotFoundException, SQLException {
		
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream("src/main/resource/database.properties.sql"));
			
			final String DB_URL = properties.getProperty("url");
			final String USER_NAME = properties.getProperty("userName");
			final String PASSWORD = properties.getProperty("password");
			final String DRIVER = properties.getProperty("driverName");
			
		// Đăng ký Driver Class với DriveManger
			Class.forName(DRIVER);
			
		// kết nối
			connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			
			System.out.println("Kết nối thành công");
			
		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException("Lỗi Đăng Ký Driver");
		}catch (SQLException e) {
			throw new SQLException("Lỗi Kết Nối SQL");
		} catch (FileNotFoundException e) {
			System.out.println("Lỗi không tìm thấy file");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Lỗi không đọc được file");
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		try {
			if (connection == null || connection.isClosed()) {
				throw new SQLException("Lỗi Kết Nối SQL");
			} else {
				connectedForTesting();
				return connection;
			}
		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException("Lỗi Đăng Ký Driver");
		} catch (SQLException e) {
			throw new SQLException("Lỗi Kết Nối SQL");
		}
		
	}
	
	public static void disconnect() throws SQLException {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			throw new SQLException("Lỗi Kết Nối SQL");
		}
	}
	
	public static ResultSet executeQuery(String sql) throws ClassNotFoundException, SQLException {
		if (connection == null || connection.isClosed()) {
			connectedForTesting();
		}
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		return resultSet;
	}
	
	public static PreparedStatement getPreparedStatement(String sql) throws SQLException, ClassNotFoundException {
		if (connection == null || connection.isClosed()) {
			connectedForTesting();
		}
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		return preparedStatement;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
