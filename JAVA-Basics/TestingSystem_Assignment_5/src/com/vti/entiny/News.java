package com.vti.entiny;

import java.util.Arrays;

public class News implements INews {

	private int ID;
	private String title; // tiêu đề
	private String publishDate; // ngày xuất bản
	private String author; // tác giả
	private String content;
	private float averageRate; // tỷ lệ trung bình
	private int[] rates;
	
	public News(int id,String title, String publishDate, String author, String content,
			int[] rates) {
		super();
		this.ID = id;
		this.title = title;
		this.publishDate = publishDate;
		this.author = author;
		this.content = content;
		this.rates = rates;
		
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public float getAverageRate() {
		return averageRate;
	}
	
	@Override
	public String toString() {
		return "News [ID=" + ID 
				+ ", title=" + title 
				+ ", publishDate=" + publishDate 
				+ ", author=" + author
				+ ", content=" + content
				+ ", rates=" + Arrays.toString(rates) + "]";
	}
	@Override
	public void Display() {
		System.out.println("title=" + this.title 
						+ ", publishDate=" + this.publishDate 
						+ ", author=" + this.author 
						+ ", content=" + this.content
						+ ", averageRate=" + this.averageRate);
	}

	@Override
	public void Calculate() {
		if (this.rates != null) {
			float averageRate = (float) (this.rates[0] + this.rates[1] + this.rates[2]) / 3;
			this.averageRate = averageRate;
		}
	}
	
}
