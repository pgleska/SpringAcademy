package com.github.pgleska.SpringAcademy2.api.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.github.pgleska.SpringAcademy2.api.dto.CourseDTO;
import com.github.pgleska.SpringAcademy2.api.dto.TeacherDTO;
import com.github.pgleska.SpringAcademy2.daos.TeacherDAO;
import com.github.pgleska.SpringAcademy2.entities.Teacher;

@RestController
public class TeacherController {

	private final TeacherDAO teacherDAO;
	
	public TeacherController(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}
	
	@GetMapping(value = "/teacher/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getTeacher(@PathVariable("id") Integer id) {
		Optional<Teacher> teacherOptional = teacherDAO.findById(id);
		if(teacherOptional.isEmpty())		
			return ResponseEntity.ok(Map.of("Teacher", "Not found"));
		Teacher teacher = teacherOptional.get();
		List<TeacherDTO> dtos = new ArrayList<>();
		teacher.getCourses().forEach(c -> {
			CourseDTO dto = new CourseDTO(c);
			dtos.add(new TeacherDTO(teacher, dto));
		});				
		return ResponseEntity.ok(dtos);
	}
	
}
