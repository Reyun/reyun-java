package com.reyun.api.exception;

public class TimeoutException extends Exception {
	private static final long serialVersionUID = 3439549751684599097L;

	public TimeoutException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public TimeoutException(Throwable cause) {
		super(cause);
	}
}
