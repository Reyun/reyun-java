package com.reyun.api.exception;

public class ConnectionException extends Exception {
	private static final long serialVersionUID = 3439549751684599097L;

	public ConnectionException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ConnectionException(Throwable cause) {
		super(cause);
	}
}
