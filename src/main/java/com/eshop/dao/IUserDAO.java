package com.eshop.dao;

import java.util.List;

import com.eshop.model.User;

public interface IUserDAO {

	List<User> findAll();

	User findByUsernameAndPassword(String username, String password);

	User findByEmail(String email);

	User findByUsername(String username);
	
	Long save(User user);
}
