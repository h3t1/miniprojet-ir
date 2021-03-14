package com.iddl.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class CatalogueProduitNotFoundException extends RuntimeException {
	public static final long serialVersionUID = 1l;
	
	public CatalogueProduitNotFoundException(String message) {
		super(message);
	}

	public CatalogueProduitNotFoundException(String message, Throwable throwable) {
		super(message, throwable);
	}
}