package com.vti.frontend;

import java.sql.SQLException;
import java.util.Scanner;

import com.vti.backend.Exercise2_CRUD;
import com.vti.utils.JdbcUtils;

public class Program2 {

	public static void main(String[] args) {

		Exercise2_CRUD exercise2 = new Exercise2_CRUD();
		Scanner scanner = new Scanner(System.in);
		
		try {
//			exercise2.question1();
//			exercise2.question2();
//			exercise2.question3();
//			exercise2.question4();
//			exercise2.question5();
//			exercise2.question6();
			exercise2.question7();
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			scanner.close();
			try {
				JdbcUtils.disconnect();
			} catch (SQLException e) {
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
		}

		
	}

}
