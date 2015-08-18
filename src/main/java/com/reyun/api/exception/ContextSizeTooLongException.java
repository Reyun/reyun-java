package com.reyun.api.exception;

public class ContextSizeTooLongException extends Exception {
    private static final long serialVersionUID = 8362573521071792985L;

    public ContextSizeTooLongException(int size) {
		super(String.valueOf(size));
	}
}
