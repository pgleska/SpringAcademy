package com.github.pgleska.SpringAcademy2.api.dto;

import com.github.pgleska.SpringAcademy2.entities.Teacher;

public class TeacherDTO {
	private Integer id;
	private String firstName;
	private String lastName;
	private CourseDTO course;
	
	public TeacherDTO(Teacher teacher, CourseDTO course) {
		this.id = teacher.getId();
		this.firstName = teacher.getFirstName();
		this.lastName = teacher.getLastName();
		this.course = course;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public CourseDTO getCourse() {
		return course;
	}
}
