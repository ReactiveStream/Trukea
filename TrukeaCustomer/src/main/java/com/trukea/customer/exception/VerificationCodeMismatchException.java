package com.trukea.customer.exception;

import java.util.List;

public class VerificationCodeMismatchException extends TrukeaCustomerException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3530903307514679659L;
	
	public List<TrukeaError> errors;
	public VerificationCodeMismatchException(List<TrukeaError> errors) {
		this.errors=errors;
		
		// TODO Auto-generated constructor stub
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

	public List<TrukeaError> getErrors() {
		return errors;
	}

	public void setErrors(List<TrukeaError> errors) {
		this.errors = errors;
	}
	

}
