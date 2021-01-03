package com.training.employeemgmt.dto;

import java.time.LocalDateTime;

public class ErrorModel {
	private Object message;
	private LocalDateTime timestamp;

	public Object getMessage() {
		return message;
	}

	public void setMessage(Object message) {
		this.message = message;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
}
