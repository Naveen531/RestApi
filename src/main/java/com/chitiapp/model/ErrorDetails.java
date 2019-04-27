package com.chitiapp.model;


import java.util.Date;

public class ErrorDetails {
	  private Date timestamp;
	  private String message;
	  private String details;
	    private int errorCode;

	  public ErrorDetails() {
		// TODO Auto-generated constructor stub
	}
	  
	  
	  
		public ErrorDetails(Date timestamp, String message, String details, int errorCode) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
		this.errorCode = errorCode;
	}



		public String getDetails() {
			return details;
		}
	public int getErrorCode() {
			return errorCode;
		}
	 

	public String getMessage() {
		return message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	  
	  
}
