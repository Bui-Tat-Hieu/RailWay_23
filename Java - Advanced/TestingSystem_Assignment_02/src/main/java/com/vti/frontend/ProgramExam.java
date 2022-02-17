package com.vti.frontend;

import java.util.List;

import com.vti.backend.datelayer.ExamRepository;
import com.vti.enity.Exam;

public class ProgramExam {
	
	public static void main(String[] args) {
		
		ExamRepository examRepository = new ExamRepository();
		
		
		System.out.println("Danh Sách Exam");
		List<Exam> lists = examRepository.getAllExam();
		for (Exam exam : lists) {
			System.out.println(exam);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
