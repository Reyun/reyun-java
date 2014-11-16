package com.reyun.api.exception;

public class SystemException extends RuntimeException {
	private static final long serialVersionUID = 3439549751684599097L;

	public SystemException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public SystemException(Throwable cause) {
		super(cause);
	}
}
