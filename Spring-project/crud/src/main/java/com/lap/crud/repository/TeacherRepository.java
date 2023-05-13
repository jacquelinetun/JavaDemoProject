package com.lap.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lap.crud.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{

}
