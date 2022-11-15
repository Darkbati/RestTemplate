package com.template.rest.dao;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("requestDAO")
@RequiredArgsConstructor
public class RequestDAOImpl<E, K> implements GenericDAO<E, K> {
	private SqlSessionTemplate sqlSession;

	@Override
	public E selectByKey(String mapperId, K entity) {
		return sqlSession.selectOne(mapperId, entity);
	}

	@Override
	public List<E> selectAll(String statement) {
		return null;
	}

	@Override
	public Integer update(String statement, K entity) {
		return null;
	}

	@Override
	public Integer delete(String statement, K entity) {
		return null;
	}

	@Override
	public Integer insert(String statement, K entity) {
		return null;
	}
	
}
