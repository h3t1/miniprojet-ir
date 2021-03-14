package com.iddl.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class CommandeNotFoundException extends RuntimeException {
	public static final long serialVersionUID = 1l;
	
	public CommandeNotFoundException(String message) {
		super(message);
	}

	public CommandeNotFoundException(String message, Throwable throwable) {
		super(message, throwable);
	}
}