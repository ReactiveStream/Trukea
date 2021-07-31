package com.trukea.customer.form.account;

import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ForgetPasswordForm{
	

	
	@Length(min=10,max=10)
	private String mobileNo;
	@Email
	private String emailAddress;

}
