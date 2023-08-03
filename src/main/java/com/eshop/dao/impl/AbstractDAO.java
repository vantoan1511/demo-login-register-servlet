package com.eshop.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.eshop.dao.GenericDAO;
import com.eshop.mapper.RowMapper;

public class AbstractDAO<T> implements GenericDAO<T> {

	private Connection getConnection() {
		try {
			Connection connection = null;
			String url = "jdbc:mysql://localhost:3306/eshopservlet";
			String username = "root";
			String password = "admin";
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
			return connection;
		} catch (SQLException | ClassNotFoundException e) {
			return null;
		}
	}

	@Override
	public List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		List<T> results = new ArrayList<>();
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			setParameters(statement, parameters);
			rs = statement.executeQuery();
			while (rs.next()) {
				results.add(rowMapper.mapRow(rs));
			}
			return results;
		} catch (Exception e) {
			return null;
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e2) {

			}
		}
	}

	@Override
	public Long insert(String sql, Object... parameters) {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		Long id = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			setParameters(statement, parameters);
			statement.executeUpdate();
			rs = statement.getGeneratedKeys();
			while (rs.next()) {
				id = rs.getLong(1);
			}
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
			}
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e2) {

			}
		}
		return id;
	}

	private void setParameters(PreparedStatement statement, Object... parameters) {
		for (int i = 0; i < parameters.length; i++) {
			try {
				if (parameters[i] instanceof String) {
					statement.setString(i + 1, (String) parameters[i]);
				}
				if (parameters[i] instanceof Long) {
					statement.setLong(i + 1, (long) parameters[i]);
				}
			} catch (SQLException e) {

			}
		}
	}
}