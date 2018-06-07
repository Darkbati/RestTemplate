package com.template.rest.service;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class GenericService {

	@SuppressWarnings("unchecked")
	public Map<String, Object> ObjectToMap(Object object) {
		ObjectMapper oMapper = new ObjectMapper();
		return oMapper.convertValue(object, Map.class);
	}

}
