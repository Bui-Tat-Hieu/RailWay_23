package com.vti.enity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "exam")
public class Exam implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "exam_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short examId;
	
	@Column(name = "`code1`", length = 10, nullable = false)
	private String code1;
	
	@Column(name = "title", length = 50)
	private String title;
	
	@Column(name = "duration", nullable = false)
	private short duration;
	
	@Column(name = "create_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;


	public Exam() {
		super();
	}


	public short getExamId() {
		return examId;
	}


	public void setExamId(short examId) {
		this.examId = examId;
	}


	public String getCode1() {
		return code1;
	}


	public void setCode1(String code1) {
		this.code1 = code1;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public short getDuration() {
		return duration;
	}


	public void setDuration(short duration) {
		this.duration = duration;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	@Override
	public String toString() {
		return "Exam [examId=" + examId + ", code1=" + code1 + ", title=" + title + ", duration=" + duration
				+ ", createDate=" + createDate + "]";
	}
	
	

}
