package com.ecommerce.dao;

import com.ecommerce.model.user;

public interface userDao {
	boolean register(user u);
	boolean userLogin(String email , String password);
	
}
