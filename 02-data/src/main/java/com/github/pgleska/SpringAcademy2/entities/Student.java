package com.github.pgleska.SpringAcademy2.entities;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String email;
	
	private Integer studentId;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "student_course", 
		joinColumns = @JoinColumn(referencedColumnName = "id", name = "student_id"),
		inverseJoinColumns = @JoinColumn(referencedColumnName = "id", name = "course_id")
	)
	private Set<Course> courses;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Integer getStudentId() {
		return studentId;
	}
	
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	
	@Override
	public String toString() {
		return "Student: {id: " + id + ", email: " + email + ", studentId: " + studentId + "}";
	}
}
