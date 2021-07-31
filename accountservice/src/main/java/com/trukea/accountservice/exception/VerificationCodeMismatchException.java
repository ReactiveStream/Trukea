package com.trukea.accountservice.exception;

import java.util.List;

public class VerificationCodeMismatchException extends AccountServiceException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1959363636902698831L;
	
	public List<TrukeaError> errors;
	
	
	
	public List<TrukeaError> getErrors() {
		return errors;
	}

	public void setErrors(List<TrukeaError> errors) {
		this.errors = errors;
	}

	public VerificationCodeMismatchException(List<TrukeaError> errors) {
		this.errors = errors;
		
	}

	public VerificationCodeMismatchException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VerificationCodeMismatchException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public VerificationCodeMismatchException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public VerificationCodeMismatchException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public VerificationCodeMismatchException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
