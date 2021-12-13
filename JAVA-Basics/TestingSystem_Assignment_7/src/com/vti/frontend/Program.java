package com.vti.frontend;


import com.vti.backend.Exercise1_Static;

public class Program {

	public static void main(String[] args) {
		
		
		Exercise1_Static exe1 = new Exercise1_Static();
		
//		exe1.question1();
//		exe1.question2();
//		exe1.question3();
//		exe1.question4();
//		exe1.question5();
//		exe1.question6();
//		exe1.question7();
		try {
			exe1.question8();
		} catch (Exception e) {
		  System.out.println(e.getMessage());
		}
		

	}

}
