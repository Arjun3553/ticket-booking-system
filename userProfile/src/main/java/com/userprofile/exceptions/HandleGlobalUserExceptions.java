package com.userprofile.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.userprofile.model.ErrorResponse;

@RestControllerAdvice
public class HandleGlobalUserExceptions {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> invalidInput(MethodArgumentNotValidException ex) {

		Map<String, String> errorMap = new HashMap<String, String>();

		ex.getBindingResult().getFieldErrors().forEach((errors) -> {
			errorMap.put(errors.getField(), errors.getDefaultMessage());
		});
		return errorMap;
	}

	@ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorResponse> handleUserException(UserException ex) {
		ErrorResponse errObj = ErrorResponse.builder().errorMessage(ex.getMessage()).errorCode(ex.getErrorCode())
				.build();

		return new ResponseEntity<>(errObj, errObj.getErrorCode());
	}

}
