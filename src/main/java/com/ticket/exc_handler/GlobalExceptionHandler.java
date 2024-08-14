package com.ticket.exc_handler;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ticket.dto.ApiResponse;
import com.ticket.exception.TicketException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		List<FieldError> fieldErrors = e.getFieldErrors();

		Map<String, String> map = fieldErrors.stream()
				.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
	}
	
	@ExceptionHandler(TicketException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ApiResponse handleTicketException(TicketException e) {
		return new ApiResponse(e.getMessage());
	}
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ApiResponse handleRuntimeException(RuntimeException e) {
		return new ApiResponse(e.getMessage());
	}

}
