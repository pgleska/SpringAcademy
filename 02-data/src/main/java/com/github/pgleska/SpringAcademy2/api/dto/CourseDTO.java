package com.github.pgleska.SpringAcademy2.api.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.github.pgleska.SpringAcademy2.entities.Course;
import com.github.pgleska.SpringAcademy2.entities.Student;

public class CourseDTO {
	private Integer id;
	private String name;
	private List<Integer> studentIds;
	
	public CourseDTO(Course course) {
		this.id = course.getId();
		this.name = course.getName();
		this.studentIds = course.getStudents().stream().map(Student::getStudentId).collect(Collectors.toList());
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public List<Integer> getStudentIds() {
		return studentIds;
	}
}
