package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagementRepository extends JpaRepository<Management, String>{
	public Management findByPassword(String password);

	public Management findByUsername(String username);

}
