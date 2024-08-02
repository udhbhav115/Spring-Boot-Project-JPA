package com.example.demo.exception;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.model.ErrorHandler;

@RestControllerAdvice
public class ExceptionHandler {
	@Autowired
	ErrorHandler handler;
	
	@org.springframework.web.bind.annotation.ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ErrorHandler> handleConstraintViolationException(SQLIntegrityConstraintViolationException exception){
		handler.setErrorCode("5000");
		handler.setErrorMessage(exception.getMessage().replace("Column '", "").replace("'", ""));
		return new ResponseEntity<>(handler,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
