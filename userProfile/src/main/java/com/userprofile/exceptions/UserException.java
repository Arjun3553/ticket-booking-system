package com.userprofile.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class UserException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpStatus errorCode;

	public UserException(String message, HttpStatus code) {
		super(message);
		this.errorCode = code;
	}

}
