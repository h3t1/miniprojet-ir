package com.iddl.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ClientNotFoundException extends RuntimeException {
	public static final long serialVersionUID = 1l;
	
	public ClientNotFoundException(String message) {
		super(message);
	}

	public ClientNotFoundException(String message, Throwable throwable) {
		super(message, throwable);
	}
}