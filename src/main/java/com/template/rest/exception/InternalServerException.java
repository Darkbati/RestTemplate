package com.template.rest.exception;

public class InternalServerException extends Exception {
	private static final long serialVersionUID = -2273829721356111391L;
	private Integer errorCode;
	private String systemMessage;

	public InternalServerException(String systemMessage, String exceptionMessage, Throwable cause, Integer errorCode) {
		super(exceptionMessage, cause);

		this.errorCode = errorCode;
		this.systemMessage = systemMessage;
	}

	public InternalServerException(String exceptionMessage, Throwable cause, Integer errorCode) {
		super(exceptionMessage, cause);

		this.errorCode = errorCode;
		this.systemMessage = "Internal Exception";
	}

	public InternalServerException(String systemMessage, Integer errorCode) {
		super();

		this.errorCode = errorCode;
		this.systemMessage = systemMessage;
	}

	public InternalServerException(Integer errorCode) {
		super();

		this.errorCode = errorCode;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getSystemMessage() {
		return systemMessage;
	}

	public void setSystemMessage(String systemMessage) {
		this.systemMessage = systemMessage;
	}

}
