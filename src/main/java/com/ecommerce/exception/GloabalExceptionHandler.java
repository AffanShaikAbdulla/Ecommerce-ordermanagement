package com.ecommerce.exception;

import java.lang.module.ResolutionException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GloabalExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors()
				.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
		return ResponseEntity.badRequest().body(errors);

	}

	public ResponseEntity<Map<String, String>> handleCustomException(RuntimeException ex) {
		Map<String, String> error = new HashMap<>();
		error.put("error", ex.getMessage());
		HttpStatus status = HttpStatus.BAD_REQUEST;
		if (ex instanceof OrderNotFoundException) {
			status = HttpStatus.NOT_FOUND;

		} else if (ex instanceof InvalidStatusTransactionException) {
			status = HttpStatus.CONFLICT;
		}
		return ResponseEntity.status(status).body(error);
	}

}
