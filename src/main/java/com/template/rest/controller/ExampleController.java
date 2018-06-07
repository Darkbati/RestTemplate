package com.template.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.template.rest.exception.InternalServerException;
import com.template.rest.model.RequestModel;
import com.template.rest.protocol.ResponseProtocol;
import com.template.rest.service.ExampleService;

public class ExampleController {

	@Autowired
	private ExampleService exampleService;

	@RequestMapping(value = "/exception", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseProtocol exception(@RequestBody RequestModel model) throws InternalServerException {
		try {
			exampleService.InternalException();
		} catch (InternalServerException e) {
			throw e;
		} catch (Exception e) {
			throw new InternalServerException("Sytem Exception", e.getMessage(), e.getCause(), 500);
		}

		//throw new InternalServerException("Exception is test code", 500);
		return new ResponseProtocol();
	}
}
