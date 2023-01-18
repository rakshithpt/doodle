package com.jsp.jspwfm.Exceptions;

public class UserNotFoundException extends Exception {

	String message ="UserNotFoundException";

	public UserNotFoundException(String message) {
		super("UserNotFound");
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
