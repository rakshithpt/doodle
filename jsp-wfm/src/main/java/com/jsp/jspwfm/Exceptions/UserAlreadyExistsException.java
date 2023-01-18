package com.jsp.jspwfm.Exceptions;

public class UserAlreadyExistsException extends Exception {
	String message = "UserAlreadyExistsException";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserAlreadyExistsException(String message)
	{
		super("UserAlreadyExists");
		this.message = message;
	}
	
	

}
