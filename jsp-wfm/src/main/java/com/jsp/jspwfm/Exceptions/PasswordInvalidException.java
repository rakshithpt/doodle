package com.jsp.jspwfm.Exceptions;

public class PasswordInvalidException extends Exception
{
	String message = "Password is Invalid";

	public PasswordInvalidException(String message) {
		super("Invalid Password");
		this.message = message;

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
			
	

}
