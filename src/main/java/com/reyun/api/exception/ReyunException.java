package com.reyun.api.exception;

public class ReyunException extends RuntimeException {
	private static final long serialVersionUID = 8752038811204814220L;

	public ReyunException() {
		super();
	}
	
	public ReyunException(String str) {
		super(str);
	}
	
	public ReyunException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ReyunException(Throwable cause) {
		super(cause);
	}
}
