package com.reyun.api.exception;

public class ParamRequiredException extends Exception {
	private static final long serialVersionUID = 1739996258771929045L;

	public ParamRequiredException(String str) {
		super(str);
	}
}
