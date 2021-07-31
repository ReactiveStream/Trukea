package com.trukea.accountservice.exception;

import java.util.List;

public class UserNotFoundException extends AccountServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8465241268495212121L;
	
	public List<TrukeaError> errors;
	public UserNotFoundException(List<TrukeaError> errors) {
		this.errors=errors;
		// TODO Auto-generated constructor stub
	}


	public UserNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UserNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UserNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public List<TrukeaError> getErrors() {
		return errors;
	}

	public void setErrors(List<TrukeaError> errors) {
		this.errors = errors;
	}
	
	

}
