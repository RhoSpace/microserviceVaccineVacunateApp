package com.vacunateapp.vaccine.exceptions.handlers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ValidationHandler extends ResponseEntityExceptionHandler{

	 @Override
	    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
	                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
	        log.info("mensaje");
	        Map<String, String> errors = new HashMap<>();
	        ex.getBindingResult().getAllErrors().forEach((error) ->{

	            String fieldName = ((FieldError) error).getField();
	            String message = error.getDefaultMessage();
	            errors.put(fieldName, message);
	        });
	        return new ResponseEntity<Object>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	
}
