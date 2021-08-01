package com.trukea.customer.form.account;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResetPasswordForm {
	
	private long userAccountNo;
	
	 
	@NotBlank
	private  String password;
	@NotBlank
	private String reTypePassword;

}
