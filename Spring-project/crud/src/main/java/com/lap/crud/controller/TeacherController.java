package com.lap.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.lap.crud.entity.Teacher;
import com.lap.crud.service.TeacherService;

@Controller
public class TeacherController {

	@Autowired	
	private TeacherService service;
	
	@GetMapping("/teacher/{id}")
	public String teacher (Model model, @PathVariable long id) {
		Teacher teacher = new Teacher();
		if (id != 0) {
			 teacher = service.findByID(id);			
		}
		model.addAttribute("teacher", teacher);
		return"teacher";
	}
	
	@GetMapping("/teachers")
	public String teachers (Model model) {
		List<Teacher> teachers = service.findAll();
		model.addAttribute("teachers", teachers);
		return "teachers";
	}
	
	@PostMapping("/teacher/save")
	public String save (@ModelAttribute("teacher") Teacher teacher) {
		service.save(teacher);
		return "redirect:/teachers";
	}
	
	@GetMapping("/teacher/delete/{id}")
	public String delete (@PathVariable long id){
		service.delete(service.findByID(id));
		return "redirect:/teachers";
	}
	
}
