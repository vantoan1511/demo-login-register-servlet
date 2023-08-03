package com.eshop.dao;

import java.util.List;

import com.eshop.mapper.RowMapper;

public interface GenericDAO<T> {

	List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);
	
	Long insert(String sql, Object... parameters);
}
