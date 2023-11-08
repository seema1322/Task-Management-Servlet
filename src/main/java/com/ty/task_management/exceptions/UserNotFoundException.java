package com.ty.task_management.exceptions;

public class UserNotFoundException extends RuntimeException {

	@Override
	public String getMessage() {
		return "User details are not available";
	}

}
