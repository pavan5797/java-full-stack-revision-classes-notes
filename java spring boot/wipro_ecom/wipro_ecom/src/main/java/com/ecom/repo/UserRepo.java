package com.ecom.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	public User findByEmail(String email);

}
