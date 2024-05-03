package com.tbs.vehicledetails.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tbs.vehicledetails.entity.ErrorMessage;

@ControllerAdvice
@ResponseStatus
public class EntityExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(VehicleNotFoundException.class)
	public ResponseEntity<ErrorMessage> veehicleNotFoundException(VehicleNotFoundException exception){
		ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
	}
}
