package com.github.pgleska.SpringAcademy2.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.pgleska.SpringAcademy2.entities.Course;

public interface CourseDAO extends JpaRepository<Course, Integer> {

}
