package com.template.rest.protocol;

public class ResponseProtocol {
	private Integer resultCode;
	private String resultMessage;
	private Object resultObject;

	public ResponseProtocol() {
		this.resultCode = 0;
		this.resultMessage = "success";
		this.resultObject = null;
	}

	public ResponseProtocol(Object object) {
		this.resultCode = 0;
		this.resultMessage = "success";
		this.resultObject = object;
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
}
