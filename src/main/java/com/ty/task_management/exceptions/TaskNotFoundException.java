package com.ty.task_management.exceptions;

public class TaskNotFoundException extends RuntimeException {

	@Override
	public String getMessage() {
		return "Task details are not available";
	}

}
