package com.ecom.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.Admin;

// @Repository --> not needed when we extends JpaRepository
public interface AdminRepo extends JpaRepository<Admin, Integer>{
	public Admin findByEmail(String email);
}


/*
	Insert save ( )
	delete delete ( ) <== PK
	update no method <== PK
	list all data : findAll ( )
	search findById ( ) <== PK
*/