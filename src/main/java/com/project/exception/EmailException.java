package com.project.exception;

public class EmailException extends BaseException {

	private static final long serialVersionUID = -5293631671814846242L;

	public EmailException(String errorMsg) {
		super(errorMsg);
	}

	public EmailException(String errorMsg, Throwable throwable) {
		super(errorMsg, throwable);
	}

}