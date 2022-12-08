package com.github.pgleska.SpringAcademy2.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.github.pgleska.SpringAcademy2.entities.Student;

public interface StudentDAO extends JpaRepository<Student, Integer> {
	Optional<Student> findByEmail(String email);
	List<Student> findByEmailContaining(String email);
	Page<Student> findByEmailContaining(String email, Pageable pageable);
}
