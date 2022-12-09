package com.github.pgleska.SpringAcademy2.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.pgleska.SpringAcademy2.entities.Teacher;

public interface TeacherDAO extends JpaRepository<Teacher, Integer> {

}
