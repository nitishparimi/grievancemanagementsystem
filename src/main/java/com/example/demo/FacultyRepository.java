package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty, String>{
	public Faculty findByPassword(String password);

	public Faculty findByUsername(String username);
	
	public Faculty findById(int id);

}
