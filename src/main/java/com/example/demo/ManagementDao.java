package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagementDao {
	
	@Autowired
	ManagementRepository repo;
	
	public Management getDetailsById(Management m) {
		return repo.findByUsername(m.getUsername());
	}
	
	
	public boolean validateLogin(Management m) {
		Management management = repo.findByUsername(m.getUsername());
		if(management != null && management.getPassword().equals(m.getPassword())) {
			return true;
		}
		return false;
	}




}
