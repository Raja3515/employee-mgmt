package com.training.employeemgmt.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.training.employeemgmt.dto.ErrorModel;

@ControllerAdvice
public class EmployeeMgmtControllerAdvice {

	@ExceptionHandler({ RuntimeException.class })
	public ResponseEntity<Object> handleException(RuntimeException runtimeException, WebRequest request) {
		ErrorModel errorModel = new ErrorModel();
		errorModel.setMessage(runtimeException.getMessage());
		errorModel.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<Object>(errorModel, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		ErrorModel errorModel = new ErrorModel();
		errorModel.setMessage(errors);
		errorModel.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<Object>(errorModel, HttpStatus.BAD_REQUEST);
	}
}
