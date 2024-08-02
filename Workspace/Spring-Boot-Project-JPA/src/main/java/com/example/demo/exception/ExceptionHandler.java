package com.example.demo.exception;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import com.example.demo.model.Errors;

@RestControllerAdvice
public class ExceptionHandler {
	@Autowired
	Errors handler;
	
	@org.springframework.web.bind.annotation.ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<Errors> handleConstraintViolationException(SQLIntegrityConstraintViolationException exception){
		handler.setErrorCode("5000");
		handler.setErrorMessage(exception.getMessage().replace("Column '", "").replace("'", ""));
		return new ResponseEntity<>(handler,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Errors> handleValidationErrors(MethodArgumentNotValidException exception){
		Errors errors = exception.getFieldErrors().stream().map(error->{
			handler.setErrorCode("5001");
			handler.setErrorMessage(error.getDefaultMessage());
			return handler;
		}).findFirst().get();
		
		return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
	}
}
