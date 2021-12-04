package com.vti.backend;


import java.util.Scanner;

import org.apache.commons.lang3.ArrayUtils;

import com.vti.entiny.News;

public class Exercise1_Abstraction {
	
	private News[] newArr; // create array news
	private Scanner scanner; // create thuộc tính scanner
	
	// create method Exercise1_Abstraction
	public Exercise1_Abstraction() {
		
		newArr = new News[] {};
		scanner = new Scanner(System.in);
	}
	
	public void question1() { 
		
		while (true) {
			System.out.println("\n\tLựa chọn chức năng bạn muốn sử ");
			System.out.println("\t1.Insert news");
			System.out.println("\t2.View list news.");
			System.out.println("\t3.Average rate");
			System.out.println("\t4.Exit");
			
			int menuchoose = scanner.nextInt();
			switch (menuchoose) {
			case 1 :
				insertNews();
				break;
			case 2 :
				viewListNews();
				break;
			case 3 :
				averageRate();
				break;
			case 4: 
				System.out.println("Bye");
				scanner.close();
				return;
			default :
				System.out.println("Lựa chọn số đúng trên menu");
				break;
			}
		}

	}

	private void insertNews() {

		System.out.println("\tMời Nhập Title");
		scanner.nextLine();
		String title = scanner.nextLine();
		System.out.println("\tMời Nhập Publish Date (dd-MM-yyyy)");
		String publishDate = scanner.nextLine();
		System.out.println("\tMời Nhập Author");
		String author = scanner.nextLine();
		System.out.println("\tMời Nhập Content");
		String content = scanner.nextLine();
		System.out.println("\tMời Nhập đánh giá 1");
		int rates1 = scanner.nextInt();
		System.out.println("\tMời Nhập đánh giá 2");
		int rates2 = scanner.nextInt();
		System.out.println("\tMời Nhập đánh giá 3");
		int rates3 = scanner.nextInt();
		
		int[] rateArr = new int[] {rates1, rates2, rates3};
		
		News news = new News(newArr.length, title, publishDate, author, content, rateArr);
		newArr = ArrayUtils.add(newArr, news);
		System.out.println("Đã thêm tin");
		System.out.println(news);
	}

	private void viewListNews() {
		
		News[] news = newArr;
		for (News newsItem : news) {
			newsItem.Display();
		}
	}

	private void averageRate() {
		
		News[] news = newArr;
		for (News newsItem : news) {
			newsItem.Calculate();
			newsItem.Display();
			
		}
	}


}