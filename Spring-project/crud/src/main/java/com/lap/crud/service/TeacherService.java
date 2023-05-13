package com.lap.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lap.crud.entity.Teacher;
import com.lap.crud.repository.TeacherRepository;

@Service
public class TeacherService {
	
	@Autowired
	private TeacherRepository repository;
	
	public void save(Teacher teacher ) {
		repository.save(teacher);
	}
	
	public void delete (Teacher teacher) {
		repository.delete(teacher);
	}
	
	public Teacher findByID (long id ) {
		return repository.findById (id).get();
	}
	
	public List<Teacher> findAll () {
		return repository.findAll();
	}
	
}