package models.dto;

import models.enums.OperationResponseStatus;

public class BaseResponse {
	private String message;
	
	private String description;

	private OperationResponseStatus status;
	
	public BaseResponse() {
		
	}
	
	public BaseResponse(OperationResponseStatus status) {
		this.status = status;
	}
	
	public BaseResponse(String message) {
		this.message = message;
	}
	
	public BaseResponse(String message, String description) {
		this.message = message;
		this.description = description;
	}

	public BaseResponse(String message, String description, OperationResponseStatus status) {
		this.message = message;
		this.description = description;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public OperationResponseStatus getStatus() {
		return status;
	}

	public void setStatus(OperationResponseStatus status) {
		this.status = status;
	}
}
