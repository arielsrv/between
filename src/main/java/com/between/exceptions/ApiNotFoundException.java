package com.between.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ApiNotFoundException extends ResponseStatusException {

	public ApiNotFoundException(String message) {
		super(HttpStatus.NOT_FOUND, message);
	}
}

