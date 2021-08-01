package com.trukea.customer.validator.form;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.trukea.customer.form.account.ForgetPasswordForm;

@Component
public class ForgetPasswordFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return clazz.isAssignableFrom(ForgetPasswordForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ForgetPasswordForm form=(ForgetPasswordForm)target;
			
		if(form.getEmailAddress()==null && form.getMobileNo()==null) {
			errors.reject("mobilenooremailaddress", "MobileNo or Email Address is required");
		}
		
		
	}
	

}
