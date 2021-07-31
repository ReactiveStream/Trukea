
package com.trukea.accountservice.exception;

import java.util.List;

public class AccountServiceException extends Throwable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2012734558224628711L;
	
	public List<TrukeaError> errors;
	
	

	public List<TrukeaError> getErrors() {
		return errors;
	}

	public void setErrors(List<TrukeaError> errors) {
		this.errors = errors;
	}

	public AccountServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public AccountServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public AccountServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public AccountServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
