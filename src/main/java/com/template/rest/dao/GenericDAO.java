package com.template.rest.dao;

import java.util.List;

public interface GenericDAO<E, K> {
	public E selectByKey(String statement, K entity);
	
	public List<E> selectAll(String statement);
	
	public Integer update(String statement, K entity);

	public Integer delete(String statement, K entity);
	
	public Integer insert(String statement, K entity);
}
