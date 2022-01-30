package com.between.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ApiBadRequestException extends ResponseStatusException {

	public ApiBadRequestException(String message) {
		super(HttpStatus.BAD_REQUEST, message);
	}
}
