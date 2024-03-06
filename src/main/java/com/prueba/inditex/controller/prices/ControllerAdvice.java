package com.prueba.inditex.controller.prices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.prueba.inditex.entity.error.ErrorEntity;

@RestControllerAdvice
public class ControllerAdvice {
	
	@ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ErrorEntity> methodArgumentExceptionHandler(MethodArgumentTypeMismatchException exception) {
		ErrorEntity error = ErrorEntity.builder().code(HttpStatus.BAD_REQUEST.value()).message(exception.getMessage()).build();
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(value = MissingServletRequestParameterException.class)
	public ResponseEntity<ErrorEntity> missingParameterExceptionHandler(MissingServletRequestParameterException exception) {
		ErrorEntity error = ErrorEntity.builder().code(HttpStatus.BAD_REQUEST.value()).message(exception.getMessage()).build();
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(value = RuntimeException.class)
	public ResponseEntity<ErrorEntity> runtimeExceptionHandler(RuntimeException re) {
		ErrorEntity error = ErrorEntity.builder().code(HttpStatus.INTERNAL_SERVER_ERROR.value()).message(re.getMessage()).build();
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
}
