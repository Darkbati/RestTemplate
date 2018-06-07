package com.template.rest.protocol;

public class ResponseProtocol {
	private Integer resultCode;
	private String resultMessage;

	public ResponseProtocol() {
		this.resultCode = 0;
		this.resultMessage = "success";
	}

	public ResponseProtocol(Integer code, String message) {
		this.resultCode = code;
		this.resultMessage = message;
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
}
