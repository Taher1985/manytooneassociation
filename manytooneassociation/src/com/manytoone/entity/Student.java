package com.manytoone.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "STUDENT_SEQ")
	@Column(name = "STUDENT_ID")
	private int studentId;

	@Column(name = "STUDENT_NAME")
	private String studentName;

	@ManyToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "GUIDE_ID")
	private Guide guide;

	public Student() {
		super();
	}

	public Student(String studentName, Guide guide) {
		super();
		this.studentName = studentName;
		this.guide = guide;
	}

	@Override
	public String toString() {
		return "Student Details are \nStudent Id: " + studentId + " and Student Name: " + studentName
				+ " \n\nGuide Details are " + guide;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Guide getGuide() {
		return guide;
	}

	public void setGuide(Guide guide) {
		this.guide = guide;
	}

}
