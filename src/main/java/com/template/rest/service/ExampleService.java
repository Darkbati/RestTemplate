package com.template.rest.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.template.rest.constant.DBMapper;
import com.template.rest.dao.GenericDAO;
import com.template.rest.exception.InternalServerException;
import com.template.rest.model.RequestModel;

@Service
public class ExampleService extends GenericService {

	@Autowired
	@Qualifier("requestDAO")
	private GenericDAO<RequestModel, Map<String, Object>> requestDAO;

	public void InternalException() throws InternalServerException {
		throw new InternalServerException("Server Layer Exception", 998);
	}

	public void selectByKey() throws InternalServerException {
		Map<String, Object> params = new HashMap<String, Object>();
		requestDAO.selectByKey(DBMapper.DB01.SelectByKey, params);
	}
}
