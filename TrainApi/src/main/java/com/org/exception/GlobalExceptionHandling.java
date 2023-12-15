package com.org.exception;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.org.dto.ErorrResponse;

@ControllerAdvice
public class GlobalExceptionHandling {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErorrResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
		ErorrResponse error = new ErorrResponse("Error Occured ::" + ex.getMessage(), LocalTime.now(), LocalDate.now());
		return ResponseEntity.status(HttpStatus.CREATED).body(error);
	}

}
