package com.project.exception;

public class SmsException extends BaseException {
	
	private static final long serialVersionUID = 1376598837747293728L;

	public SmsException(String errorMsg) {
		super(errorMsg);
	}

	public SmsException(String errorMsg, Throwable throwable) {
		super(errorMsg, throwable);
	}

}
