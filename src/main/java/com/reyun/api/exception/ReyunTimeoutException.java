package com.reyun.api.exception;

public class ReyunTimeoutException extends Exception {
	private static final long serialVersionUID = 3439549751684599097L;

	public ReyunTimeoutException(Throwable cause) {
		super(cause);
	}
}
