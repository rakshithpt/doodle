package com.jsp.jspwfm.Exceptions;

public class TaskFailedException extends Exception {
	
	String msg = "Task Failed";

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public TaskFailedException(String msg) {
		super("Failed Task");
		this.msg = msg;
	}
	
	

}
