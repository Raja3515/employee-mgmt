package com.training.employeemgmt.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
	public ResponseEntity<Object> handleException(RuntimeException runtimeException) {
		ErrorModel errorModel = new ErrorModel();
		errorModel.setMessage(runtimeException.getMessage());
		errorModel.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<Object>(errorModel, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler({ CustomException.class })
	public ResponseEntity<Object> handleCustomException(RuntimeException runtimeException) {
		ErrorModel errorModel = new ErrorModel();
		errorModel.setMessage(runtimeException.getMessage());
		errorModel.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<Object>(errorModel, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
		List<String> errorMessages=new ArrayList<String>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String errorMessage = error.getDefaultMessage();
			errorMessages.add(errorMessage);
		});
		ErrorModel errorModel = new ErrorModel();
		errorModel.setMessage(errorMessages);
		errorModel.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<Object>(errorModel, HttpStatus.BAD_REQUEST);
	}
}
