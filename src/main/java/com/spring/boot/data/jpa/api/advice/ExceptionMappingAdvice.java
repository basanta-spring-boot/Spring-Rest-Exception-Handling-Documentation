package com.spring.boot.data.jpa.api.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.boot.data.jpa.api.dto.ErrorDetails;
import com.spring.boot.data.jpa.api.exception.UserServiceFailureException;

@ControllerAdvice
public class ExceptionMappingAdvice {

	@ExceptionHandler(UserServiceFailureException.class)
	public ResponseEntity<ErrorDetails> exceptionHandler(Exception ex) {
		ErrorDetails error = new ErrorDetails();
		error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
		error.setErrorMessage(ex.getMessage());
		return new ResponseEntity<ErrorDetails>(error, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
