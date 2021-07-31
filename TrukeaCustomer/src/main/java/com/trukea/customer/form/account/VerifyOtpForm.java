package com.trukea.customer.form.account;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class VerifyOtpForm {
	
	private long userAccountNo;
	@NotBlank
	@Length(min=4,max=4)
	private String otpCode;

}
