package com.project.exception;

public abstract class BaseException extends Exception {

	private static final long serialVersionUID = 4193953562180274501L;

	public BaseException(String errorMsg) {
		super(errorMsg);
	}

	public BaseException(Throwable throwable) {
		super(throwable);
	}

	public BaseException(String errorMsg, Throwable throwable) {
		super(errorMsg, throwable);
	}
}