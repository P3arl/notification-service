package com.project.exception;

public class NotificationException extends BaseException {
	
	private static final long serialVersionUID = 4613743275553868997L;

	public NotificationException(String errorMsg) {
		super(errorMsg);
	}

	public NotificationException(String errorMsg, Throwable throwable) {
		super(errorMsg, throwable);
	}

}
