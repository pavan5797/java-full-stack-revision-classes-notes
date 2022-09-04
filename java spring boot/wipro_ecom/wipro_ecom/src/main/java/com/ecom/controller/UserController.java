package com.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ecom.model.User;
import com.ecom.repo.UserRepo;

public class UserController {
	@Autowired
	private UserRepo uRepo;
	
	@PostMapping("/user/login")
	public String adminLogin(@RequestBody User us)
	{	
		User us1 = uRepo.findByEmail(us.getEmail());
		if(us1.getPassword().equals(us.getPassword())==true)
			return "welcome";
		else
			return "please check your email and passsowrd";
		
	}
}
