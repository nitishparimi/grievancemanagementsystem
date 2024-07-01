package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Facultydao {
	
	@Autowired
	FacultyRepository repo;
	
	public Faculty getDetailsById(Faculty f) {
		return repo.findById(f.getId());
	}
	
	
	public boolean validateLogin(Faculty f) {
		Faculty faculty = repo.findById(f.getId());
		if(faculty != null && faculty.getPassword().equals(f.getPassword())) {
			return true;
		}
		return false;
	}

}
