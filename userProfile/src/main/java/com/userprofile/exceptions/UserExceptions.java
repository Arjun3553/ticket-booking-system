package com.userprofile.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptions {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> invalidInput(MethodArgumentNotValidException ex) {

		Map<String, String> errorMap = new HashMap<String, String>();

		ex.getBindingResult().getFieldErrors().forEach((errors) -> {
			errorMap.put(errors.getField(), errors.getDefaultMessage());
		});
		return errorMap;
	}

//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ExceptionHandler(IllegalArgumentException.class)
//	public String invalidMobileNumber(IllegalArgumentException ex) {
//		return ex.getMessage();
//	}

}
