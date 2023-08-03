package com.eshop.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.eshop.dao.IUserDAO;
import com.eshop.mapper.UserMapper;
import com.eshop.model.User;

public class UserDAO extends AbstractDAO<User> implements IUserDAO {

	@Override
	public List<User> findAll() {
		String sql = "SELECT * FROM user";
		return query(sql, new UserMapper());
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		String sql = "SELECT * FROM user WHERE username=? AND password=?";
		List<User> users = new ArrayList<>();
		users = query(sql, new UserMapper(), username, password);
		return users.isEmpty() ? new User() : users.get(0);
	}

	@Override
	public User findByEmail(String email) {
		String sql = "SELECT * FROM user WHERE email=?";
		List<User> users = new ArrayList<>();
		users = query(sql, new UserMapper(), email);
		return users.isEmpty() ? new User() : users.get(0);
	}

	@Override
	public User findByUsername(String username) {
		String sql = "SELECT * FROM user WHERE username=?";
		List<User> users = new ArrayList<>();
		users = query(sql, new UserMapper(), username);
		return users.isEmpty() ? new User() : users.get(0);
	}

	@Override
	public Long save(User user) {
		StringBuilder sql = new StringBuilder("INSERT INTO user(email, username, password) VALUES ");
		sql.append("(?,?,?)");
		return insert(sql.toString(), user.getEmail(), user.getUsername(), user.getPassword());
	}

}
