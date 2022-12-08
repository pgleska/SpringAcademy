package com.github.pgleska.SpringAcademy2.api.controllers;

import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pgleska.SpringAcademy2.daos.StudentDAO;
import com.github.pgleska.SpringAcademy2.entities.Student;

@RestController
public class StudentController {

	private final StudentDAO studentDAO;
	
	public StudentController(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}	
	
	@GetMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getStudents(@RequestParam(name = "email") Optional<String> email) {
		if(email.isPresent()) {
			return ResponseEntity.ok(Map.of("students", studentDAO.findByEmail(email.get())));
		} else {
			return ResponseEntity.ok(Map.of("students", studentDAO.findAll()));
		}
	}
	
	@GetMapping(value = "/students/email-contaning", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getStudentsByEmailContaingCharacters(@RequestParam(name = "email") Optional<String> email) {
		if(email.isPresent()) {
			return ResponseEntity.ok(Map.of("students", studentDAO.findByEmailContaining(email.get())));
		} else {
			return ResponseEntity.ok(Map.of("students", studentDAO.findAll()));
		}
	}
	
	@GetMapping(value = "/students/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getOneStudent(@PathVariable("id") Integer id) {
		Optional<Student> student = studentDAO.findById(id);
		if(student.isPresent()) {
			return ResponseEntity.ok(Map.of("student", student.toString()));
		} else {
			return ResponseEntity.ok(Map.of("student", "Not found"));
		}
	}
	
	@GetMapping(value = "/students-sorted-by-email", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getStudentsSortedByEmail() {
		return ResponseEntity.ok(Map.of("students", studentDAO.findAll(Sort.by(Sort.Direction.ASC, "email"))));
	}
	
	@GetMapping(value = "/students-pagination", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getStudentsWithPagination(Pageable pageable) {
		Page<Student> page = studentDAO.findAll(pageable);
		return ResponseEntity.ok(page);
	}
	
	
	@GetMapping(value = "/students/email-contaning-paginated", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getStudentsByEmailContaingCharactersPaginated(@RequestParam(name = "email") Optional<String> email, 
			Pageable pageable) {
		if(email.isPresent()) {
			return ResponseEntity.ok(Map.of("students", studentDAO.findByEmailContaining(email.get(), pageable)));
		} else {
			return ResponseEntity.ok(Map.of("students", studentDAO.findAll()));
		}
	}
}
