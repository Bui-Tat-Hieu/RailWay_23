package com.vti.frontend;

import java.io.IOException;

import com.vti.backend.Exercise1_Basic;

public class Program1 {

	public static void main(String[] args) {
		
		Exercise1_Basic exercise1 = new Exercise1_Basic();

		try {
//			exercise1.question1();
//			exercise1.question2();
//			exercise1.question3();
//			exercise1.question4();
			exercise1.question5();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
