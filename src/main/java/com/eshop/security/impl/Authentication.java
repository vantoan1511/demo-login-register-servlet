package com.eshop.security.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.eshop.model.User;
import com.eshop.security.IAuthentication;
import com.eshop.service.IUserService;

@ApplicationScoped
public class Authentication implements IAuthentication {

	@Inject
	private IUserService userService;

	private User user;
	private boolean isAuthenticated;

	public Authentication() {
		this.user = new User();
		this.isAuthenticated = false;
	}

	public Authentication getAuthen() {
		return this;
	}

	@Override
	public User getUser() {
		return this.user;
	}

	@Override
	public boolean isAuthenticated() {
		return this.isAuthenticated;
	}

	@Override
	public boolean authenticate(String enteredUsername, String enteredPassword) {
		if (isValidUser(enteredUsername, enteredPassword)) {
			this.isAuthenticated = true;
		} else {
			this.isAuthenticated = false;
		}
		return this.isAuthenticated;
	}

	@Override
	public String getName() {
		return this.user.getUsername();
	}

	@Override
	public void logOut() {
		this.isAuthenticated = false;
		this.user.setEmail("");
		this.user.setUsername("");
		this.user.setPassword("");
	}

	@Override
	public void register(String email, String username, String password) {
		User user = new User();
		if (userService.findByEmail(email).getUsername().equals("")) {
			user.setEmail(email);
		}
		if (userService.findByUsername(username).getUsername().equals("")) {
			user.setUsername(username);
		}
		if (!user.getEmail().equals("") && !user.getUsername().equals("")) {
			user.setPassword(password);
			userService.save(user);
		}
		this.user = user;
	}

	private boolean isValidUser(String enteredUsername, String enteredPassword) {
		user = userService.findByUsernameAndPassword(enteredUsername, enteredPassword);
		if (!user.getUsername().equals("")) {
			return true;
		}
		return false;
	}
}
