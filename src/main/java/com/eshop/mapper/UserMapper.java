package com.eshop.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.eshop.model.User;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs) {
		try {
			User user = new User();
			user.setId(rs.getLong("id"));
			user.setEmail(rs.getString("email"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			return user;
		} catch (SQLException e) {
			return null;
		}
	}

}
