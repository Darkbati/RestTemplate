package com.template.rest.exception;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

//@Component
public class ErrorMessage {
	protected static Logger logger = LogManager.getLogger(ErrorMessage.class);

	protected HashMap<Integer, String> messageMap = new HashMap<Integer, String>();

	public ErrorMessage() {

	}

	@PostConstruct
	public void Init() {
		try {
			Properties props = new Properties();
			props.load(new FileInputStream(System.getProperty("errorcode.properties")));

			Enumeration<Object> keyEnum = props.keys();
			while (keyEnum.hasMoreElements()) {
				String key = (String) keyEnum.nextElement();

				if (StringUtils.isNotEmpty(key)) {
					String message = props.getProperty(key);
					messageMap.put(Integer.parseInt(key), message);
				}
			}
		} catch (IOException e) {
			logger.error(e);
		}
	}

	public String getMessage(Integer errorCode) {
		if (messageMap.size() <= 0) {
			return "Error Message Map is not initaialize";
		}
		if (messageMap.containsKey(errorCode) == false) {
			return "Not found error message";
		}
		return messageMap.get(errorCode);
	}

}
