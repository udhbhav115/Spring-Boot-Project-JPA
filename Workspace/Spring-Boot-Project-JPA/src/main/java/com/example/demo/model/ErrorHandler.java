package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class ErrorHandler {
	private String errorCode;
	private String errorMessage;
	public ErrorHandler() {
	}
	public ErrorHandler(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
