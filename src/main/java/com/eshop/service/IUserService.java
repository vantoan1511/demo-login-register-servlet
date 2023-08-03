package com.eshop.service;

import java.util.List;

import com.eshop.model.User;

public interface IUserService {

	List<User> findAll();

	User findByUsernameAndPassword(String username, String password);
	
	User findByEmail(String email);
	
	User findByUsername(String username);
	
	Long save(User user);
}
