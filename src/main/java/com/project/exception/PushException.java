package com.project.exception;

public class PushException extends BaseException {
	
	private static final long serialVersionUID = 7283162405529902051L;

	public PushException(String errorMsg) {
		super(errorMsg);
	}

	public PushException(String errorMsg, Throwable throwable) {
		super(errorMsg, throwable);
	}

}
