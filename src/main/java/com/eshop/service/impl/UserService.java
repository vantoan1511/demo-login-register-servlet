package com.eshop.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.eshop.dao.IUserDAO;
import com.eshop.model.User;
import com.eshop.service.IUserService;

public class UserService implements IUserService {

	@Inject
	private IUserDAO userDAO;

	@Override
	public List<User> findAll() {
		return userDAO.findAll();
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		return userDAO.findByUsernameAndPassword(username, password);
	}

	@Override
	public User findByEmail(String email) {
		return userDAO.findByEmail(email);
	}

	@Override
	public User findByUsername(String username) {
		return userDAO.findByUsername(username);
	}

	@Override
	public Long save(User user) {
		return userDAO.save(user);
	}

}
