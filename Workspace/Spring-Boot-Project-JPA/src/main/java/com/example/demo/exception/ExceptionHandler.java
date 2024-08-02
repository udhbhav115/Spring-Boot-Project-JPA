package com.example.demo.exception;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.model.Errors;

@RestControllerAdvice
public class ExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<Errors> handleConstraintViolationException(SQLIntegrityConstraintViolationException exception){
		Errors handler=new Errors();
		handler.setErrorCode("5000");
		handler.setErrorMessage(exception.getMessage().replace("Column '", "").replace("'", ""));
		return new ResponseEntity<>(handler,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<java.util.List<Errors>> handleValidationErrors(MethodArgumentNotValidException exception){
		java.util.List<Errors> errors = exception.getFieldErrors().stream().map(error->{
			Errors handler=new Errors();
			handler.setErrorCode("5001");
			handler.setErrorMessage(error.getDefaultMessage());
			return handler;
		}).collect(Collectors.toList());
		
		return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
	}
}
