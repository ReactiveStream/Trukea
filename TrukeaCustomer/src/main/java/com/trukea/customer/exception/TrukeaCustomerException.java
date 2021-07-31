package com.trukea.customer.exception;

import java.util.List;

public class TrukeaCustomerException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3733567673695780873L;
	
	public List<TrukeaError> errors;

	public TrukeaCustomerException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TrukeaCustomerException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public TrukeaCustomerException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public TrukeaCustomerException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public TrukeaCustomerException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	
	

}
