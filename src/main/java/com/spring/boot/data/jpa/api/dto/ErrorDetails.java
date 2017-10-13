package com.spring.boot.data.jpa.api.dto;

public class ErrorDetails {
	private int errorCode;
	private String errorMessage;

	public ErrorDetails() {
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
