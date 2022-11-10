package com.template.rest.controller;

import java.util.HashMap;
import java.util.Map;

import com.template.rest.service.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.template.rest.exception.InternalServerException;
import com.template.rest.model.RequestModel;
import com.template.rest.protocol.ResponseProtocol;
import com.template.rest.service.ExampleService;

@RestController
@RequiredArgsConstructor
public class ExampleController {

	private final ExampleService exampleService;
	private final JWTService jwtService;

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

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Korean");
		return new ResponseProtocol(map, HashMap.class.getName());
	}

	@RequestMapping(value = "/test", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseProtocol test() throws InternalServerException {
		String token = jwtService.createToken();

		System.out.println(token);

		String expiredToken = "eyJyZWdEYXRlIjoxNjY3OTYxNzc2NDk3LCJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6InRlc3QiLCJ1c2VybmFtZSI6ImRhcmtiYXRpIiwiZXhwIjoxNjY3OTYxODM2fQ.KtVt7dosul2sY5k0VLvN-FXBgSsv6krkxwAWphRrPcg";

		try {
			String t = jwtService.getSubject(expiredToken);
			System.out.println("test");
		} catch(Exception e) {
			System.out.println("test");
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Korean");
		return new ResponseProtocol(map, HashMap.class.getName());
	}
}
