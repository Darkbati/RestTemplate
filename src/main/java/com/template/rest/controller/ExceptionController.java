package com.template.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.template.rest.exception.ErrorMessage;
import com.template.rest.exception.InternalServerException;
import com.template.rest.protocol.ResponseProtocol;

@ControllerAdvice
@RestController
public class ExceptionController {

	@Autowired
	protected ErrorMessage errorMessage = new ErrorMessage();

	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(value = InternalServerException.class)
	@ResponseBody
	public ResponseProtocol InternalServerException(InternalServerException e) {
		return new ResponseProtocol(e.getErrorCode(), errorMessage.getMessage(e.getErrorCode()));
	}

}
