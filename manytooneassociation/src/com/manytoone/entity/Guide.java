package com.manytoone.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Guide {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "GUIDE_SEQ")
	@Column(name = "GUIDE_ID")
	private int guideId;

	@Column(name = "GUIDE_NAME")
	private String guideName;

	@OneToMany(mappedBy = "guide", cascade = { CascadeType.PERSIST ,CascadeType.REMOVE})
	private List<Student> students;

	public Guide() {
		super();
	}

	public Guide(String guideName) {
		super();
		this.guideName = guideName;
	}

	public int getGuideId() {
		return guideId;
	}

	public void setGuideId(int guideId) {
		this.guideId = guideId;
	}

	public String getGuideName() {
		return guideName;
	}

	public void setGuideName(String guideName) {
		this.guideName = guideName;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public void addStudent(Student student) {
		student.setGuide(this);
	}
	
	@Override
	public String toString() {
		return "\nGuide Id: " + guideId + " and Guide Name: " + guideName;
	}

}
