package com.vti.entiny;

public class Student {
	
	private int id;
	private String name;
	private String homeTown;
	private float score;
	
	
// b
	public Student(String name, String homeTown) {
		super();
		this.name = name;
		this.homeTown = homeTown;
		this.score = 0f;
	}

// c
	
	public void setScore(float score) {
		this.score = score;
	}

// d
	public void plusScore(float score) {
		this.score = this.score + score;
	}
	
// e
	@Override
	public String toString() {
		String rank = null;
		if (this.score < 4f) {
			rank = "Yếu";
		} else if (this.score < 6f) {
			rank = "Trung Bình";
		} else if (this.score < 8f) {
			rank = "Khá";
		} else {
			rank = "Giỏi";
		}	
		return "Student [name=" + name + ", score=" + score + ", Xếp Loại=" + rank + "]";

	}
}
