package com.iddl.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class PanierNotFoundException extends RuntimeException {
	public static final long serialVersionUID = 1l;
	
	public PanierNotFoundException(String message) {
		super(message);
	}

	public PanierNotFoundException(String message, Throwable throwable) {
		super(message, throwable);
	}
}