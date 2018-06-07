package com.template.rest.protocol;

public class ResponseProtocol {
	private Integer resultCode;
	private String resultMessage;
	private String resultClassName;
	private Object resultObject;

	public ResponseProtocol() {
		this.resultCode = 0;
		this.resultMessage = "success";
		this.resultObject = null;
	}

	public ResponseProtocol(Object object, String className) {
		this.resultCode = 0;
		this.resultMessage = "success";
		this.resultObject = object;
		this.resultClassName = className;
	}

	public ResponseProtocol(Integer code, String message, Object object) {
		this.resultCode = code;
		this.resultMessage = message;
		this.resultObject = object;
	}

	public ResponseProtocol(Integer code, String message) {
		this.resultCode = code;
		this.resultMessage = message;
		this.resultObject = null;
	}

	public Integer getResultCode() {
		return resultCode;
	}

	public void setResultCode(Integer resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public Object getResultObject() {
		return resultObject;
	}

	public void setResultObject(Object resultObject) {
		this.resultObject = resultObject;
	}

	public String getResultClassName() {
		return resultClassName;
	}

	public void setResultClassName(String resultClassName) {
		this.resultClassName = resultClassName;
	}
}
