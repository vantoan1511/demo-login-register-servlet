package com.eshop.security;

import com.eshop.model.User;

public interface IAuthentication {

	boolean isAuthenticated();

	boolean authenticate(String enteredUsername, String enteredPassword);

	String getName();

	void logOut();

	void register(String email, String username, String password);

	User getUser();
}
