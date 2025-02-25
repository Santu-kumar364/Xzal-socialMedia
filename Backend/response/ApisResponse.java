package com.socialMedia.response;

public class ApisResponse {
	
	private String message;
	private boolean status;
	
	public ApisResponse() {
		
	}

	public ApisResponse(String message, boolean status) {
		super();
		this.message = message;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	

}
