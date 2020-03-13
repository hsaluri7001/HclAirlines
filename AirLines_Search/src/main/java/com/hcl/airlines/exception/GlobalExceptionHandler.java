package com.hcl.airlines.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	    @ExceptionHandler(CustomException.class)
	    public ResponseEntity<CustomException> customHandleNotFound(Exception ex, WebRequest request) {

	        CustomException errors = new CustomException();
	        errors.setTimestamp(LocalDateTime.now());
	        errors.setError(ex.getMessage());
	        errors.setStatus(HttpStatus.NOT_FOUND.value());
	        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);

	    }

}
