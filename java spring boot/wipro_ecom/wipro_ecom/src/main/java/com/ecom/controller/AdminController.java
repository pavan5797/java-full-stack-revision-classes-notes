package com.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.model.Admin;
import com.ecom.repo.AdminRepo;

@RestController
public class AdminController {
	
	@Autowired
	private AdminRepo aRepo;
	
	@PostMapping("/admin/login")
	public String adminLogin(@RequestBody Admin ad)
	{
		Admin ad1 = aRepo.findByEmail(ad.getEmail());
		if(ad1.getPassword().equals(ad.getPassword())==true)
			return "welcome";
		else
			return "please check your email and passsowrd";
		
	}

}
